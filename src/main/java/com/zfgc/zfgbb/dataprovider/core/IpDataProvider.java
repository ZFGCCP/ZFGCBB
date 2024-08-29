package com.zfgc.zfgbb.dataprovider.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.core.IpAddressDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.model.meta.IpAddress;

@Repository
public class IpDataProvider extends AbstractDataProvider {
	@Autowired
	private IpAddressDao ipDao;
	
	public IpAddress createOrRetrieveIp(String ip) {
		IpAddressDboExample ex = new IpAddressDboExample();
		ex.createCriteria().andIpEqualTo(ip);
		
		IpAddressDbo result = ipDao.get(ex).stream().findFirst().orElse(null);
		
		if(result == null) {
			result = new IpAddressDbo();
			result.setIp(ip);
			//todo: add a regex for this
			result.setIpV6Flag(false);
			//todo: add stopforum spam for this
			result.setIsSpammerFlag(false);
			ipDao.save(result);
		}
		
		return mapper.map(result, IpAddress.class);
	}
}
