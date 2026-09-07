package com.zfgc.zfgbb.dao.bbcode;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.BBCodeAttributeDbo;
import com.zfgc.zfgbb.dbo.BBCodeAttributeDboExample;
import com.zfgc.zfgbb.mappers.AttributeDataTypeDboMapper;
import com.zfgc.zfgbb.mappers.BBCodeAttributeDboMapper;

@Repository
public class BBCodeAttributeDao extends AbstractDao<BBCodeAttributeDboExample, BBCodeAttributeDboMapper, BBCodeAttributeDbo>  {

    public BBCodeAttributeDao(BBCodeAttributeDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public Optional<BBCodeAttributeDbo> get(Integer id) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(id));
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
