package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.PollQuestionDbo;
import com.zfgc.zfgbb.dbo.PollQuestionDboExample;
import com.zfgc.zfgbb.mappers.PollQuestionDboMapper;

@Repository
public class PollQuestionDao extends AbstractDao<PollQuestionDboExample, PollQuestionDboMapper, PollQuestionDbo> {

	@Autowired
	public PollQuestionDao(PollQuestionDboMapper mapper) {
		super(mapper);
	}

	@Override
	public PollQuestionDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PollQuestionDbo> get(PollQuestionDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(PollQuestionDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(PollQuestionDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}