package com.zfgc.zfgbb.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.forum.ThreadSplit;
import com.zfgc.zfgbb.controller.BaseController;
import com.zfgc.zfgbb.services.forum.ForumService;

@RestController
@RequestMapping("/thread")
public class ThreadController extends BaseController {
	
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/template")
	public ResponseEntity getThreadTemplate(@RequestParam("boardId") Integer boardId) {
		Thread template = forumService.getThreadTemplate(boardId, super.zfgcUser());
		return ResponseEntity.ok(template);
	}
	
	@PostMapping
	public ResponseEntity saveThread(@RequestParam("boardId") Integer boardId, Thread thread) {
		Thread saved = forumService.saveThread(thread, super.zfgcUser());
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping("/{threadId}")
	public ResponseEntity getThread(@PathVariable("threadId") Integer threadId, @RequestParam("numPerPage") Integer numPerPage, @RequestParam("pageNo") Integer pageNo) {
		return ResponseEntity.ok(forumService.getThread(threadId, pageNo, numPerPage, super.zfgcUser()));
	}
	
	@DeleteMapping("/{threadId}")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_DELETER')")
	public ResponseEntity deleteThread(@PathVariable("threadId") Integer threadId) {
		forumService.deleteThread(threadId, super.zfgcUser());
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{threadId}/move/{boardId}")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_EDITOR')")
	public ResponseEntity moveThread(@PathVariable("threadId") Integer threadId, @PathVariable("boardId") Integer boardId) {
		return ResponseEntity.ok(forumService.moveThread(threadId, boardId, super.zfgcUser()));
	}
	
	@PutMapping("/{threadId}/lockToggle")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_EDITOR')")
	public ResponseEntity lockToggleThread(@PathVariable("threadId") Integer threadId) {
		return ResponseEntity.ok(forumService.toggleLocked(threadId, super.zfgcUser()));
	}
	
	@PutMapping("/{threadId}/stickyToggle")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_EDITOR')")
	public ResponseEntity stickyToggleThread(@PathVariable("threadId") Integer threadId) {
		return ResponseEntity.ok(forumService.toggleSticky(threadId, super.zfgcUser()));
	}
	
	@GetMapping("/{threadId}/split")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_EDITOR')")
	public ResponseEntity getThreadSplitTemplate(@PathVariable("threadId") Integer threadId) {
		return ResponseEntity.ok(forumService.getSplitTemplate(threadId, super.zfgcUser()));
	}
	
	@PostMapping("/{threadId}/split")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_EDITOR')")
	public ResponseEntity splitThread(@PathVariable("threadId") Integer threadId, ThreadSplit threadSplit) {
		return ResponseEntity.ok(forumService.splitThread(threadSplit, super.zfgcUser()));
	}
}