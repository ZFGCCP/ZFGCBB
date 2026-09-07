package com.zfgc.zfgbb.dao.users;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDbo;
import com.zfgc.zfgbb.dbo.UserRefreshTokenDboExample;
import com.zfgc.zfgbb.mappers.UserRefreshTokenDboMapper;

@Repository
public class UserRefreshTokenDao extends IdentityDao<UserRefreshTokenDbo, UserRefreshTokenDboExample> {

	public UserRefreshTokenDao(UserRefreshTokenDboMapper mapper) {
		super(mapper);
	}

	public int consume(Integer userRefreshTokenId, OffsetDateTime now) {
		UserRefreshTokenDbo consumed = new UserRefreshTokenDbo();
		consumed.setRevokedFlag(true);
		consumed.setRotatedTs(now);
		UserRefreshTokenDboExample example = new UserRefreshTokenDboExample();
		example.createCriteria().andUserRefreshTokenIdEqualTo(userRefreshTokenId)
				.andRevokedFlagEqualTo(false)
				.andExpiresTsGreaterThanOrEqualTo(now);
		return updateWhere(consumed, example);
	}
}
