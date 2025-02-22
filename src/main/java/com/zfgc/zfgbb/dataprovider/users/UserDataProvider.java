package com.zfgc.zfgbb.dataprovider.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.users.AvatarDao;
import com.zfgc.zfgbb.dao.users.EmailAddressDao;
import com.zfgc.zfgbb.dao.users.UserBioInfoDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.config.loadoption.user.BasicUserLoadOptions;
import com.zfgc.zfgbb.config.loadoption.user.FullUserLoadOptions;
import com.zfgc.zfgbb.config.loadoption.user.LoggedInUserLoadOptions;
import com.zfgc.zfgbb.dao.UserPermissionViewDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.dbo.UserPermissionViewDboExample;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Avatar;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.users.UserBioInfo;

@Repository
public class UserDataProvider extends AbstractDataProvider {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserPermissionViewDao userPermissionDao;
	
	@Autowired
	private EmailAddressDao emailDao;
	
	@Autowired
	private UserBioInfoDao bioInfoDao;
	
	@Autowired
	private AvatarDao avatarDao;
	
	public User getUser(String userName) {
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserNameEqualTo(userName).andActiveFlagEqualTo(true);
		UserDbo userDb = userDao.get(ex).stream().findFirst().orElse(createGuest());

		return getUser(userDb.getPkId(), new LoggedInUserLoadOptions());
	}
	
	public User getUser(Integer userId, BasicUserLoadOptions loadOptions) {
		if(loadOptions == null) {
			loadOptions = new BasicUserLoadOptions();
		}
		
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserIdEqualTo(userId).andActiveFlagEqualTo(true);
		UserDbo userDb = userDao.get(ex).stream().findFirst().orElse(createGuest());
		
		User user = mapper.map(userDb, User.class);

		//todo: setup guest permissions
		if(Boolean.TRUE.equals(loadOptions.loadPermissions())){
			UserPermissionViewDboExample upEx = new UserPermissionViewDboExample();
			upEx.createCriteria().andUserIdEqualTo(user.getUserId());
			List<Permission> permissions = convertDboListToModel(userPermissionDao.get(upEx), Permission.class);
	
			user.setPermissions(permissions);
		}
		
		if(Boolean.TRUE.equals(loadOptions.loadBio())) {
			UserBioInfoDbo bioInfoDbo = bioInfoDao.get(userId);
			if(bioInfoDbo != null) {
				user.setBioInfo(mapper.map(bioInfoDbo, UserBioInfo.class));
			}
		}
		
		if(Boolean.TRUE.equals(loadOptions.loadAvatar())) {
			AvatarDboExample avatarEx = new AvatarDboExample();
			avatarEx.createCriteria().andUserIdEqualTo(userId)
									 .andActiveFlagEqualTo(true);
			
			Optional<AvatarDbo> avDb = avatarDao.get(avatarEx).stream().findFirst();
			
			if(avDb != null) {
				Avatar av = avDb.map((a) -> mapper.map(a, Avatar.class)).orElse(null);
				user.setAvatar(av);
			}
		}
		
		return user;
	}
	
	public User createUser(User user) {
		UserDbo userDbo = mapper.map(user, UserDbo.class);
		userDao.save(userDbo);
		
		//create bio info
		UserBioInfoDbo bioInfo = mapper.map(user.getBioInfo(), UserBioInfoDbo.class);
		bioInfo.setUserId(userDbo.getPkId());
		bioInfoDao.save(bioInfo);
		
		EmailAddressDbo emailDbo = mapper.map(user.getEmail(), EmailAddressDbo.class);
		emailDbo.setUserId(userDbo.getPkId());
		emailDao.save(emailDbo);
		
		return getUser(userDbo.getPkId(), new FullUserLoadOptions());
	}
	
	public UserDbo createGuest() {
		UserDbo user = new UserDbo();
		user.setUserId(-1);
		user.setDisplayName("Guest");
		
		return user;
	}
	
	public User saveUserProfile(User user) {
		UserDbo userDbo = mapper.map(user, UserDbo.class);
		userDbo = userDao.save(userDbo);
		
		if(user.getBioInfo() != null) {
			UserBioInfoDbo bioInfoDbo = mapper.map(user.getBioInfo(), UserBioInfoDbo.class);
			bioInfoDao.save(bioInfoDbo);
		}
		
		return getUser(userDbo.getUserId(), null);
	}
	
}