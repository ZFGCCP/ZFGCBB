package com.zfgc.zfgbb.dao.bbcode;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.BBCodeConfigDbo;
import com.zfgc.zfgbb.dbo.BBCodeConfigDboExample;
import com.zfgc.zfgbb.mappers.BBCodeConfigDboMapper;

@Repository
public class BBCodeConfigDao extends AbstractDao<BBCodeConfigDboExample, BBCodeConfigDboMapper, BBCodeConfigDbo>  {

    public BBCodeConfigDao(BBCodeConfigDboMapper mapper) {
        super(mapper);
    }
	
	@Override
	public Optional<BBCodeConfigDbo> get(Integer id) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(id));
	}

	@Override
	public List<BBCodeConfigDbo> get(BBCodeConfigDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(BBCodeConfigDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(BBCodeConfigDbo toCreate) {
		mapper.insert(toCreate);
	}
}
