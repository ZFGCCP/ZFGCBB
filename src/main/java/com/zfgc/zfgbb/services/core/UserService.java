package com.zfgc.zfgbb.services.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.zfgc.zfgbb.model.User;

@Service
@Transactional
public class UserService {
	@Value("${clausius.client}")
	private String clientId;
	
	@Value("${clausius.password}")
	private String clientSecret;
	
	@Value("${clausius.authEndpoint}")
	private String authEndpoint;
	
	private void registerUserAtIdentity(User user) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(clientId, clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity ent = new HttpEntity("{ \"username\" : \"" + user.getUsername() + "\", \"password\" : \"" + user.getPassword() + "\" }", headers);

		template.exchange(authEndpoint + "/users/register", HttpMethod.POST, ent, String.class);
	}
}
