package com.zfgc.zfgbb.model.meta;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
