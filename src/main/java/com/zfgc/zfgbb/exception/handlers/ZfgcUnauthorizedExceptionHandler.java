package com.zfgc.zfgbb.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zfgc.zfgbb.exception.ZfgcUnauthorizedException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ZfgcUnauthorizedExceptionHandler {

	@ExceptionHandler(value=ZfgcUnauthorizedException.class)
	public ResponseEntity concurrentErrorHandler(HttpServletRequest req, ZfgcUnauthorizedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access attempted.");
	}
	
}
