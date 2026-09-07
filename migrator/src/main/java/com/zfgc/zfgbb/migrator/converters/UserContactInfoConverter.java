package com.zfgc.zfgbb.migrator.converters;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.EmailAddressDbo;
import com.zfgc.zfgbb.dbo.EmailAddressDboExample;
import com.zfgc.zfgbb.dbo.UserContactInfoDbo;
import com.zfgc.zfgbb.mappers.EmailAddressDboMapper;
import com.zfgc.zfgbb.mappers.UserContactInfoDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMembersDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMembersDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserContactInfoConverter extends AbstractConverter<Map<Integer, UserContactInfoDbo>> {

	@Override
	public JobType getType() {
		return JobType.USER_CONTACT_INFO;
	}

	Logger logger = LoggerFactory.getLogger(UserContactInfoConverter.class);

	private final SMFMembersDbMapper membersMapper;

	private final UserContactInfoDboMapper contactInfoMapper;

	private final EmailAddressDboMapper emailMapper;

	private final MigratorIdMapService idMap;

	@Override
	@Transactional
	public Map<Integer, UserContactInfoDbo> convertToZfgbb() {
		return membersMapper.selectByExample(new SMFMembersDbExample())
					 .stream()
					 .map(member -> {
						 Cancellable.check();
						 Integer zfgbbUserId = idMap.lookup(LegacyEntityType.USER, member.getIdMember());

						 EmailAddressDbo email = new EmailAddressDbo();
						 email.setEmailAddress(member.getEmailAddress());
						 email.setSpammerFlag(member.getIsSpammer() == 1);
						 email.setMigrationHash(MigrationHasher.hash(email.getEmailAddress()
								+ email.getSpammerFlag().toString()));

						 EmailAddressDboExample emailEx = new EmailAddressDboExample();
						 emailEx.createCriteria().andMigrationHashEqualTo(email.getMigrationHash());
						 Optional<EmailAddressDbo> existingEmail = emailMapper.selectByExample(emailEx).stream().findFirst();
						 existingEmail.ifPresentOrElse(
								 existing -> email.setEmailAddressId(existing.getEmailAddressId()),
								 () -> emailMapper.insert(email));

						 UserContactInfoDbo dbo = new UserContactInfoDbo();
						 dbo.setAllowEmailFlag(Boolean.FALSE.equals(member.getHideEmail()));
						 dbo.setAllowPmFlag(true);
						 dbo.setEmailAddressId(email.getEmailAddressId());
						 dbo.setUserId(zfgbbUserId);
						 dbo.setMigrationHash(MigrationHasher.hash(member.getIdMember().toString()
								+ dbo.getEmailAddressId().toString()
								+ dbo.getAllowEmailFlag().toString()
								+ dbo.getAllowPmFlag().toString()));

						 UserContactInfoDbo existing = contactInfoMapper.selectByPrimaryKey(zfgbbUserId);
						 if (existing == null) {
							 contactInfoMapper.insert(dbo);
						 } else if (JobContextHolder.isForce() || !Objects.equals(existing.getMigrationHash(), dbo.getMigrationHash())) {
							 contactInfoMapper.updateByPrimaryKey(dbo);
						 }

						 return dbo;
					 })
					 .collect(Collectors.toMap(UserContactInfoDbo::getUserId, Function.identity()));
	}
}
