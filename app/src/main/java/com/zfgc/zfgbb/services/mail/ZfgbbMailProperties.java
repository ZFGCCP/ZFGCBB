package com.zfgc.zfgbb.services.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zfgbb.mail")
public record ZfgbbMailProperties(String from) {}
