package com.zfgc.zfgbb.migrator.converters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.CategoryDbo;
import com.zfgc.zfgbb.mappers.CategoryDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFCategoryDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFCategoryDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFCategoryDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryConverter extends AbstractConverter<Map<Integer, CategoryDbo>> {

	private final SMFCategoryDbMapper smfCategoryMapper;

	private final CategoryDboMapper categoryDboMapper;

	private final MigratorIdMapService idMap;

	@Override
	public JobType getType() {
		return JobType.CATEGORIES;
	}

	@Override
	@Transactional
	public Map<Integer, CategoryDbo> convertToZfgbb() {
		List<SMFCategoryDb> SMFCategories = smfCategoryMapper.selectByExample(new SMFCategoryDbExample());
		Map<Integer, CategoryDbo> result = new HashMap<>();

		SMFCategories.forEach((smfCategory) -> {
			Cancellable.check();
			CategoryDbo cat = new CategoryDbo();

			cat.setCategoryName(smfCategory.getName());
			cat.setCategoryOrder(smfCategory.getCatOrder() != null
					? smfCategory.getCatOrder().shortValue()
					: 0);

			cat.setMigrationHash(MigrationHasher.hash(smfCategory.getIdCat().toString()
					+ cat.getCategoryName()
					+ cat.getCategoryOrder()
					+ (cat.getDescription() == null ? "" : cat.getDescription())
					+ (cat.getParentBoardId() == null ? "" : cat.getParentBoardId())));

			Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.CATEGORY, smfCategory.getIdCat());
			if (existingZfgbbId == null) {
				categoryDboMapper.insert(cat);
				idMap.record(LegacyEntityType.CATEGORY, smfCategory.getIdCat(), cat.getCategoryId());
			} else {
				CategoryDbo existing = categoryDboMapper.selectByPrimaryKey(existingZfgbbId);
				if (existing == null) {
					cat.setCategoryId(existingZfgbbId);
					categoryDboMapper.insert(cat);
				} else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), cat.getMigrationHash())) {
					cat.setCategoryId(existingZfgbbId);
					categoryDboMapper.updateByPrimaryKey(cat);
				} else {
					cat.setCategoryId(existingZfgbbId);
				}
			}

			result.put(smfCategory.getIdCat(), cat);
		});

		return result;
	}
}
