package com.zfgc.zfgbb.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Permission;

import jakarta.servlet.http.HttpServletRequest;

public class BaseController {
	@Autowired
	HttpServletRequest request;
	
	protected User zfgcUser(){
		Principal userPrincipal = request.getUserPrincipal();
		
		if(userPrincipal == null) {
			return createGuest();
		}
		
		
		
		return (User) ((Authentication) userPrincipal).getPrincipal();
	}
	
	private User createGuest() {
		User guest = new User();
		Permission guestPerm = new Permission();
		guest.setDisplayName("Friend");
		guest.setUserId(-1);
		guestPerm.setId(2);
		guestPerm.setPermissionCode("ZFGC_GUEST");
		
		guest.getPermissions().add(guestPerm);
		
		return guest;
	}
}