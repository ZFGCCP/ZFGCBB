package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.ReadDao;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDbo;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDboExample;
import com.zfgc.zfgbb.mappers.AllMessagesInThreadViewDboMapper;

@Repository
public class AllMessagesInThreadViewDao extends ReadDao<AllMessagesInThreadViewDbo, AllMessagesInThreadViewDboExample> {

	public AllMessagesInThreadViewDao(AllMessagesInThreadViewDboMapper mapper) {
		super(mapper);
	}
}
