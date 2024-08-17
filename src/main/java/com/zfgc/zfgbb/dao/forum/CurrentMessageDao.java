package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.CurrentMessageDbo;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.mappers.CurrentMessageDboMapper;

@Repository
public class CurrentMessageDao extends AbstractDao<CurrentMessageDboExample, CurrentMessageDboMapper, CurrentMessageDbo>{

	public CurrentMessageDao(CurrentMessageDboMapper mapper) {
		super(mapper);
	}

	@Override
	public CurrentMessageDbo get(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<CurrentMessageDbo> get(CurrentMessageDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(CurrentMessageDbo toSave) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void create(CurrentMessageDbo toCreate) {
		throw new UnsupportedOperationException();
	}
	
}