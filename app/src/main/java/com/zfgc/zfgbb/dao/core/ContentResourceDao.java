package com.zfgc.zfgbb.dao.core;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.IdentityDao;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.mappers.ContentResourceDboMapper;

@Repository
public class ContentResourceDao extends IdentityDao<ContentResourceDbo, ContentResourceDboExample> {

	public ContentResourceDao(ContentResourceDboMapper mapper) {
		super(mapper);
	}
}
