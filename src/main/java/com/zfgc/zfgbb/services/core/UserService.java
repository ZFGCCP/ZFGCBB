package com.zfgc.zfgbb.services.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.zfgc.zfgbb.config.loadoption.user.FullUserLoadOptions;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.exception.ZfgcUnauthorizedException;
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
	
	@Autowired
	private UserDataProvider userDataProvider;
	
	public User createNewUser(User user) {
		userDataProvider.createUser(user);
		registerUserAtIdentity(user);
		return user;
	}
	
	private void registerUserAtIdentity(User user) {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(clientId, clientSecret);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity ent = new HttpEntity("{ \"username\" : \"" + user.getUsername() + "\", \"password\" : \"" + user.getPassword() + "\" }", headers);

		ResponseEntity resp = template.exchange(authEndpoint + "/users/register", HttpMethod.POST, ent, String.class);
		
		if(resp.getStatusCode().isError()) {
			throw new RuntimeException("Failed to create user " + user.getUsername() + " at identity provider. Error code: " + resp.getStatusCode().value());
		}
	}
	
	public User loadUser(Integer userId) {
		User user = userDataProvider.getUser(userId, new FullUserLoadOptions());
		return user;
	}
	
	public User saveUserProfile(User user, User zfgcUser) {
		
		//check admin permissions. A non-profile admin can only edit their own profile, and they cannot edit permissions.
		if(!zfgcUser.hasPermission("ZFGC_USER_PROFILE_ADMIN")) {
			user.setPermissions(null);
			
			if(!zfgcUser.getUserId().equals(user.getUserId())) {
				throw new ZfgcUnauthorizedException("User attempted to save another user's profile.", zfgcUser);
			}
		}
		
		return userDataProvider.saveUserProfile(user);
	}
}
