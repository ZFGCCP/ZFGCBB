package com.zfgc.zfgbb.mapstruct.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.UserSettingsDbo;
import com.zfgc.zfgbb.model.users.UserSettings;

@Mapper(config = BBMapperConfig.class)
public interface UserSettingsMap {

	@Mapping(target = "userId", ignore = true)
	@Mapping(target = "createdTs", ignore = true)
	@Mapping(target = "updatedTs", ignore = true)
	void applyOnto(UserSettings settings, @MappingTarget UserSettingsDbo row);

	UserSettings toModel(UserSettingsDbo row);
}
