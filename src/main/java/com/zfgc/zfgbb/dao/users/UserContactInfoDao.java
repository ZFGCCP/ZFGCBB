package com.zfgc.zfgbb.dao.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.UserContactInfoDbo;
import com.zfgc.zfgbb.dbo.UserContactInfoDboExample;
import com.zfgc.zfgbb.mappers.UserContactInfoDboMapper;

@Repository
public class UserContactInfoDao extends AbstractDao<UserContactInfoDboExample, UserContactInfoDboMapper, UserContactInfoDbo> {

	@Autowired
	public UserContactInfoDao(UserContactInfoDboMapper mapper) {
		super(mapper);
	}

	@Override
	public UserContactInfoDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserContactInfoDbo> get(UserContactInfoDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(UserContactInfoDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(UserContactInfoDbo toCreate) {
		mapper.insert(toCreate);
	}
} 