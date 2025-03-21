package com.zfgc.zfgbb.model.forum;

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
    private Integer boardId;
    private Integer createdUserId;
    
    private User createdUser;
    private Integer postCount;
    private Integer viewCount;
    private Integer pageCount;
    
	@JsonIgnore
    private List<Permission> boardPermissions = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    
    private LatestMessage latestMessage;
    
    private Poll pollInfo;
    
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
	public Poll getPollInfo() {
		return pollInfo;
	}
	public void setPollInfo(Poll pollInfo) {
		this.pollInfo = pollInfo;
	}
	
    public Integer getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public LatestMessage getLatestMessage() {
		return latestMessage;
	}
	public void setLatestMessage(LatestMessage latestMessage) {
		this.latestMessage = latestMessage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}