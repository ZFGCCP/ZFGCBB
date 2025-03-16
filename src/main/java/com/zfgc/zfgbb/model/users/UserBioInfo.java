package com.zfgc.zfgbb.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class UserBioInfo extends BaseModel {

	@JsonIgnore
	private Integer userId;
	private String customTitle;
	private String personalText;
	private String signature;
	
	public String getCustomTitle() {
		return customTitle;
	}

	public void setCustomTitle(String customTitle) {
		this.customTitle = customTitle;
	}

	public String getPersonalText() {
		return personalText;
	}

	public void setPersonalText(String personalText) {
		this.personalText = personalText;
	}

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		userId = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}