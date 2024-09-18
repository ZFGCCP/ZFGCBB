package com.zfgc.zfgbb.dataprovider.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.users.EmailAddressDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dao.UserPermissionViewDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.dbo.UserPermissionViewDboExample;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Permission;

@Repository
public class UserDataProvider extends AbstractDataProvider {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserPermissionViewDao userPermissionDao;
	
	@Autowired
	private EmailAddressDao emailDao;
	
	public User getUser(String ssoKey) {
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andSsoKeyEqualTo(ssoKey).andActiveFlagEqualTo(true);
		UserDbo userDb = userDao.get(ex).stream().findFirst().orElse(createGuest());
		
		User user = mapper.map(userDb, User.class);

		//todo: setup guest permissions
		UserPermissionViewDboExample upEx = new UserPermissionViewDboExample();
		upEx.createCriteria().andUserIdEqualTo(user.getUserId());
		List<Permission> permissions = convertDboListToModel(userPermissionDao.get(upEx), Permission.class);

		user.setPermissions(permissions);
		
		return user;
	}
	
	public User getUser(Integer userId) {
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserIdEqualTo(userId).andActiveFlagEqualTo(true);
		UserDbo userDb = userDao.get(ex).stream().findFirst().orElse(createGuest());
		
		User user = mapper.map(userDb, User.class);

		//todo: setup guest permissions
		UserPermissionViewDboExample upEx = new UserPermissionViewDboExample();
		upEx.createCriteria().andUserIdEqualTo(user.getUserId());
		List<Permission> permissions = convertDboListToModel(userPermissionDao.get(upEx), Permission.class);

		user.setPermissions(permissions);
		
		return user;
	}
	
	public User createUser(User user) {
		UserDbo userDbo = mapper.map(user, UserDbo.class);
		userDao.save(userDbo);
		
		EmailAddressDbo emailDbo = mapper.map(user.getEmail(), EmailAddressDbo.class);
		emailDbo.setUserId(userDbo.getPkId());
		emailDao.save(emailDbo);
		
		return getUser(userDbo.getPkId());
	}
	
	public UserDbo createGuest() {
		UserDbo user = new UserDbo();
		user.setUserId(-1);
		user.setDisplayName("Guest");
		
		return user;
	}
	
}