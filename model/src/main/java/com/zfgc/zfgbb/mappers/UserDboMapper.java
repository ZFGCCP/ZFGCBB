package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public interface UserDboMapper extends VersionedIdentityCrudMapper<UserDbo, UserDboExample, Integer> {
}