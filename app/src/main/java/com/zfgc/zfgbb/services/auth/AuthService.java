package com.zfgc.zfgbb.services.auth;

import static com.zfgc.zfgbb.util.ZfgcSecurityUtils.sha256Hex;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zfgc.zfgbb.dataprovider.loadoption.UserLoadOptions;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dao.users.UserRefreshTokenDao;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDbo;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDboExample;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.model.users.AuthCredentials;
import com.zfgc.zfgbb.model.users.ConsumedRefreshToken;
import com.zfgc.zfgbb.model.users.LoginResponse;
import com.zfgc.zfgbb.model.users.TokenPair;

@Service
@Transactional(noRollbackFor = { BadCredentialsException.class, LockedException.class, CredentialsExpiredException.class,
		DisabledException.class })
public class AuthService {

	private static final SecureRandom RNG = new SecureRandom();
	private static final int TOKEN_BYTES = 32;

	private final UserDataProvider userDataProvider;

	private final TokenSubjectValidator tokenSubjects;
	private final UserDao userDao;
	private final AuthenticationManager loginAuthenticationManager;
	private final JwtEncoder accessTokenEncoder;
	private final UserRefreshTokenDao refreshTokenDao;
	private final Duration rememberedTtl;
	private final Duration sessionTtl;
	private final Duration rotationGrace;
	private final Cache<Integer, String> successorCache;
	private final int lockoutFailedAttempts;
	private final long lockoutDurationMinutes;
	private final long accessTokenTtlSeconds;

	public AuthService(UserDataProvider userDataProvider,
			TokenSubjectValidator tokenSubjects,
			UserDao userDao,
			@Qualifier("loginAuthenticationManager") AuthenticationManager loginAuthenticationManager,
			JwtEncoder accessTokenEncoder,
			UserRefreshTokenDao refreshTokenDao,
			@Value("${zfgbb.auth.refresh.ttl-days}") long rememberedTtlDays,
			@Value("${zfgbb.auth.refresh.session-ttl-hours}") long sessionTtlHours,
			@Value("${zfgbb.auth.refresh.rotation-grace-seconds}") long rotationGraceSeconds,
			@Value("${zfgbb.auth.lockout.failed-attempts}") int lockoutFailedAttempts,
			@Value("${zfgbb.auth.lockout.duration-minutes}") long lockoutDurationMinutes,
			@Value("${zfgbb.auth.jwt.access-ttl-minutes}") long accessTokenTtlMinutes) {
		this.userDataProvider = userDataProvider;
		this.tokenSubjects = tokenSubjects;
		this.userDao = userDao;
		this.loginAuthenticationManager = loginAuthenticationManager;
		this.accessTokenEncoder = accessTokenEncoder;
		this.refreshTokenDao = refreshTokenDao;
		this.rememberedTtl = Duration.ofDays(rememberedTtlDays);
		this.sessionTtl = Duration.ofHours(sessionTtlHours);
		if (rotationGraceSeconds < 0)
			throw new IllegalArgumentException("rotation grace must not be negative");
		this.rotationGrace = Duration.ofSeconds(rotationGraceSeconds);
		this.successorCache = CacheBuilder.newBuilder()
				.expireAfterWrite(rotationGrace)
				.maximumSize(100_000)
				.build();
		this.lockoutFailedAttempts = lockoutFailedAttempts;
		this.lockoutDurationMinutes = lockoutDurationMinutes;
		this.accessTokenTtlSeconds = Duration.ofMinutes(accessTokenTtlMinutes).toSeconds();
	}

	public LoginResponse login(AuthCredentials credentials) {
		if (credentials == null)
			throw new BadCredentialsException("Username and password are required.");

		User principal = reauthenticate(credentials.username(), credentials.password());

		User user = userDataProvider.findUser(principal.getUserId(), UserLoadOptions.loggedIn())
				.orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
		return issueLoginResponse(user, credentials.stayLoggedIn());
	}

