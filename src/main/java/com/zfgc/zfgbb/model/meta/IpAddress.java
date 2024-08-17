package com.zfgc.zfgbb.model.meta;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class IpAddress extends BaseModel {

	@JsonIgnore
	private Integer ipAddressId;
	private String ip;
	private Boolean ipV6Flag;
	private Boolean isSpammerFlag;
	
	@Override
	public Integer getId() {
		return ipAddressId;
	}

	@Override
	public void setId(Integer id) {
		ipAddressId = id;
	}

	public Integer getIpAddressId() {
		return ipAddressId;
	}

	public void setIpAddressId(Integer ipAddressId) {
		this.ipAddressId = ipAddressId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getIpV6Flag() {
		return ipV6Flag;
	}

	public void setIpV6Flag(Boolean ipV6Flag) {
		this.ipV6Flag = ipV6Flag;
	}

	public Boolean getIsSpammerFlag() {
		return isSpammerFlag;
	}

	public void setIsSpammerFlag(Boolean isSpammerFlag) {
		this.isSpammerFlag = isSpammerFlag;
	}

	
}
