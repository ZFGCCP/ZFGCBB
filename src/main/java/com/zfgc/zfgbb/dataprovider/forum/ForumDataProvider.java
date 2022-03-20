package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.BoardDao;
import com.zfgc.zfgbb.dao.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.CategoryDao;
import com.zfgc.zfgbb.dao.ThreadDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BoardDbo;
import com.zfgc.zfgbb.dbo.BoardDboExample;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.CategoryDbo;
import com.zfgc.zfgbb.dbo.CategoryDboExample;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.dbo.ThreadDboExample;
import com.zfgc.zfgbb.model.forum.Board;
import com.zfgc.zfgbb.model.forum.Category;
import com.zfgc.zfgbb.model.forum.Forum;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.model.forum.Thread;
import com.zfgc.zfgbb.model.users.Permission;
import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;

@Repository
public class ForumDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ThreadDao threadDao;
	
	@Autowired
	private BoardPermissionViewDao boardPermissionDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private MessageHistoryDao messageHistoryDao;
	
	@Autowired
	private CurrentMessageDao currentMessageDao;
	
	public Forum getForum(Integer boardId) {
		Forum forum = new Forum();
		
		BoardDbo boardDbo = boardDao.get(boardId);
		forum.setBoardName(boardDbo.getBoardName());
		
		CategoryDboExample exC = new CategoryDboExample();
		exC.createCriteria().andParentBoardIdEqualTo(boardId);
		List<Category> categories = super.convertDboListToModel(categoryDao.get(exC), Category.class);
		
		categories.forEach(cat ->{
			BoardDboExample ex = new BoardDboExample();
			ex.createCriteria().andCategoryIdEqualTo(cat.getCategoryId());
			cat.setBoards(convertDboListToModel(boardDao.get(ex), Board.class));
		});
		
		ThreadDboExample exT = new ThreadDboExample();
		exT.createCriteria().andBoardIdEqualTo(boardId);
		List<Thread> unstickyThreads = super.convertDboListToModel(threadDao.get(exT), Thread.class);
		exT.createCriteria().andPinnedFlagEqualTo(true);
		List<Thread> stickyThreads = super.convertDboListToModel(threadDao.get(exT), Thread.class);
	
		forum.setThreads(unstickyThreads);
		forum.setStickyThreads(stickyThreads);
		forum.setCategories(categories);
		
		//load up permissions for the board
		forum.setBoardPermissions(getBoardPermissions(boardId));
		
		return forum;
	}
	
	public Thread getThread(Integer threadId, Integer page, Integer count) {
		Thread result = mapper.map(threadDao.get(threadId), Thread.class);
		
		//get messages
		result.setMessages(super.convertDboListToModel(getMessagesForThread(threadId, page, count), Message.class));
		
		//get permissions for the parent board
		result.setBoardPermissions(getBoardPermissions(result.getBoardId()));
		return result;
	}
	
	public Thread saveThread(Thread thread) {
		ThreadDbo threadDbo = mapper.map(thread, ThreadDbo.class);
		
		//create the thread dbo first
		threadDbo = threadDao.save(threadDbo);
		
		MessageDbo headMessage = mapper.map(thread.getMessages().stream().findFirst().orElseThrow(), MessageDbo.class);
		Thread result = mapper.map(threadDbo, Thread.class);
	}
	
	public List<Permission> getBoardPermissions(Integer boardId){
		BoardPermissionViewDboExample bEx = new BoardPermissionViewDboExample();
		bEx.createCriteria().andBoardIdEqualTo(boardId);
		return super.convertDboListToModel(boardPermissionDao.get(bEx), Permission.class);
	}
	
	public List<Message> getMessagesForThread(Integer threadId, Integer page, Integer count){
		Integer start = ((page - 1)*count) + 1;
		CurrentMessageDboExample ex = new CurrentMessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		List<Message> messages = currentMessageDao.getWithLimit(ex, start, count)
						 .stream()
						 .map(message -> {
							 Message msg = mapper.map(message, Message.class);
							 MessageHistory hist = mapper.map(message, MessageHistory.class);
							 msg.getHistory().add(hist);
							 return msg;
						 }).collect(Collectors.toList());
						 
		
		
		return super.convertDboListToModel(messages, Message.class);
	}
	
	public Message getMessage(Integer messageId) {
		Message message = mapper.map(messageDao.get(messageId), Message.class);
		MessageHistoryDboExample ex = new MessageHistoryDboExample();
		ex.createCriteria().andMessageIdEqualTo(messageId);
		List<MessageHistory> history = super.convertDboListToModel(messageHistoryDao.get(ex), MessageHistory.class);
		message.setHistory(history);
		
		return message;
	}
	
	public Message saveMessage(Message message) {
		MessageDbo messageDbo = mapper.map(message, MessageDbo.class);
		
		messageDbo = messageDao.save(messageDbo);
		
		MessageHistory history = message.getCurrentMessage();
		MessageHistoryDbo historyDbo = mapper.map(history, MessageHistoryDbo.class);
		historyDbo = messageHistoryDao.save(historyDbo);
		
		Message result = mapper.map(messageDbo, Message.class);
		result.getHistory().addAll(message.getHistory());
	}
	
	public Message postMessageToThread(Integer threadId, Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getHistory(), "message history cannot be null.");
		Preconditions.checkNotNull(threadId, "threadId cannot be null.");
		//ensure we have the right thread set
		message.setThreadId(threadId);
		MessageDbo db = mapper.map(message, MessageDbo.class);
		
		//insert a message history record
		MessageHistoryDbo histDb = mapper.map(message.getHistory().stream().findFirst().orElseThrow(), 
											  MessageHistoryDbo.class);
		
		histDb = messageHistoryDao.save(histDb);
		
		Message result = mapper.map(messageDao.save(db), Message.class);
		result.getHistory().add(mapper.map(histDb, MessageHistory.class));
		
		return result;
	}
	
	public Message editMessage(Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getHistory(), "message history cannot be null.");
		
		MessageHistoryDbo histDb = mapper.map(Streams.findLast(message.getHistory().stream()), MessageHistoryDbo.class);
		messageHistoryDao.save(histDb);
		
		return getMessage(message.getMessageId());
	}
	
	
	
}