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
}