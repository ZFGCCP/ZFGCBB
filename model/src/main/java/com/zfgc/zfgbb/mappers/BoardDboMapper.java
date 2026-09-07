package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public interface BoardDboMapper extends VersionedIdentityCrudMapper<BoardDbo, BoardDboExample, Integer> {
}