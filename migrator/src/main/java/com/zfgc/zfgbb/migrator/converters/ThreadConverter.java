package com.zfgc.zfgbb.migrator.converters;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.zfgc.zfgbb.dbo.ThreadDbo;
import com.zfgc.zfgbb.mappers.ThreadDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFTopicDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFTopicDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMessageDbMapper;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFTopicDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThreadConverter extends AbstractConverter<Map<Integer, ThreadDbo>> {

	@Override
	public JobType getType() {
		return JobType.THREADS;
	}

	private final SMFTopicDbMapper smfTopicMapper;

	private final ThreadDboMapper threadDboMapper;

	private final SMFMessageDbMapper smfMessageMapper;

	private final MigratorIdMapService idMap;

	Logger logger = LoggerFactory.getLogger(ThreadConverter.class);

	@Override
	@Transactional
	public Map<Integer, ThreadDbo> convertToZfgbb() {
		List<SMFTopicDb> SMFTopics = smfTopicMapper.selectByExample(new SMFTopicDbExample());
		Map<Integer, ThreadDbo> result = new HashMap<>();

		logger.info("Beginning conversion of SMF Topic to ZFGBB Thread");
		logger.info(SMFTopics.size() + " records found");
		SMFTopics.forEach((smfTopic) -> {
			Cancellable.check();

			SMFMessageDbExample ex = new SMFMessageDbExample();
			ex.createCriteria().andIdTopicEqualTo(smfTopic.getIdTopic());
			SMFMessageDb msg = smfMessageMapper.selectByExample(ex)
											   .stream()
											   .sorted(Comparator.comparingInt(SMFMessageDb::getPosterTime))
											   .findFirst().orElse(null);

			if (msg == null) {
				return;
			}

			ThreadDbo thread = new ThreadDbo();
			thread.setBoardId(idMap.lookup(LegacyEntityType.BOARD, smfTopic.getIdBoard().intValue()));
			Integer smfMemberStarted = smfTopic.getIdMemberStarted();
			thread.setCreatedUserId(smfMemberStarted == null || smfMemberStarted == 0
					? null
					: idMap.lookup(LegacyEntityType.USER, smfMemberStarted));
			thread.setLockedFlag(smfTopic.getLocked().intValue() > 0);
			thread.setPinnedFlag(smfTopic.getIsSticky().intValue() > 0);
			thread.setThreadName(HtmlUtils.htmlUnescape(msg.getSubject()));
			thread.setViewCount(smfTopic.getNumViews());

			thread.setMigrationHash(MigrationHasher.hash(smfTopic.getIdTopic().toString()
					+ thread.getThreadName()
					+ thread.getLockedFlag().toString()
					+ thread.getPinnedFlag().toString()
					+ smfTopic.getIdBoard()
					+ smfTopic.getIdMemberStarted()
					+ thread.getViewCount()));

			Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.THREAD, smfTopic.getIdTopic());
			if (existingZfgbbId == null) {
				threadDboMapper.insert(thread);
				idMap.record(LegacyEntityType.THREAD, smfTopic.getIdTopic(), thread.getThreadId());
			} else {
				ThreadDbo existing = threadDboMapper.selectByPrimaryKey(existingZfgbbId);
				if (existing == null) {
					thread.setThreadId(existingZfgbbId);
					threadDboMapper.insert(thread);
				} else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), thread.getMigrationHash())) {
					thread.setThreadId(existingZfgbbId);
					threadDboMapper.updateByPrimaryKey(thread);
				} else {
					thread.setThreadId(existingZfgbbId);
				}
			}

			result.put(smfTopic.getIdTopic(), thread);
		});

		logger.info("Finished conversion of ZFGBB Thread");

		return result;
	}
}
