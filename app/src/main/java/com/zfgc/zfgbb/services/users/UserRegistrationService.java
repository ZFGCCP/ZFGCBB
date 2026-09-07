package com.zfgc.zfgbb.services.users;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.exception.ZfgcInvalidRequestException;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.model.users.EmailAddress;
import com.zfgc.zfgbb.model.users.EncodedPassword;
import com.zfgc.zfgbb.model.users.RegistrationRequest;
import com.zfgc.zfgbb.services.auth.ZfgcPasswordEncoder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

	private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,32}$");
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
	private static final int MIN_PASSWORD_LENGTH = 8;
	private static final Set<String> RESERVED_IDENTITY_TOKENS =
			Set.of("[deleted]", "__deleted__");

	private final UserDataProvider userDataProvider;

	private final ZfgcPasswordEncoder passwordEncoder;

	private final TransactionTemplate transactionTemplate;

	public User createNewUser(RegistrationRequest req) {
		validateRegistration(req);

		if (userDataProvider.findByUserName(req.userName()).isPresent()
				|| userDataProvider.findBySsoKey(req.userName()).isPresent()) {
			throw new ZfgcInvalidRequestException("Username already taken.");
		}
		if (userDataProvider.findByEmail(req.email()).isPresent()) {
			throw new ZfgcInvalidRequestException("Email already registered.");
		}

		EncodedPassword hashed = passwordEncoder.hash(req.password());
		try {
			return transactionTemplate.execute(status -> userDataProvider.createUser(identity(req, hashed)));
		} catch (DuplicateKeyException identityClaimedConcurrently) {
			throw new ZfgcInvalidRequestException("Name or email already in use.");
		}
	}

	public User reassignUserIdentity(RegistrationRequest req, int userId) {
		validateRegistration(req);
		requireIdentityAvailableOutsideOf(req, userId);

		EncodedPassword hashed = passwordEncoder.hash(req.password());
		return transactionTemplate.execute(status -> userDataProvider.replaceUserIdentity(identity(req, hashed), userId));
	}

	private void requireIdentityAvailableOutsideOf(RegistrationRequest req, int userId) {
		if (isHeldByAnotherUser(userDataProvider.findByUserName(req.userName()).map(UserDbo::getUserId), userId)
				|| isHeldByAnotherUser(userDataProvider.findBySsoKey(req.userName()).map(UserDbo::getUserId), userId))
			throw new ZfgcInvalidRequestException("Username already taken.");
		Optional<Integer> registeredEmailAddressId = userDataProvider.findByEmail(req.email())
				.map(EmailAddressDbo::getEmailAddressId);
		if (registeredEmailAddressId.isPresent()
				&& !userDataProvider.emailAddressBelongsTo(registeredEmailAddressId.get(), userId)
				&& userDataProvider.emailAddressIsClaimedBySomeUser(registeredEmailAddressId.get()))
			throw new ZfgcInvalidRequestException("Email already registered.");
	}

	private static boolean isHeldByAnotherUser(Optional<Integer> holderUserId, int userId) {
		return holderUserId.filter(holder -> holder.intValue() != userId).isPresent();
	}

	private User identity(RegistrationRequest req, EncodedPassword hashed) {
		return User.builder()
				.userName(req.userName())
				.displayName(req.displayName())
				.ssoKey(req.userName())
				.activeFlag(true)
				.passwordHash(hashed.hash())
				.passwordAlgo(hashed.algo())
				.passwordSalt(hashed.salt())
				.passwordChangedTs(OffsetDateTime.now(ZoneOffset.UTC))
				.failedLoginCount(0)
				.email(EmailAddress.builder().emailAddress(req.email()).spammerFlag(false).build())
				.build();
	}

	private boolean isReservedIdentity(String value) {
		if (value == null)
			return false;
		String normalized = java.text.Normalizer.normalize(value, java.text.Normalizer.Form.NFKC)
				.trim().toLowerCase(Locale.ROOT);
		return RESERVED_IDENTITY_TOKENS.contains(normalized);
	}

	public void validateRegistration(RegistrationRequest req) {
		if (req == null) {
			throw new ZfgcInvalidRequestException("Registration request is required.");
		}
		if (StringUtils.isBlank(req.userName()) || !USERNAME_PATTERN.matcher(req.userName()).matches()) {
			throw new ZfgcInvalidRequestException("Username must be 3-32 characters, letters/digits/underscore only.");
		}
		if (StringUtils.isBlank(req.displayName())) {
			throw new ZfgcInvalidRequestException("Display name is required.");
		}
		if (isReservedIdentity(req.userName()) || isReservedIdentity(req.displayName())) {
			throw new ZfgcInvalidRequestException("That username or display name is reserved.");
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
