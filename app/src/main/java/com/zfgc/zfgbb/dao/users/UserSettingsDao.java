package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.KeyedDao;
import com.zfgc.zfgbb.dbo.UserSettingsDbo;
import com.zfgc.zfgbb.dbo.UserSettingsDboExample;
import com.zfgc.zfgbb.mappers.UserSettingsDboMapper;

@Repository
public class UserSettingsDao extends KeyedDao<UserSettingsDbo, UserSettingsDboExample, Integer> {

	public UserSettingsDao(UserSettingsDboMapper mapper) {
		super(mapper);
	}
}
