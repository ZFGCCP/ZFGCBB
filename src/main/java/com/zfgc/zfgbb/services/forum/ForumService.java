package com.zfgc.zfgbb.services.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zfgc.zfgbb.dataprovider.forum.ForumDataProvider;
import com.zfgc.zfgbb.dataprovider.forum.ThreadDataProvider;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.services.AbstractService;
import com.zfgc.zfgbb.model.forum.Thread;

@Service
public class ForumService extends AbstractService {
	
	@Autowired
	private ForumDataProvider forumDataProvider;
	
	@Autowired
	private BBCodeService bbCodeService;
	
	@Autowired
	private ThreadDataProvider threadDataProvider;
	
	public Forum getForum(Integer boardId, User zfgcUser) {
		Forum forum = forumDataProvider.getForum(boardId);
		
		super.secureObject(forum, zfgcUser);
		
		return forum;
	}
	
	public Thread createThread(Thread thread, User zfgcUser) {
		//first, lets make sure the user actually can post to this board
		thread.setBoardPermissions(forumDataProvider.getBoardPermissions(thread.getBoardId()));
		super.secureObject(thread, zfgcUser);
		
		//then ensure the user didn't fuck with the owner of the thread template
		thread.setCreatedUserId(zfgcUser.getUserId());
		
		//finally, save the thread
		thread = threadDataProvider.saveThread(thread);
		
		return thread;
	}
	
	public Thread getThread(Integer threadId, Integer page, Integer count, User zfgcUser) {
		Thread thread = threadDataProvider.getThread(threadId, page, count);
		
		super.secureObject(thread, zfgcUser);
		
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
	
}