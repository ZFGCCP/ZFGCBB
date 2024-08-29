package com.zfgc.zfgbb.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dataprovider.core.IpDataProvider;
import com.zfgc.zfgbb.model.meta.IpAddress;
import com.zfgc.zfgbb.services.AbstractService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class IpService extends AbstractService {
	
	@Autowired
	private IpDataProvider ipDataProvider;
	
	@Autowired
	private HttpServletRequest request;
	
	public IpAddress getClientIp() {
		return ipDataProvider.createOrRetrieveIp(request.getRemoteAddr());
	}
	
}