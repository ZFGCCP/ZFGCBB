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
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserSettings extends BaseModel {

	@JsonIgnore
	private Integer userId;
	private String theme;
	private String smileySet;
	private Boolean notifyAnnouncementsFlag;
	private Boolean notifySendBodyFlag;
	private Boolean sendHappyBirthdayFlag;

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		this.userId = id;
	}
}
