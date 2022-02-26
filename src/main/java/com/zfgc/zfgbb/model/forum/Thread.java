package com.zfgc.zfgbb.model.forum;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Thread extends BaseModel {
	@JsonIgnore
	private Integer threadId;
    private String threadName;
    private Boolean lockedFlag;
    private Boolean pinnedFlag;
    private Instant createdTs;
    private Instant updatedTs;
    private Integer boardId;
    
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
}