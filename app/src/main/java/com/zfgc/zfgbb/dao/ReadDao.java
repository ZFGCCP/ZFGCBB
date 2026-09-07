package com.zfgc.zfgbb.dao;

import java.util.List;
import java.util.Optional;

import com.zfgc.zfgbb.persistence.ReadMapper;

public abstract class ReadDao<Dbo, Example> {

	private final ReadMapper<Dbo, Example> readMapper;

	protected ReadDao(ReadMapper<Dbo, Example> readMapper) {
		this.readMapper = readMapper;
	}

	public List<Dbo> get(Example example) {
		return readMapper.selectByExampleWithLimits(example);
	}

	public Optional<Dbo> getOne(Example example) {
		return get(example).stream().findFirst();
	}

	public long count(Example example) {
		return readMapper.countByExample(example);
	}

	public boolean exists(Example example) {
		return count(example) > 0;
	}
}
