package com.zfgc.zfgbb.dao.users;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.EmailAddressDboExample;
import com.zfgc.zfgbb.mappers.EmailAddressDboMapper;

@Repository
public class EmailAddressDao extends IdentityDao<EmailAddressDbo, EmailAddressDboExample> {

	public EmailAddressDao(EmailAddressDboMapper mapper) {
		super(mapper);
	}
}
