package com.zfgc.zfgbb.dao.zfgbb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.zfgbb.UserPermissionViewDbo;
import com.zfgc.zfgbb.dbo.zfgbb.UserPermissionViewDboExample;
import com.zfgc.zfgbb.mappers.UserPermissionViewDboMapper;

@Repository
public class UserPermissionViewDao extends AbstractDao<UserPermissionViewDboExample, UserPermissionViewDboMapper, UserPermissionViewDbo>{

	@Autowired
	public UserPermissionViewDao(UserPermissionViewDboMapper mapper) {
		super(mapper);
	}

	@Override
	public UserPermissionViewDbo get(Integer id) {
		return null;
	}

	@Override
	public List<UserPermissionViewDbo> get(UserPermissionViewDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(UserPermissionViewDbo toSave) {
		
	}

	@Override
	protected void create(UserPermissionViewDbo toCreate) {
		
	}
	
}