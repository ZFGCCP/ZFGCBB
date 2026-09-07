package com.zfgc.zfgbb.model.users;

import com.zfgc.zfgbb.model.BaseModel;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zfgc.zfgbb.model.meta.IpAddress;
import com.zfgc.zfgbb.model.Securable;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
	@JsonIgnore
	private String userName;
	private Boolean activeFlag;
	@JsonIgnore
	private EmailAddress email;
	@JsonIgnore
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
	@JsonIgnore
	private OffsetDateTime tokensValidAfterTs;
	@JsonIgnore
	private Boolean credentialsNonExpired;
	@Builder.Default
	private List<Permission> permissions = new ArrayList<>();
	
	private IpAddress currentIpAddress;
	@Builder.Default
	private List<IpAddress> allKnownIpAddresses = new ArrayList<>();
	private UserBioInfo bioInfo;
	private UserContactInfo contactInfo;
	private ReactionSummary reactionSummary;
	private List<Award> awards;
	private UserSettings settings;
	
	public static User orphaned() {
		return User.builder()
				.displayName("ORPHANED")
				.permissions(new ArrayList<>())
				.build();
	}

	public static User guest() {
		User guest = new User();
		guest.setDisplayName("Friend");
		guest.setUserId(-1);

		Permission guestPerm = new Permission();
		guestPerm.setId(2);
		guestPerm.setPermissionCode("ZFGC_GUEST");

		Permission readPerm = new Permission();
		readPerm.setId(9);
		readPerm.setPermissionCode("ZFGC_READ_ONLY");

		guest.getPermissions().add(guestPerm);
		guest.getPermissions().add(readPerm);

		return guest;
	}

	public static final Set<String> PUBLIC_RANK_PERMISSIONS = Set.of(
			"ZFGC_SITE_ADMIN", "ZFGC_SITE_MODERATOR", "ZFGC_WIKI_MODERATOR");

	public void retainPublicRankPermissions() {
		this.permissions = permissions == null ? new ArrayList<>() : permissions.stream()
				.filter(permission -> PUBLIC_RANK_PERMISSIONS.contains(permission.getPermissionCode()))
				.collect(Collectors.toList());
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (permissions == null)
			return List.of();
		return permissions.stream()
					      .map(perm -> {
					    	  return new SimpleGrantedAuthority("ROLE_" + perm.getPermissionCode());
					      })
					      .collect(Collectors.toList());
	}


	@JsonIgnore
	@Override
	public String getUsername() {
		return userName;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return lockedUntilTs == null || !lockedUntilTs.isAfter(OffsetDateTime.now(ZoneOffset.UTC));
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired == null || credentialsNonExpired;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return Boolean.TRUE.equals(activeFlag);
	}

	@JsonIgnore
	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public void setId(Integer id) {
		userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		if (passwordHash == null)
			return null;
		return new EncodedPassword(passwordAlgo == null ? PasswordAlgo.BCRYPT : passwordAlgo, passwordSalt, passwordHash)
				.toEncoded();
	}
	
	@JsonIgnore
	public boolean hasPermission(String permission) {
		if(permissions != null) {
			return permissions.stream().anyMatch(pr -> permission.equals(pr.getPermissionCode()));
		}

		return false;
	}

	@JsonIgnore
	public List<Integer> permissionIds() {
		if (permissions == null)
			return List.of();
		return permissions.stream().filter(Objects::nonNull).map(Permission::getPermissionId)
				.filter(Objects::nonNull).toList();
	}

	@JsonIgnore
	public boolean hasAnyPermissionId(Collection<Integer> requiredPermissionIds) {
		if (requiredPermissionIds == null || requiredPermissionIds.isEmpty())
			return false;
		Set<Integer> heldPermissionIds = new HashSet<>(permissionIds());
		if (heldPermissionIds.isEmpty())
			return false;
		for (Integer requiredPermissionId : requiredPermissionIds)
			if (heldPermissionIds.contains(requiredPermissionId))
				return true;
		return false;
	}

	@JsonIgnore
	public boolean canAccess(Securable securedResource) {
		if (securedResource == null || securedResource.getPermissions() == null)
			return false;
		return hasAnyPermissionId(securedResource.getPermissions().stream().filter(Objects::nonNull)
				.map(Permission::getPermissionId).toList());
	}

	@JsonIgnore
	public boolean invalidatesTokenIssuedAt(Optional<Instant> tokenIssuedAt) {
		return tokenValidityCutoff()
				.map(cutoff -> tokenIssuedAt.filter(issuance -> issuance.isAfter(cutoff)).isEmpty())
				.orElse(false);
	}

	@JsonIgnore
	public Instant earliestAcceptableTokenIssuance(Instant candidateIssuance) {
		return tokenValidityCutoff()
				.filter(cutoff -> !candidateIssuance.truncatedTo(ChronoUnit.SECONDS).isAfter(cutoff))
				.map(cutoff -> cutoff.truncatedTo(ChronoUnit.SECONDS).plusSeconds(1))
				.orElse(candidateIssuance);
	}

	private Optional<Instant> tokenValidityCutoff() {
		return Optional.ofNullable(tokensValidAfterTs).map(OffsetDateTime::toInstant);
	}

}