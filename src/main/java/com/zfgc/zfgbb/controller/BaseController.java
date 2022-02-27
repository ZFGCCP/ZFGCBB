package com.zfgc.zfgbb.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.zfgc.zfgbb.model.User;

public class BaseController {
	@Autowired
	HttpServletRequest request;
	
	protected User zfgcUser(){
		Principal userPrincipal = request.getUserPrincipal();
		return (User) ((Authentication) userPrincipal).getPrincipal();
	}
}