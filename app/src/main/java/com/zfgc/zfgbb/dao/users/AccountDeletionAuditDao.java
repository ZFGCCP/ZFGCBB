package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.AccountDeletionAuditDbo;
import com.zfgc.zfgbb.dbo.AccountDeletionAuditDboExample;
import com.zfgc.zfgbb.mappers.AccountDeletionAuditDboMapper;

@Repository
public class AccountDeletionAuditDao extends IdentityDao<AccountDeletionAuditDbo, AccountDeletionAuditDboExample> {

	public AccountDeletionAuditDao(AccountDeletionAuditDboMapper mapper) {
		super(mapper);
	}
}
