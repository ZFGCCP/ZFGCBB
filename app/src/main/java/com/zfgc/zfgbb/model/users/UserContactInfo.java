package com.zfgc.zfgbb.model.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class UserContactInfo extends BaseModel {
	@JsonIgnore
	private Integer userId;
	private EmailAddress emailAddress;
	private Boolean allowEmailFlag;
	private Boolean allowPmFlag;

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		this.userId = id;
	}
} 