package com.zfgc.zfgbb.services.core;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.config.loadoption.user.FullUserLoadOptions;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.exception.ZfgcInvalidRequestException;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.exception.ZfgcUnauthorizedException;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.EmailAddress;
import com.zfgc.zfgbb.model.users.HashedPassword;
import com.zfgc.zfgbb.model.users.RegistrationRequest;

@Service
@Transactional
public class UserService {

	private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,32}$");
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	private static final int MIN_PASSWORD_LENGTH = 8;

	@Autowired
	private UserDataProvider userDataProvider;

	@Autowired
	private PasswordService passwordService;

	public User createNewUser(RegistrationRequest req) {
		validate(req);

		if (userDataProvider.findByUserName(req.userName()).isPresent()) {
			throw new ZfgcInvalidRequestException("Username already taken.");
		}
		if (userDataProvider.findByEmail(req.email()).isPresent()) {
			throw new ZfgcInvalidRequestException("Email already registered.");
		}

		HashedPassword hashed = passwordService.hash(req.password());

		User user = User.builder()
				.userName(req.userName())
				.displayName(req.displayName())
				.ssoKey(req.userName())
				.activeFlag(true)
				.passwordHash(hashed.hash())
				.passwordAlgo(hashed.algo())
				.passwordSalt(hashed.salt())
				.passwordChangedTs(java.time.OffsetDateTime.now())
				.failedLoginCount(0)
				.email(EmailAddress.builder().emailAddress(req.email()).spammerFlag(false).build())
				.build();

		return userDataProvider.createUser(user);
	}

	public User loadUser(Integer userId) {
		return userDataProvider.findUser(userId, new FullUserLoadOptions())
				.orElseThrow(ZfgcNotFoundException::new);
	}

	public User saveUserProfile(User user, User zfgcUser) {
		// check admin permissions. A non-profile admin can only edit their own profile,
		// and they cannot edit permissions.
		if (!zfgcUser.hasPermission("ZFGC_USER_PROFILE_ADMIN")) {
			user.setPermissions(null);

			if (!zfgcUser.getUserId().equals(user.getUserId())) {
				throw new ZfgcUnauthorizedException("User attempted to save another user's profile.", zfgcUser);
			}
		}

		return userDataProvider.saveUserProfile(user);
	}

	private void validate(RegistrationRequest req) {
		if (req == null) {
			throw new ZfgcInvalidRequestException("Registration request is required.");
		}
		if (StringUtils.isBlank(req.userName()) || !USERNAME_PATTERN.matcher(req.userName()).matches()) {
			throw new ZfgcInvalidRequestException("Username must be 3-32 characters, letters/digits/underscore only.");
		}
		if (StringUtils.isBlank(req.displayName())) {
			throw new ZfgcInvalidRequestException("Display name is required.");
		}
		if (StringUtils.isBlank(req.email()) || !EMAIL_PATTERN.matcher(req.email()).matches()) {
			throw new ZfgcInvalidRequestException("A valid email address is required.");
		}
		if (req.password() == null || req.password().length() < MIN_PASSWORD_LENGTH) {
			throw new ZfgcInvalidRequestException(
					"Password must be at least " + MIN_PASSWORD_LENGTH + " characters.");
		}
	}
}
