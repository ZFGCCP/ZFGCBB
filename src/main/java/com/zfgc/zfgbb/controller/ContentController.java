package com.zfgc.zfgbb.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.services.core.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController extends BaseController {

	@Autowired
	private ContentService contentService;
	
	@GetMapping("image/{resourceId}")
	public ResponseEntity getImageResource(@PathVariable("resourceId") Integer resourceId) throws MalformedURLException {
		return prepareResource(contentService.getImageResource(resourceId));
	}
	
	private ResponseEntity prepareResource(Resource resource) {
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_GIF)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
}