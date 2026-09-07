package com.zfgc.zfgbb.config.security;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.services.auth.TokenSubjectValidator;

@Component
@RequiredArgsConstructor
public class ZfgcJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

	private final TokenSubjectValidator tokenSubjects;

	@Override
	public AbstractAuthenticationToken convert(Jwt jwt) {
		Integer subjectUserId;
		try {
			subjectUserId = Integer.valueOf(jwt.getSubject());
		} catch (NumberFormatException notAnAccessToken) {
			throw new InvalidBearerTokenException("token subject is not a user id");
		}
		User user = tokenSubjects.validSubject(subjectUserId,
				Optional.ofNullable(jwt.getIssuedAt()), InvalidBearerTokenException::new);
		return new UsernamePasswordAuthenticationToken(user, jwt, user.getAuthorities());
	}
}
