package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.mappers.BoardDboMapper;
import com.zfgc.zfgbb.mappers.MessageDboMapper;

@Repository
public class MessageDao extends AbstractDao<MessageDboExample, MessageDboMapper, MessageDbo>{

	@Autowired
    public MessageDao(MessageDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public MessageDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	protected void update(MessageDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(MessageDbo toCreate) {
		mapper.insert(toCreate);
	}

	@Override
	public List<MessageDbo> get(MessageDboExample ex) {
		return mapper.selectByExample(ex);
	}
	
	public List<MessageDbo> getWithLimit(MessageDboExample ex, Integer start, Integer total){
		return mapper.selectByExampleWithLimit(ex, start, total);
	}
	
}