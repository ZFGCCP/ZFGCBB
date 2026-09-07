package com.zfgc.zfgbb.controller.forum;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.controller.BaseController;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.services.forum.ForumService;
import com.zfgc.zfgbb.authorization.AllowAnonymous;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController extends BaseController {
	
	private final ForumService forumService;
	
	@GetMapping("/template")
	//@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_CREATOR')")
	@AllowAnonymous
	public ResponseEntity getMessageTemplate(@RequestParam("threadId") Integer threadId) {
		Message template = forumService.getMessageTemplate(null, threadId, null, super.zfgcUser());
		return ResponseEntity.ok(template);
	}
	
	@PostMapping("/{threadId}")
	//@PreAuthorize("hasRole('ROLE_ZFGC_THREAD_POSTER')")
	public ResponseEntity addMessageToThread(@PathVariable Integer threadId, @RequestBody Message message) {
		return ResponseEntity.ok(forumService.saveMessage(message, super.zfgcUser()));
	}
	
	@GetMapping("/user/{userId}")
	@AllowAnonymous
	public List<Message> getMessagesByUser(@PathVariable Integer userId,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "pageSize", required = false) Integer pageSize) {
		return forumService.getMessagesByUserId(userId, page, pageSize, super.zfgcUser().permissionIds());
	}
	
}