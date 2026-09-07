package com.zfgc.zfgbb.migrator.converters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import com.zfgc.zfgbb.dbo.IpAddressDbo;
import com.zfgc.zfgbb.dbo.IpAddressDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.mappers.IpAddressDboMapper;
import com.zfgc.zfgbb.mappers.MessageHistoryDboMapper;
import com.zfgc.zfgbb.migrator.SmfTimes;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageDbWithBLOBs;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageHistoryDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMessageHistoryDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMessageDbMapper;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMessageHistoryDbMapper;
import com.zfgc.zfgbb.migrator.smf.queries.SmfMessageStreamMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageHistoryConverter extends AbstractConverter<Void> {

	private final SMFMessageHistoryDbMapper smfMsgHistoryMapper;

	private final SMFMessageDbMapper smfMsgMapper;

	private final SmfMessageStreamMapper smfMessageStreamMapper;

	private final MessageHistoryDboMapper msgHistoryMapper;

	private final IpAddressDboMapper ipMapper;

	private final MigratorIdMapService idMap;

	private final SqlSessionFactory sqlSessionFactory;

	@Value("${zfgbb.migrator.batch-size:5000}")
	private final int batchSize;

	private static final Logger logger = LoggerFactory.getLogger(MessageHistoryConverter.class);

	private boolean freshRun;

	@Override
	public JobType getType() {
		return JobType.MESSAGE_HISTORY;
	}

	@Override
	public Void convertToZfgbb() {
		long total = smfMsgMapper.countByExample(new SMFMessageDbExample());
		boolean force = JobContextHolder.isForce();
		long existingHistory = msgHistoryMapper.countByExample(new MessageHistoryDboExample());
		freshRun = !force && existingHistory == 0;
		logger.info("Beginning conversion of {} SMF messages -> message history (batch size {}, freshRun={})",
				total, batchSize, freshRun);

		Map<Integer, List<SMFMessageHistoryDb>> historyByMsgId = smfMsgHistoryMapper
				.selectByExampleWithBLOBs(new SMFMessageHistoryDbExample()).stream()
				.collect(Collectors.groupingBy(SMFMessageHistoryDb::getIdMsg));
		Map<String, IpAddressDbo> ipByIp = ipMapper.selectByExample(new IpAddressDboExample()).stream()
				.collect(Collectors.toMap(IpAddressDbo::getIp, Function.identity(), (a, b) -> a));

		Integer lastId = 0;
		long processed = 0;

		while (true) {
			List<SMFMessageDbWithBLOBs> batch =
					smfMessageStreamMapper.selectAfterIdLimit(lastId, batchSize);
			if (batch.isEmpty()) {
				break;
			}

			processBatch(batch, historyByMsgId, ipByIp);

			processed += batch.size();
			lastId = batch.get(batch.size() - 1).getIdMsg();
			logger.info("Processed {}/{} message-history records", processed, total);
		}

		logger.info("Finished converting message history");
		return null;
	}

	private void processBatch(List<SMFMessageDbWithBLOBs> batch,
			Map<Integer, List<SMFMessageHistoryDb>> historyByMsgId,
			Map<String, IpAddressDbo> ipByIp) {
		try (SqlSession bs = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
			MessageHistoryDboMapper bsHistory = bs.getMapper(MessageHistoryDboMapper.class);
			for (SMFMessageDbWithBLOBs msg : batch) {
				Cancellable.check();
				convertOne(msg, historyByMsgId, ipByIp, bsHistory);
			}
			bs.flushStatements();
			bs.commit();
		}
	}

	private void convertOne(SMFMessageDbWithBLOBs msg,
			Map<Integer, List<SMFMessageHistoryDb>> historyByMsgId,
			Map<String, IpAddressDbo> ipByIp,
			MessageHistoryDboMapper bsHistory) {
		Integer zfgbbMessageId = idMap.lookupOrNull(LegacyEntityType.MESSAGE, msg.getIdMsg());
		if (zfgbbMessageId == null) {
			return;
		}
		String posterIp = msg.getPosterIp();
		if (posterIp == null || posterIp.isBlank()) {
			posterIp = "127.0.0.1";
		}
		Integer ipAddressId = ipByIp.get(posterIp).getIpAddressId();

		List<SMFMessageHistoryDb> historyRows = historyByMsgId.get(msg.getIdMsg());
		if (historyRows != null) {
			for (SMFMessageHistoryDb smfHist : historyRows) {
				MessageHistoryDbo histRow = new MessageHistoryDbo();
				histRow.setCreatedTs(SmfTimes.fromEpochSeconds(smfHist.getModifiedTime()));
				histRow.setCurrentFlag(false);
				histRow.setIpAddressId(ipAddressId);
				histRow.setMessageId(zfgbbMessageId);
				histRow.setMessageText(HtmlUtils.htmlUnescape(smfHist.getBody()));
				histRow.setUpdatedTs(histRow.getCreatedTs());

				histRow.setMigrationHash(MigrationHasher.hash(msg.getIdMsg().toString()
						+ "history-" + SmfTimes.fromEpochSeconds(smfHist.getModifiedTime()).toString()
						+ histRow.getMessageText()
						+ histRow.getCurrentFlag().toString()
						+ ipAddressId));

				upsertHistory(histRow, bsHistory);
			}
		}

		MessageHistoryDbo currentRow = new MessageHistoryDbo();
		currentRow.setCreatedTs(SmfTimes.fromEpochSeconds(msg.getPosterTime()));
		currentRow.setCurrentFlag(true);
		currentRow.setIpAddressId(ipAddressId);
		currentRow.setMessageId(zfgbbMessageId);
		currentRow.setMessageText(HtmlUtils.htmlUnescape(msg.getBody()));
		currentRow.setUpdatedTs(currentRow.getCreatedTs());

		currentRow.setMigrationHash(MigrationHasher.hash(msg.getIdMsg().toString()
				+ "current"
				+ currentRow.getMessageText()
				+ currentRow.getCurrentFlag().toString()
				+ currentRow.getCreatedTs().toString()
				+ ipAddressId));

		upsertHistory(currentRow, bsHistory);
	}

	private void upsertHistory(MessageHistoryDbo row, MessageHistoryDboMapper bsHistory) {
		if (freshRun) {
			bsHistory.insert(row);
			return;
		}

		MessageHistoryDboExample ex = new MessageHistoryDboExample();
		ex.createCriteria().andMigrationHashEqualTo(row.getMigrationHash());
		MessageHistoryDbo existing = msgHistoryMapper.selectByExample(ex).stream().findFirst().orElse(null);
		if (existing == null) {
			bsHistory.insert(row);
		} else if (JobContextHolder.isForce()
				|| !Objects.equals(existing.getMigrationHash(), row.getMigrationHash())) {
			row.setMessageHistoryId(existing.getMessageHistoryId());
			bsHistory.updateByPrimaryKey(row);
		} else {
			row.setMessageHistoryId(existing.getMessageHistoryId());
		}
	}
}
