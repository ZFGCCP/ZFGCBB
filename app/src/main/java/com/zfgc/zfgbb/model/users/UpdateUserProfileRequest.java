package com.zfgc.zfgbb.model.users;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSetter;

public class UpdateUserProfileRequest {
	private String displayName;
	private String personalText;
	private String signature;
	private String location;
	private LocalDate birthDate;
	private Integer genderId;
	private String websiteTitle;
	private String websiteUrl;
	private Boolean hideEmailFlag;
	private Boolean hideOnlineStatus;
	private Integer avatarId;
	private boolean displayNamePresent;
	private boolean personalTextPresent;
	private boolean signaturePresent;
	private boolean locationPresent;
	private boolean birthDatePresent;
	private boolean genderIdPresent;
	private boolean websiteTitlePresent;
	private boolean websiteUrlPresent;
	private boolean hideEmailFlagPresent;
	private boolean hideOnlineStatusPresent;
	private boolean avatarIdPresent;

	@JsonSetter public void setDisplayName(String value) { displayNamePresent = true; displayName = value; }
	@JsonSetter public void setPersonalText(String value) { personalTextPresent = true; personalText = value; }
	@JsonSetter public void setSignature(String value) { signaturePresent = true; signature = value; }
	@JsonSetter public void setLocation(String value) { locationPresent = true; location = value; }
	@JsonSetter public void setBirthDate(LocalDate value) { birthDatePresent = true; birthDate = value; }
	@JsonSetter public void setGenderId(Integer value) { genderIdPresent = true; genderId = value; }
	@JsonSetter public void setWebsiteTitle(String value) { websiteTitlePresent = true; websiteTitle = value; }
	@JsonSetter public void setWebsiteUrl(String value) { websiteUrlPresent = true; websiteUrl = value; }
	@JsonSetter public void setHideEmailFlag(Boolean value) { hideEmailFlagPresent = true; hideEmailFlag = value; }
	@JsonSetter public void setHideOnlineStatus(Boolean value) { hideOnlineStatusPresent = true; hideOnlineStatus = value; }
	@JsonSetter public void setAvatarId(Integer value) { avatarIdPresent = true; avatarId = value; }

	public String displayName() { return displayName; }
	public String personalText() { return personalText; }
	public String signature() { return signature; }
	public String location() { return location; }
	public LocalDate birthDate() { return birthDate; }
	public Integer genderId() { return genderId; }
	public String websiteTitle() { return websiteTitle; }
	public String websiteUrl() { return websiteUrl; }
	public Boolean hideEmailFlag() { return hideEmailFlag; }
	public Boolean hideOnlineStatus() { return hideOnlineStatus; }
	public Integer avatarId() { return avatarId; }
	public boolean displayNamePresent() { return displayNamePresent; }
	public boolean personalTextPresent() { return personalTextPresent; }
	public boolean signaturePresent() { return signaturePresent; }
	public boolean locationPresent() { return locationPresent; }
	public boolean birthDatePresent() { return birthDatePresent; }
	public boolean genderIdPresent() { return genderIdPresent; }
	public boolean websiteTitlePresent() { return websiteTitlePresent; }
	public boolean websiteUrlPresent() { return websiteUrlPresent; }
	public boolean hideEmailFlagPresent() { return hideEmailFlagPresent; }
	public boolean hideOnlineStatusPresent() { return hideOnlineStatusPresent; }
	public boolean avatarIdPresent() { return avatarIdPresent; }
}
