package com.zfgc.zfgbb.controller;

import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.config.security.OauthUsersDetailsServiceImpl;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.AuthCredentials;
import com.zfgc.zfgbb.services.core.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
	
	@Autowired
	private OauthUsersDetailsServiceImpl oauthService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/loggedInUser")
	public ResponseEntity getLoggedInUser() {
		return ResponseEntity.ok(zfgcUser());
	}
	
	@PostMapping("auth/login")
	public ResponseEntity login(@RequestBody AuthCredentials credentials) {
		String result = oauthService.getLoginToken(credentials);
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity registerNewUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.createNewUser(user));
	}
}