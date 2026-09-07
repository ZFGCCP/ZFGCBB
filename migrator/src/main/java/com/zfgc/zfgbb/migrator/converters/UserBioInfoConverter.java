package com.zfgc.zfgbb.migrator.converters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import com.zfgc.zfgbb.dbo.AvatarDbo;
import com.zfgc.zfgbb.dbo.AvatarDboExample;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.dbo.GenderLkupDbo;
import com.zfgc.zfgbb.dbo.GenderLkupDboExample;
import com.zfgc.zfgbb.dbo.UserBioInfoDbo;
import com.zfgc.zfgbb.mappers.AvatarDboMapper;
import com.zfgc.zfgbb.mappers.ContentResourceDboMapper;
import com.zfgc.zfgbb.mappers.GenderLkupDboMapper;
import com.zfgc.zfgbb.mappers.UserBioInfoDboMapper;
import com.zfgc.zfgbb.migrator.SmfTimes;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.jobs.SmfSettingsService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFAttachmentsDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFAttachmentsDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMembersDbExample;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFMembersDbWithBLOBs;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFAttachmentsDbMapper;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFMembersDbMapper;

@Component
public class UserBioInfoConverter extends AbstractConverter<Map<Integer, UserBioInfoDbo>> {

	@Override
	public JobType getType() {
		return JobType.USER_BIO_INFO;
	}

	@Autowired
	public SMFMembersDbMapper smfMembersMapper;

	@Autowired
	public UserBioInfoDboMapper bioInfoMapper;

	@Autowired
	private SMFAttachmentsDbMapper smfAttachmentsDbMapper;

	@Autowired
	private AvatarDboMapper avatarMapper;

	@Autowired
	private ContentResourceDboMapper contentMapper;

	@Autowired
	private GenderLkupDboMapper genderLkupMapper;

	@Autowired
	private MigratorIdMapService idMap;

	@Autowired
	private SmfSettingsService smfSettings;

	@Override
	@Transactional
	public Map<Integer, UserBioInfoDbo> convertToZfgbb() {
		List<SMFMembersDbWithBLOBs> SMFMembers = smfMembersMapper.selectByExampleWithBLOBs(new SMFMembersDbExample());
		Map<Integer, UserBioInfoDbo> result = new HashMap<>();
		String defaultTimezone = smfSettings.getDefaultTimezone().orElse(null);

		SMFAttachmentsDbExample avatarEx = new SMFAttachmentsDbExample();
		avatarEx.createCriteria().andIdMemberIsNotNull()
								 .andIdMemberNotEqualTo(0);
		Map<Integer, SMFAttachmentsDb> SMFAvatarAttachments =
				smfAttachmentsDbMapper.selectByExample(avatarEx).stream()
									  .collect(Collectors.toMap(SMFAttachmentsDb::getIdMember, Function.identity()));

		List<GenderLkupDbo> genderLk = genderLkupMapper.selectByExample(new GenderLkupDboExample());

		SMFMembers.forEach((smfMember) -> {
			Cancellable.check();
			Integer zfgbbUserId = idMap.lookup(LegacyEntityType.USER, smfMember.getIdMember());

			AvatarDbo avatar = new AvatarDbo();
			SMFAttachmentsDb smfAvatar = SMFAvatarAttachments.get(smfMember.getIdMember());
			if (smfAvatar != null || !smfMember.getAvatar().equals("")) {
				avatar.setActiveFlag(true);

				if (smfAvatar != null) {
					avatar.setUrl("");
					ContentResourceDbo contentResource = new ContentResourceDbo();
					contentResource.setContentTypeId(1);
					contentResource.setFilename(smfAvatar.getFilename());
					contentResource.setFileExt(smfAvatar.getFileext());
					contentResource.setMimeType(smfAvatar.getMimeType());
					contentResource.setChecksum(smfAvatar.getFileHash());
					contentResource.setUploadedUserId(zfgbbUserId);
					contentResource.setFileSize(smfAvatar.getSize().longValue());
					contentResource.setMigrationHash(MigrationHasher.hash(contentResource.getContentTypeId().toString()
							+ contentResource.getUploadedUserId().toString()
							+ contentResource.getFilename()
							+ contentResource.getChecksum()
							+ contentResource.getFileExt()
							+ contentResource.getMimeType()
							+ contentResource.getFileSize().toString()));

					ContentResourceDboExample resourceEx = new ContentResourceDboExample();
					resourceEx.createCriteria().andMigrationHashEqualTo(contentResource.getMigrationHash());
					Optional<ContentResourceDbo> existingResource = contentMapper.selectByExample(resourceEx).stream().findFirst();

					existingResource.ifPresentOrElse(
							existing -> contentResource.setContentResourceId(existing.getContentResourceId()),
							() -> contentMapper.insert(contentResource));

					avatar.setContentResourceId(contentResource.getContentResourceId());
					avatar.setActiveFlag(smfAvatar.getApproved() == 1);
				} else if (!smfMember.getAvatar().isEmpty() && !smfMember.getAvatar().startsWith("http")) {
					avatar.setUrl("");
					createInternalAvatarResource(avatar, smfMember.getAvatar(), zfgbbUserId);
				} else {
					avatar.setUrl(smfMember.getAvatar());
				}

				avatar.setMigrationHash(MigrationHasher.hash((avatar.getUrl() != null ? avatar.getUrl() : "")
						+ avatar.getActiveFlag().toString()
						+ (avatar.getContentResourceId() != null ? avatar.getContentResourceId().toString() : "-1")));

				AvatarDboExample avEx = new AvatarDboExample();
				avEx.createCriteria().andMigrationHashEqualTo(avatar.getMigrationHash());
				Optional<AvatarDbo> existingAvatar = avatarMapper.selectByExample(avEx).stream().findFirst();

				existingAvatar.ifPresentOrElse((existing) -> {
					avatar.setAvatarId(existing.getAvatarId());
					avatarMapper.updateByPrimaryKey(avatar);
				},
				() -> {
					avatarMapper.insert(avatar);
				});
			}

			UserBioInfoDbo user = new UserBioInfoDbo();

			String genderCode = smfMember.getGender().intValue() == 1 ? "M" : (smfMember.getGender().intValue() == 2 ? "F" : null);
			Integer genderId = genderLk.stream().filter(lk -> lk.getCode().equals(genderCode)).findFirst().map(GenderLkupDbo::getGenderId).orElse(null);

			user.setUserId(zfgbbUserId);
			user.setCustomTitle(smfMember.getUsertitle() != null ? HtmlUtils.htmlUnescape(smfMember.getUsertitle()) : null);
			user.setPersonalText(smfMember.getPersonalText() != null ? HtmlUtils.htmlUnescape(smfMember.getPersonalText()) : null);
			user.setSignature(smfMember.getSignature() != null ? HtmlUtils.htmlUnescape(smfMember.getSignature()) : null);
			user.setAvatarId(avatar.getAvatarId());
			user.setBirthDate(smfMember.getBirthdate());
			user.setKarmaBad(smfMember.getKarmaBad());
			user.setKarmaGood(smfMember.getKarmaGood());
			user.setHideEmailFlag(Boolean.TRUE.equals(smfMember.getHideEmail()));
			user.setHideOnlineStatus(!Boolean.TRUE.equals(smfMember.getShowOnline()));
			user.setGenderId(genderId);
			user.setPreferredTimezone(defaultTimezone);

			user.setDateRegistered(SmfTimes.fromEpochSeconds(smfMember.getDateRegistered()));

			user.setMigrationHash(MigrationHasher.hash(smfMember.getIdMember().toString()
					+ (user.getSignature() != null ? user.getSignature() : "")
					+ (user.getCustomTitle() != null ? user.getCustomTitle() : "")
					+ (user.getAvatarId() != null ? user.getAvatarId() : "")
					+ (user.getPersonalText() != null ? user.getPersonalText() : "")
					+ (user.getKarmaGood() != null ? user.getKarmaGood() : "")
					+ (user.getKarmaBad() != null ? user.getKarmaBad() : "")
					+ (user.getHideOnlineStatus() != null ? user.getHideOnlineStatus().toString() : "")
					+ (user.getHideEmailFlag() != null ? user.getHideEmailFlag().toString() : "")
					+ (user.getBirthDate() != null ? user.getBirthDate().toString() : "")
					+ (user.getGenderId() != null ? user.getGenderId().toString() : "")
					+ (user.getDateRegistered() != null ? user.getDateRegistered().toString() : "")
					+ (user.getPreferredTimezone() != null ? user.getPreferredTimezone() : "")));

			UserBioInfoDbo existingUser = bioInfoMapper.selectByPrimaryKey(zfgbbUserId);
			if (existingUser == null) {
				bioInfoMapper.insert(user);
			} else if (JobContextHolder.isForce() || !Objects.equals(existingUser.getMigrationHash(), user.getMigrationHash())) {
				bioInfoMapper.updateByPrimaryKey(user);
			}

			result.put(smfMember.getIdMember(), user);
		});

		return result;
	}

