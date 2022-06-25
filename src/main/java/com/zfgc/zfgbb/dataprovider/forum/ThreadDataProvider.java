package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;
import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.forum.ThreadSplit;
import com.zfgc.zfgbb.model.users.Permission;

@Repository
public class ThreadDataProvider extends AbstractDataProvider {

	@Autowired
	private ThreadDao threadDao;
	
	@Autowired
	private MessageDataProvider messageDataProvider;
	
	@Autowired
	private BoardPermissionViewDao boardPermissionDao;
	
	public Thread getThread(Integer threadId, Integer page, Integer count) {
		ThreadDbo threadDb = threadDao.get(threadId);
		Thread result = null;
		if(threadDb != null) {
			result = mapper.map(threadDao.get(threadId), Thread.class);
			
			//get messages
			result.setMessages(super.convertDboListToModel(messageDataProvider.getMessagesForThread(threadId, page, count), Message.class));
			
			//get permissions for the parent board
			result.setBoardPermissions(getBoardPermissions(result.getBoardId()));
		}
		return result;
	}
	
	public Thread getThread(Integer threadId) {
		ThreadDbo threadDb = threadDao.get(threadId);
		Thread result = null;
		if(threadDb != null) {
			result = mapper.map(threadDao.get(threadId), Thread.class);
			
			//get permissions for the parent board
			result.setBoardPermissions(getBoardPermissions(result.getBoardId()));
		}
		
		return result;
	}
	
	public Thread saveThread(Thread thread) {
		ThreadDbo threadDbo = mapper.map(thread, ThreadDbo.class);
		
		//create the thread dbo first
		threadDbo = threadDao.save(threadDbo);
		
		Message headMessage = thread.getMessages().stream().findFirst().orElse(null);
		Thread result = mapper.map(threadDbo, Thread.class);
		if(headMessage != null) {
			headMessage = messageDataProvider.saveMessage(headMessage);
		
			result = mapper.map(threadDbo, Thread.class);
		
			result.getMessages().add(headMessage);
		}
		return result;
	}
	
	public List<Permission> getBoardPermissions(Integer boardId){
		BoardPermissionViewDboExample bEx = new BoardPermissionViewDboExample();
		bEx.createCriteria().andBoardIdEqualTo(boardId);
		return super.convertDboListToModel(boardPermissionDao.get(bEx), Permission.class);
	}
	
	public void deleteThread(Integer threadId) {
		messageDataProvider.deleteMessagesForThread(threadId);
		ThreadDboExample ex = new ThreadDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		threadDao.delete(ex);
	}
	
	public Thread splitThread(ThreadSplit splitter, Thread newThread) {
		newThread.getMessages().clear();
		
		newThread.setThreadName(splitter.getNewThreadTitle());
		newThread = saveThread(newThread);
		messageDataProvider.moveMessagesToNewThread(splitter.getMessageIdsToMove(), newThread.getId());
		
		return newThread;
	}
	
}
