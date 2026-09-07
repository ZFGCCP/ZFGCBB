package com.zfgc.zfgbb.migrator.converters;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.zfgc.zfgbb.dbo.PollDbo;
import com.zfgc.zfgbb.mappers.PollDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFPollsDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFPollsDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFTopicDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFTopicDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFPollsDbMapper;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFTopicDbMapper;

@Component
public class PollConverter extends AbstractConverter<Map<Integer, PollDbo>> {

	@Override
	public JobType getType() {
		return JobType.POLLS;
	}

	@Autowired
	private SMFPollsDbMapper smfPollsMapper;

	@Autowired
	private PollDboMapper pollMapper;

	@Autowired
	private SMFTopicDbMapper threadMapper;

	@Autowired
	private MigratorIdMapService idMap;

	@Override
	@Transactional
	public Map<Integer, PollDbo> convertToZfgbb() {
		List<SMFPollsDb> smfPolls = smfPollsMapper.selectByExample(new SMFPollsDbExample());
		SMFTopicDbExample threadEx = new SMFTopicDbExample();
		threadEx.createCriteria().andIdPollIsNotNull().andIdPollNotEqualTo(0);
		Map<Integer, Integer> smfPollToTopicMap = threadMapper.selectByExample(threadEx).stream()
				.collect(Collectors.toMap(SMFTopicDb::getIdPoll, SMFTopicDb::getIdTopic));

		Map<Integer, PollDbo> result = new HashMap<>();

		smfPolls.forEach(smfPoll -> {
			Cancellable.check();

			Integer smfTopicId = smfPollToTopicMap.get(smfPoll.getIdPoll());
			Integer zfgbbThreadId = smfTopicId == null
					? null
					: idMap.lookupOrNull(LegacyEntityType.THREAD, smfTopicId);
			if (zfgbbThreadId == null) {
				return;
			}
			Integer smfPollMember = smfPoll.getIdMember();
			Integer zfgbbUserId = (smfPollMember == null || smfPollMember == 0)
					? null
					: idMap.lookupOrNull(LegacyEntityType.USER, smfPollMember);

			PollDbo poll = new PollDbo();

			Instant instant = Instant.ofEpochMilli(TimeUnit.SECONDS.toMillis(smfPoll.getExpireTime()));
			OffsetDateTime expireTime = OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));

			poll.setChangeVoteFlag(smfPoll.getChangeVote());
			poll.setCreatedTs(OffsetDateTime.now());
			poll.setCreatedUserId(zfgbbUserId);
			poll.setExpireTime(smfPoll.getExpireTime() == 0 ? null : expireTime);
			poll.setGuestVoteCount(smfPoll.getNumGuestVoters());
			poll.setGuestVoteFlag(smfPoll.getGuestVote());
			poll.setHideResultsFlag(smfPoll.getHideResults());
			poll.setMaxVotes(smfPoll.getMaxVotes());
			poll.setPollQuestion(HtmlUtils.htmlUnescape(smfPoll.getQuestion()));
			poll.setResetPoll(smfPoll.getResetPoll());
			poll.setThreadId(zfgbbThreadId);
			poll.setVotingLockedFlag(smfPoll.getVotingLocked());

			poll.setMigrationHash(MigrationHasher.hash(poll.getPollQuestion()
					+ smfPoll.getIdMember().toString()
					+ poll.getGuestVoteCount().toString()
					+ smfPoll.getIdPoll().toString()
					+ poll.getResetPoll().toString()
					+ smfPoll.getIdTopic().toString()
					+ poll.getChangeVoteFlag().toString()
					+ (poll.getExpireTime() == null ? "0" : poll.getExpireTime().toString())
					+ poll.getGuestVoteFlag().toString()
					+ poll.getHideResultsFlag().toString()
					+ poll.getMaxVotes().toString()
					+ poll.getVotingLockedFlag().toString()));

			Integer existingZfgbbId = idMap.lookupOrNull(LegacyEntityType.POLL, smfPoll.getIdPoll());
			if (existingZfgbbId == null) {
				pollMapper.insert(poll);
				idMap.record(LegacyEntityType.POLL, smfPoll.getIdPoll(), poll.getPollId());
			} else {
				PollDbo existing = pollMapper.selectByPrimaryKey(existingZfgbbId);
				if (existing == null) {
					poll.setPollId(existingZfgbbId);
					pollMapper.insert(poll);
				} else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), poll.getMigrationHash())) {
					poll.setPollId(existingZfgbbId);
					pollMapper.updateByPrimaryKey(poll);
				} else {
					poll.setPollId(existingZfgbbId);
				}
			}

			result.put(smfPoll.getIdPoll(), poll);
		});

		return result.values().stream().collect(Collectors.toMap(PollDbo::getPollId, Function.identity()));
	}
}
