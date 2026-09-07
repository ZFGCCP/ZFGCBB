package com.zfgc.zfgbb.dao;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.mappers.ThreadDboMapper;

@Repository
public class ThreadDao extends IdentityDao<ThreadDbo, ThreadDboExample> {

	public ThreadDao(ThreadDboMapper mapper) {
		super(mapper);
	}
}
