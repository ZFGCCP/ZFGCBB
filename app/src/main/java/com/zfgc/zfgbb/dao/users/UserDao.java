package com.zfgc.zfgbb.dao.users;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.mappers.UserDboMapper;

@Repository
public class UserDao extends IdentityDao<UserDbo, UserDboExample> {

	public UserDao(UserDboMapper mapper) {
		super(mapper);
	}

	public int recordFailedLoginAttempt(Integer userId, OffsetDateTime now, int lockThreshold,
			OffsetDateTime lockUntil) {
		Optional<UserDbo> lockedRow = lockForUpdate(userId);
		if (lockedRow.isEmpty())
			return 0;
		UserDbo row = lockedRow.get();
		boolean lockLapsed = row.getLockedUntilTs() != null && !row.getLockedUntilTs().isAfter(now);
		int failedLoginCount = lockLapsed ? 1
				: (row.getFailedLoginCount() == null ? 0 : row.getFailedLoginCount()) + 1;
		row.setFailedLoginCount(failedLoginCount);
		if (failedLoginCount >= lockThreshold)
			row.setLockedUntilTs(lockUntil);
		else if (lockLapsed)
			row.setLockedUntilTs(null);
		save(row);
		return 1;
	}

	public int clearFailedLoginState(Integer userId, OffsetDateTime now) {
		Optional<UserDbo> lockedRow = lockForUpdate(userId);
		if (lockedRow.isEmpty())
			return 0;
		UserDbo row = lockedRow.get();
		boolean dirty = (row.getFailedLoginCount() != null && row.getFailedLoginCount() > 0)
				|| row.getLockedUntilTs() != null;
		if (!dirty)
			return 0;
		row.setFailedLoginCount(0);
		row.setLockedUntilTs(null);
		save(row);
		return 1;
	}

	public int updateDisplayName(String displayName, Integer userId) {
		UserDbo row = new UserDbo();
		row.setDisplayName(displayName);
		UserDboExample example = new UserDboExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return updateWhere(row, example);
	}
}
