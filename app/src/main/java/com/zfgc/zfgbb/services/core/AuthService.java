package com.zfgc.zfgbb.services.core;

import java.time.Duration;
import java.time.OffsetDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.config.loadoption.user.LoggedInUserLoadOptions;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.AuthCredentials;
import com.zfgc.zfgbb.model.users.ConsumedRefreshToken;
import com.zfgc.zfgbb.model.users.HashedPassword;
import com.zfgc.zfgbb.model.users.LoginResponse;
import com.zfgc.zfgbb.model.users.PasswordAlgo;
import com.zfgc.zfgbb.model.users.TokenPair;

@Service
// noRollbackFor: failed-login increments are intentional side effects and must
// survive the BadCredentialsException we throw on each bad attempt. Without
// this, every failed login would silently roll back the failed_login_count
// update, so the lockout threshold would never be reached.
@Transactional(noRollbackFor = { BadCredentialsException.class, LockedException.class, CredentialsExpiredException.class })
public class AuthService {

	private final UserDao userDao;
	private final UserDataProvider userDataProvider;
	private final PasswordService passwordService;
	private final JwtService jwtService;
	private final RefreshTokenService refreshTokenService;
	private final int lockoutFailedAttempts;
	private final long lockoutDurationMinutes;
	private final long passwordMaxAgeDays;

	public AuthService(UserDao userDao,
			UserDataProvider userDataProvider,
			PasswordService passwordService,
			JwtService jwtService,
			RefreshTokenService refreshTokenService,
			@Value("${zfgbb.auth.lockout.failed-attempts}") int lockoutFailedAttempts,
			@Value("${zfgbb.auth.lockout.duration-minutes}") long lockoutDurationMinutes,
			@Value("${zfgbb.auth.password.max-age-days}") long passwordMaxAgeDays) {
		this.userDao = userDao;
		this.userDataProvider = userDataProvider;
		this.passwordService = passwordService;
		this.jwtService = jwtService;
		this.refreshTokenService = refreshTokenService;
		this.lockoutFailedAttempts = lockoutFailedAttempts;
		this.lockoutDurationMinutes = lockoutDurationMinutes;
		this.passwordMaxAgeDays = passwordMaxAgeDays;
	}

	public LoginResponse login(AuthCredentials credentials) {
		if (credentials == null
				|| StringUtils.isBlank(credentials.getUsername())
				|| StringUtils.isBlank(credentials.getPassword())) {
			throw new BadCredentialsException("Username and password are required.");
		}

		UserDbo dbo = userDataProvider.findByUserName(credentials.getUsername())
				.orElseThrow(() -> new BadCredentialsException("Invalid username or password."));

		if (!Boolean.TRUE.equals(dbo.getActiveFlag())) {
			throw new BadCredentialsException("Account is not active.");
		}

		// Lockout check happens before password verify so locked accounts can't be
		// brute-forced past the lockout window.
		if (isLocked(dbo)) {
			throw new LockedException("Account is locked due to too many failed login attempts.");
		}

		PasswordAlgo algo = parseAlgo(dbo.getPasswordAlgo());
		boolean ok = passwordService.verify(
				credentials.getPassword(),
				dbo.getPasswordHash(),
				algo,
				dbo.getPasswordSalt());

		if (!ok) {
			recordFailedLogin(dbo);
			throw new BadCredentialsException("Invalid username or password.");
		}

		// Password expiry check happens after a successful verify so we don't leak
		// "password is correct but expired" info to attackers — but we still block.
		if (isPasswordExpired(dbo)) {
			throw new CredentialsExpiredException("Password has expired and must be reset.");
		}

		// Successful login: clear any prior lockout state.
		clearFailedLoginState(dbo);

		// Lazy upgrade legacy hashes to bcrypt on successful login.
		if (algo == PasswordAlgo.SMF2_SHA1) {
			HashedPassword fresh = passwordService.hash(credentials.getPassword());
			dbo.setPasswordHash(fresh.hash());
			dbo.setPasswordAlgo(fresh.algo().name());
			dbo.setPasswordSalt(fresh.salt());
			dbo.setPasswordChangedTs(OffsetDateTime.now());
			userDao.save(dbo);
		}

		User user = userDataProvider.findUser(dbo.getUserId(), new LoggedInUserLoadOptions())
				.orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
		return issueLoginResponse(user, credentials.isStayLoggedIn());
	}

	public LoginResponse issueLoginResponse(User user, boolean stayLoggedIn) {
		String accessToken = jwtService.issueAccessToken(user);
		String refreshToken = refreshTokenService.issue(user.getUserId(), stayLoggedIn);
		return new LoginResponse(accessToken, refreshToken, stayLoggedIn, user);
	}

	public TokenPair refresh(String refreshToken) {
		ConsumedRefreshToken consumed = refreshTokenService.consume(refreshToken);
		User user = userDataProvider.findUser(consumed.userId(), new LoggedInUserLoadOptions())
				.orElseThrow(() -> new BadCredentialsException("Refresh token references unknown user"));
		String newAccess = jwtService.issueAccessToken(user);
		String newRefresh = refreshTokenService.issue(user.getUserId(), consumed.stayLoggedIn());
		return new TokenPair(newAccess, newRefresh, consumed.stayLoggedIn());
	}

	public void logout(String refreshToken) {
		refreshTokenService.revoke(refreshToken);
	}

	private boolean isLocked(UserDbo dbo) {
		OffsetDateTime until = dbo.getLockedUntilTs();
		return until != null && until.isAfter(OffsetDateTime.now());
	}

	private boolean isPasswordExpired(UserDbo dbo) {
		if (passwordMaxAgeDays <= 0) {
			return false;
		}
		OffsetDateTime changed = dbo.getPasswordChangedTs();
		if (changed == null) {
			// Account predates expiry tracking; treat as not-expired so we don't lock
			// out legacy users on day one of the policy taking effect.
			return false;
		}
		return changed.plus(Duration.ofDays(passwordMaxAgeDays)).isBefore(OffsetDateTime.now());
	}

	private void recordFailedLogin(UserDbo dbo) {
		int current = dbo.getFailedLoginCount() == null ? 0 : dbo.getFailedLoginCount();
		int next = current + 1;
		dbo.setFailedLoginCount(next);
		if (next >= lockoutFailedAttempts) {
			dbo.setLockedUntilTs(OffsetDateTime.now().plus(Duration.ofMinutes(lockoutDurationMinutes)));
		}
		userDao.save(dbo);
	}

	private void clearFailedLoginState(UserDbo dbo) {
		boolean dirty = false;
		if (dbo.getFailedLoginCount() != null && dbo.getFailedLoginCount() > 0) {
			dbo.setFailedLoginCount(0);
			dirty = true;
		}
		if (dbo.getLockedUntilTs() != null) {
			dbo.setLockedUntilTs(null);
			dirty = true;
		}
		if (dirty) {
			userDao.save(dbo);
		}
	}

	private PasswordAlgo parseAlgo(String algo) {
		if (algo == null) {
			return PasswordAlgo.BCRYPT;
		}
		try {
			return PasswordAlgo.valueOf(algo);
		} catch (IllegalArgumentException e) {
			throw new BadCredentialsException("Unknown password algorithm.");
		}
	}
}
