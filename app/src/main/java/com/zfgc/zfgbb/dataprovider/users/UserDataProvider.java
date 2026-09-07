package com.zfgc.zfgbb.dataprovider.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.users.AvatarDao;
import com.zfgc.zfgbb.dao.users.BrUserPermissionDao;
import com.zfgc.zfgbb.dao.users.EmailAddressDao;
import com.zfgc.zfgbb.dao.users.UserBioInfoDao;
import com.zfgc.zfgbb.dao.users.UserContactInfoDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.config.loadoption.user.BasicUserLoadOptions;
import com.zfgc.zfgbb.config.loadoption.user.FullUserLoadOptions;
import com.zfgc.zfgbb.config.loadoption.user.LoggedInUserLoadOptions;
import com.zfgc.zfgbb.dao.UserPermissionViewDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dataprovider.forum.MessageDataProvider;
import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.dbo.BrUserPermissionDbo;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.EmailAddressDboExample;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.dbo.UserContactInfoDbo;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.dbo.UserKarmaViewDbo;
import com.zfgc.zfgbb.dbo.UserKarmaViewDboExample;
import com.zfgc.zfgbb.dbo.UserPermissionViewDboExample;
import com.zfgc.zfgbb.mappers.MessageDboMapper;
import com.zfgc.zfgbb.mappers.UserKarmaViewDboMapper;
import com.zfgc.zfgbb.mapstruct.users.AvatarMap;
import com.zfgc.zfgbb.mapstruct.users.KarmaMap;
import com.zfgc.zfgbb.mapstruct.users.PermissionMap;
import com.zfgc.zfgbb.mapstruct.users.UserBioInfoMap;
import com.zfgc.zfgbb.mapstruct.users.UserContactInfoMap;
import com.zfgc.zfgbb.mapstruct.users.UserMap;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.users.Avatar;
import com.zfgc.zfgbb.model.users.EmailAddress;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.users.UserBioInfo;
import com.zfgc.zfgbb.model.users.UserContactInfo;
import com.zfgc.zfgbb.model.users.UserKarmaView;
import com.zfgc.zfgbb.services.forum.BBCodeService;

@Repository
public class UserDataProvider extends AbstractDataProvider {

	private static final Integer ZFGC_USER_PERMISSION_ID = 1;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserPermissionViewDao userPermissionDao;

	@Autowired
	private BrUserPermissionDao brUserPermissionDao;

	@Autowired
	private EmailAddressDao emailDao;

	@Autowired
	private UserBioInfoDao bioInfoDao;

	@Autowired
	private AvatarDao avatarDao;

	@Autowired
	private UserContactInfoDao contactInfoDao;

	@Autowired
	private BBCodeService bbcodeService;

	@Autowired
	private UserMap userMap;

	@Autowired
	private UserBioInfoMap userBioInfoMap;

	@Autowired
	private MessageDboMapper messageDboMapper;

	@Autowired
	private UserKarmaViewDboMapper karmaViewDboMapper;

	@Autowired
	private KarmaMap karmaMap;

	@Autowired
	private UserContactInfoMap userContactInfoMap;

	@Autowired
	private AvatarMap avatarMap;

	@Autowired
	private PermissionMap permissionMap;

	public Optional<User> findUser(String userName) {
		if (userName == null || userName.isBlank()) {
			return Optional.empty();
		}
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserNameEqualTo(userName).andActiveFlagEqualTo(true);
		return userDao.get(ex).stream().findFirst()
				.flatMap(dbo -> findUser(dbo.getUserId(), new LoggedInUserLoadOptions()));
	}

	public Optional<User> findUser(Integer userId) {
		return findUser(userId, new BasicUserLoadOptions());
	}

	public Optional<User> findUser(Integer userId, BasicUserLoadOptions loadOptions) {
		if (userId == null) {
			return Optional.empty();
		}
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserIdEqualTo(userId).andActiveFlagEqualTo(true);
		return userDao.get(ex).stream().findFirst()
				.map(userDb -> hydrateUser(userDb, loadOptions));
	}

