package com.zfgc.zfgbb.migrator.converters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.mappers.ContentResourceDboMapper;
import com.zfgc.zfgbb.migrator.jobs.JobContextHolder;
import com.zfgc.zfgbb.migrator.jobs.JobType;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFAttachmentsDb;
import com.zfgc.zfgbb.migrator.smf.dbo.SMFAttachmentsDbExample;
import com.zfgc.zfgbb.migrator.smf.mappers.SMFAttachmentsDbMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttachmentFilesConverter extends AbstractConverter<Void> {

	@Override
	public JobType getType() {
		return JobType.ATTACHMENT_FILES;
	}

	private static final Logger logger = LoggerFactory.getLogger(AttachmentFilesConverter.class);

	private final SMFAttachmentsDbMapper smfAttachmentsMapper;

	private final ContentResourceDboMapper contentResourceMapper;

	@Override
	public Void convertToZfgbb() throws IOException {
		String sourcePath = JobContextHolder.getAttachmentsSourcePath();
		String targetPath = JobContextHolder.getAttachmentsTargetPath();
		if (sourcePath == null || sourcePath.isBlank() || targetPath == null || targetPath.isBlank()) {
			throw new IllegalStateException(
					"Attachment source and target paths must be provided with the job request");
		}

		Path source = Paths.get(sourcePath);
		Path target = Paths.get(targetPath);
		Files.createDirectories(target);

		Map<String, ContentResourceDbo> resourceByChecksum = contentResourceMapper
				.selectByExample(new ContentResourceDboExample()).stream()
				.filter(cr -> cr.getChecksum() != null && !cr.getChecksum().isEmpty())
				.collect(Collectors.toMap(ContentResourceDbo::getChecksum, Function.identity(), (a, b) -> a));

		Map<String, ContentResourceDbo> resourceByFilename = contentResourceMapper
				.selectByExample(new ContentResourceDboExample()).stream()
				.filter(cr -> cr.getChecksum() == null || cr.getChecksum().isEmpty())
				.collect(Collectors.toMap(ContentResourceDbo::getFilename, Function.identity(), (a, b) -> a));

		try (Stream<Path> files = Files.walk(source)) {
			files.filter(Files::isRegularFile)
					.filter(p -> {
						String name = p.getFileName().toString();
						return !name.equals("attachments") && !name.equals(".gitignore");
					})
					.forEach(filePath -> {
						Cancellable.check();
						String fileName = filePath.getFileName().toString();

						ContentResourceDbo resource = resolveResource(
								fileName, resourceByChecksum, resourceByFilename);
						if (resource == null) {
							return;
						}

						Path destination = target.resolve(String.valueOf(resource.getContentResourceId()));
						try {
							Files.copy(filePath, destination, StandardCopyOption.REPLACE_EXISTING);
							logger.info("wrote {} -> {}", fileName, destination);
						} catch (IOException e) {
							throw new RuntimeException("failed to write " + destination, e);
						}
					});
		}
		return null;
	}

	private ContentResourceDbo resolveResource(
			String fileName,
			Map<String, ContentResourceDbo> resourceByChecksum,
			Map<String, ContentResourceDbo> resourceByFilename) {

		// Avatar files: avatar_XXX.ext — look up content_resource by filename directly
		if (fileName.startsWith("avatar_")) {
			ContentResourceDbo resource = resourceByFilename.get(fileName);
			if (resource == null) {
				logger.warn("no content_resource for avatar file {}", fileName);
			}
			return resource;
		}

		int underscore = fileName.indexOf('_');
		if (underscore < 0) {
			logger.warn("skipping {} — no '_' in filename", fileName);
			return null;
		}

		// Primary path: look up SMF attachment by file_hash
		String fileHash = fileName.substring(underscore + 1);
		SMFAttachmentsDbExample hashEx = new SMFAttachmentsDbExample();
		hashEx.createCriteria().andFileHashEqualTo(fileHash);
		SMFAttachmentsDb attachment = smfAttachmentsMapper.selectByExample(hashEx)
				.stream().findFirst().orElse(null);

		if (attachment != null) {
			ContentResourceDbo resource = resourceByChecksum.get(attachment.getFileHash());
			if (resource != null) {
				return resource;
			}
		}

		// Fallback: extract id_attach from filename prefix, look up by primary key
		try {
			int idAttach = Integer.parseInt(fileName.substring(0, underscore));
			attachment = smfAttachmentsMapper.selectByPrimaryKey(idAttach);
		} catch (NumberFormatException ignored) {
		}

		if (attachment == null) {
			logger.warn("no SMF attachment for file {}", fileName);
			return null;
		}

		// For empty-hash attachments, match content_resource by filename
		ContentResourceDbo resource = resourceByFilename.get(attachment.getFilename());
		if (resource == null) {
			logger.warn("no content_resource for attachment {} (file {})", attachment.getFilename(), fileName);
		}
		return resource;
	}
}
