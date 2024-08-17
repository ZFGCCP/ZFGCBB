package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.security.Securable;

public class Forum extends BaseModel implements Securable{

	private List<Category> categories = new ArrayList<>();
	private String boardName;
	private List<Thread> stickyThreads = new ArrayList<>();
	private List<Thread> threads = new ArrayList<>();
	private Integer categoryId;
	private Long threadCount = 0L;
	private Integer threadsPerPage = 10;
	
	@JsonIgnore
	private Integer boardId;
	@JsonIgnore
	private List<Permission> boardPermissions = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	public List<Thread> getStickyThreads() {
		return stickyThreads;
	}

	public void setStickyThreads(List<Thread> stickyThreads) {
		this.stickyThreads = stickyThreads;
	}

	public List<Permission> getBoardPermissions() {
		return boardPermissions;
	}

	public void setBoardPermissions(List<Permission> boardPermissions) {
		this.boardPermissions = boardPermissions;
	}

	@Override
	@JsonIgnore
	public List<Permission> getPermissions() {
		return this.boardPermissions;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public Integer getThreadsPerPage() {
		return threadsPerPage;
	}

	public void setThreadsPerPage(Integer threadsPerPage) {
		this.threadsPerPage = threadsPerPage;
	}

	public Long getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Long threadCount) {
		this.threadCount = threadCount;
	}

	public Integer getPageCount() {
		int count = (int)Math.ceil( threadCount / threadsPerPage.longValue());
		return count == 0 ? 1 : count;
	}

	
	
	
}