	private void createInternalAvatarResource(AvatarDbo avatar, String smfAvatarPath, Integer zfgbbUserId) {
		String avatarsSourcePath = JobContextHolder.getAvatarsSourcePath();
		String targetPath = JobContextHolder.getAttachmentsTargetPath();
		if (avatarsSourcePath == null || avatarsSourcePath.isBlank() || targetPath == null) {
			avatar.setUrl(smfAvatarPath);
			return;
		}

		Path sourceFile = Paths.get(avatarsSourcePath, smfAvatarPath);
		if (!Files.exists(sourceFile)) {
			avatar.setUrl(smfAvatarPath);
			return;
		}

		String filename = sourceFile.getFileName().toString();
		String ext = filename.contains(".") ? filename.substring(filename.lastIndexOf('.') + 1) : "";
		long fileSize;
		try { fileSize = Files.size(sourceFile); } catch (IOException e) { fileSize = 0; }

		ContentResourceDbo cr = new ContentResourceDbo();
		cr.setContentTypeId(1);
		cr.setFilename(filename);
		cr.setFileExt(ext);
		cr.setMimeType("image/" + (ext.equalsIgnoreCase("jpg") ? "jpeg" : ext.toLowerCase()));
		cr.setChecksum("");
		cr.setUploadedUserId(zfgbbUserId);
		cr.setFileSize(fileSize);
		cr.setMigrationHash(MigrationHasher.hash("internal-avatar-" + smfAvatarPath));

		ContentResourceDboExample existingEx = new ContentResourceDboExample();
		existingEx.createCriteria().andMigrationHashEqualTo(cr.getMigrationHash());
		Optional<ContentResourceDbo> existing = contentMapper.selectByExample(existingEx).stream().findFirst();
		existing.ifPresentOrElse(
				e -> cr.setContentResourceId(e.getContentResourceId()),
				() -> contentMapper.insert(cr));

		try {
			Path dest = Paths.get(targetPath, String.valueOf(cr.getContentResourceId()));
			Files.copy(sourceFile, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("failed to copy internal avatar " + smfAvatarPath, e);
		}

		avatar.setContentResourceId(cr.getContentResourceId());
	}
}
