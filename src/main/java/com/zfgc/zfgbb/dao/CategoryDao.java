package com.zfgc.zfgbb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.CategoryDbo;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.mappers.BBCodeAttributeModeDboMapper;
import com.zfgc.zfgbb.mappers.CategoryDboMapper;

@Repository
public class CategoryDao extends AbstractDao<CategoryDboExample, CategoryDboMapper, CategoryDbo>{

	@Autowired
    public CategoryDao(CategoryDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public CategoryDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CategoryDbo> get(CategoryDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(CategoryDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(CategoryDbo toCreate) {
		mapper.insert(toCreate);
	}

}
