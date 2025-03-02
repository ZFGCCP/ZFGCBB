package com.zfgc.zfgbb.config.loadoption.user;

public class FullUserLoadOptions extends BasicUserLoadOptions {
	@Override
	public boolean loadBio() {
		return true;
	}
	
	@Override
	public boolean loadPermissions() {
		return true;
	}
}
