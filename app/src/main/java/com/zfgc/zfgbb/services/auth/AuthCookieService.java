package com.zfgc.zfgbb.services.auth;

import java.time.Duration;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.model.users.TokenPair;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthCookieService {

	public static final String ACCESS_COOKIE_NAME = "zfgbb_access_token";
	public static final String REFRESH_COOKIE_NAME = "zfgbb_refresh_token";

	@Value("${zfgbb.auth.cookie.secure:true}")
	private final boolean secure;
	@Value("${zfgbb.auth.jwt.access-ttl-minutes}")
	private final long accessTtlMinutes;
	@Value("${zfgbb.auth.refresh.ttl-days}")
	private final long refreshTtlDays;

	@Value("${server.servlet.context-path:}")
	private final String contextPath;

	private String authEndpointsPath() {
		return contextPath + "/users/auth";
	}

	public ResponseEntity.BodyBuilder setTokenCookies(ResponseEntity.BodyBuilder response, TokenPair tokens) {
		return response
				.header(HttpHeaders.SET_COOKIE,
						buildAccessCookie(tokens.accessToken(), tokens.stayLoggedIn()).toString())
				.header(HttpHeaders.SET_COOKIE,
						buildRefreshCookie(tokens.refreshToken(), tokens.stayLoggedIn()).toString());
	}

	public ResponseEntity.BodyBuilder clearTokenCookies(ResponseEntity.BodyBuilder response) {
		return response
				.header(HttpHeaders.SET_COOKIE, clearAccessCookie().toString())
				.header(HttpHeaders.SET_COOKIE, clearRefreshCookie().toString());
	}

	private ResponseCookie buildAccessCookie(String token, boolean persistBeyondBrowserSession) {
		ResponseCookieBuilder expiringWithTheBrowserSession = ResponseCookie.from(ACCESS_COOKIE_NAME, token)
				.httpOnly(true)
				.secure(secure)
				.sameSite("Lax")
				.path("/");
		if (persistBeyondBrowserSession)
			expiringWithTheBrowserSession.maxAge(Duration.ofMinutes(accessTtlMinutes));
		return expiringWithTheBrowserSession.build();
	}

	private ResponseCookie buildRefreshCookie(String token, boolean persistBeyondBrowserSession) {
		ResponseCookieBuilder expiringWithTheBrowserSession = ResponseCookie.from(REFRESH_COOKIE_NAME, token)
				.httpOnly(true)
				.secure(secure)
				.sameSite("Strict")
				.path(authEndpointsPath());
		if (persistBeyondBrowserSession)
			expiringWithTheBrowserSession.maxAge(Duration.ofDays(refreshTtlDays));
		return expiringWithTheBrowserSession.build();
	}

	private ResponseCookie clearAccessCookie() {
		return ResponseCookie.from(ACCESS_COOKIE_NAME, "")
				.httpOnly(true)
				.secure(secure)
				.sameSite("Lax")
				.path("/")
				.maxAge(0)
				.build();
	}

	private ResponseCookie clearRefreshCookie() {
		return ResponseCookie.from(REFRESH_COOKIE_NAME, "")
				.httpOnly(true)
				.secure(secure)
				.sameSite("Strict")
				.path(authEndpointsPath())
				.maxAge(0)
				.build();
	}

	public Optional<String> readAccessCookie(HttpServletRequest request) {
		return readCookie(request, ACCESS_COOKIE_NAME);
	}

	public Optional<String> readRefreshCookie(HttpServletRequest request) {
		return readCookie(request, REFRESH_COOKIE_NAME);
	}

	private Optional<String> readCookie(HttpServletRequest request, String name) {
		if (request == null || request.getCookies() == null)
			return Optional.empty();
		for (Cookie cookie : request.getCookies()) {
			if (name.equals(cookie.getName()) && cookie.getValue() != null && !cookie.getValue().isBlank())
				return Optional.of(cookie.getValue());
		}
		return Optional.empty();
	}
}
