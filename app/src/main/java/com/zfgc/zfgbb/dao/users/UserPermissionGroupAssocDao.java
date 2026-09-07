package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.UserPermissionGroupAssocDbo;
import com.zfgc.zfgbb.dbo.UserPermissionGroupAssocDboExample;
import com.zfgc.zfgbb.mappers.UserPermissionGroupAssocDboMapper;

@Repository
public class UserPermissionGroupAssocDao extends IdentityDao<UserPermissionGroupAssocDbo, UserPermissionGroupAssocDboExample> {

	public UserPermissionGroupAssocDao(UserPermissionGroupAssocDboMapper mapper) {
		super(mapper);
	}
}
