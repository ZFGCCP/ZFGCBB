package com.zfgc.zfgbb.dao;

import java.time.OffsetDateTime;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

import com.zfgc.zfgbb.dbo.AbstractDbo;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;

public abstract class AbstractDao<DbExample, DbMapper, Dbo extends AbstractDbo> {

	protected DbMapper mapper;

	public abstract Optional<Dbo> get(Integer id);

	public abstract List<Dbo> get(DbExample ex);

	public AbstractDao(DbMapper mapper) {
		this.mapper = mapper;
	}

	public Dbo save(Dbo toSave) {
		Integer pk = toSave.getPkId();

		if (pk == null) {
			OffsetDateTime now = OffsetDateTime.now();
			toSave.setCreatedTs(now);
			toSave.setUpdatedTs(now);
			create(toSave);
		} else {
			Dbo existing = get(pk).orElseThrow(() -> new ZfgcNotFoundException());
			OffsetDateTime existingTs = existing.getUpdatedTime();
			OffsetDateTime toSaveTs = toSave.getUpdatedTime();
			if (existingTs != null && toSaveTs != null && existingTs.isAfter(toSaveTs)) {
				// concurrency problem, get this garbo outta here
				throw new ConcurrentModificationException();
			}
			toSave.setUpdatedTs(OffsetDateTime.now());
			update(toSave);
		}

		return get(toSave.getPkId()).get();
	}

	public DbMapper getMapper() {
		return mapper;
	}

	protected abstract void update(Dbo toSave);

	protected abstract void create(Dbo toCreate);

	public void delete(DbExample id) {
		throw new RuntimeException("delete not supported");
	}
}
