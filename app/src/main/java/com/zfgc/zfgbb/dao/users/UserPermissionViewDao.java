package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.ReadDao;
import com.zfgc.zfgbb.dbo.UserPermissionViewDbo;
import com.zfgc.zfgbb.dbo.UserPermissionViewDboExample;
import com.zfgc.zfgbb.mappers.UserPermissionViewDboMapper;

@Repository
public class UserPermissionViewDao extends ReadDao<UserPermissionViewDbo, UserPermissionViewDboExample> {

	public UserPermissionViewDao(UserPermissionViewDboMapper mapper) {
		super(mapper);
	}
}
