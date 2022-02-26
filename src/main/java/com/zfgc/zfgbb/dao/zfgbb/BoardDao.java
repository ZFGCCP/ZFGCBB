package com.zfgc.zfgbb.dao.zfgbb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.zfgbb.BoardDbo;
import com.zfgc.zfgbb.dbo.zfgbb.BoardDboExample;
import com.zfgc.zfgbb.mappers.BBCodeAttributeModeDboMapper;
import com.zfgc.zfgbb.mappers.BoardDboMapper;

@Repository
public class BoardDao extends AbstractDao<BoardDboExample, BoardDboMapper, BoardDbo>{

	@Autowired
    public BoardDao(BoardDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public BoardDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	protected void update(BoardDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(BoardDbo toCreate) {
		mapper.insert(toCreate);
	}

	@Override
	public List<BoardDbo> get(BoardDboExample ex) {
		return mapper.selectByExample(ex);
	}
	
}