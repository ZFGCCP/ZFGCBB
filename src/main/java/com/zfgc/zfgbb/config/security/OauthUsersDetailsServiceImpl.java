package com.zfgc.zfgbb.config.security;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
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

	@Value("${clausius.client}")
	private String clientId;
	
	@Value("${clausius.password}")
	private String clientSecret;
	
	@Value("${clausius.authEndpoint}")
	private String authEndpoint;
	
	@Autowired
	private UserDataProvider userDataProvider;
	 
	@Override
	public UserDetails loadUserByUsername(String ssoKey) throws UsernameNotFoundException {
		return userDataProvider.getUser(ssoKey);
	}
	
	public String getLoginToken(AuthCredentials credentials) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(clientId, clientSecret);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		//todo: move these paramters into the request body
		HttpEntity ent = new HttpEntity("grant_type=password&scope=all&username=" + credentials.getUsername() + "&password=" + credentials.getPassword(), headers);

		ResponseEntity<String> result = template.exchange(authEndpoint + "/oauth/token", HttpMethod.POST, ent, String.class);
		return result.getBody();
	}

}