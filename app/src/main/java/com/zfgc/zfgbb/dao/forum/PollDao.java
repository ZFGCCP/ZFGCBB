package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.PollDbo;
import com.zfgc.zfgbb.dbo.PollDboExample;
import com.zfgc.zfgbb.mappers.PollDboMapper;

@Repository
public class PollDao extends IdentityDao<PollDbo, PollDboExample> {

	public PollDao(PollDboMapper mapper) {
		super(mapper);
	}
}
