package com.zfgc.zfgbb.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValueCheckStrategy;


@MapperConfig(
	    componentModel = "spring",
	    unmappedTargetPolicy = ReportingPolicy.ERROR,
	    unmappedSourcePolicy = ReportingPolicy.IGNORE,
	    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
	)
public interface BBMapperConfig {
}
