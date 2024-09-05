package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.PollDbo;
import com.zfgc.zfgbb.dbo.PollDboExample;
import com.zfgc.zfgbb.mappers.PollDboMapper;

@Repository
public class PollDao extends AbstractDao<PollDboExample, PollDboMapper, PollDbo> {

	@Autowired
	public PollDao(PollDboMapper mapper) {
		super(mapper);
	}

	@Override
	public PollDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PollDbo> get(PollDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(PollDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(PollDbo toCreate) {
		mapper.insert(toCreate);
	}

}
