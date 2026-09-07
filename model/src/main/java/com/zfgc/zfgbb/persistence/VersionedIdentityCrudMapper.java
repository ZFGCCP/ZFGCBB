package com.zfgc.zfgbb.persistence;

public interface VersionedIdentityCrudMapper<Dbo, Example, PrimaryKey>
		extends IdentityCrudMapper<Dbo, Example, PrimaryKey> {

	int updateByPrimaryKeyAndVersion(Dbo row);
}
