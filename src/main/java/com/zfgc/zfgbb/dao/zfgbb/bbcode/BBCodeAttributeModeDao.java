package com.zfgc.zfgbb.dao.zfgbb.bbcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.zfgbb.BBCodeAttributeModeDbo;
import com.zfgc.zfgbb.dbo.zfgbb.BBCodeAttributeModeDboExample;
import com.zfgc.zfgbb.mappers.BBCodeAttributeDboMapper;
import com.zfgc.zfgbb.mappers.BBCodeAttributeModeDboMapper;

@Repository
public class BBCodeAttributeModeDao extends AbstractDao<BBCodeAttributeModeDboExample, BBCodeAttributeModeDboMapper, BBCodeAttributeModeDbo>  {

	@Autowired
    public BBCodeAttributeModeDao(BBCodeAttributeModeDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public BBCodeAttributeModeDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BBCodeAttributeModeDbo> get(BBCodeAttributeModeDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(BBCodeAttributeModeDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(BBCodeAttributeModeDbo toCreate) {
		mapper.insert(toCreate);
	}
}
