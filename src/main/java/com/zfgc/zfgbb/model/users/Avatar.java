package com.zfgc.zfgbb.model.users;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Avatar extends BaseModel {
	@JsonIgnore
	private Integer avatarId;
	
	@JsonIgnore
	private String url;
	private Boolean activeFlag;
	
	
	@JsonIgnore
	private String filename;
	
	public String getLocation() {
		if(url != null) {
			return url;
		}
		else {
			return "todo:contentstreamurl/" + filename;
		}
	}

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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}