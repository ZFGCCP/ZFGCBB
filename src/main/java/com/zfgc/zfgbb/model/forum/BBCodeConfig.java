package com.zfgc.zfgbb.model.forum;

import java.util.HashMap;
import java.util.Map;

import com.zfgc.zfgbb.model.BaseModel;

public class BBCodeConfig extends BaseModel {

	private Integer bbCodeConfigId;
    private String code;
    private String endTag;
    private Boolean processContentFlag;
    private String allAttributeNamesAsString;
    private Map<String,BBCodeAttributeMode> attributeConfig = new HashMap<>();
    
	public Integer getBbCodeConfigId() {
		return bbCodeConfigId;
	}

	public void setBbCodeConfigId(Integer bbCodeConfigId) {
		this.bbCodeConfigId = bbCodeConfigId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}

	public Boolean getProcessContentFlag() {
		return processContentFlag;
	}

	public void setProcessContentFlag(Boolean processContentFlag) {
		this.processContentFlag = processContentFlag;
	}

	public String getAllAttributeNamesAsString() {
		return allAttributeNamesAsString;
	}
	public void setAllAttributeNamesAsString(String allAttributeNamesAsString) {
		this.allAttributeNamesAsString = allAttributeNamesAsString;
	}
	
	@Override
	public Integer getId() {
		return bbCodeConfigId;
	}

	@Override
	public void setId(Integer id) {
		bbCodeConfigId = id;
	}

	public Map<String,BBCodeAttributeMode> getAttributeConfig() {
		return attributeConfig;
	}

	public void setAttributeConfig(Map<String,BBCodeAttributeMode> attributeConfig) {
		this.attributeConfig = attributeConfig;
	}
	
}