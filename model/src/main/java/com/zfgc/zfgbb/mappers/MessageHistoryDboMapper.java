package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public interface MessageHistoryDboMapper extends VersionedIdentityCrudMapper<MessageHistoryDbo, MessageHistoryDboExample, Integer> {
}