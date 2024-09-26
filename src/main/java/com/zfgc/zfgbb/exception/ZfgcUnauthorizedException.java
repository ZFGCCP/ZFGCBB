package com.zfgc.zfgbb.exception;

import com.zfgc.zfgbb.model.User;

public class ZfgcUnauthorizedException extends RuntimeException {
	
	public ZfgcUnauthorizedException(String message, User user) {
		super("Unauthorized action by user " + user.getUserId() + ". Detailed Message: " + message);
	}
	
}