	public User reauthenticate(String username, String password) {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password))
			throw new BadCredentialsException("Username and password are required.");

		Authentication authentication;
		try {
			authentication = loginAuthenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException wrongPassword) {
			userDataProvider.findByUserName(username).ifPresent(this::recordFailedLogin);
			throw wrongPassword;
		}

		User principal = (User) authentication.getPrincipal();
		OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
		userDao.clearFailedLoginState(principal.getUserId(), now);
		return principal;
	}

	public LoginResponse issueLoginResponse(User user, boolean stayLoggedIn) {
		String accessToken = issueAccessToken(user);
		String refreshToken = issue(user.getUserId(), stayLoggedIn);
		return new LoginResponse(accessToken, refreshToken, stayLoggedIn, accessTokenTtlSeconds, user);
	}

	public TokenPair refresh(String refreshToken) {
		ConsumedRefreshToken consumed = consume(refreshToken);
		User user = tokenSubjects.validSubject(consumed.userId(),
				Optional.ofNullable(consumed.issuedTs()).map(OffsetDateTime::toInstant),
				BadCredentialsException::new);
		String newAccess = issueAccessToken(user);
		String newRefresh = consumed.existingSuccessorRaw() != null
				? consumed.existingSuccessorRaw()
				: issueSuccessor(user.getUserId(), consumed.stayLoggedIn(), consumed.familyId(),
						consumed.parentTokenId());
		return new TokenPair(newAccess, newRefresh, consumed.stayLoggedIn(), accessTokenTtlSeconds);
	}

	public String issueAccessToken(User user) {
		Instant issuedAt = user.earliestAcceptableTokenIssuance(Instant.now());
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.subject(String.valueOf(user.getUserId()))
				.issuedAt(issuedAt)
				.expiresAt(issuedAt.plusSeconds(accessTokenTtlSeconds))
				.build();
		return accessTokenEncoder
				.encode(JwtEncoderParameters.from(JwsHeader.with(() -> "HS256").build(), claims))
				.getTokenValue();
	}

	public void logout(String refreshToken) {
		revoke(refreshToken);
	}

	private void recordFailedLogin(UserDbo dbo) {
		OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
		OffsetDateTime lockUntil = now.plus(Duration.ofMinutes(lockoutDurationMinutes));
		userDao.recordFailedLoginAttempt(dbo.getUserId(), now, lockoutFailedAttempts, lockUntil);
	}
	public String issue(Integer userId, boolean stayLoggedIn) {
		return mint(userId, stayLoggedIn, UUID.randomUUID().toString()).rawToken();
	}

	private MintedRefreshToken mint(Integer userId, boolean stayLoggedIn, String familyId) {
		String rawToken = generateRawToken();
		OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
		UserRefreshTokenDbo dbo = new UserRefreshTokenDbo();
		dbo.setUserId(userId);
		dbo.setTokenHash(sha256Hex(rawToken));
		dbo.setIssuedTs(now);
		dbo.setExpiresTs(now.plus(stayLoggedIn ? rememberedTtl : sessionTtl));
		dbo.setRevokedFlag(false);
		dbo.setFamilyId(familyId);
		dbo.setSuccessorId(null);
		return new MintedRefreshToken(rawToken, refreshTokenDao.save(dbo));
	}

	public ConsumedRefreshToken consume(String rawToken) {
		UserRefreshTokenDbo tokenRecord = lookup(rawToken)
				.orElseThrow(() -> new BadCredentialsException("Invalid refresh token."));

		OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
		if (tokenRecord.getExpiresTs() == null || tokenRecord.getExpiresTs().isBefore(now))
			throw new BadCredentialsException("Refresh token has expired.");

		boolean stayLoggedIn = wasIssuedForAPersistentSession(tokenRecord);

		int consumed = refreshTokenDao.consume(tokenRecord.getUserRefreshTokenId(), now);
		if (consumed == 1)
			return new ConsumedRefreshToken(tokenRecord.getUserId(), stayLoggedIn, tokenRecord.getIssuedTs(),
					tokenRecord.getFamilyId(), tokenRecord.getUserRefreshTokenId(), null);

		UserRefreshTokenDbo current = lookup(rawToken)
				.orElseThrow(() -> new BadCredentialsException("Refresh token has already been used or revoked."));
		if (current.getRevokedTs() != null || current.getRotatedTs() == null)
			throw new BadCredentialsException("Refresh token has already been used or revoked.");

		boolean withinGrace = current.getRotatedTs().isAfter(now.minus(rotationGrace));
		if (withinGrace && successorIsLive(current.getSuccessorId(), now)) {
			String existingSuccessorRaw = successorCache.getIfPresent(current.getUserRefreshTokenId());
			if (existingSuccessorRaw == null)
				throw new BadCredentialsException("Refresh token successor is no longer available.");
			return new ConsumedRefreshToken(current.getUserId(), stayLoggedIn, current.getIssuedTs(),
					current.getFamilyId(), current.getUserRefreshTokenId(), existingSuccessorRaw);
		}

		if (current.getSuccessorId() == null)
			throw new BadCredentialsException("Refresh token has already been used or revoked.");

		UserRefreshTokenDboExample family = new UserRefreshTokenDboExample();
		family.createCriteria().andFamilyIdEqualTo(current.getFamilyId());
		revokeMatching(family, now);
		throw new BadCredentialsException("Refresh token reuse detected; token family revoked.");
	}

	public String issueSuccessor(Integer userId, boolean stayLoggedIn, String familyId, Integer parentTokenId) {
		MintedRefreshToken successor = mint(userId, stayLoggedIn, familyId);
		UserRefreshTokenDbo backlink = new UserRefreshTokenDbo();
		backlink.setSuccessorId(successor.persisted().getUserRefreshTokenId());
		UserRefreshTokenDboExample parent = new UserRefreshTokenDboExample();
		parent.createCriteria().andUserRefreshTokenIdEqualTo(parentTokenId);
		refreshTokenDao.updateWhere(backlink, parent);
		successorCache.put(parentTokenId, successor.rawToken());
		return successor.rawToken();
	}

	private boolean successorIsLive(Integer successorId, OffsetDateTime now) {
		if (successorId == null)
			return false;
		UserRefreshTokenDbo successor = refreshTokenDao.find(successorId).orElse(null);
		if (successor == null)
			return false;
		return Boolean.FALSE.equals(successor.getRevokedFlag())
				&& successor.getExpiresTs() != null && !successor.getExpiresTs().isBefore(now);
	}

	public void revoke(String rawToken) {
		lookup(rawToken).ifPresent(dbo -> {
			UserRefreshTokenDboExample token = new UserRefreshTokenDboExample();
			token.createCriteria().andUserRefreshTokenIdEqualTo(dbo.getUserRefreshTokenId());
			revokeMatching(token, OffsetDateTime.now(ZoneOffset.UTC));
		});
	}

	public void revokeAllForUser(Integer userId) {
		UserRefreshTokenDboExample live = new UserRefreshTokenDboExample();
		live.createCriteria().andUserIdEqualTo(userId).andRevokedTsIsNull();
		revokeMatching(live, OffsetDateTime.now(ZoneOffset.UTC));
	}

	private void revokeMatching(UserRefreshTokenDboExample scope, OffsetDateTime now) {
		UserRefreshTokenDbo revoked = new UserRefreshTokenDbo();
		revoked.setRevokedFlag(true);
		revoked.setRevokedTs(now);
		refreshTokenDao.updateWhere(revoked, scope);
	}

	public int deleteEveryToken() {
		int deleted = refreshTokenDao.deleteWhere(new UserRefreshTokenDboExample());
		successorCache.invalidateAll();
		return deleted;
	}

	private boolean wasIssuedForAPersistentSession(UserRefreshTokenDbo tokenRecord) {
		Duration originalTtl = Duration.between(tokenRecord.getIssuedTs(), tokenRecord.getExpiresTs());
		return originalTtl.compareTo(sessionTtl) > 0;
	}

	private Optional<UserRefreshTokenDbo> lookup(String rawToken) {
		if (rawToken == null) {
			return Optional.empty();
		}
		UserRefreshTokenDboExample ex = new UserRefreshTokenDboExample();
		ex.createCriteria().andTokenHashEqualTo(sha256Hex(rawToken));
		return refreshTokenDao.getOne(ex);
	}

	private static String generateRawToken() {
		byte[] bytes = new byte[TOKEN_BYTES];
		RNG.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	private record MintedRefreshToken(String rawToken, UserRefreshTokenDbo persisted) {
	}

}
