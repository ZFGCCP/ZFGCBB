package com.zfgc.zfgbb.migrator.converters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.mappers.MessageHistoryDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BbcodePostprocessConverter extends AbstractConverter<Void> {

	private static final Logger logger = LoggerFactory.getLogger(BbcodePostprocessConverter.class);

	private final MessageHistoryDboMapper messageHistoryMapper;

	private final MigratorIdMapService idMap;

	@Override
	public JobType getType() {
		return JobType.BBCODE_REWRITE;
	}

	@Override
	@Transactional
	public Void convertToZfgbb() {
		LegacyIdMaps maps = new LegacyIdMaps(
				idMap.getAllForType(LegacyEntityType.THREAD),
				idMap.getAllForType(LegacyEntityType.MESSAGE),
				idMap.getAllForType(LegacyEntityType.BOARD),
				idMap.getAllForType(LegacyEntityType.USER),
				idMap.getAllForType(LegacyEntityType.ATTACHMENT));

		LegacyUrlRewriter rewriter = LegacyUrlRewriter.forLegacyHost(
				JobContextHolder.getLegacyHost(),
				JobContextHolder.getAppBaseUrl());

		List<MessageHistoryDbo> histories = messageHistoryMapper.selectByExample(new MessageHistoryDboExample());
		int rewritten = 0;
		for (MessageHistoryDbo history : histories) {
			Cancellable.check();
			String body = history.getMessageText();
			if (body == null) {
				continue;
			}
			String updated = rewriter.rewriteBody(body, maps);
			if (!updated.equals(body)) {
				history.setMessageText(updated);
				messageHistoryMapper.updateByPrimaryKey(history);
				rewritten++;
			}
		}
		if (rewritten > 0) {
			logger.info("Rewrote BBCode references in {} message_history rows", rewritten);
		}
		return null;
	}
}
