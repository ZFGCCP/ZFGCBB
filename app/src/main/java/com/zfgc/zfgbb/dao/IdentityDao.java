package com.zfgc.zfgbb.dao;

import java.util.ConcurrentModificationException;

import com.zfgc.zfgbb.dbo.AbstractDbo;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.persistence.VersionedIdentityCrudMapper;

public abstract class IdentityDao<Dbo extends AbstractDbo, Example> extends KeyedDao<Dbo, Example, Integer> {

	private final VersionedIdentityCrudMapper<Dbo, Example, Integer> versionedMapper;

	protected IdentityDao(VersionedIdentityCrudMapper<Dbo, Example, Integer> versionedMapper) {
		super(versionedMapper);
		this.versionedMapper = versionedMapper;
	}

	public Dbo save(Dbo toSave) {
		Integer primaryKey = toSave.getPkId();
		if (primaryKey == null) {
			insert(toSave);
			return toSave;
		}

		if (toSave.getUpdatedTime() == null) {
			if (update(toSave) == 0)
				throw new ZfgcNotFoundException();
			return toSave;
		}

		if (versionedMapper.updateByPrimaryKeyAndVersion(toSave) == 0) {
			find(primaryKey).orElseThrow(ZfgcNotFoundException::new);
			throw new ConcurrentModificationException();
		}
		return toSave;
	}
}
