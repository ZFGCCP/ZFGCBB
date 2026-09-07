package com.zfgc.zfgbb.mapstruct.users;

import org.mapstruct.Mapper;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.model.users.User;
import org.mapstruct.Mapping;

@Mapper(config=BBMapperConfig.class)
public interface UserMap {
	
	@Mapping(target = "allKnownIpAddresses", ignore = true)
	@Mapping(target = "bioInfo", ignore = true)
	@Mapping(target = "contactInfo", ignore = true)
	@Mapping(target = "reactionSummary", ignore = true)
	@Mapping(target = "awards", ignore = true)
	@Mapping(target = "currentIpAddress", ignore = true)
	@Mapping(target = "email", ignore = true)
	@Mapping(target = "permissions", ignore = true)
	@Mapping(target = "settings", ignore = true)
	@Mapping(target = "credentialsNonExpired", ignore = true)
	User toModel(UserDbo dbo);

	@Mapping(target="migrationHash", ignore=true)
	UserDbo toDbo(User user);
}
