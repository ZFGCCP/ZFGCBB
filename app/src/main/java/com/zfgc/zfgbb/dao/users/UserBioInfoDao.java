package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.KeyedDao;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.dbo.UserBioInfoDboExample;
import com.zfgc.zfgbb.mappers.UserBioInfoDboMapper;

@Repository
public class UserBioInfoDao extends KeyedDao<UserBioInfoDbo, UserBioInfoDboExample, Integer> {

	public UserBioInfoDao(UserBioInfoDboMapper mapper) {
		super(mapper);
	}
}
