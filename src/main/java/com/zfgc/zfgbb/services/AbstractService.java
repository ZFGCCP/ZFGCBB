package com.zfgc.zfgbb.services;

import java.util.Set;
import java.util.stream.Collectors;

import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.security.Securable;

public abstract class AbstractService {
	
	protected void secureObject(Securable secureThis, User zfgcUser) {
		Set<Integer> userPerms = zfgcUser.getPermissions().stream().map(Permission::getPermissionId).collect(Collectors.toSet());
		secureThis.getPermissions().forEach(perm -> {
			if(userPerms.contains(perm.getPermissionId())) {
				return;
			}
		});
		
		throw new ZfgcNotFoundException();
	}
	
}