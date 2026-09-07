package com.zfgc.zfgbb.mapstruct.forum;

import org.mapstruct.Mapper;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.CurrentMessageDbo;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.model.forum.Message;
import org.mapstruct.Mapping;

@Mapper(config=BBMapperConfig.class)
public interface MessageMap {

	
	@Mapping(target = "currentMessage", ignore = true)
	@Mapping(target = "fileAttachments", ignore = true)
	@Mapping(target="createdTs", source="dbo.createdTs")
	@Mapping(target="updatedTs", source="dbo.updatedTs")
	Message toModel(MessageDbo dbo, User createdUser);

	@Mapping(target = "currentMessage", ignore = true)
	@Mapping(target = "fileAttachments", ignore = true)
	@Mapping(target="createdTs", source="dbo.createdTs")
	@Mapping(target="updatedTs", source="dbo.updatedTs")
	Message toModel(CurrentMessageDbo dbo, User createdUser);
	
}
