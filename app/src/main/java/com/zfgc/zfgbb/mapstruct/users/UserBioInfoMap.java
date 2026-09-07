package com.zfgc.zfgbb.mapstruct.users;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.model.users.UserBioInfo;

@Mapper(config=BBMapperConfig.class)
public interface UserBioInfoMap {

	@Mapping(target = "postCount", ignore = true)
	@Mapping(target="avatar", ignore=true)
	@Mapping(target="signatureParsed", ignore=true)
	@Mapping(target="dateFormat", ignore=true)
	UserBioInfo toModel(UserBioInfoDbo dbo);
	
	@Mapping(target="migrationHash", ignore=true)
	@Mapping(target="avatarId", source="avatar.avatarId")
	@Mapping(target="karmaGood", ignore=true)
	@Mapping(target="karmaBad", ignore=true)
	UserBioInfoDbo toDbo(UserBioInfo model);
	
}
