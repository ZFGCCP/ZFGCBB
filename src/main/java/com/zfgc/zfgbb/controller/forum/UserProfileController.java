package com.zfgc.zfgbb.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.controller.BaseController;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.services.core.UserService;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	//@PreAuthorize("hasAnyRole('ROLE_ZFGC_PROFILE_VIEWER','ROLE_ZFGC_PROFILE_EDITOR','ROLE_ZFGC_PROFILE_ADMIN')")
	public ResponseEntity getUserProfile(@PathVariable("userId") Integer userId) {
		return ResponseEntity.ok(userService.loadUser(userId));
	}
	
	@PostMapping("/{userId}")
	@PreAuthorize("hasAnyRole('ROLE_ZFGC_PROFILE_EDITOR','ROLE_ZFGC_PROFILE_ADMIN')")
	public ResponseEntity saveUserProfile(@PathVariable("userId") Integer userId, @RequestBody User user) {
		return ResponseEntity.ok(userService.saveUserProfile(user, zfgcUser()));
	}
	
}