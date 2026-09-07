package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.KeyedDao;
import com.zfgc.zfgbb.dbo.UserContactInfoDbo;
import com.zfgc.zfgbb.dbo.UserContactInfoDboExample;
import com.zfgc.zfgbb.mappers.UserContactInfoDboMapper;

@Repository
public class UserContactInfoDao extends KeyedDao<UserContactInfoDbo, UserContactInfoDboExample, Integer> {

	public UserContactInfoDao(UserContactInfoDboMapper mapper) {
		super(mapper);
	}
}
