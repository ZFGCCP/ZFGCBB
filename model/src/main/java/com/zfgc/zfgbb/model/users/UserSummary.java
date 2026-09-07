package com.zfgc.zfgbb.model.users;

import lombok.Data;

@Data
public class UserSummary {
	private Integer userId;
	private String userName;
	private String displayName;
	private Boolean siteAdmin;
}
