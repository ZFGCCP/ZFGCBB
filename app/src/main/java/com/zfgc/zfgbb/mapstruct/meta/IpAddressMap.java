package com.zfgc.zfgbb.mapstruct.meta;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zfgc.zfgbb.config.BBMapperConfig;
import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.model.meta.IpAddress;

@Mapper(config=BBMapperConfig.class, builder=@Builder(disableBuilder=true))
public interface IpAddressMap {
	@Mapping(target="id", ignore=true)
	IpAddress toModel(IpAddressDbo dbo);
}
