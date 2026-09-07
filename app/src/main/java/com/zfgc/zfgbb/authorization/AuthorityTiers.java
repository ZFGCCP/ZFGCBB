package com.zfgc.zfgbb.authorization;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.model.users.User;

@Component
@RequiredArgsConstructor
public class AuthorityTiers {

	private static final String ROLE_READ_ONLY = "ROLE_ZFGC_READ_ONLY";

	private final RoleHierarchy roleHierarchy;

	public boolean authenticated(User actor) {
		return actor != null && actor.getUserId() != null && actor.getUserId() > 0;
	}

	public boolean hasRole(User actor, String role) {
		return reachableRoles(actor).contains(role);
	}

	public boolean isReadOnly(User actor) {
		return hasRole(actor, ROLE_READ_ONLY);
	}

	public Set<String> reachableRoles(User actor) {
		Collection<? extends GrantedAuthority> authorities = actor.getAuthorities();
		if (authorities == null || authorities.isEmpty())
			return Set.of();
		Set<String> roles = new HashSet<>();
		for (GrantedAuthority granted : roleHierarchy.getReachableGrantedAuthorities(authorities))
			roles.add(granted.getAuthority());
		return roles;
	}
}
