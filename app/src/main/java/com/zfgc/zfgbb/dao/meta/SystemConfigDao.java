package com.zfgc.zfgbb.dao.meta;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.KeyedDao;
import com.zfgc.zfgbb.dbo.SystemConfigDbo;
import com.zfgc.zfgbb.dbo.SystemConfigDboExample;
import com.zfgc.zfgbb.mappers.SystemConfigDboMapper;

@Repository
public class SystemConfigDao extends KeyedDao<SystemConfigDbo, SystemConfigDboExample, String> {

	public SystemConfigDao(SystemConfigDboMapper mapper) {
		super(mapper);
	}
}
