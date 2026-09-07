package com.zfgc.zfgbb.services.system;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.SystemConfigDbo;
import com.zfgc.zfgbb.dao.meta.SystemConfigDao;

@Service
@Transactional
@RequiredArgsConstructor
public class SystemConfigService {

	public static final class Keys {
		public static final String INSTALLED = "installed";
		public static final String SITE_NAME = "site_name";
		public static final String INSTALLED_AT = "installed_at";
		public static final String INSTALLED_BY_USER_ID = "installed_by_user_id";

		private Keys() {
		}
	}

	private final SystemConfigDao systemConfigDao;

	@Transactional(readOnly = true)
	public boolean isInstalled() {
		return Optional.ofNullable(get(Keys.INSTALLED))
				.map(Boolean::parseBoolean)
				.orElse(false);
	}

	@Transactional(readOnly = true)
	public String get(String key) {
		return systemConfigDao.find(key)
				.map(SystemConfigDbo::getConfigValue)
				.orElse(null);
	}

	public void set(String key, String value) {
		SystemConfigDbo existing = systemConfigDao.find(key).orElse(null);
		if (existing != null) {
			existing.setConfigValue(value);
			systemConfigDao.update(existing);
		} else {
			SystemConfigDbo inserted = new SystemConfigDbo();
			inserted.setConfigKey(key);
			inserted.setConfigValue(value);
			systemConfigDao.insert(inserted);
		}
	}
}
