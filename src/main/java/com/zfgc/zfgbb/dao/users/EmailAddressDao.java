package com.zfgc.zfgbb.dao.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.EmailAddressDboExample;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.mappers.EmailAddressDboMapper;
import com.zfgc.zfgbb.mappers.UserDboMapper;

@Repository
public class EmailAddressDao extends AbstractDao<EmailAddressDboExample, EmailAddressDboMapper, EmailAddressDbo>{
	
	@Autowired
	public EmailAddressDao(EmailAddressDboMapper mapper) {
		super(mapper);
	}

	@Override
	public EmailAddressDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<EmailAddressDbo> get(EmailAddressDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(EmailAddressDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(EmailAddressDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}