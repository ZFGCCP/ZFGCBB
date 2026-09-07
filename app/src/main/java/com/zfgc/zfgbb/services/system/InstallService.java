package com.zfgc.zfgbb.services.system;

import java.time.OffsetDateTime;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dao.users.BrUserPermissionDao;
import com.zfgc.zfgbb.dbo.BrUserPermissionDbo;
import com.zfgc.zfgbb.exception.ZfgcInvalidRequestException;
import com.zfgc.zfgbb.model.system.InstallRequest;
import com.zfgc.zfgbb.model.system.InstallResponse;
import com.zfgc.zfgbb.model.system.InstallResult;
import com.zfgc.zfgbb.model.users.RegistrationRequest;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.services.users.UserRegistrationService;

@Service
public class InstallService {

	public static final Integer ZFGC_SITE_ADMIN_PERMISSION_ID = 10;

	private final SystemConfigService systemConfigService;
	private final UserRegistrationService userRegistrationService;
	private final BrUserPermissionDao brUserPermissionDao;
	private final DataSource dataSource;

	public InstallService(SystemConfigService systemConfigService,
			UserRegistrationService userRegistrationService,
			BrUserPermissionDao brUserPermissionDao,
			DataSource dataSource) {
		this.systemConfigService = systemConfigService;
		this.userRegistrationService = userRegistrationService;
		this.brUserPermissionDao = brUserPermissionDao;
		this.dataSource = dataSource;
	}

	public InstallResult install(InstallRequest req) {
		if (req == null) {
			throw new ZfgcInvalidRequestException("Install request is required.");
		}
		if (systemConfigService.isInstalled()) {
			throw new ZfgcInvalidRequestException("System is already installed.");
		}

		boolean sampleApplied = false;
		if (Boolean.TRUE.equals(req.applySampleData())) {
			runSeedMigration();
			sampleApplied = true;
		}

		User admin = installCore(req);

		String siteName = StringUtils.defaultIfBlank(req.siteName(), "ZFGBB");
		InstallResponse response = new InstallResponse(true, admin.getUserId(), siteName, sampleApplied, null, null);
		return new InstallResult(response, admin);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	protected User installCore(InstallRequest req) {
		RegistrationRequest reg = new RegistrationRequest(
				req.adminUserName(),
				req.adminDisplayName(),
				req.adminEmail(),
				req.adminPassword());
		User admin = userRegistrationService.createNewUser(reg);

		// createNewUser grants ZFGC_USER; the install endpoint also grants
		// ZFGC_SITE_ADMIN.
		BrUserPermissionDbo siteAdmin = new BrUserPermissionDbo();
		siteAdmin.setUserId(admin.getUserId());
		siteAdmin.setUserPermissionId(ZFGC_SITE_ADMIN_PERMISSION_ID);
		brUserPermissionDao.insert(siteAdmin);

		String siteName = StringUtils.defaultIfBlank(req.siteName(), "ZFGBB");
		systemConfigService.set(SystemConfigService.Keys.SITE_NAME, siteName);
		systemConfigService.set(SystemConfigService.Keys.INSTALLED_AT, OffsetDateTime.now().toString());
		systemConfigService.set(SystemConfigService.Keys.INSTALLED_BY_USER_ID, String.valueOf(admin.getUserId()));
		// Flip the marker LAST so a partial-install failure means we didnt install.

		systemConfigService.set(SystemConfigService.Keys.INSTALLED, "true");

		return admin;
	}

	private void runSeedMigration() {
		Flyway.configure()
				.dataSource(dataSource)
				.locations("classpath:db/seed")
				.schemas("zfgbb")
				.defaultSchema("zfgbb")
				.table("flyway_seed_history")
				.baselineOnMigrate(true)
				.baselineVersion(MigrationVersion.fromVersion("0"))
				.load()
				.migrate();
	}
}
