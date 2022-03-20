package com.zfgc.zfgbb.model.forum;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.security.Securable;

public class Thread extends BaseModel implements Securable {
	@JsonIgnore
	private Integer threadId;
    private String threadName;
    private Boolean lockedFlag;
    private Boolean pinnedFlag;
    private Instant createdTs;
    private Instant updatedTs;
    private Integer boardId;
    private Integer createdUserId;
    
    private User createdUser;
    
    @JsonIgnore
    private List<Permission> boardPermissions = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    
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
	public Boolean getLockedFlag() {
		return lockedFlag;
	}
	public void setLockedFlag(Boolean lockedFlag) {
		this.lockedFlag = lockedFlag;
	}
	public Boolean getPinnedFlag() {
		return pinnedFlag;
	}
	public void setPinnedFlag(Boolean pinnedFlag) {
		this.pinnedFlag = pinnedFlag;
	}
	public Instant getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Instant createdTs) {
		this.createdTs = createdTs;
	}
	public Instant getUpdatedTs() {
		return updatedTs;
	}
	public void setUpdatedTs(Instant updatedTs) {
		this.updatedTs = updatedTs;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	@Override
	public Integer getId() {
		return threadId;
	}
	@Override
	public void setId(Integer id) {
		threadId = id;
	}
	public User getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	public List<Permission> getBoardPermissions() {
		return boardPermissions;
	}
	public void setBoardPermissions(List<Permission> boardPermissions) {
		this.boardPermissions = boardPermissions;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Integer getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}
	
	@Override
	@JsonIgnore
	public List<Permission> getPermissions() {
		return getBoardPermissions();
	}
}