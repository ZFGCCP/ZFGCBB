package com.zfgc.zfgbb.dataprovider.loadoption;

public record UserLoadOptions(boolean loadAvatar, boolean loadBio, boolean loadReactions, boolean loadAwards,
		boolean loadPermissions, boolean loadContactInfo, boolean loadSettings) {

	public static UserLoadOptions basic() {
		return new UserLoadOptions(true, true, true, false, false, false, false);
	}

	public static UserLoadOptions full() {
		return new UserLoadOptions(true, true, true, true, true, true, true);
	}

	public static UserLoadOptions loggedIn() {
		return new UserLoadOptions(false, false, false, false, true, false, true);
	}

	public static UserLoadOptions publicProfile() {
		return new UserLoadOptions(true, true, true, false, true, false, false);
	}
}
