package com.zfgc.zfgbb.model.forum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoardSummary {
	private Integer boardId;
    private String description;
    private String boardName;
    private Long threadCount;
    private Long postCount;
    private Integer latestMessageId;
    private Integer latestThreadId;
    private Integer latestMessageOwnerId;
    private String latestMessageUserName;
    private Integer categoryId;
    private Integer parentBoardId;
    
    @JsonIgnore
    private LocalDateTime latestMessageCreatedTs;
    
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Long getThreadCount() {
		return threadCount;
	}
	public void setThreadCount(Long threadCount) {
		this.threadCount = threadCount;
	}
	public Long getPostCount() {
		return postCount;
	}
	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}
	public Integer getLatestMessageId() {
		return latestMessageId;
	}
	public void setLatestMessageId(Integer latestMessageId) {
		this.latestMessageId = latestMessageId;
	}
	public Integer getLatestThreadId() {
		return latestThreadId;
	}
	public void setLatestThreadId(Integer latestThreadId) {
		this.latestThreadId = latestThreadId;
	}
	public Integer getLatestMessageOwnerId() {
		return latestMessageOwnerId;
	}
	public void setLatestMessageOwnerId(Integer latestMessageOwnerId) {
		this.latestMessageOwnerId = latestMessageOwnerId;
	}
	public String getLatestMessageUserName() {
		return latestMessageUserName;
	}
	public void setLatestMessageUserName(String latestMessageUserName) {
		this.latestMessageUserName = latestMessageUserName;
	}
	public LocalDateTime getLatestMessageCreatedTs() {
		return latestMessageCreatedTs;
	}
	public void setLatestMessageCreatedTs(LocalDateTime latestMessageCreatedTs) {
		this.latestMessageCreatedTs = latestMessageCreatedTs;
	}
	public String getLatestMessageCreatedTsAsString() {
		if(latestMessageCreatedTs != null) {
			return DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss am").format(latestMessageCreatedTs);
		}
		
		return null;
	}
	
	public void setLatestMessageCreatedTsAsString(String latestMessageCreatedTsAsString) {
		if(!StringUtils.isEmpty(latestMessageCreatedTsAsString)) {
			latestMessageCreatedTs = (LocalDateTime) DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss am").parse(latestMessageCreatedTsAsString);
		}
	}
	public Integer getParentBoardId() {
		return parentBoardId;
	}
	public void setParentBoardId(Integer parentBoardId) {
		this.parentBoardId = parentBoardId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}