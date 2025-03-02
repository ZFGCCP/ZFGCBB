package com.zfgc.zfgbb.model.users;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Avatar extends BaseModel {
	@JsonIgnore
	private Integer avatarId;
	private String url;
	private Integer userId;
	private Boolean activeFlag;

	public Integer getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public Integer getId() {
		return avatarId;
	}

	@Override
	public void setId(Integer id) {
		avatarId = id;
	}
	
}