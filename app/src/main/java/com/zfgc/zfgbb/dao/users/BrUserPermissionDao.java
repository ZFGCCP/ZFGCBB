package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.KeyedDao;
import com.zfgc.zfgbb.dbo.BrUserPermissionDbo;
import com.zfgc.zfgbb.dbo.BrUserPermissionDboExample;
import com.zfgc.zfgbb.mappers.BrUserPermissionDboMapper;

@Repository
public class BrUserPermissionDao extends KeyedDao<BrUserPermissionDbo, BrUserPermissionDboExample, Integer> {

	public BrUserPermissionDao(BrUserPermissionDboMapper mapper) {
		super(mapper);
	}

	public int grantIfAbsent(Integer userId, Integer userPermissionId) {
		BrUserPermissionDboExample example = new BrUserPermissionDboExample();
		example.createCriteria().andUserIdEqualTo(userId).andUserPermissionIdEqualTo(userPermissionId);
		if (exists(example))
			return 0;
		BrUserPermissionDbo grant = new BrUserPermissionDbo();
		grant.setUserId(userId);
		grant.setUserPermissionId(userPermissionId);
		insert(grant);
		return 1;
	}
}
