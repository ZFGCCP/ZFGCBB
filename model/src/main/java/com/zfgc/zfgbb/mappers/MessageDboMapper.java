package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public interface MessageDboMapper extends VersionedIdentityCrudMapper<MessageDbo, MessageDboExample, Integer> {
}