package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.GenderLkupDbo;
import com.zfgc.zfgbb.dbo.GenderLkupDboExample;
import com.zfgc.zfgbb.mappers.GenderLkupDboMapper;

@Repository
public class GenderLkupDao extends IdentityDao<GenderLkupDbo, GenderLkupDboExample> {

	public GenderLkupDao(GenderLkupDboMapper mapper) {
		super(mapper);
	}
}
