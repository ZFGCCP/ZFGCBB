package com.zfgc.zfgbb.model.users;

public record TokenPair(String accessToken, String refreshToken, boolean stayLoggedIn, long accessTokenTtlSeconds) {

	public TokenPair withoutTokens() {
		return new TokenPair(null, null, stayLoggedIn, accessTokenTtlSeconds);
	}
}
