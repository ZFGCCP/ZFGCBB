package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

public class Poll extends BaseModel {
	@JsonIgnore
	private Integer pollId;
    private String pollQuestion;
    private Integer threadId;
    
    private List<PollQuestion> answers = new ArrayList<>();
    
	@Override
	public Integer getId() {
		return pollId;
	}
	@Override
	public void setId(Integer id) {
		pollId = id;
	}
	public String getPollQuestion() {
		return pollQuestion;
	}
	public void setPollQuestion(String pollQuestion) {
		this.pollQuestion = pollQuestion;
	}
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public List<PollQuestion> getAnswers() {
		return answers;
	}
	public void setAnswers(List<PollQuestion> answers) {
		this.answers = answers;
	}
}