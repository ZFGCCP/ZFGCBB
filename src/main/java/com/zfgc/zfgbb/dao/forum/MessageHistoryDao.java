package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.mappers.MessageHistoryDboMapper;

@Repository
public class MessageHistoryDao extends AbstractDao<MessageHistoryDboExample, MessageHistoryDboMapper, MessageHistoryDbo> {

	public MessageHistoryDao(MessageHistoryDboMapper mapper) {
		super(mapper);
	}

	@Override
	public MessageHistoryDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MessageHistoryDbo> get(MessageHistoryDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(MessageHistoryDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(MessageHistoryDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}