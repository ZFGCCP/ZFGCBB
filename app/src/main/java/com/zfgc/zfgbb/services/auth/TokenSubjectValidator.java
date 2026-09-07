package com.zfgc.zfgbb.services.auth;

import java.time.Instant;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.dataprovider.loadoption.UserLoadOptions;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.model.users.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenSubjectValidator {

	private final UserDataProvider userDataProvider;

	public User validSubject(Integer userId, Optional<Instant> issuedAt,
			Function<String, RuntimeException> rejected) {
		User user = userDataProvider.findUser(userId, UserLoadOptions.loggedIn())
				.orElseThrow(() -> rejected.apply("token references unknown user " + userId));
		if (!user.isEnabled())
			throw rejected.apply("token references disabled user " + userId);
		if (user.invalidatesTokenIssuedAt(issuedAt))
			throw rejected.apply("token for user " + userId + " was issued before the validity cutoff");
		return user;
	}
}
