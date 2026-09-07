package com.zfgc.zfgbb.model.forum;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class Poll extends BaseModel {
	@JsonIgnore
	private Integer pollId;
	private String pollQuestion;
	private Integer threadId;
	private Boolean votingLockedFlag;
	
	@JsonIgnore
	private OffsetDateTime expireTime;
	private Boolean hideResultsFlag;
	private Boolean changeVoteFlag;
	private Integer createdUserId;
	private Boolean guestVoteFlag;
	private Integer guestVoteCount;
	private Integer resetPoll;
	private Integer maxVotes;
	private String migrationHash;
    
    @Builder.Default
    private List<PollChoice> answers = new ArrayList<>();
    
	@Override
	public Integer getId() {
		return pollId;
	}
	@Override
	public void setId(Integer id) {
		pollId = id;
	}
	
	public Integer getVotes() {
		return answers.stream().mapToInt(ans -> ans.getVotes()).sum() + guestVoteCount;
	}
}