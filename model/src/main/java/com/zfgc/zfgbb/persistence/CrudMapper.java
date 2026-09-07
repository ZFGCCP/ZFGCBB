package com.zfgc.zfgbb.persistence;

import org.apache.ibatis.annotations.Param;

public interface CrudMapper<Dbo, Example, PrimaryKey> extends ReadMapper<Dbo, Example> {

	Dbo selectByPrimaryKey(PrimaryKey primaryKey);

	int insert(Dbo row);

	int insertSelective(Dbo row);

	int updateByPrimaryKey(Dbo row);

	int updateByPrimaryKeySelective(Dbo row);

	int updateByExample(@Param("row") Dbo row, @Param("example") Example example);

	int updateByExampleSelective(@Param("row") Dbo row, @Param("example") Example example);

	int deleteByPrimaryKey(PrimaryKey primaryKey);

	int deleteByExample(Example example);
}
