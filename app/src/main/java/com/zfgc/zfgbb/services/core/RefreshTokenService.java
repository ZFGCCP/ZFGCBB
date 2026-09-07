package com.zfgc.zfgbb.services.core;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dao.users.UserRefreshTokenDao;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDbo;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDboExample;
import com.zfgc.zfgbb.model.users.ConsumedRefreshToken;

@Service
// noRollbackFor: consume() throws when an already-used or expired refresh token is
// presented. That's an expected control-flow signal, not an error worth rolling
// back the surrounding tx (which would also undo legitimate writes higher up).
@Transactional(noRollbackFor = BadCredentialsException.class)
public class RefreshTokenService {

	private static final SecureRandom RNG = new SecureRandom();
	private static final int TOKEN_BYTES = 32;

	private final UserRefreshTokenDao dao;
	private final Duration rememberedTtl;
	private final Duration sessionTtl;

	public RefreshTokenService(UserRefreshTokenDao dao,
			@Value("${zfgbb.auth.refresh.ttl-days}") long rememberedTtlDays,
			@Value("${zfgbb.auth.refresh.session-ttl-hours}") long sessionTtlHours) {
		this.dao = dao;
		this.rememberedTtl = Duration.ofDays(rememberedTtlDays);
		this.sessionTtl = Duration.ofHours(sessionTtlHours);
	}

	public String issue(Integer userId, boolean stayLoggedIn) {
		String rawToken = generateRawToken();
		OffsetDateTime now = OffsetDateTime.now();
		Duration ttl = stayLoggedIn ? rememberedTtl : sessionTtl;
		UserRefreshTokenDbo dbo = new UserRefreshTokenDbo();
		dbo.setUserId(userId);
		dbo.setTokenHash(sha256Hex(rawToken));
		dbo.setIssuedTs(now);
		dbo.setExpiresTs(now.plus(ttl));
		dbo.setRevokedFlag(false);
		dao.save(dbo);
		return rawToken;
	}

	public ConsumedRefreshToken consume(String rawToken) {
		UserRefreshTokenDbo dbo = lookup(rawToken)
				.orElseThrow(() -> new BadCredentialsException("Invalid refresh token."));

		if (Boolean.TRUE.equals(dbo.getRevokedFlag())) {
			throw new BadCredentialsException("Refresh token has been revoked.");
		}
		if (dbo.getExpiresTs() == null || dbo.getExpiresTs().isBefore(OffsetDateTime.now())) {
			throw new BadCredentialsException("Refresh token has expired.");
		}

		// Original lifetime > sessionTtl ⇒ this token was issued under "stay logged in",
		// so the rotated cookie should also be persistent.
		Duration originalTtl = Duration.between(dbo.getIssuedTs(), dbo.getExpiresTs());
		boolean stayLoggedIn = originalTtl.compareTo(sessionTtl) > 0;

		dbo.setRevokedFlag(true);
		dao.save(dbo);
		return new ConsumedRefreshToken(dbo.getUserId(), stayLoggedIn);
	}

	public void revoke(String rawToken) {
		lookup(rawToken).ifPresent(dbo -> {
			dbo.setRevokedFlag(true);
			dao.save(dbo);
		});
	}

	public void revokeAllForUser(Integer userId) {
		UserRefreshTokenDboExample ex = new UserRefreshTokenDboExample();
		ex.createCriteria().andUserIdEqualTo(userId).andRevokedFlagEqualTo(false);
		List<UserRefreshTokenDbo> active = dao.get(ex);
		for (UserRefreshTokenDbo dbo : active) {
			dbo.setRevokedFlag(true);
			dao.save(dbo);
		}
	}

	private java.util.Optional<UserRefreshTokenDbo> lookup(String rawToken) {
		if (rawToken == null) {
			return java.util.Optional.empty();
		}
		UserRefreshTokenDboExample ex = new UserRefreshTokenDboExample();
		ex.createCriteria().andTokenHashEqualTo(sha256Hex(rawToken));
		return dao.get(ex).stream().findFirst();
	}

	private static String generateRawToken() {
		byte[] bytes = new byte[TOKEN_BYTES];
		RNG.nextBytes(bytes);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

	private static String sha256Hex(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder(digest.length * 2);
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("SHA-256 not available", e);
		}
	}
}
