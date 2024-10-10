package com.zfgc.zfgbb.model.forum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LatestMessage {
	private Integer threadId;
    private String threadName;
    private Integer messageId;
    private Integer messageHistoryId;
    @JsonIgnore
    private LocalDateTime createdTs;
    private String ownerName;
    
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getMessageHistoryId() {
		return messageHistoryId;
	}
	public void setMessageHistoryId(Integer messageHistoryId) {
		this.messageHistoryId = messageHistoryId;
	}
	public LocalDateTime getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCreatedTsAsString() {
		if(createdTs != null) {
			return createdTs.format(DateTimeFormatter.ofPattern("MM/dd/YYYY HH:mm:SS"));
		}
		return "";
	}
}