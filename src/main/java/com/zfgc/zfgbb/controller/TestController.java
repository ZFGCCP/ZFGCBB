package com.zfgc.zfgbb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {
	
	@GetMapping("/")
	public ResponseEntity test() {
		zfgcUser();
		return ResponseEntity.ok().build();
	}
	
}