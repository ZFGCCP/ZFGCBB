package com.zfgc.zfgbb.security;

import java.util.List;

import com.zfgc.zfgbb.model.users.Permission;

public interface Securable {
	public List<Permission> getPermissions();
}
