package com.zfgc.zfgbb.dao.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.mappers.ContentResourceDboMapper;

@Repository
public class ContentResourceDao extends AbstractDao<ContentResourceDboExample, ContentResourceDboMapper, ContentResourceDbo>{

	@Autowired
	public ContentResourceDao(ContentResourceDboMapper mapper) {
		super(mapper);
	}

	@Override
	public ContentResourceDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ContentResourceDbo> get(ContentResourceDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(ContentResourceDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(ContentResourceDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}