package com.zfgc.zfgbb.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity getBoard(@PathVariable("boardId") Integer boardId, @RequestParam(name="pageNo",required=false) Integer pageNo) {
		return ResponseEntity.ok(forumService.getBoard(boardId, pageNo, super.zfgcUser()));
	}
	
	@GetMapping("/forum")
	public ResponseEntity getForum() {
		return ResponseEntity.ok(forumService.getForum(super.zfgcUser()));
	}
}
