package com.zfgc.zfgbb.mapstruct.users;

import org.mapstruct.Mapper;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDbo;
import com.zfgc.zfgbb.dbo.UserPermissionViewDbo;
import com.zfgc.zfgbb.model.users.Permission;
import org.mapstruct.Mapping;

@Mapper(config=BBMapperConfig.class)
public interface PermissionMap {

	@Mapping(target = "permissionName", ignore = true)
	Permission toModel(UserPermissionViewDbo dbo);

	Permission toModel(BoardPermissionViewDbo dbo);

}
