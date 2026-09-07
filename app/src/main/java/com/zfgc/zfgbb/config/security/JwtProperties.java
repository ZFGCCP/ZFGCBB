package com.zfgc.zfgbb.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zfgbb.auth.jwt")
public record JwtProperties(String secret) {}
