package com.zfgc.zfgbb.dao.forum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.AbstractDao;
import com.zfgc.zfgbb.dbo.FileAttachmentDbo;
import com.zfgc.zfgbb.dbo.FileAttachmentDboExample;
import com.zfgc.zfgbb.mappers.FileAttachmentDboMapper;

@Repository
public class FileAttachmentsDao extends AbstractDao<FileAttachmentDboExample, FileAttachmentDboMapper, FileAttachmentDbo>{

	@Autowired
	public FileAttachmentsDao(FileAttachmentDboMapper mapper) {
		super(mapper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public FileAttachmentDbo get(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<FileAttachmentDbo> get(FileAttachmentDboExample ex) {
		return mapper.selectByExample(ex);
	}

	@Override
	protected void update(FileAttachmentDbo toSave) {
		mapper.updateByPrimaryKey(toSave);
	}

	@Override
	protected void create(FileAttachmentDbo toCreate) {
		mapper.insert(toCreate);
	}
	
}