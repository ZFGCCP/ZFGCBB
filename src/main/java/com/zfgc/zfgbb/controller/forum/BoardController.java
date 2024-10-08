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
	
	@GetMapping("/{boardId}")
	public ResponseEntity getBoard(@PathVariable("boardId") Integer boardId) {
		return ResponseEntity.ok(forumService.getForum(boardId, super.zfgcUser()));
	}
}
