package com.zfgc.zfgbb.dataprovider.forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.dao.bbcode.BBCodeAttributeDao;
import com.zfgc.zfgbb.dao.bbcode.BBCodeAttributeModeDao;
import com.zfgc.zfgbb.dao.bbcode.BBCodeConfigDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dbo.BBCodeAttributeDbo;
import com.zfgc.zfgbb.dbo.BBCodeAttributeDboExample;
import com.zfgc.zfgbb.dbo.BBCodeAttributeModeDbo;
import com.zfgc.zfgbb.dbo.BBCodeAttributeModeDboExample;
import com.zfgc.zfgbb.dbo.BBCodeConfigDbo;
import com.zfgc.zfgbb.dbo.BBCodeConfigDboExample;
import com.zfgc.zfgbb.model.forum.AttributeDataType;
import com.zfgc.zfgbb.model.forum.BBCodeAttribute;
import com.zfgc.zfgbb.model.forum.BBCodeAttributeMode;
import com.zfgc.zfgbb.model.forum.BBCodeConfig;

@Repository
public class BBCodeDataProvider extends AbstractDataProvider {
	
	@Autowired
	private BBCodeConfigDao bbCodeConfigDao;
	
	@Autowired
	private BBCodeAttributeModeDao bbCodeAttributeModeDao;
	
	@Autowired
	private BBCodeAttributeDao bbCodeAttributeDao;
	
	public List<BBCodeConfig> getValidBbCodes() {
		BBCodeConfigDboExample ex = new BBCodeConfigDboExample();
		List<BBCodeConfigDbo> results = bbCodeConfigDao.get(ex);
		
		return super.convertDboListToModel(results, BBCodeConfig.class);
	}
	
	public List<BBCodeAttributeMode> getAttributeModesByBbCode(Integer bbCodeId) {
		BBCodeAttributeModeDboExample ex = new BBCodeAttributeModeDboExample();
		ex.createCriteria().andBbCodeConfigIdEqualTo(bbCodeId);
		List<BBCodeAttributeModeDbo> results = bbCodeAttributeModeDao.get(ex);
		
		return super.convertDboListToModel(results, BBCodeAttributeMode.class);
	}
	
	public List<BBCodeAttribute> getAttributesByMode(Integer modeId){
		BBCodeAttributeDboExample ex = new BBCodeAttributeDboExample();
		ex.createCriteria().andBbCodeAttributeModeIdEqualTo(modeId);
		List<BBCodeAttributeDbo> results = bbCodeAttributeDao.get(ex);

		return super.convertDboListToModel(results, BBCodeAttribute.class);
	}
	
	public Map<String,BBCodeConfig> getBbCodeConfig(){
		Map<String,BBCodeConfig> result = new HashMap<>();
		
		List<BBCodeConfig> bbCodes = getValidBbCodes();
		StringBuilder attString = null;
		for(BBCodeConfig bbCode : bbCodes){
			attString = new StringBuilder();
			//LOGGER.info("Loading Config for " + config.getCode() + "...");
			List<BBCodeAttributeMode> modesDb = getAttributeModesByBbCode(bbCode.getBbCodeConfigId());
			List<BBCodeAttributeMode> modes = new ArrayList<>();
			for(BBCodeAttributeMode mode : modesDb){
				modes.add(mode);
				StringBuilder modeString = new StringBuilder();
				List<BBCodeAttribute> attributeDb = getAttributesByMode(mode.getBbCodeAttributeModeId());
				List<BBCodeAttribute> attributes = new ArrayList<>();
				
				for(BBCodeAttribute attribute : attributeDb){
					attribute.setDataType(AttributeDataType.values()[attribute.getAttributeDataType()]);
					attribute.setAttributeIndex("{{" + Integer.parseInt(attribute.getAttributeIndex()) + "}}");
					attribute.setName(attribute.getName().equals("NAMELESS") ? "=" : attribute.getName() + "=");
					attributes.add(attribute);
					modeString.append(attribute.getName().equals("=") ? "=" : attribute.getName() + "=");
					
					if(attString.indexOf(attribute.getName()) == -1 || attString.length() == 0){
						if(attString.length() > 0){
							attString.append(",");
						}
						
						attString.append(attribute.getName().equals("=") ? "=" : attribute.getName() + "=");
					}
				}
				
				mode.setAttributes(attributes);
				bbCode.getAttributeConfig().put(modeString.toString(), mode);
			}
			bbCode.setAllAttributeNamesAsString(attString.toString());
			result.put(bbCode.getCode().toUpperCase(), bbCode);
		}

		return result;
	}
}