package com.zfgc.zfgbb.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.controller.BaseController;
import com.zfgc.zfgbb.services.forum.ForumService;
import com.zfgc.zfgbb.model.forum.Thread;

@RestController
@RequestMapping("/board")
public class BoardController extends BaseController {

	@Autowired
	private ForumService forumService;
	
	@GetMapping("/{boardId}/thread/template")
	public ResponseEntity getThreadTemplate(@PathVariable("boardId") Integer boardId) {
		Thread template = forumService.getThreadTemplate(boardId, super.zfgcUser());
		return ResponseEntity.ok(template);
	}
	
	@PostMapping("/{boardId}/thread")
	public ResponseEntity saveThread(@PathVariable("boardId") Integer boardId, Thread thread) {
		Thread saved = forumService.saveThread(thread, super.zfgcUser());
		return ResponseEntity.ok(saved);
	}
}
