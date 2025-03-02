package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class BBCodeAttributeMode extends BaseModel {
	@JsonIgnore
	private Integer bbCodeAttributeModeId;
    private Integer bbCodeConfigId;
    private Boolean contentIsAttributeFlag = false;
    private String openTag;
    private String closeTag;
    private Boolean outputContentFlag = true;
    private List<BBCodeAttribute> attributes = new ArrayList<>();
	
	public Integer getBbCodeAttributeModeId() {
		return bbCodeAttributeModeId;
	}

	public void setBbCodeAttributeModeId(Integer bbCodeAttributeModeId) {
		this.bbCodeAttributeModeId = bbCodeAttributeModeId;
	}

	public Integer getBbCodeConfigId() {
		return bbCodeConfigId;
	}

	public void setBbCodeConfigId(Integer bbCodeConfigId) {
		this.bbCodeConfigId = bbCodeConfigId;
	}

	public Boolean getContentIsAttributeFlag() {
		return contentIsAttributeFlag;
	}

	public void setContentIsAttributeFlag(Boolean contentIsAttributeFlag) {
		this.contentIsAttributeFlag = contentIsAttributeFlag;
	}

	public String getOpenTag() {
		return openTag;
	}

	public void setOpenTag(String openTag) {
		this.openTag = openTag;
	}

	public String getCloseTag() {
		return closeTag;
	}

	public void setCloseTag(String closeTag) {
		this.closeTag = closeTag;
	}

	public Boolean getOutputContentFlag() {
		return outputContentFlag;
	}

	public void setOutputContentFlag(Boolean outputContentFlag) {
		this.outputContentFlag = outputContentFlag;
	}

	@Override
	public Integer getId() {
		return bbCodeAttributeModeId;
	}

	@Override
	public void setId(Integer id) {
		bbCodeAttributeModeId = id;
	}

	public List<BBCodeAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<BBCodeAttribute> attributes) {
		this.attributes = attributes;
	}

}
