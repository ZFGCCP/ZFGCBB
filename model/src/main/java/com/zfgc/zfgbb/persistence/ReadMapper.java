package com.zfgc.zfgbb.persistence;

import java.util.List;

public interface ReadMapper<Dbo, Example> {

	long countByExample(Example example);

	List<Dbo> selectByExample(Example example);

	List<Dbo> selectByExampleWithLimits(Example example);
}
