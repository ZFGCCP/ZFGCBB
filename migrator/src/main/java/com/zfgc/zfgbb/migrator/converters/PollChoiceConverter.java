package com.zfgc.zfgbb.migrator.converters;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.zfgc.zfgbb.dbo.PollChoiceDbo;
import com.zfgc.zfgbb.dbo.PollChoiceDboExample;
import com.zfgc.zfgbb.mappers.PollChoiceDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFPollChoicesDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFPollChoicesDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PollChoiceConverter extends AbstractConverter<Map<Integer, PollChoiceDbo>> {

	@Override
	public JobType getType() {
		return JobType.POLL_CHOICES;
	}

	private final PollChoiceDboMapper pollChoiceMapper;

	private final SMFPollChoicesDbMapper smfPollChoiceMapper;

	private final MigratorIdMapService idMap;

	@Override
	@Transactional
	public Map<Integer, PollChoiceDbo> convertToZfgbb() {
		return smfPollChoiceMapper.selectByExample(new SMFPollChoicesDbExample()).stream()
				.map(smfChoice -> {
					Cancellable.check();
					Integer zfgbbPollId = idMap.lookupOrNull(LegacyEntityType.POLL, smfChoice.getIdPoll());
					if (zfgbbPollId == null) {
						return null;
					}

					PollChoiceDbo pollChoice = new PollChoiceDbo();
					pollChoice.setActiveFlag(true);
					pollChoice.setChoiceText(HtmlUtils.htmlUnescape(smfChoice.getLabel()));
					pollChoice.setSeqno(smfChoice.getIdChoice());
					pollChoice.setPollId(zfgbbPollId);
					pollChoice.setVotes(smfChoice.getVotes().intValue());

					pollChoice.setMigrationHash(MigrationHasher.hash(pollChoice.getChoiceText()
							+ smfChoice.getIdChoice().toString()
							+ smfChoice.getIdPoll().toString()
							+ pollChoice.getVotes().toString()
							+ pollChoice.getActiveFlag().toString()));

					PollChoiceDboExample pollEx = new PollChoiceDboExample();
					pollEx.createCriteria().andMigrationHashEqualTo(pollChoice.getMigrationHash());

					pollChoiceMapper.selectByExample(pollEx).stream().findFirst().ifPresentOrElse(
							poll -> {
								pollChoice.setPollChoiceId(poll.getPollChoiceId());
								pollChoiceMapper.updateByPrimaryKey(pollChoice);
							},
							() -> pollChoiceMapper.insert(pollChoice));

					return pollChoice;
				})
				.filter(p -> p != null)
				.collect(Collectors.toMap(PollChoiceDbo::getPollChoiceId, Function.identity()));
	}
}
