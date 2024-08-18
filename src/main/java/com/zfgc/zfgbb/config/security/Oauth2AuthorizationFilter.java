package com.zfgc.zfgbb.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.filter.GenericFilterBean;

import com.zfgc.zfgbb.util.ZfgcSecurityUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Oauth2AuthorizationFilter extends GenericFilterBean {

	@Autowired
	private OauthUsersDetailsServiceImpl oauthUsersDetailsServiceImpl;
  
  public Oauth2AuthorizationFilter (OauthUsersDetailsServiceImpl userDetailsService) {
    this.oauthUsersDetailsServiceImpl = userDetailsService;
  }
  
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

	  SecurityContext context = SecurityContextHolder.getContext();
	  if(context.getAuthentication() != null && context.getAuthentication().getPrincipal() instanceof Jwt) {
      
		  //check here what authority user came from and transform to an sso key here
		  //for now we only support clausius auth, but facebook and google are to come
		  String ssoKey = "CLAUSIUS:" + ZfgcSecurityUtils.generateMd5(((Jwt)context.getAuthentication().getPrincipal()).getClaimAsString("user_name"));
		  
		  UserDetails user = oauthUsersDetailsServiceImpl.loadUserByUsername(ssoKey); 
		  UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		  context.setAuthentication(authentication);
	  }
    
	  chain.doFilter(request, response);
  }

}