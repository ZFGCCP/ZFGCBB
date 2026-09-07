package com.zfgc.zfgbb.model.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseModel {

	@JsonIgnore
	private Integer permissionId;
	private String permissionCode;
	private String permissionName;
	
	@Override
	public Integer getId() {
		return permissionId;
	}

	@Override
	public void setId(Integer id) {
		permissionId = id;
	}
	
}