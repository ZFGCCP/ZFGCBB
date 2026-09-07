package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.mappers.AvatarDboMapper;

@Repository
public class AvatarDao extends IdentityDao<AvatarDbo, AvatarDboExample> {

	public AvatarDao(AvatarDboMapper mapper) {
		super(mapper);
	}
}
