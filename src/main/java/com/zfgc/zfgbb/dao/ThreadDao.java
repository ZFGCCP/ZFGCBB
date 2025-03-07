package com.zfgc.zfgbb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.mappers.CategoryDboMapper;
import com.zfgc.zfgbb.mappers.ThreadDboMapper;

@Repository
public class ThreadDao extends AbstractDao<ThreadDboExample, ThreadDboMapper, ThreadDbo>{

	@Autowired
    public ThreadDao(ThreadDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public ThreadDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ThreadDbo> get(ThreadDboExample ex) {
		return mapper.selectByExampleWithRange(ex);
	}

	@Override
	protected void update(ThreadDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(ThreadDbo toCreate) {
		mapper.insert(toCreate);
	}
	
	@Override
	public void delete(ThreadDboExample ex) {
		mapper.deleteByExample(ex);
	}
	
}