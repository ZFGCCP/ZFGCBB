package com.zfgc.zfgbb.services.forum;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dataprovider.forum.ForumDataProvider;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.forum.Thread;

@Service
public class ForumService {
	
	@Autowired
	private ForumDataProvider forumDataProvider;
	
	@Autowired
	private BBCodeService bbCodeService;
	
	public Forum getForum(Integer boardId, User zfgcUser) {
		Forum forum = forumDataProvider.getForum(boardId);
		
		secureForum(forum, zfgcUser);
		
		return forum;
	}
	
	public Thread createThread(Thread thread, User zfgcUser) {
		//first, lets make sure the user actually can post to this board
		thread.setBoardPermissions(forumDataProvider.getBoardPermissions(thread.getBoardId()));
		secureThread(thread, zfgcUser);
		
		//then ensure the user didn't fuck with the owner of the thread template
		thread.setCreatedUserId(zfgcUser.getUserId());
		
		return thread;
	}
	
	public Thread getThread(Integer threadId, Integer page, Integer count, User zfgcUser) {
		Thread thread = forumDataProvider.getThread(threadId, page, count);
		
		secureThread(thread, zfgcUser);
		
		//parse messages
		thread.getMessages().forEach(message -> {
			try {
				String parsed = bbCodeService.parseText(message.getCurrentMessage().getMessageText());
				message.getCurrentMessage().setMessageText(parsed);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
		
		return thread;
	}
	
	private void secureThread(Thread thread, User zfgcUser) {
		Set<Integer> userPerms = zfgcUser.getPermissions().stream().map(Permission::getPermissionId).collect(Collectors.toSet());
		thread.getBoardPermissions().forEach(perm -> {
			if(userPerms.contains(perm.getPermissionId())) {
				return;
			}
		});
		
		throw new ZfgcNotFoundException();
	}
	
	private void secureForum(Forum forum, User zfgcUser) {
		Set<Integer> userPerms = zfgcUser.getPermissions().stream().map(Permission::getPermissionId).collect(Collectors.toSet());
		forum.getBoardPermissions().forEach(perm -> {
			if(userPerms.contains(perm.getPermissionId())) {
				return;
			}
		});
		
		throw new ZfgcNotFoundException();
	}
	
}