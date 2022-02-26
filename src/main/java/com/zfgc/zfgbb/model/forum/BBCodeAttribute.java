package com.zfgc.zfgbb.model.forum;

import com.zfgc.zfgbb.model.BaseModel;

public class BBCodeAttribute extends BaseModel {

	private Integer bbCodeAttributeId;
    private Integer attributeDataType;
    private String attributeIndex;
    private Integer bbCodeAttributeModeId;
    private String name;
    private AttributeDataType dataType;

    public String transformValue(String value){
		String result = "";
		
		switch(dataType){
		case TIMESTAMP:
			result = createDate(value);
			break;
			
		case TEXT:
			result = value;
			break;
		}

		return result;
	}
	
    public String createDate(String value){
		return "";//ZfgcTimeUtils.createDateAsString(value, super.getUserTimeZone());
	}
    
	public Integer getBbCodeAttributeId() {
		return bbCodeAttributeId;
	}

	public void setBbCodeAttributeId(Integer bbCodeAttributeId) {
		this.bbCodeAttributeId = bbCodeAttributeId;
	}

	public Integer getAttributeDataType() {
		return attributeDataType;
	}

	public void setAttributeDataType(Integer attributeDataType) {
		this.attributeDataType = attributeDataType;
	}

	public Integer getBbCodeAttributeModeId() {
		return bbCodeAttributeModeId;
	}

	public void setBbCodeAttributeModeId(Integer bbCodeAttributeModeId) {
		this.bbCodeAttributeModeId = bbCodeAttributeModeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getId() {
		return bbCodeAttributeId;
	}

	@Override
	public void setId(Integer id) {
		bbCodeAttributeId = id;
	}

	public String getAttributeIndex() {
		return attributeIndex;
	}

	public void setAttributeIndex(String attributeIndex) {
		this.attributeIndex = attributeIndex;
	}
	
	public void setDataType(AttributeDataType dataType) {
		this.dataType = dataType;
	}
	
}