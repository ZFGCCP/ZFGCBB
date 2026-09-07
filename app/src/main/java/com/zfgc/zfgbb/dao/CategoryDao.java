package com.zfgc.zfgbb.dao;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dbo.CategoryDbo;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.mappers.CategoryDboMapper;

@Repository
public class CategoryDao extends IdentityDao<CategoryDbo, CategoryDboExample> {

	public CategoryDao(CategoryDboMapper mapper) {
		super(mapper);
	}
}
