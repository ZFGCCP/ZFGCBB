package com.zfgc.zfgbb.dao.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.dbo.UserBioInfoDboExample;
import com.zfgc.zfgbb.mappers.UserBioInfoDboMapper;

@Repository
public class UserBioInfoDao extends AbstractDao<UserBioInfoDboExample, UserBioInfoDboMapper, UserBioInfoDbo> {

	@Autowired
	public UserBioInfoDao(UserBioInfoDboMapper mapper) {
		super(mapper);
	}

	@Override
	public UserBioInfoDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserBioInfoDbo> get(UserBioInfoDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(UserBioInfoDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
		
	}

	@Override
	protected void create(UserBioInfoDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}