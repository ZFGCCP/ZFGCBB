package com.zfgc.zfgbb.model.users;

import com.zfgc.zfgbb.model.users.User;

public record LoginResponse(String accessToken, String refreshToken, boolean stayLoggedIn, long accessTokenTtlSeconds,
		User user) {

	public TokenPair tokens() {
		return new TokenPair(accessToken, refreshToken, stayLoggedIn, accessTokenTtlSeconds);
	}

	public LoginResponse withoutTokens() {
		return new LoginResponse(null, null, stayLoggedIn, accessTokenTtlSeconds, user);
	}
}
