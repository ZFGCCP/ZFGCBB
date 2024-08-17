package com.zfgc.zfgbb.model.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class EmailAddress extends BaseModel {
	@JsonIgnore
	private Integer emailAddressId;
    private String emailAddress;
    private Boolean spammerFlag;
    
	public Integer getEmailAddressId() {
		return emailAddressId;
	}
	public void setEmailAddressId(Integer emailAddressId) {
		this.emailAddressId = emailAddressId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Boolean getSpammerFlag() {
		return spammerFlag;
	}
	public void setSpammerFlag(Boolean spammerFlag) {
		this.spammerFlag = spammerFlag;
	}
	@Override
	public Integer getId() {
		return emailAddressId;
	}
	@Override
	public void setId(Integer id) {
		emailAddressId = id;
	}
}