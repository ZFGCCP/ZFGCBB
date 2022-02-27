package com.zfgc.zfgbb.dao.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.zfgbb.UserDbo;
import com.zfgc.zfgbb.dbo.zfgbb.UserDboExample;
import com.zfgc.zfgbb.mappers.UserDboMapper;

@Repository
public class UserDao extends AbstractDao<UserDboExample, UserDboMapper, UserDbo>{
	
	@Autowired
	public UserDao(UserDboMapper mapper) {
		super(mapper);
	}

	@Override
	public UserDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserDbo> get(UserDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(UserDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(UserDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}