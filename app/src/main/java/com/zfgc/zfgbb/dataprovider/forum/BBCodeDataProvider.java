package com.zfgc.zfgbb.dataprovider.forum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BBCodeDataProvider extends AbstractDataProvider {
	
	private final BBCodeConfigDao bbCodeConfigDao;
	
	private final BBCodeAttributeModeDao bbCodeAttributeModeDao;
	
	private final BBCodeAttributeDao bbCodeAttributeDao;
	
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
		for(BBCodeConfig bbCode : bbCodes){
			List<BBCodeAttributeMode> modesDb = getAttributeModesByBbCode(bbCode.getBbCodeConfigId());

			Map<Integer, List<BBCodeAttribute>> attrsByMode = new HashMap<>();
			Set<String> orderedNames = new LinkedHashSet<>();
			for (BBCodeAttributeMode mode : modesDb) {
				List<BBCodeAttribute> attrs = getAttributesByMode(mode.getBbCodeAttributeModeId());
				for (BBCodeAttribute attribute : attrs) {
					attribute.setDataType(AttributeDataType.values()[attribute.getAttributeDataType()]);
					attribute.setAttributeIndex("{{" + Integer.parseInt(attribute.getAttributeIndex()) + "}}");
					attribute.setName(attribute.getName().equals("NAMELESS") ? "=" : attribute.getName() + "=");
					orderedNames.add(attribute.getName());
				}
				attrsByMode.put(mode.getBbCodeAttributeModeId(), attrs);
			}

			bbCode.setAllAttributeNamesAsString(String.join(",", orderedNames));

			for (BBCodeAttributeMode mode : modesDb) {
				List<BBCodeAttribute> attrs = attrsByMode.get(mode.getBbCodeAttributeModeId());
				Set<String> namesInMode = attrs.stream()
						.map(BBCodeAttribute::getName)
						.collect(Collectors.toSet());

				StringBuilder modeKey = new StringBuilder();
				for (String name : orderedNames) {
					if (namesInMode.contains(name)) {
						modeKey.append(name);
					}
				}

				attrs.sort(Comparator.comparingInt(a ->
						Integer.parseInt(a.getAttributeIndex().replaceAll("[^0-9]", ""))));

				mode.setAttributes(attrs);
				bbCode.getAttributeConfig().put(modeKey.toString(), mode);
			}

			result.put(bbCode.getCode().toUpperCase(), bbCode);
		}

		return result;
	}
}