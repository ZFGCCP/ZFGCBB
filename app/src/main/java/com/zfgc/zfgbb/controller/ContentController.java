package com.zfgc.zfgbb.controller;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.services.core.ContentService;
import com.zfgc.zfgbb.authorization.AllowAnonymous;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController extends BaseController {

	private final ContentService contentService;

	@GetMapping("image/{resourceId}")
	@AllowAnonymous
	public ResponseEntity<Resource> getImageResource(@PathVariable("resourceId") Integer resourceId)
			throws MalformedURLException {
		ContentResourceDbo dbo = contentService.getContentResourceDbo(resourceId);
		Resource resource = contentService.getImageResource(resourceId);
		String displayName = dbo != null ? dbo.getFilename() : resource.getFilename();
		return ResponseEntity.ok()
				.contentType(
						contentService.getMimeType(displayName).orElse(MediaType.APPLICATION_OCTET_STREAM))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + displayName + "\"")
				.body(resource);
	}

}