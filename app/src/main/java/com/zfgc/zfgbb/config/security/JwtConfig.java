package com.zfgc.zfgbb.config.security;

import java.nio.charset.StandardCharsets;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
@RequiredArgsConstructor
public class JwtConfig {

	private static final String PLACEHOLDER_SECRET = "dev-only-secret-replace-me-with-32-or-more-bytes-please";

	private final JwtProperties jwtProperties;
	private final Environment environment;

	@Bean
	public SecretKeySpec jwtSigningKey() {
		String secret = jwtProperties.secret();
		boolean devProfile = environment.acceptsProfiles(Profiles.of("local"));
		boolean weakSecret = secret == null || secret.isBlank()
				|| secret.equals(PLACEHOLDER_SECRET)
				|| secret.length() < 32;
		if (!devProfile && weakSecret) {
			throw new IllegalStateException(
					"zfgbb.auth.jwt.secret must be a >= 32 char value outside the local profile");
		}
		return new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	}

	@Bean
	public JwtEncoder jwtEncoder(SecretKeySpec key) {
		return new NimbusJwtEncoder(new ImmutableSecret<>(key));
	}

	@Bean
	public JwtDecoder jwtDecoder(SecretKeySpec key) {
		return NimbusJwtDecoder.withSecretKey(key).macAlgorithm(MacAlgorithm.HS256).build();
	}
}
