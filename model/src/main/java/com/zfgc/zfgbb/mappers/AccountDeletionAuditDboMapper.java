package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.AccountDeletionAuditDbo;
import com.zfgc.zfgbb.dbo.AccountDeletionAuditDboExample;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public interface AccountDeletionAuditDboMapper extends VersionedIdentityCrudMapper<AccountDeletionAuditDbo, AccountDeletionAuditDboExample, Integer> {
}