	private User hydrateUser(UserDbo userDb, BasicUserLoadOptions loadOptions) {
		Integer userId = userDb.getUserId();

		// todo: setup guest permissions
		UserPermissionViewDboExample upEx = new UserPermissionViewDboExample();
		upEx.createCriteria().andUserIdEqualTo(userId);
		List<Permission> permissions = Boolean.TRUE.equals(loadOptions.loadPermissions())
				? userPermissionDao.get(upEx).stream().map(permissionMap::toModel).toList()
				: Collections.emptyList();

		Optional<UserBioInfo> bioInfo = Boolean.TRUE.equals(loadOptions.loadBio()) ? bioInfoDao.find(userId)
				.map(bioInfoDbo -> {
					MessageDboExample msgEx = new MessageDboExample();
					msgEx.createCriteria().andOwnerIdEqualTo(userId);

					Integer postCount = (int) messageDboMapper.countByExample(msgEx);

					String signatureParsed = "";
					signatureParsed = bbcodeService.parseText(bioInfoDbo.getSignature());

					// load avatar
					AvatarDboExample avatarEx = new AvatarDboExample();
					if (bioInfoDbo.getAvatarId() != null) {
						avatarEx.createCriteria().andAvatarIdEqualTo(bioInfoDbo.getAvatarId())
								.andActiveFlagEqualTo(true);
					}
					Optional<Avatar> avatar = Boolean.TRUE.equals(loadOptions.loadAvatar())
							&& bioInfoDbo.getAvatarId() != null
									? avatarDao.get(avatarEx).stream()
											.findFirst()
											.map(avatarMap::toModel)
									: Optional.empty();

					// load karma
					UserKarmaViewDboExample karmaEx = new UserKarmaViewDboExample();
					karmaEx.createCriteria().andReceivingUserIdEqualTo(userId);
					List<UserKarmaView> karmaList = Boolean.TRUE.equals(loadOptions.loadKarma())
							? karmaViewDboMapper.selectByExample(karmaEx).stream().map(karmaMap::toViewModel).toList()
							: Collections.emptyList();

					return userBioInfoMap.toModel(bioInfoDbo)
							.toBuilder()
							.postCount(postCount)
							.signatureParsed(signatureParsed)
							.karma(karmaList)
							.avatar(avatar.orElse(null))
							.build();
				}) : Optional.empty();

		Optional<UserContactInfo> contactInfo = Boolean.TRUE.equals(loadOptions.loadContactInfo())
				? contactInfoDao.find(userId)
						.map(ci -> {
							EmailAddressDbo email = emailDao.find(ci.getEmailAddressId()).get();
							return userContactInfoMap.toModel(ci, email);
						})
				: Optional.empty();

		return userMap.toModel(userDb)
				.toBuilder()
				.bioInfo(bioInfo.orElse(null))
				.contactInfo(contactInfo.orElse(null))
				.permissions(permissions)
				.build();
	}

	public User createUser(User user) {
		UserDbo userDbo = map(user, UserDbo.class);
		userDao.save(userDbo);

		EmailAddressDbo emailDbo = map(user.getEmail(), EmailAddressDbo.class);
		emailDao.save(emailDbo);
		UserContactInfoDbo contactInfo = new UserContactInfoDbo();
		contactInfo.setUserId(userDbo.getUserId());
		contactInfo.setEmailAddressId(emailDbo.getEmailAddressId());
		contactInfo.setAllowEmailFlag(true);
		contactInfo.setAllowPmFlag(true);
		contactInfoDao.insertSelective(contactInfo);

		UserBioInfoDbo bioInfo = user.getBioInfo() != null
				? map(user.getBioInfo(), UserBioInfoDbo.class)
				: new UserBioInfoDbo();
		bioInfo.setUserId(userDbo.getUserId());
		bioInfoDao.insertSelective(bioInfo);

		BrUserPermissionDbo defaultPerm = new BrUserPermissionDbo();
		defaultPerm.setUserId(userDbo.getUserId());
		defaultPerm.setUserPermissionId(ZFGC_USER_PERMISSION_ID);
		brUserPermissionDao.insert(defaultPerm);

		return findUser(userDbo.getUserId(), new FullUserLoadOptions())
				.orElseThrow(() -> new IllegalStateException("user disappeared after createUser"));
	}

	public Optional<UserDbo> findByUserName(String userName) {
		UserDboExample ex = new UserDboExample();
		ex.createCriteria().andUserNameEqualTo(userName);
		return userDao.get(ex).stream().findFirst();
	}

	public Optional<EmailAddressDbo> findByEmail(String email) {
		EmailAddressDboExample ex = new EmailAddressDboExample();
		ex.createCriteria().andEmailAddressEqualTo(email);
		return emailDao.get(ex).stream().findFirst();
	}

	public User saveUserProfile(User user) {
		UserDbo userDbo = map(user, UserDbo.class);
		userDbo = userDao.save(userDbo);

		if (user.getBioInfo() != null) {
			UserBioInfoDbo bioInfoDbo = map(user.getBioInfo(), UserBioInfoDbo.class);
			bioInfoDao.update(bioInfoDbo);
		}

		return findUser(userDbo.getUserId(), new BasicUserLoadOptions())
				.orElseThrow(() -> new IllegalStateException("user disappeared after saveUserProfile"));
	}

}