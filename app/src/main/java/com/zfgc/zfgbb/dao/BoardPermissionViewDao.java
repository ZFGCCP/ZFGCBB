package com.zfgc.zfgbb.dao;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dbo.BoardPermissionViewDbo;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.mappers.BoardPermissionViewDboMapper;

@Repository
public class BoardPermissionViewDao extends ReadDao<BoardPermissionViewDbo, BoardPermissionViewDboExample> {

	public BoardPermissionViewDao(BoardPermissionViewDboMapper mapper) {
		super(mapper);
	}
}
