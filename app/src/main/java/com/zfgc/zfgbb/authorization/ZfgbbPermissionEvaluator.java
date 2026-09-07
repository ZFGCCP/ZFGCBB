package com.zfgc.zfgbb.authorization;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.model.users.User;

@Component
@RequiredArgsConstructor
public class ZfgbbPermissionEvaluator implements PermissionEvaluator {

	private final List<ResourceAccessRules> resourceAccessRules;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		throw new UnsupportedOperationException("hasPermission(target, permission) is unsupported");
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		if (authentication == null || targetId == null
				|| !(authentication.getPrincipal() instanceof User actor) || !(targetId instanceof Number))
			return false;
		for (ResourceAccessRules rules : resourceAccessRules) {
			if (rules.supports(targetType))
				return rules.allows(actor, targetType, ((Number) targetId).intValue(), String.valueOf(permission));
		}
		return false;
	}
}
