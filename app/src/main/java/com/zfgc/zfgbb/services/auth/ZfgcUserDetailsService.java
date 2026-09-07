package com.zfgc.zfgbb.services.auth;

import lombok.RequiredArgsConstructor;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ConcurrentModificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.model.users.EncodedPassword;
import com.zfgc.zfgbb.model.users.User;

@Service
@RequiredArgsConstructor
public class ZfgcUserDetailsService implements UserDetailsService, UserDetailsPasswordService {

	private final UserDataProvider userDataProvider;
	private final UserDao userDao;
	@Value("${zfgbb.auth.password.max-age-days}")
	private final long passwordMaxAgeDays;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDataProvider.findUserForAuthentication(userName)
				.orElseThrow(() -> new UsernameNotFoundException(userName));
		user.setCredentialsNonExpired(isPasswordCurrent(user));
		return user;
	}

	@Override
	public UserDetails updatePassword(UserDetails user, String newEncodedPassword) {
		User principal = (User) user;
		EncodedPassword upgraded = EncodedPassword.parse(newEncodedPassword);
		UserDbo userDbo = userDao.find(principal.getUserId()).orElseThrow();
		userDbo.setPasswordHash(upgraded.hash());
		userDbo.setPasswordAlgo(upgraded.algo().name());
		userDbo.setPasswordSalt(upgraded.salt());
		userDbo.setPasswordChangedTs(OffsetDateTime.now(ZoneOffset.UTC));
		try {
			userDao.save(userDbo);
		} catch (ConcurrentModificationException upgradeRaced) {
			return user;
		}

		principal.setPasswordHash(upgraded.hash());
		principal.setPasswordAlgo(upgraded.algo());
		principal.setPasswordSalt(upgraded.salt());
		return principal;
	}

	private boolean isPasswordCurrent(User user) {
		if (passwordMaxAgeDays <= 0)
			return true;
		OffsetDateTime passwordChanged = user.getPasswordChangedTs();
		if (passwordChanged == null)
			return true;
		return !passwordChanged.plus(Duration.ofDays(passwordMaxAgeDays)).isBefore(OffsetDateTime.now(ZoneOffset.UTC));
	}
}
