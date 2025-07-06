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
	
	@Autowired
	private UserDataProvider userDataProvider;
	
	public User createNewUser(User user) {
		userDataProvider.createUser(user);
		registerUserAtIdentity(user);
		return user;
	}
	
	private void registerUserAtIdentity(User user) {
		
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
