package com.zfgc.zfgbb.authorization;

import com.zfgc.zfgbb.model.users.User;

public interface ResourceAccessRules {

	boolean supports(String resourceType);

	boolean allows(User actor, String resourceType, int targetId, String action);
}
