package com.zfgc.zfgbb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication()
@ComponentScan(basePackages = "com.zfgc.zfgbb", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class),
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.zfgc\\.zfgbb\\.migrator\\..*") })
@MapperScan("com.zfgc.zfgbb.mappers")
@EnableMethodSecurity(prePostEnabled = true)
@ConfigurationPropertiesScan
public class ZfgbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZfgbbApplication.class, args);
	}

}
