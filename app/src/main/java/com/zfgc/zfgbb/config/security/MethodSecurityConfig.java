package com.zfgc.zfgbb.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authorization.DefaultAuthorizationManagerFactory;

@Configuration
public class MethodSecurityConfig {

	@Bean
	public static RoleHierarchy roleHierarchy() {
		return RoleHierarchyImpl.fromHierarchy("""
				ROLE_ZFGC_SITE_ADMIN > ROLE_ZFGC_SITE_MODERATOR
				ROLE_ZFGC_SITE_ADMIN > ROLE_ZFGC_PROFILE_ADMIN
				ROLE_ZFGC_SITE_ADMIN > ROLE_ZFGC_WIKI_MODERATOR
				ROLE_ZFGC_SITE_MODERATOR > ROLE_ZFGC_FORUM_MODERATE
				ROLE_ZFGC_FORUM_MODERATE > ROLE_ZFGC_FORUM_WRITE
				ROLE_ZFGC_FORUM_WRITE > ROLE_ZFGC_FORUM_READ
				ROLE_ZFGC_USER > ROLE_ZFGC_FORUM_WRITE
				ROLE_ZFGC_PROFILE_ADMIN > ROLE_ZFGC_PROFILE_WRITE
				ROLE_ZFGC_PROFILE_WRITE > ROLE_ZFGC_PROFILE_READ
				""");
	}

	@Bean
	static MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy,
			PermissionEvaluator permissionEvaluator) {
		DefaultMethodSecurityExpressionHandler expressionHandler = new ZfgbbMethodSecurityExpressionHandler(roleHierarchy);
		expressionHandler.setPermissionEvaluator(permissionEvaluator);
		return expressionHandler;
	}

	private static final class ZfgbbMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
		private ZfgbbMethodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
			if (roleHierarchy != null && getAuthorizationManagerFactory() instanceof DefaultAuthorizationManagerFactory<?> factory) {
				factory.setRoleHierarchy(roleHierarchy);
			}
		}
	}

}
