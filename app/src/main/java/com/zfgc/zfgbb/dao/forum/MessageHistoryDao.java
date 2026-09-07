package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.mappers.MessageHistoryDboMapper;

@Repository
public class MessageHistoryDao extends IdentityDao<MessageHistoryDbo, MessageHistoryDboExample> {

	public MessageHistoryDao(MessageHistoryDboMapper mapper) {
		super(mapper);
	}
}
