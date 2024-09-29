package com.zfgc.zfgbb.dao.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.mappers.AvatarDboMapper;

@Repository
public class AvatarDao extends AbstractDao<AvatarDboExample, AvatarDboMapper, AvatarDbo> {

	@Autowired
	public AvatarDao(AvatarDboMapper mapper) {
		super(mapper);
	}

	@Override
	public AvatarDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AvatarDbo> get(AvatarDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(AvatarDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
		
	}

	@Override
	protected void create(AvatarDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}