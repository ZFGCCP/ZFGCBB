package com.zfgc.zfgbb.authorization;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zfgc.zfgbb.model.users.User;

public final class RequestingUser {

	private RequestingUser() {
	}

	public static User onThisRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null || attributes.getRequest() == null) {
			return User.guest();
		}
		Principal userPrincipal = attributes.getRequest().getUserPrincipal();
		if (userPrincipal == null) {
			return User.guest();
		}
		Object authenticated = ((Authentication) userPrincipal).getPrincipal();
		return authenticated instanceof User user ? user : User.guest();
	}
}
