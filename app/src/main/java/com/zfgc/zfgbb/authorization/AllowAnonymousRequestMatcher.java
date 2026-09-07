package com.zfgc.zfgbb.authorization;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.ServletRequestPathUtils;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AllowAnonymousRequestMatcher implements RequestMatcher {

	@Qualifier("requestMappingHandlerMapping")
	private final RequestMappingHandlerMapping handlerMapping;

	@Override
	public boolean matches(HttpServletRequest request) {
		return resolveHandlerMethod(request)
				.map(handler -> handler.hasMethodAnnotation(AllowAnonymous.class)
						|| handler.getBeanType().isAnnotationPresent(AllowAnonymous.class))
				.orElse(false);
	}

	private Optional<HandlerMethod> resolveHandlerMethod(HttpServletRequest request) {
		boolean parsedHere = false;
		try {
			if (!ServletRequestPathUtils.hasParsedRequestPath(request)) {
				ServletRequestPathUtils.parseAndCache(request);
				parsedHere = true;
			}
			HandlerExecutionChain chain = handlerMapping.getHandler(request);
			if (chain != null && chain.getHandler() instanceof HandlerMethod handlerMethod) {
				return Optional.of(handlerMethod);
			}
		} catch (Exception e) {
			return Optional.empty();
		} finally {
			if (parsedHere) {
				ServletRequestPathUtils.clearParsedRequestPath(request);
			}
		}
		return Optional.empty();
	}
}
