package com.zfgc.zfgbb.model.users;

import java.time.OffsetDateTime;

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
public class UserBioInfo extends BaseModel {

	@JsonIgnore
	private Integer userId;
	private String customTitle;
	private String personalText;
	private String signature;
	private String signatureParsed;
	private String location;
	
	private String birthDate;
	private OffsetDateTime lastLogin;
	private OffsetDateTime dateRegistered;
	private String dateFormat;
	private String timeFormat;
	private String preferredTimezone;
	private Integer genderId;
	private String websiteTitle;
	private String websiteUrl;
	private String realName;
	private Boolean hideEmailFlag;
	private Boolean hideOnlineStatus;
	private Integer postCount;
	
	private Avatar avatar;

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		userId = id;
	}
}