package com.zfgc.zfgbb.migrator.converters;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.mappers.MessageDboMapper;
import com.zfgc.zfgbb.migrator.SmfTimes;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.mappers.MigratorTimestampMapper;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDbWithBLOBs;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMessageDbMapper;
import com.zfgc.zfgbb.migrator.smf.queries.SmfMessageStreamMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageConverter extends AbstractConverter<Void> {

	private final MessageDboMapper messageMapper;

	private final SMFMessageDbMapper smfMessageMapper;

	private final SmfMessageStreamMapper smfMessageStreamMapper;

	private final MigratorIdMapService idMap;

	private final MigratorTimestampMapper migratorTimestampMapper;

	private final TransactionTemplate transactionTemplate;

	@Value("${zfgbb.migrator.batch-size:5000}")
	private final int batchSize;

	private static final Logger logger = LoggerFactory.getLogger(MessageConverter.class);

	@Override
	public JobType getType() {
		return JobType.MESSAGES;
	}

	@Override
	public Void convertToZfgbb() {
		long total = smfMessageMapper.countByExample(new SMFMessageDbExample());
		logger.info("Beginning conversion of {} SMF messages (batch size {})", total, batchSize);

		Map<Integer, AtomicInteger> postInThreadCounters = new HashMap<>();
		Integer lastId = 0;
		long processed = 0;

		while (true) {
			final Integer cursor = lastId;
			List<SMFMessageDbWithBLOBs> batch =
					smfMessageStreamMapper.selectAfterIdLimit(cursor, batchSize);
			if (batch.isEmpty()) {
				break;
			}

			transactionTemplate.executeWithoutResult(status -> {
				for (SMFMessageDbWithBLOBs smfMsg : batch) {
					Cancellable.check();
					convertOne(smfMsg, postInThreadCounters);
				}
			});

			processed += batch.size();
			lastId = batch.get(batch.size() - 1).getIdMsg();
			logger.info("Processed {}/{} messages", processed, total);
		}

		logger.info("Finished converting messages");
		return null;
	}

	private void convertOne(SMFMessageDbWithBLOBs smfMsg, Map<Integer, AtomicInteger> postInThreadCounters) {
		MessageDbo msg = new MessageDbo();

		postInThreadCounters.putIfAbsent(smfMsg.getIdTopic(), new AtomicInteger(1));

		Integer smfMember = smfMsg.getIdMember();
		msg.setOwnerId(smfMember == null || smfMember == 0
				? null
				: idMap.lookup(LegacyEntityType.USER, smfMember));
		msg.setThreadId(idMap.lookup(LegacyEntityType.THREAD, smfMsg.getIdTopic()));
		msg.setPostInThread(postInThreadCounters.get(smfMsg.getIdTopic()).getAndIncrement());
		msg.setCreatedTs(SmfTimes.fromEpochSeconds(smfMsg.getPosterTime()));

		OffsetDateTime updatedTime = SmfTimes.fromEpochSeconds(smfMsg.getModifiedTime());
		msg.setUpdatedTs(updatedTime != null ? updatedTime : msg.getCreatedTs());

		msg.setMigrationHash(MigrationHasher.hash(smfMsg.getIdMsg().toString()
				+ "" + smfMsg.getIdMember()
				+ smfMsg.getIdTopic()
				+ (msg.getPostInThread() == null ? -1 : msg.getPostInThread())
				+ msg.getCreatedTs().toString()
				+ (msg.getUpdatedTs() == null ? 0 : msg.getUpdatedTs().toString())));

		Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.MESSAGE, smfMsg.getIdMsg());
		if (existingZfgbbId == null) {
			messageMapper.insert(msg);
			idMap.record(LegacyEntityType.MESSAGE, smfMsg.getIdMsg(), msg.getMessageId());
		} else {
			MessageDbo existing = messageMapper.selectByPrimaryKey(existingZfgbbId);
			if (existing == null) {
				msg.setMessageId(existingZfgbbId);
				messageMapper.insert(msg);
			} else if (JobContextHolder.isForce()
					|| !Objects.equals(existing.getMigrationHash(), msg.getMigrationHash())) {
				msg.setMessageId(existingZfgbbId);
				messageMapper.updateByPrimaryKey(msg);
			} else {
				msg.setMessageId(existingZfgbbId);
			}
		}

		if (msg.getCreatedTs() != null) {
			migratorTimestampMapper.setMessageTimestamps(
					msg.getMessageId(), msg.getCreatedTs(), msg.getUpdatedTs());
		}
	}
}
