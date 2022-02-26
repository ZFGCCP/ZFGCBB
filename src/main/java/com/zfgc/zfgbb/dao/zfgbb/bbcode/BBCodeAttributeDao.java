package com.zfgc.zfgbb.dao.zfgbb.bbcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.zfgbb.BBCodeAttributeDbo;
import com.zfgc.zfgbb.dbo.zfgbb.BBCodeAttributeDboExample;
import com.zfgc.zfgbb.mappers.AttributeDataTypeDboMapper;
import com.zfgc.zfgbb.mappers.BBCodeAttributeDboMapper;

@Repository
public class BBCodeAttributeDao extends AbstractDao<BBCodeAttributeDboExample, BBCodeAttributeDboMapper, BBCodeAttributeDbo>  {

	@Autowired
    public BBCodeAttributeDao(BBCodeAttributeDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public BBCodeAttributeDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BBCodeAttributeDbo> get(BBCodeAttributeDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(BBCodeAttributeDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(BBCodeAttributeDbo toCreate) {
		mapper.insert(toCreate);
	}

}
