package com.zfgc.zfgbb.model.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class PollQuestion extends BaseModel {

	@JsonIgnore
	private Integer pollQuestionId;
    private String answerText;
    private Integer pollId;
    private Integer votes;
	
	public Integer getPollQuestionId() {
		return pollQuestionId;
	}

	public void setPollQuestionId(Integer pollQuestionId) {
		this.pollQuestionId = pollQuestionId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	@Override
	public Integer getId() {
		return pollQuestionId;
	}

	@Override
	public void setId(Integer id) {
		pollQuestionId = id;
	}

}
