package com.zfgc.zfgbb.services.core;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dao.cms.ContentResourceDao;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.services.AbstractService;
import lombok.RequiredArgsConstructor;

@Service
@ConfigurationProperties(prefix = "zfgbb.content")
@RequiredArgsConstructor
public class ContentService extends AbstractService {
	private String path;
	private String images;

	public void setPath(String path) {
		this.path = path;
	}

	public void setImages(String images) {
		this.images = images;
	}

	private final ContentResourceDao contentResourceDao;

	public ContentResourceDbo getContentResourceDbo(Integer resourceId) {
		ContentResourceDboExample ex = new ContentResourceDboExample();
		ex.createCriteria().andContentResourceIdEqualTo(resourceId);
		return contentResourceDao.get(ex).stream().findFirst().orElse(null);
	}

	public Resource getImageResource(Integer resourceId) throws MalformedURLException {
		ContentResourceDbo dbo = getContentResourceDbo(resourceId);
		if (dbo == null) {
			throw new ZfgcNotFoundException();
		}
		Path filePath = Paths.get(path, images, String.valueOf(dbo.getContentResourceId()));
		return new UrlResource(filePath.toUri());
	}

	public Optional<MediaType> getMimeType(String filename) {
		return MediaTypeFactory.getMediaType(filename);
	}
}