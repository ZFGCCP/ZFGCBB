package com.zfgc.zfgbb.model.forum;

import java.time.OffsetDateTime;

import com.zfgc.zfgbb.model.BaseModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class PollChoice extends BaseModel {

	private Integer pollChoiceId;
	private Integer pollId;
	private String choiceText;
	private Boolean activeFlag;
	private Integer votes;
	private String migrationHash;
	private Integer seqno;
	
	@Override
	public Integer getId() {
		return pollChoiceId;
	}

	@Override
	public void setId(Integer id) {
		pollChoiceId = id;
	}

}
