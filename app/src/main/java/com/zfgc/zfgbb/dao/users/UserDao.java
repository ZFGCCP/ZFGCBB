package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.mappers.UserDboMapper;

@Repository
public class UserDao extends IdentityDao<UserDbo, UserDboExample> {

	public UserDao(UserDboMapper mapper) {
		super(mapper);
	}
}
