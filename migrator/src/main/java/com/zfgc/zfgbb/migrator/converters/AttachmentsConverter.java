package com.zfgc.zfgbb.migrator.converters;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.dbo.FileAttachmentDbo;
import com.zfgc.zfgbb.dbo.FileAttachmentDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.mappers.ContentResourceDboMapper;
import com.zfgc.zfgbb.mappers.FileAttachmentDboMapper;
import com.zfgc.zfgbb.mappers.MessageDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.jobs.LegacyEntityType;
import com.zfgc.zfgbb.migrator.jobs.MigratorIdMapService;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFAttachmentsDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFAttachmentsDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttachmentsConverter extends AbstractConverter<Map<Integer, ContentResourceDbo>> {

	@Override
	public JobType getType() {
		return JobType.ATTACHMENTS;
	}

	private final SMFAttachmentsDbMapper smfAttachmentsDbMapper;

	private final ContentResourceDboMapper contentMapper;

	private final MessageDboMapper messageMapper;

	private final FileAttachmentDboMapper attachmentMapper;

	private final MigratorIdMapService idMap;

	@Override
	@Transactional
	public Map<Integer, ContentResourceDbo> convertToZfgbb() {
		SMFAttachmentsDbExample attachEx = new SMFAttachmentsDbExample();
		attachEx.createCriteria().andIdMsgGreaterThan(0);

		return smfAttachmentsDbMapper.selectByExample(attachEx).stream()
				.map(attachment -> {
					Cancellable.check();
					Integer zfgbbMessageId = idMap.lookupOrNull(LegacyEntityType.MESSAGE, attachment.getIdMsg());
					if (zfgbbMessageId == null) {
						return null;
					}
					MessageDbo msg = messageMapper.selectByPrimaryKey(zfgbbMessageId);
					if (msg == null) {
						return null;
					}

					ContentResourceDbo resource = new ContentResourceDbo();
					resource.setContentTypeId(2);
					resource.setChecksum(attachment.getFileHash());
					resource.setFileExt(attachment.getFileext());
					resource.setFilename(attachment.getFilename());
					resource.setMimeType(attachment.getMimeType());
					Integer ownerId = msg.getOwnerId() != null ? msg.getOwnerId() : 1;
					resource.setUploadedUserId(ownerId);
					resource.setFileSize(attachment.getSize().longValue());
					resource.setMigrationHash(MigrationHasher.hash(resource.getContentTypeId().toString()
							+ ownerId.toString()
							+ resource.getFilename()
							+ resource.getChecksum()
							+ resource.getFileExt()
							+ resource.getMimeType()
							+ resource.getFileSize().toString()));

					ContentResourceDboExample existingResourceEx = new ContentResourceDboExample();
					existingResourceEx.createCriteria().andMigrationHashEqualTo(resource.getMigrationHash());
					contentMapper.selectByExample(existingResourceEx).stream().findFirst()
							.ifPresentOrElse(
									existing -> resource.setContentResourceId(existing.getContentResourceId()),
									() -> contentMapper.insert(resource));

					FileAttachmentDbo fileAttachment = new FileAttachmentDbo();
					fileAttachment.setActiveFlag(attachment.getApproved().intValue() == 1);
					fileAttachment.setContentResourceId(resource.getContentResourceId());
					fileAttachment.setMessageId(msg.getMessageId());
					fileAttachment.setDownloads(attachment.getDownloads());
					fileAttachment.setMigrationHash(MigrationHasher.hash(attachment.getIdAttach().toString()
							+ fileAttachment.getMessageId().toString()
							+ fileAttachment.getActiveFlag().toString()
							+ fileAttachment.getContentResourceId().toString()
							+ fileAttachment.getDownloads().toString()));

					FileAttachmentDboExample existingAttachmentEx = new FileAttachmentDboExample();
					existingAttachmentEx.createCriteria().andMigrationHashEqualTo(fileAttachment.getMigrationHash());
					attachmentMapper.selectByExample(existingAttachmentEx).stream().findFirst()
							.ifPresentOrElse(
									existing -> fileAttachment.setFileAttachmentId(existing.getFileAttachmentId()),
									() -> attachmentMapper.insert(fileAttachment));

					idMap.record(LegacyEntityType.ATTACHMENT, attachment.getIdAttach(),
							fileAttachment.getFileAttachmentId());

					return resource;
				})
				.filter(r -> r != null)
				.collect(Collectors.toMap(ContentResourceDbo::getContentResourceId, Function.identity(),
						(a, b) -> a));
	}
}
