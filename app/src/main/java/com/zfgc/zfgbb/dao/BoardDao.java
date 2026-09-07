package com.zfgc.zfgbb.dao;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.mappers.BoardDboMapper;

@Repository
public class BoardDao extends IdentityDao<BoardDbo, BoardDboExample> {

	public BoardDao(BoardDboMapper mapper) {
		super(mapper);
	}
}
