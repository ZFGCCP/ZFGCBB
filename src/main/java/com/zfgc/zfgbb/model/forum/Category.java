package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Category extends BaseModel {
	@JsonIgnore
	private Integer categoryId;
	private String categoryName;
	private String description;
	private Integer parentCategoryId;
	
	private List<BoardSummary> boards = new ArrayList<>();
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	
	@Override
	public Integer getId() {
		return categoryId;
	}
	@Override
	public void setId(Integer id) {
		categoryId = id;
	}
	public List<BoardSummary> getBoards() {
		return boards;
	}
	public void setBoards(List<BoardSummary> boards) {
		this.boards = boards;
	}
}