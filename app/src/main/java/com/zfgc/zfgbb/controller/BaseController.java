package com.zfgc.zfgbb.controller;

import java.util.List;
import java.util.Map;


import com.zfgc.zfgbb.authorization.RequestingUser;
import com.zfgc.zfgbb.model.users.User;

public class BaseController {

	protected static List<Map<String, Object>> toFacet(List<Map.Entry<String, Long>> values) {
		return values.stream()
				.map(entry -> Map.<String, Object>of("value", entry.getKey(), "count", entry.getValue()))
				.toList();
	}

	protected User zfgcUser() {
		return RequestingUser.onThisRequest();
	}
}