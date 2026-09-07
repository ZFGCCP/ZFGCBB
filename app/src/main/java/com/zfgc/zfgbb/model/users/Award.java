package com.zfgc.zfgbb.model.users;

import lombok.Data;

@Data
public class Award {
	private Integer awardId;
	private String code;
	private String name;
	private String description;
	private String icon;
	private String reason;
	private String grantedTs;
	private Integer contentEntityId;
}
