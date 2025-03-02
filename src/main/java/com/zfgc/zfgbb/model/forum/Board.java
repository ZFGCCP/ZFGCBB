package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.users.Permission;

public class Board extends BaseModel {

	@JsonIgnore
	private Integer boardId;
	private String boardName;
	private String description;
	private Integer categoryId;
	private Integer parentBoardId;
	private Long threadCount;
	
	private List<Thread> stickyThreads;
	private List<Thread> unStickyThreads;
	private List<BoardSummary> childBoards;
	
	@JsonIgnore
	private List<Permission> boardPerms = new ArrayList<>();
	
	public List<Thread> getStickyThreads() {
		return stickyThreads;
	}

	public void setStickyThreads(List<Thread> stickyThreads) {
		this.stickyThreads = stickyThreads;
	}

	public List<Thread> getUnStickyThreads() {
		return unStickyThreads;
	}

	public void setUnStickyThreads(List<Thread> unStickyThreads) {
		this.unStickyThreads = unStickyThreads;
	}

	@Override
	public Integer getId() {
		return boardId;
	}
	
	@Override
	public void setId(Integer id) {
		boardId = id;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getParentBoardId() {
		return parentBoardId;
	}

	public void setParentBoardId(Integer parentBoardId) {
		this.parentBoardId = parentBoardId;
	}

	public Long getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Long threadCount) {
		this.threadCount = threadCount;
	}

	public List<BoardSummary> getChildBoards() {
		return childBoards;
	}

	public void setChildBoards(List<BoardSummary> childBoards) {
		this.childBoards = childBoards;
	}
	
	public Long getPageCount() {
		if(threadCount == null) {
			return 1L;
		}
		return (long) Math.ceil(threadCount.doubleValue() / 10.0);
	}

	public List<Permission> getBoardPerms() {
		return boardPerms;
	}

	public void setBoardPerms(List<Permission> boardPerms) {
		this.boardPerms = boardPerms;
	}



}
