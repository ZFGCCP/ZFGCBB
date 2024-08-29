package com.zfgc.zfgbb.dao.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.mappers.IpAddressDboMapper;

@Repository
public class IpAddressDao extends AbstractDao<IpAddressDboExample, IpAddressDboMapper, IpAddressDbo> {
	
	@Autowired
	public IpAddressDao(IpAddressDboMapper mapper) {
		super(mapper);
	}

	@Override
	public IpAddressDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<IpAddressDbo> get(IpAddressDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(IpAddressDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(IpAddressDbo toCreate) {
		mapper.insert(toCreate);
	}

}
