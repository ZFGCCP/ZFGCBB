package com.zfgc.zfgbb.dao;

import java.util.Optional;

import com.zfgc.zfgbb.persistence.CrudMapper;

public abstract class KeyedDao<Dbo, Example, PrimaryKey> extends ReadDao<Dbo, Example> {

	private final CrudMapper<Dbo, Example, PrimaryKey> crudMapper;

	protected KeyedDao(CrudMapper<Dbo, Example, PrimaryKey> crudMapper) {
		super(crudMapper);
		this.crudMapper = crudMapper;
	}

	public Optional<Dbo> find(PrimaryKey primaryKey) {
		return Optional.ofNullable(crudMapper.selectByPrimaryKey(primaryKey));
	}

	public boolean existsWithPrimaryKey(PrimaryKey primaryKey) {
		return find(primaryKey).isPresent();
	}

	public void insert(Dbo row) {
		crudMapper.insert(row);
	}

	public void insertSelective(Dbo row) {
		crudMapper.insertSelective(row);
	}

	public int update(Dbo row) {
		return crudMapper.updateByPrimaryKey(row);
	}

	public int updateSelective(Dbo row) {
		return crudMapper.updateByPrimaryKeySelective(row);
	}

	public int updateWhere(Dbo row, Example example) {
		return crudMapper.updateByExampleSelective(row, example);
	}

	public void delete(PrimaryKey primaryKey) {
		crudMapper.deleteByPrimaryKey(primaryKey);
	}

	public int deleteWhere(Example example) {
		return crudMapper.deleteByExample(example);
	}
}
