package com.zfgc.zfgbb.services.core;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.zfgc.zfgbb.dao.core.ContentResourceDao;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.services.AbstractService;

@Service
public class ContentService extends AbstractService {
	
	@Value("${zfgbb.content.path}")
	private String contentPath;
	
	@Value("${zfgbb.content.images}")
	private String imagesPath;
	
	@Autowired
	private ContentResourceDao contentResourceDao;
	
	public Resource getImageResource(Integer resourceId) throws MalformedURLException {
		ContentResourceDboExample ex = new ContentResourceDboExample();
		ex.createCriteria().andContentResourceIdEqualTo(resourceId);
		
		ContentResourceDbo dbo = contentResourceDao.get(ex).stream().findFirst().orElse(null);
		if(dbo == null) {
			throw new ZfgcNotFoundException();
		}
		else {
			return createContentResource(contentPath + imagesPath, dbo.getFilename());
		}
	}
	
	private Resource createContentResource(String fullPath, String filename) throws MalformedURLException {
		Path path = Paths.get(fullPath + "/" + filename);
		Resource resource = new UrlResource(path.toUri());
		
		return resource;
	}
}