package com.zfgc.zfgbb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.meta.IpAddress;
import com.zfgc.zfgbb.model.users.EmailAddress;
import com.zfgc.zfgbb.model.users.Permission;

public class User extends BaseModel implements UserDetails {
	@JsonIgnore
	private Integer userId;
	private String displayName;
	private String userName;
	private Boolean activeFlag;
	private EmailAddress email;
	
	@JsonIgnore
	private List<Permission> permissions = new ArrayList<>();
	
	private IpAddress currentIpAddress;
	private List<IpAddress> allKnownIpAddresses = new ArrayList<>();
	
	
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissions.stream()
					      .map(perm -> {
					    	  return new SimpleGrantedAuthority("ROLE_" + perm.getPermissionCode());
					      })
					      .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		userId = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public IpAddress getCurrentIpAddress() {
		return currentIpAddress;
	}

	public void setCurrentIpAddress(IpAddress currentIpAddress) {
		this.currentIpAddress = currentIpAddress;
	}

	public List<IpAddress> getAllKnownIpAddresses() {
		return allKnownIpAddresses;
	}

	public void setAllKnownIpAddresses(List<IpAddress> allKnownIpAddresses) {
		this.allKnownIpAddresses = allKnownIpAddresses;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}