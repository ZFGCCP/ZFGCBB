package com.zfgc.zfgbb.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zfgbb.cors")
public record CorsProperties(List<String> allowedOriginPatterns) {}
