package com.zfgc.zfgbb.model.forum;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Message extends BaseModel {
	@JsonIgnore
	private Integer messageId;
	private Integer ownerId;
	private Integer threadId;
	
	private List<MessageHistory> history = new ArrayList<>();
	
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

	public List<MessageHistory> getHistory() {
		return history;
	}

	public void setHistory(List<MessageHistory> history) {
		this.history = history;
	}
	
	public MessageHistory getCurrentMessage() {
		return history.stream().filter(x -> x.getCurrentFlag()).findFirst().orElseThrow();
	}
	
	@JsonIgnore
	public LocalDate getLatestMessageTs() {
		return getCurrentMessage().getCreatedTs();
	}
	
}