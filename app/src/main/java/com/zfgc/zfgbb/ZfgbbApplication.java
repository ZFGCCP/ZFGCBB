package com.zfgc.zfgbb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication(scanBasePackages = "com.zfgc.zfgbb")
@ComponentScan(basePackages = "com.zfgc.zfgbb",
		excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.zfgc\\.zfgbb\\.migrator\\..*"))
@MapperScan("com.zfgc.zfgbb.mappers")
@EnableMethodSecurity(prePostEnabled = true)
public class ZfgbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZfgbbApplication.class, args);
	}

}
