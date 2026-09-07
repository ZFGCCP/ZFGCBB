package com.zfgc.zfgbb.dataprovider.meta;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import com.zfgc.zfgbb.dao.meta.IpAddressDao;
import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.mapstruct.meta.IpAddressMap;
import com.zfgc.zfgbb.model.meta.IpAddress;

@Repository
@RequiredArgsConstructor
public class IpDataProvider {

	private final IpAddressDao ipDao;

	private final IpAddressMap ipAddressMap;
	
	public IpAddress createOrRetrieveIp(String ip) {
		IpAddressDboExample ex = new IpAddressDboExample();
		ex.createCriteria().andIpEqualTo(ip);
		
		IpAddressDbo result = ipDao.getOne(ex).orElse(null);
		
		if(result == null) {
			result = new IpAddressDbo();
			result.setIp(ip);
			//todo: add a regex for this
			result.setIpV6Flag(false);
			//todo: add stopforum spam for this
			result.setIsSpammerFlag(false);
			ipDao.save(result);
		}
		
		return ipAddressMap.toModel(result);
	}
}
