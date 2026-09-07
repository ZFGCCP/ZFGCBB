package com.zfgc.zfgbb.migrator.converters;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.KarmaDbo;
import com.zfgc.zfgbb.dbo.KarmaDboExample;
import com.zfgc.zfgbb.mappers.KarmaDboMapper;
import com.zfgc.zfgbb.migrator.SmfTimes;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.mappers.MigratorTimestampMapper;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFLogKarmaDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFLogKarmaDbWithBLOBs;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFLogKarmaDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KarmaConverter extends AbstractConverter<Map<Integer, KarmaDbo>> {

	@Override
	public JobType getType() {
		return JobType.KARMA;
	}

	private final KarmaDboMapper karmaMapper;

	private final SMFLogKarmaDbMapper SMFKarmaMapper;

	private final MigratorIdMapService idMap;

	private final MigratorTimestampMapper migratorTimestampMapper;

	private final String MSG_REGEX = "[0-9]+$";

	@Override
	@Transactional
	public Map<Integer, KarmaDbo> convertToZfgbb() {
		List<SMFLogKarmaDbWithBLOBs> karmaSMF = SMFKarmaMapper.selectByExampleWithBLOBs(new SMFLogKarmaDbExample());
		Pattern pattern = Pattern.compile(MSG_REGEX);

		return karmaSMF.stream()
				.map(karma -> {
					Cancellable.check();
					Matcher matcher = pattern.matcher(karma.getLink());
					if (!matcher.find()) {
						return null;
					}
					Integer smfMsgId = Integer.parseInt(matcher.group());
					Integer zfgbbMsgId = idMap.lookupOrNull(LegacyEntityType.MESSAGE, smfMsgId);
					if (zfgbbMsgId == null) {
						return null;
					}
					Integer smfExecutor = karma.getIdExecutor();
					Integer zfgbbCommentingUserId = (smfExecutor == null || smfExecutor == 0)
							? null
							: idMap.lookupOrNull(LegacyEntityType.USER, smfExecutor);

					KarmaDbo karmaPg = new KarmaDbo();
					karmaPg.setCommentingUserId(zfgbbCommentingUserId);
					karmaPg.setCreatedTs(SmfTimes.fromEpochSeconds(karma.getLogTime()));
					karmaPg.setUpdatedTs(SmfTimes.fromEpochSeconds(karma.getLogTime()));
					karmaPg.setIsPositive(karma.getAction().equals(1));
					karmaPg.setMessageId(zfgbbMsgId);
					karmaPg.setDescription(karma.getDescription());

					karmaPg.setMigrationId(MigrationHasher.hash(karma.getIdExecutor().toString()
							+ smfMsgId.toString()
							+ karmaPg.getIsPositive().toString()
							+ (karmaPg.getDescription() == null ? "" : karmaPg.getDescription().toString())
							+ karmaPg.getCreatedTs().toString()
							+ (karmaPg.getUpdatedTs() == null ? "" : karmaPg.getUpdatedTs().toString())));

					KarmaDboExample ex = new KarmaDboExample();
					ex.createCriteria().andMigrationIdEqualTo(karmaPg.getMigrationId());

					Optional<KarmaDbo> existing = karmaMapper.selectByExample(ex).stream().findFirst();
					existing.ifPresentOrElse(ext -> {
						karmaPg.setKarmaId(ext.getKarmaId());
						karmaMapper.updateByPrimaryKey(karmaPg);
					}, () -> {
						karmaMapper.insert(karmaPg);
					});

					if (karmaPg.getCreatedTs() != null) {
						migratorTimestampMapper.setKarmaTimestamps(
								karmaPg.getKarmaId(), karmaPg.getCreatedTs(), karmaPg.getUpdatedTs());
					}

					return karmaPg;
				})
				.filter(km -> km != null)
				.collect(Collectors.toMap(KarmaDbo::getKarmaId, Function.identity()));
	}
}
