package com.zfgc.zfgbb.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import com.zfgc.zfgbb.model.meta.IpAddress;
import com.zfgc.zfgbb.model.users.Avatar;
import com.zfgc.zfgbb.model.users.EmailAddress;
import com.zfgc.zfgbb.model.users.PasswordAlgo;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.users.UserBioInfo;
import com.zfgc.zfgbb.model.users.UserContactInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel implements UserDetails {
	@JsonIgnore
	private Integer userId;
	private String displayName;
	private String userName;
	private Boolean activeFlag;
	private EmailAddress email;
	private String ssoKey;
	@JsonIgnore
	private String passwordHash;
	@JsonIgnore
	private PasswordAlgo passwordAlgo;
	@JsonIgnore
	private String passwordSalt;
	@JsonIgnore
	private OffsetDateTime lockedUntilTs;
	@JsonIgnore
	private Integer failedLoginCount;
	@JsonIgnore
	private OffsetDateTime passwordChangedTs;
	private List<Permission> permissions = new ArrayList<>();
	
	private IpAddress currentIpAddress;
	private List<IpAddress> allKnownIpAddresses = new ArrayList<>();
	private UserBioInfo bioInfo;
	private UserContactInfo contactInfo;
	
	public static User orphaned() {
		return User.builder()
				.displayName("ORPHANED")
				.permissions(new ArrayList<>())
				.build();
	}

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
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// No account-expiry policy yet (no use case). Reserved for future use; if/when
		// added, store an account_expires_ts column and compare against now() here.
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return lockedUntilTs == null || lockedUntilTs.isBefore(OffsetDateTime.now());
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// The configurable max-age policy is enforced server-side in AuthService.login()
		// (where we have @Value access). This default keeps the UserDetails contract
		// satisfied for code paths that consult UserDetails directly.
		return true;
	}

	@Override
	public boolean isEnabled() {
		return Boolean.TRUE.equals(activeFlag);
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

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getSsoKey() {
		return ssoKey;
	}

	public void setSsoKey(String ssoKey) {
		this.ssoKey = ssoKey;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return passwordHash;
	}

	public UserBioInfo getBioInfo() {
		return bioInfo;
	}

	public void setBioInfo(UserBioInfo bioInfo) {
		this.bioInfo = bioInfo;
	}
	
	@JsonIgnore
	public boolean hasPermission(String permission) {
		if(permissions != null) {
			return permissions.stream().anyMatch(pr -> pr.getPermissionCode().equals(permission));
		}
		
		return false;
	}
	
}