package com.zfgc.zfgbb.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Permission extends BaseModel {

	@JsonIgnore
	private Integer permissionId;
	private String permissionCode;
	private String permissionName;
	
	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Override
	public Integer getId() {
		return permissionId;
	}

	@Override
	public void setId(Integer id) {
		permissionId = id;
	}
	
}