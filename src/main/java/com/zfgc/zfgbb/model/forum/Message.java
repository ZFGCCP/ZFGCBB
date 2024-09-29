package com.zfgc.zfgbb.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.User;

public class Message extends BaseModel {
	@JsonIgnore
	private Integer messageId;
	private Integer ownerId;
	private Integer threadId;
	private Integer postInThread;
	
	private User createdUser;
	
	private MessageHistory currentMessage = new MessageHistory();
	
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public Integer getId() {
		return messageId;
	}

	@Override
	public void setId(Integer id) {
		messageId = id;
	}

	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	
	@JsonIgnore
	public LocalDateTime getLatestMessageTs() {
		return currentMessage.getCreatedTs();
	}

	public MessageHistory getCurrentMessage() {
		return currentMessage;
	}

	public void setCurrentMessage(MessageHistory currentMessage) {
		this.currentMessage = currentMessage;
	}

	public Integer getPostInThread() {
		return postInThread;
	}

	public void setPostInThread(Integer postInThread) {
		this.postInThread = postInThread;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	
}