package com.zfgc.zfgbb.authorization.access;

import lombok.RequiredArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.authorization.AuthorityTiers;
import com.zfgc.zfgbb.model.users.User;

@Component
@RequiredArgsConstructor
public class ProfileAccessRules {

	private static final String ROLE_PROFILE_ADMIN = "ROLE_ZFGC_PROFILE_ADMIN";

	private final AuthorityTiers tiers;

	public boolean canViewPrivateProfile(User actor, Integer targetUserId) {
		return isSelfOrProfileAdmin(actor, targetUserId);
	}

	public Set<String> permittedProfileActions(User actor, Integer targetUserId) {
		if (!tiers.authenticated(actor))
			return Set.of();
		Set<String> permitted = new LinkedHashSet<>();
		boolean selfOrAdmin = isSelfOrProfileAdmin(actor, targetUserId);
		boolean notReadOnly = !tiers.isReadOnly(actor);
		if (selfOrAdmin)
			permitted.add("profile.view.private");
		if (selfOrAdmin && notReadOnly) {
			permitted.add("profile.edit");
			permitted.add("profile.settings.edit");
		}
		if (tiers.hasRole(actor, ROLE_PROFILE_ADMIN) && notReadOnly)
			permitted.add("profile.award.grant");
		return permitted;
	}

	private boolean isSelfOrProfileAdmin(User actor, Integer targetUserId) {
		if (!tiers.authenticated(actor))
			return false;
		return actor.getUserId().equals(targetUserId) || tiers.hasRole(actor, ROLE_PROFILE_ADMIN);
	}
}
