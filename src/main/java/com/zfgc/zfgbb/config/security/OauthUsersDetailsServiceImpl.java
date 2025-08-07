package com.zfgc.zfgbb.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zfgc.zfgbb.dao.users.EmailAddressDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dao.UserPermissionViewDao;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.EmailAddressDboExample;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.dbo.UserPermissionViewDboExample;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.AuthCredentials;

@Service
public class OauthUsersDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDataProvider userDataProvider;
	 
	@Override
	public UserDetails loadUserByUsername(String ssoKey) throws UsernameNotFoundException {
		return userDataProvider.getUser(ssoKey);
	}
	
	public String getLoginToken(AuthCredentials credentials) {
		return "";
	}
	
	

}