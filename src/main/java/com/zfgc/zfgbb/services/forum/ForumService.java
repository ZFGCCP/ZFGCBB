package com.zfgc.zfgbb.services.forum;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dataprovider.forum.ForumDataProvider;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.forum.Thread;

@Service
public class ForumService {
	
	@Autowired
	private ForumDataProvider forumDataProvider;
	
	public Forum getForum(Integer boardId, User zfgcUser) {
		Forum forum = forumDataProvider.getForum(boardId);
		
		secureForum(forum, zfgcUser);
		
		return forum;
	}
	
	public Thread getThread(Integer threadId, Integer page, Integer count, User zfgcUser) {
		Thread thread = forumDataProvider.getThread(threadId, page, count);
		
		secureThread(thread, zfgcUser);
		return thread;
	}
	
	public List<Message> getThreadMessages(Integer boardId, Integer threadId, Integer page, Integer count, User zfgcUser){
		Thread temp = new Thread();
		temp.setBoardPermissions(forumDataProvider.getBoardPermissions(boardId));
		secureThread(temp, zfgcUser);
		
		return forumDataProvider.getMessagesForThread(threadId, page, count);
	}
	
	private void secureThread(Thread thread, User zfgcUser) {
		Set<Integer> userPerms = zfgcUser.getPermissions().stream().map(Permission::getPermissionId).collect(Collectors.toSet());
		thread.getBoardPermissions().forEach(perm -> {
			if(userPerms.contains(perm.getPermissionId())) {
				return;
			}
		});
	}
	
	private void secureForum(Forum forum, User zfgcUser) {
		Set<Integer> userPerms = zfgcUser.getPermissions().stream().map(Permission::getPermissionId).collect(Collectors.toSet());
		forum.getBoardPermissions().forEach(perm -> {
			if(userPerms.contains(perm.getPermissionId())) {
				return;
			}
		});
		
		//ResponseExceptionProvider.throwNotFoundException("The board you attempted to access could not be found.");
	}
	
}