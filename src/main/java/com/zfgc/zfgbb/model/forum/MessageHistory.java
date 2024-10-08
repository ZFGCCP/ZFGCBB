package com.zfgc.zfgbb.model.forum;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class MessageHistory extends BaseModel {
	@JsonIgnore
	private Integer messageHistoryId;
	private Integer messageId;
	private String messageText;
	private String unparsedText;
	private Boolean currentFlag;
	private Integer ipAddressId;
	
	public Integer getMessageHistoryId() {
		return messageHistoryId;
	}
	public void setMessageHistoryId(Integer messageHistoryId) {
		this.messageHistoryId = messageHistoryId;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	@Override
	public Integer getId() {
		return messageHistoryId;
	}
	@Override
	public void setId(Integer id) {
		messageHistoryId = id;
	}
	public Boolean getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(Boolean currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getUnparsedText() {
		return unparsedText;
	}
	public void setUnparsedText(String unparsedText) {
		this.unparsedText = unparsedText;
	}
	public Integer getIpAddressId() {
		return ipAddressId;
	}
	public void setIpAddressId(Integer ipAddressId) {
		this.ipAddressId = ipAddressId;
	}
}