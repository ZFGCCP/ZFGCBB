package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.PermissionDbo;
import com.zfgc.zfgbb.dbo.PermissionDboExample;
import com.zfgc.zfgbb.mappers.PermissionDboMapper;

@Repository
public class PermissionDao extends IdentityDao<PermissionDbo, PermissionDboExample> {

	public PermissionDao(PermissionDboMapper mapper) {
		super(mapper);
	}
}
