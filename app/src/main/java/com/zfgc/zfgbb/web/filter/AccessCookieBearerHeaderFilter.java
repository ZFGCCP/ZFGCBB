package com.zfgc.zfgbb.web.filter;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nimbusds.jwt.SignedJWT;
import com.zfgc.zfgbb.services.auth.AuthCookieService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AccessCookieBearerHeaderFilter extends OncePerRequestFilter {

	private final AuthCookieService cookieService;

	private static final Set<String> COOKIE_INDEPENDENT_PATHS = Set.of(
			"/users/auth/login", "/users/auth/refresh", "/users/auth/logout",
			"/system/install", "/system/install/status", "/system/site");

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = !contextPath.isEmpty() && requestUri.startsWith(contextPath)
				? requestUri.substring(contextPath.length())
				: requestUri;
		return COOKIE_INDEPENDENT_PATHS.contains(path);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		if (request.getHeader(HttpHeaders.AUTHORIZATION) != null) {
			chain.doFilter(request, response);
			return;
		}
		Optional<String> validToken = cookieService.readAccessCookie(request)
				.filter(token -> !isExpired(token));
		if (validToken.isPresent()) {
			chain.doFilter(new AuthHeaderRequest(request, "Bearer " + validToken.get()), response);
		} else {
			chain.doFilter(request, response);
		}
	}

	private static boolean isExpired(String token) {
		try {
			SignedJWT jwt = SignedJWT.parse(token);
			Date exp = jwt.getJWTClaimsSet().getExpirationTime();
			return exp != null && exp.toInstant().isBefore(Instant.now());
		} catch (ParseException undecipherableTokenNotWorthPromoting) {
			return true;
		}
	}

	private static final class AuthHeaderRequest extends HttpServletRequestWrapper {
		private final String authHeader;

		AuthHeaderRequest(HttpServletRequest request, String authHeader) {
			super(request);
			this.authHeader = authHeader;
		}

		@Override
		public String getHeader(String name) {
			if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(name)) {
				return authHeader;
			}
			return super.getHeader(name);
		}

		@Override
		public Enumeration<String> getHeaders(String name) {
			if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(name)) {
				return Collections.enumeration(Collections.singletonList(authHeader));
			}
			return super.getHeaders(name);
		}

		@Override
		public Enumeration<String> getHeaderNames() {
			Enumeration<String> original = super.getHeaderNames();
			Set<String> names = new LinkedHashSet<>();
			while (original.hasMoreElements()) {
				names.add(original.nextElement());
			}
			names.add(HttpHeaders.AUTHORIZATION);
			return Collections.enumeration(names);
		}
	}
}
