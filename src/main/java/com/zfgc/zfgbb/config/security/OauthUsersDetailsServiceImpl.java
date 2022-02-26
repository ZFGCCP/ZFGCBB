package com.zfgc.zfgbb.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.model.User;

@Service
public class OauthUsersDetailsServiceImpl implements UserDetailsService{
	
	private List<String> roles;
	 
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User();
	}

}