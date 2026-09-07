package com.zfgc.zfgbb.dao.meta;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.mappers.IpAddressDboMapper;

@Repository
public class IpAddressDao extends IdentityDao<IpAddressDbo, IpAddressDboExample> {

	public IpAddressDao(IpAddressDboMapper mapper) {
		super(mapper);
	}
}
