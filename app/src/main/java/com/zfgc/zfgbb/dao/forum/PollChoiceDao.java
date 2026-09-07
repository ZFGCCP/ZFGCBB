package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.PollChoiceDbo;
import com.zfgc.zfgbb.dbo.PollChoiceDboExample;
import com.zfgc.zfgbb.mappers.PollChoiceDboMapper;

@Repository
public class PollChoiceDao extends IdentityDao<PollChoiceDbo, PollChoiceDboExample> {

	public PollChoiceDao(PollChoiceDboMapper mapper) {
		super(mapper);
	}
}
