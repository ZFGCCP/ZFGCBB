package com.zfgc.zfgbb.exception.handlers;

import java.util.ConcurrentModificationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RuntimeExceptionHandler {
	
	/*@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) {
		//LOGGER.error("An unexpected error occured.", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occured. Please contact an administrator for assistance.");
	}
	
	@ExceptionHandler(value=ConcurrentModificationException.class)
	public ResponseEntity concurrentErrorHandler(HttpServletRequest req, ConcurrentModificationException e) {
		//LOGGER.error("An unexpected error occured.", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A concurrent modification error occured. Please refresh the page and try again.");
	}*/
	
}
