package com.zfgc.zfgbb.dao.forum;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.mappers.MessageDboMapper;

@Repository
public class MessageDao extends IdentityDao<MessageDbo, MessageDboExample> {

	public MessageDao(MessageDboMapper mapper) {
		super(mapper);
	}
}
