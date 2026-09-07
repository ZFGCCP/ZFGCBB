package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.ReadDao;
import com.zfgc.zfgbb.dbo.CurrentMessageDbo;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.mappers.CurrentMessageDboMapper;

@Repository
public class CurrentMessageDao extends ReadDao<CurrentMessageDbo, CurrentMessageDboExample> {

	public CurrentMessageDao(CurrentMessageDboMapper mapper) {
		super(mapper);
	}
}
