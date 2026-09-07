package com.zfgc.zfgbb.migrator.converters;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.PollChoiceDbo;
import com.zfgc.zfgbb.dbo.PollChoiceDboExample;
import com.zfgc.zfgbb.dbo.UserPollChoiceDbo;
import com.zfgc.zfgbb.dbo.UserPollChoiceDboExample;
import com.zfgc.zfgbb.mappers.PollChoiceDboMapper;
import com.zfgc.zfgbb.mappers.UserPollChoiceDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFLogPollsDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFLogPollsDbMapper;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserPollChoiceConverter extends AbstractConverter<Map<Integer, UserPollChoiceDbo>> {

	@Override
	public JobType getType() {
		return JobType.USER_POLL_CHOICES;
	}

	private final UserPollChoiceDboMapper userPollChoiceMapper;

	private final PollChoiceDboMapper pollQuestionMapper;

	private final SMFLogPollsDbMapper smfLogPollsMapper;

	private final MigratorIdMapService idMap;

	@Override
	@Transactional
	public Map<Integer, UserPollChoiceDbo> convertToZfgbb() {
		// keyed by (zfgbbPollId, seqno) → poll_choice_id
		Map<String, Integer> pollChoiceMap = pollQuestionMapper.selectByExample(new PollChoiceDboExample())
				.stream()
				.collect(Collectors.toMap(
						q -> q.getPollId() + "," + q.getSeqno(),
						PollChoiceDbo::getPollChoiceId));

		SMFLogPollsDbExample logEx = new SMFLogPollsDbExample();
		logEx.createCriteria().andIdMemberNotEqualTo(0);
		return smfLogPollsMapper.selectByExample(logEx).stream()
				.map(l -> {
					Cancellable.check();
					Integer zfgbbPollId = idMap.lookupOrNull(LegacyEntityType.POLL, l.getIdPoll());
					Integer zfgbbUserId = idMap.lookupOrNull(LegacyEntityType.USER, l.getIdMember());
					if (zfgbbPollId == null || zfgbbUserId == null) {
						return null;
					}
					Integer choiceId = pollChoiceMap.get(zfgbbPollId + "," + l.getIdChoice());
					if (choiceId == null) {
						return null;
					}

					UserPollChoiceDbo pollChoiceDbo = new UserPollChoiceDbo();
					pollChoiceDbo.setPollChoiceId(choiceId);
					pollChoiceDbo.setUserId(zfgbbUserId);

					pollChoiceDbo.setMigrationHash(MigrationHasher.hash(choiceId.toString()
							+ zfgbbUserId.toString()));
					UserPollChoiceDboExample ex = new UserPollChoiceDboExample();
					ex.createCriteria().andMigrationHashEqualTo(pollChoiceDbo.getMigrationHash())
							.andUserIdEqualTo(zfgbbUserId)
							.andPollChoiceIdEqualTo(choiceId);

					userPollChoiceMapper.selectByExample(ex).stream().findFirst()
							.ifPresentOrElse(
									upc -> {
										pollChoiceDbo.setUserPollChoiceId(upc.getUserPollChoiceId());
										userPollChoiceMapper.updateByPrimaryKey(pollChoiceDbo);
									},
									() -> userPollChoiceMapper.insert(pollChoiceDbo));

					return pollChoiceDbo;
				})
				.filter(d -> d != null)
				.collect(Collectors.toMap(UserPollChoiceDbo::getUserPollChoiceId, Function.identity()));
	}
}
