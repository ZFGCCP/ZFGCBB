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
public class Avatar extends BaseModel {
	@JsonIgnore
	private Integer avatarId;
	
	private String url;
	private Boolean activeFlag;
	private Integer contentResourceId;

	@Override
	public Integer getId() {
		return avatarId;
	}

	@Override
	public void setId(Integer id) {
		avatarId = id;
	}
	
}