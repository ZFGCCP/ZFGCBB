package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.dbo.UserBioInfoDboExample;
import com.zfgc.zfgbb.mappers.AvatarDboMapper;

@Repository
public class AvatarDao extends IdentityDao<AvatarDbo, AvatarDboExample> {

	private final UserBioInfoDao userBioInfoDao;

	public AvatarDao(AvatarDboMapper mapper, UserBioInfoDao userBioInfoDao) {
		super(mapper);
		this.userBioInfoDao = userBioInfoDao;
	}

	public boolean isAvailableTo(Integer avatarId, Integer userId) {
		AvatarDboExample activeAvatar = new AvatarDboExample();
		activeAvatar.createCriteria().andAvatarIdEqualTo(avatarId).andActiveFlagEqualTo(true);
		if (!exists(activeAvatar))
			return false;
		UserBioInfoDboExample claimedByAnotherUser = new UserBioInfoDboExample();
		claimedByAnotherUser.createCriteria().andAvatarIdEqualTo(avatarId).andUserIdNotEqualTo(userId);
		return !userBioInfoDao.exists(claimedByAnotherUser);
	}
}
