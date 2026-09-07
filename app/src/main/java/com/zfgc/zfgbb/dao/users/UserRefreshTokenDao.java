package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDbo;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDboExample;
import com.zfgc.zfgbb.mappers.UserRefreshTokenDboMapper;

@Repository
public class UserRefreshTokenDao extends IdentityDao<UserRefreshTokenDbo, UserRefreshTokenDboExample> {

	public UserRefreshTokenDao(UserRefreshTokenDboMapper mapper) {
		super(mapper);
	}
}
