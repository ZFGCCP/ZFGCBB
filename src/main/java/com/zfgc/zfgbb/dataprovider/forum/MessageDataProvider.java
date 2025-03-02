package com.zfgc.zfgbb.dataprovider.forum;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;

@Repository
public class MessageDataProvider extends AbstractDataProvider {
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private MessageHistoryDao messageHistoryDao;

	@Autowired
	private CurrentMessageDao currentMessageDao;
	
	@Autowired
	private UserDataProvider userDataProvider;
	
	public Message getMessage(Integer messageId) {
		Message message = mapper.map(messageDao.get(messageId), Message.class);
		MessageHistoryDboExample ex = new MessageHistoryDboExample();
		ex.createCriteria().andMessageIdEqualTo(messageId).andCurrentFlagEqualTo(true);
		List<MessageHistory> history = super.convertDboListToModel(messageHistoryDao.get(ex), MessageHistory.class);
		message.setCurrentMessage(history.get(0));
		
		return message;
	}
	
	public Message saveMessage(Message message) {
		MessageDbo messageDbo = mapper.map(message, MessageDbo.class);
		
		messageDbo = messageDao.save(messageDbo);
		
		MessageHistory history = message.getCurrentMessage();
		history.setMessageId(messageDbo.getMessageId());
		MessageHistoryDbo historyDbo = mapper.map(history, MessageHistoryDbo.class);
		historyDbo.setMessageText(history.getUnparsedText());
		historyDbo = messageHistoryDao.save(historyDbo);
		
		Message result = mapper.map(messageDbo, Message.class);
		result.setCurrentMessage(mapper.map(historyDbo, MessageHistory.class));
		
		return result;
	}
	
	public List<Message> getMessagesForThread(Integer threadId, Integer page, Integer count){
		Integer start = ((page - 1)*count) + 1;
		CurrentMessageDboExample ex = new CurrentMessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId)
						   .andPostInThreadBetween(start, start + count - 1);
		ex.setOrderByClause("post_in_thread asc");
		
		
		
		List<Message> messages = currentMessageDao.get(ex)
						 .stream()
						 .map(message -> {
							 Message msg = mapper.map(message, Message.class);
							 MessageHistory hist = mapper.map(message, MessageHistory.class);
							 hist.setUnparsedText(hist.getMessageText());
							 msg.setCurrentMessage(hist);
							 
							 msg.setCreatedUser(userDataProvider.getUser(msg.getOwnerId(), null));
							 
							 return msg;
						 }).collect(Collectors.toList());
						 
		
		
		return super.convertDboListToModel(messages, Message.class);
	}
	
	public Message postMessageToThread(Integer threadId, Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getCurrentMessage(), "message history cannot be null.");
		Preconditions.checkNotNull(threadId, "threadId cannot be null.");
		//ensure we have the right thread set
		message.setThreadId(threadId);
		MessageDbo db = mapper.map(message, MessageDbo.class);
		
		//insert a message history record
		MessageHistoryDbo histDb = mapper.map(message.getCurrentMessage(), 
											  MessageHistoryDbo.class);
		
		histDb = messageHistoryDao.save(histDb);
		
		Message result = mapper.map(messageDao.save(db), Message.class);
		result.setCurrentMessage(mapper.map(histDb, MessageHistory.class));
		
		return result;
	}
	
	public Message editMessage(Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getCurrentMessage(), "message history cannot be null.");
		
		MessageHistoryDbo histDb = mapper.map(message, MessageHistoryDbo.class);
		messageHistoryDao.save(histDb);
		
		return getMessage(message.getMessageId());
	}
	
	public void deleteMessagesForThread(Integer threadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		List<MessageDbo> messages = messageDao.get(ex);
		List<Integer> messageIds = messages.stream().map(MessageDbo::getPkId).collect(Collectors.toList());
		MessageHistoryDboExample hEx = new MessageHistoryDboExample();
		hEx.createCriteria().andMessageIdIn(messageIds);
		
		messageHistoryDao.delete(hEx);
		messageDao.delete(ex);
	}
	
	public void moveMessagesToNewThread(List<Integer> messageIds, Integer newThreadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andMessageIdIn(messageIds);
		
		List<MessageDbo> messages = messageDao.get(ex);
		messages.forEach(msg -> {
			msg.setThreadId(newThreadId);
			messageDao.save(msg);
		});
	}
	
	public Long getTotalPostsInThread(Integer threadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		Long count = messageDao.getMapper().countByExample(ex);
		
		return count;
	}
}