package com.zfgc.zfgbb.services.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dataprovider.forum.ForumDataProvider;
import com.zfgc.zfgbb.dataprovider.forum.MessageDataProvider;
import com.zfgc.zfgbb.dataprovider.forum.ThreadDataProvider;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.services.AbstractService;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.forum.ThreadSplit;

@Service
@Transactional
public class ForumService extends AbstractService {
	
	@Autowired
	private ForumDataProvider forumDataProvider;
	
	@Autowired
	private BBCodeService bbCodeService;
	
	@Autowired
	private ThreadDataProvider threadDataProvider;
	
	@Autowired
	private MessageDataProvider messageDataProvider;
	
	public Forum getForum(Integer boardId, User zfgcUser) {
		Forum forum = forumDataProvider.getForum(boardId);
		
		super.secureObject(forum, zfgcUser);
		
		return forum;
	}
	
	public Thread getThreadTemplate(Integer boardId, User zfgcUser) {
		Thread thread = new Thread();
		thread.setBoardId(boardId);
		thread.setCreatedUserId(zfgcUser.getUserId());
		thread.setBoardPermissions(forumDataProvider.getBoardPermissions(thread.getBoardId()));
		super.secureObject(thread, zfgcUser);
		
		Message message = getMessageTemplate(boardId, null, null, zfgcUser);
		thread.getMessages().add(message);
		
		return thread;
	}
	
	public Message getMessageTemplate(Integer boardId, Integer threadId, Integer messageId, User zfgcUser) {
		Thread permissionCheck = new Thread();
		permissionCheck.setBoardPermissions(forumDataProvider.getBoardPermissions(boardId));
		super.secureObject(permissionCheck, zfgcUser);
		
		Message message = null;
		if(messageId != null) {
			message = messageDataProvider.getMessage(messageId);
		}
		else {
			message = new Message();
			message.setOwnerId(zfgcUser.getUserId());
			message.setThreadId(threadId);
		}
		
		//add a new history record
		message.getHistory().forEach(hist -> {
			try {
				hist.setMessageText(bbCodeService.parseText(hist.getMessageText()));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			hist.setCurrentFlag(false);
		});
		MessageHistory hist = new MessageHistory();
		hist.setCurrentFlag(true);
		hist.setMessageId(messageId);
		message.getHistory().add(hist);
		
		return message;
		
	}
	
	public Thread saveThread(Thread thread, User zfgcUser) {
		//first, lets make sure the user actually can post to this board
		thread.setBoardPermissions(forumDataProvider.getBoardPermissions(thread.getBoardId()));
		super.secureObject(thread, zfgcUser);
		
		Thread saved = threadDataProvider.getThread(thread.getThreadId(), 1, 1);
		
		//then ensure the user didn't fuck with the owner of the thread template
		if(saved == null) {
			thread.setCreatedUserId(zfgcUser.getUserId());
		}
		else {
			thread.setCreatedUserId(saved.getCreatedUserId());
		}
		
		//finally, save the thread
		thread = threadDataProvider.saveThread(thread);
		
		return thread;
	}
	
	public Thread getThread(Integer threadId, Integer page, Integer count, User zfgcUser) {
		Thread thread = threadDataProvider.getThread(threadId, page, count);
		
		//super.secureObject(thread, zfgcUser);
		
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
	
	public Message saveMessage(Message message, User user) {
		Thread thread = threadDataProvider.getThread(message.getThreadId());
		super.secureObject(thread, user);
		
		return messageDataProvider.saveMessage(message);
	}
	
	public void deleteThread(Integer threadId, User user) {
		Thread thread = threadDataProvider.getThread(threadId);
		super.secureObject(thread, user);
		
		threadDataProvider.deleteThread(threadId);
	}
	
	public Thread moveThread(Integer threadId, Integer boardId, User user) {
		Thread thread = threadDataProvider.getThread(threadId);
		super.secureObject(thread, user);
		
		thread.setBoardId(boardId);
		return threadDataProvider.saveThread(thread);
	}
	
	public Thread toggleLocked(Integer threadId, User user) {
		Thread thread = threadDataProvider.getThread(threadId);
		super.secureObject(thread, user);
		
		thread.setLockedFlag(!thread.getLockedFlag());
		return threadDataProvider.saveThread(thread);
	}
	
	public Thread toggleSticky(Integer threadId, User user) {
		Thread thread = threadDataProvider.getThread(threadId);
		super.secureObject(thread, user);
		
		thread.setPinnedFlag(!thread.getPinnedFlag());
		return threadDataProvider.saveThread(thread);
	}
	
	public ThreadSplit getSplitTemplate(Integer threadId, User user) {
		Thread thread = threadDataProvider.getThread(threadId);
		super.secureObject(thread, user);
		
		ThreadSplit template = new ThreadSplit();
		template.setThreadId(threadId);
		template.setBoardId(thread.getBoardId());
		
		return template;
	}
	
	public Thread splitThread(ThreadSplit split, User user) {
		Thread thread = threadDataProvider.getThread(split.getThreadId());
		super.secureObject(thread, user);
		
		Thread newThread = getThreadTemplate(split.getBoardId(), user);
		return threadDataProvider.splitThread(split, newThread);
	}
}