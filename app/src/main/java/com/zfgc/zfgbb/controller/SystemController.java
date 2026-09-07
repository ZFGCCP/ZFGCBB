package com.zfgc.zfgbb.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zfgc.zfgbb.authorization.AllowAnonymous;
import com.zfgc.zfgbb.model.system.InstallRequest;
import com.zfgc.zfgbb.model.system.InstallResponse;
import com.zfgc.zfgbb.model.system.InstallResult;
import com.zfgc.zfgbb.model.system.InstallStatusResponse;
import com.zfgc.zfgbb.model.users.LoginResponse;
import com.zfgc.zfgbb.services.auth.AuthCookieService;
import com.zfgc.zfgbb.services.auth.AuthService;
import com.zfgc.zfgbb.services.system.InstallService;
import com.zfgc.zfgbb.services.system.SystemConfigService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/system/install")
@AllowAnonymous
public class SystemController {

	private final InstallService installService;
	private final SystemConfigService systemConfigService;
	private final AuthService authService;
	private final AuthCookieService cookieService;
	private final String installToken;

	public SystemController(InstallService installService,
			SystemConfigService systemConfigService,
			AuthService authService,
			AuthCookieService cookieService,
			@Value("${zfgbb.install.token:}") String installToken) {
		this.installService = installService;
		this.systemConfigService = systemConfigService;
		this.authService = authService;
		this.cookieService = cookieService;
		this.installToken = installToken;
	}

	@GetMapping("/status")
	public ResponseEntity<InstallStatusResponse> status() {
		boolean installed = systemConfigService.isInstalled();
		String siteName = installed ? systemConfigService.get(SystemConfigService.Keys.SITE_NAME) : null;
		return ResponseEntity.ok(new InstallStatusResponse(installed, siteName));
	}

	@PostMapping
	public ResponseEntity<InstallResponse> install(
			@RequestBody InstallRequest request,
			@RequestHeader(value = "X-Install-Token", required = false) String presentedToken) {
		if (StringUtils.isBlank(installToken)) {
			throw notFound();
		}
		if (!constantTimeEquals(presentedToken, installToken)) {
			throw notFound();
		}
		if (systemConfigService.isInstalled()) {
			throw notFound();
		}

		InstallResult result = installService.install(request);
		LoginResponse tokens = authService.issueLoginResponse(result.admin(), false);
		InstallResponse base = result.response();

		if (Boolean.TRUE.equals(request.useTokens())) {
			InstallResponse withTokens = new InstallResponse(
					base.installed(),
					base.adminUserId(),
					base.siteName(),
					base.sampleDataApplied(),
					tokens.accessToken(),
					tokens.refreshToken());
			return ResponseEntity.ok(withTokens);
		}

		return cookieService.setTokenCookies(ResponseEntity.ok(), tokens.tokens()).body(base);
	}

	private static boolean constantTimeEquals(String presented, String expected) {
		if (presented == null) {
			return false;
		}
		return java.security.MessageDigest.isEqual(
				presented.getBytes(java.nio.charset.StandardCharsets.UTF_8),
				expected.getBytes(java.nio.charset.StandardCharsets.UTF_8));
	}

	private static ResponseStatusException notFound() {
		return new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
