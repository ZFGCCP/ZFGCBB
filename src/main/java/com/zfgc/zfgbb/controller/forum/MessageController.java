package com.zfgc.zfgbb.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.controller.BaseController;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.services.forum.ForumService;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {
	
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/template")
	@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_CREATOR')")
	public ResponseEntity getMessageTemplate(@RequestParam("threadId") Integer threadId, Thread thread) {
		Message template = forumService.getMessageTemplate(thread.getBoardId(), thread.getThreadId(), null, super.zfgcUser());
		return ResponseEntity.ok(template);
	}
	
}