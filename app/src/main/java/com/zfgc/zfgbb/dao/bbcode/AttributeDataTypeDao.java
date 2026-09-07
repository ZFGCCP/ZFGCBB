package com.zfgc.zfgbb.dao.bbcode;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.AttributeDataTypeDbo;
import com.zfgc.zfgbb.dbo.AttributeDataTypeDboExample;
import com.zfgc.zfgbb.mappers.AttributeDataTypeDboMapper;

@Repository
public class AttributeDataTypeDao extends AbstractDao<AttributeDataTypeDboExample, AttributeDataTypeDboMapper, AttributeDataTypeDbo>  {

    public AttributeDataTypeDao(AttributeDataTypeDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public Optional<AttributeDataTypeDbo> get(Integer id) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(id));
	}

	@Override
	public List<AttributeDataTypeDbo> get(AttributeDataTypeDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(AttributeDataTypeDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(AttributeDataTypeDbo toCreate) {
		mapper.insert(toCreate);
	}
}
