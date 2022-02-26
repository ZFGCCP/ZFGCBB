package com.zfgc.zfgbb.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.filter.GenericFilterBean;

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
      
      UserDetails user = oauthUsersDetailsServiceImpl.loadUserByUsername(((Jwt)context.getAuthentication().getPrincipal()).getClaimAsString("user_name")); 
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      context.setAuthentication(authentication);
    }
    
    chain.doFilter(request, response);
  }

}