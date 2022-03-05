package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.users.Permission;

public class Forum {

	private List<Category> categories = new ArrayList<>();
	private String boardName;
	private List<Thread> stickyThreads = new ArrayList<>();
	private List<Thread> threads = new ArrayList<>();
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


	
	
	
}