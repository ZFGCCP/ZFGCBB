package com.zfgc.zfgbb.model.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthCredentials(
		String grant_type,
		String scope,
		@NotBlank @Size(max = 255) String username,
		@NotBlank @Size(max = 255) String password,
		boolean useTokens,
		boolean stayLoggedIn
) {
	@JsonCreator
	public AuthCredentials(
			@JsonProperty("grant_type") String grant_type,
			@JsonProperty("scope") String scope,
			@JsonProperty("username") String username,
			@JsonProperty("password") String password,
			@JsonProperty("useTokens") Boolean useTokens,
			@JsonProperty("stayLoggedIn") Boolean stayLoggedIn) {
		this(
				grant_type == null ? "password" : grant_type,
				scope == null ? "all" : scope,
				username,
				password,
				Boolean.TRUE.equals(useTokens),
				Boolean.TRUE.equals(stayLoggedIn));
	}
}
