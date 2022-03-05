package com.zfgc.zfgbb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDbo;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.mappers.BoardPermissionViewDboMapper;

@Repository
public class BoardPermissionViewDao extends AbstractDao<BoardPermissionViewDboExample, BoardPermissionViewDboMapper, BoardPermissionViewDbo>{
	
	@Autowired
	public BoardPermissionViewDao(BoardPermissionViewDboMapper mapper) {
		super(mapper);
	}

	@Override
	public BoardPermissionViewDbo get(Integer id) {
		return null;
	}

	@Override
	public List<BoardPermissionViewDbo> get(BoardPermissionViewDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(BoardPermissionViewDbo toSave) {
		
	}

	@Override
	protected void create(BoardPermissionViewDbo toCreate) {
		
	}
	
}