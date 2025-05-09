package com.zfgc.zfgbb.config.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	// userDetailsService bean
	@Autowired
	private OauthUsersDetailsServiceImpl oauthUsersDetailsServiceImpl;

	@Bean
	  public Oauth2AuthorizationFilter jwtAuthTokenFilterBean() throws Exception {
	      return new Oauth2AuthorizationFilter(oauthUsersDetailsServiceImpl);
	  }

	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//test key for now
		/*SecretKeySpec key = new SecretKeySpec(authKey.getBytes(), "HMACSHA256");
		
		http.httpBasic(httpBasic -> httpBasic.disable())
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(req -> req.requestMatchers("//*.map", "/**").permitAll())
			.authorizeHttpRequests(req -> req.anyRequest().authenticated())
			.oauth2ResourceServer(oauth -> oauth.jwt(jwt -> jwt.decoder(NimbusJwtDecoder.withSecretKey(key).build())));*/
		
		
		http.addFilterAfter(jwtAuthTokenFilterBean(), SwitchUserFilter.class);
		return http.build();

    }
	
	
 }