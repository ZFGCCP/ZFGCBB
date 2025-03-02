package com.zfgc.zfgbb.dao.forum;

import java.time.LocalDateTime;
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
		toSave.setUpdatedTs(LocalDateTime.now());
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(MessageDbo toCreate) {
		toCreate.setCreatedTs(LocalDateTime.now());
		toCreate.setUpdatedTs(LocalDateTime.now());
		mapper.insert(toCreate);
	}

	@Override
	public List<MessageDbo> get(MessageDboExample ex) {
		return mapper.selectByExample(ex);
	}
	
	@Override
	public void delete(MessageDboExample ex) {
		mapper.deleteByExample(ex);
	}
	
}