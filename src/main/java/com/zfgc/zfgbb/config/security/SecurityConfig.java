package com.zfgc.zfgbb.config.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	// userDetailsService bean
	@Autowired
	private OauthUsersDetailsServiceImpl oauthUsersDetailsServiceImpl;
	
	@Value("${clausius.auth.key}")
	private String authKey;

	@Bean
	  public Oauth2AuthorizationFilter jwtAuthTokenFilterBean() throws Exception {
	      return new Oauth2AuthorizationFilter(oauthUsersDetailsServiceImpl);
	  }

	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//test key for now
		SecretKeySpec key = new SecretKeySpec(authKey.getBytes(), "HMACSHA256");
		
		http.httpBasic().disable().csrf().disable().authorizeRequests().antMatchers("//*.map", 
				 "/**").permitAll().and().authorizeRequests().anyRequest().authenticated().and()
		    .oauth2ResourceServer().jwt().decoder(NimbusJwtDecoder.withSecretKey(key).build());
		
		http.addFilterAfter(jwtAuthTokenFilterBean(), SwitchUserFilter.class);
		return http.build();

    }
 }