package com.zfgc.zfgbb.migrator.converters;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.mappers.UserDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.jobs.MigratorPermissionService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMembersDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMembersDbWithBLOBs;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMembersDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsersConverter extends AbstractConverter<Map<Integer, UserDbo>> {

	private final SMFMembersDbMapper smfMembersMapper;

	private final UserDboMapper userDboMapper;

	private final MigratorIdMapService idMap;

	private final MigratorPermissionService permissions;

	@Override
	public JobType getType() {
		return JobType.USERS;
	}

	@Override
	@Transactional
	public Map<Integer, UserDbo> convertToZfgbb() {
		List<SMFMembersDbWithBLOBs> SMFMembers = smfMembersMapper.selectByExampleWithBLOBs(new SMFMembersDbExample());
		Map<Integer, UserDbo> result = new HashMap<>();

		SMFMembers.forEach((smfMember) -> {
			Cancellable.check();
			UserDbo user = new UserDbo();

			user.setDisplayName(smfMember.getRealName());
			user.setSsoKey(smfMember.getMemberName());
			user.setUserName(smfMember.getMemberName());
			user.setActiveFlag(smfMember.getIsActivated().intValue() > 0);
			user.setFailedLoginCount(0);

			user.setMigrationHash(MigrationHasher.hash(smfMember.getIdMember().toString()
					+ user.getSsoKey()
					+ user.getActiveFlag().toString()
					+ user.getDisplayName()
					+ user.getUserName()));

			Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.USER, smfMember.getIdMember());
			if (existingZfgbbId == null) {
				userDboMapper.insert(user);
				idMap.record(LegacyEntityType.USER, smfMember.getIdMember(), user.getUserId());
			} else {
				UserDbo existing = userDboMapper.selectByPrimaryKey(existingZfgbbId);
				if (existing == null) {
					user.setUserId(existingZfgbbId);
					userDboMapper.insert(user);
				} else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), user.getMigrationHash())) {
					user.setUserId(existingZfgbbId);
					userDboMapper.updateByPrimaryKey(user);
				} else {
					user.setUserId(existingZfgbbId);
				}
			}

			result.put(smfMember.getIdMember(), user);
		});

		SMFMembers.forEach(smfMember -> {
			UserDbo user = result.get(smfMember.getIdMember());
			if (user == null) {
				return;
			}
			Set<String> codes = new LinkedHashSet<>(
					permissions.mapSmfGroupToCodes(smfMember.getIdGroup()));
			codes.addAll(permissions.mapSmfGroupCsvToCodes(smfMember.getAdditionalGroups()));
			codes.add(MigratorPermissionService.CODE_USER);
			permissions.replaceUserPermissions(user.getUserId(), codes);
		});

		return result;
	}
}
