package com.zfgc.zfgbb.dbo;

import java.time.LocalDateTime;
import java.util.Date;

public class PollDbo extends AbstractDbo {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.poll_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Integer pollId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.poll_question
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private String pollQuestion;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.thread_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Integer threadId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.created_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private LocalDateTime createdTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.updated_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private LocalDateTime updatedTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.voting_locked_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Boolean votingLockedFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.max_votes
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Boolean maxVotes;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.expire_time
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Date expireTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.hide_results_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Boolean hideResultsFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.change_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Boolean changeVoteFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.created_user_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Integer createdUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.guest_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Boolean guestVoteFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.guest_vote_count
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Integer guestVoteCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.poll.reset_poll
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	private Integer resetPoll;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.poll_id
	 * @return  the value of zfgbb.poll.poll_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Integer getPollId() {
		return pollId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.poll_id
	 * @param pollId  the value for zfgbb.poll.poll_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.poll_question
	 * @return  the value of zfgbb.poll.poll_question
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public String getPollQuestion() {
		return pollQuestion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.poll_question
	 * @param pollQuestion  the value for zfgbb.poll.poll_question
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setPollQuestion(String pollQuestion) {
		this.pollQuestion = pollQuestion;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.thread_id
	 * @return  the value of zfgbb.poll.thread_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Integer getThreadId() {
		return threadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.thread_id
	 * @param threadId  the value for zfgbb.poll.thread_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.created_ts
	 * @return  the value of zfgbb.poll.created_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public LocalDateTime getCreatedTs() {
		return createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.created_ts
	 * @param createdTs  the value for zfgbb.poll.created_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.updated_ts
	 * @return  the value of zfgbb.poll.updated_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public LocalDateTime getUpdatedTs() {
		return updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.updated_ts
	 * @param updatedTs  the value for zfgbb.poll.updated_ts
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setUpdatedTs(LocalDateTime updatedTs) {
		this.updatedTs = updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.voting_locked_flag
	 * @return  the value of zfgbb.poll.voting_locked_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Boolean getVotingLockedFlag() {
		return votingLockedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.voting_locked_flag
	 * @param votingLockedFlag  the value for zfgbb.poll.voting_locked_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setVotingLockedFlag(Boolean votingLockedFlag) {
		this.votingLockedFlag = votingLockedFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.max_votes
	 * @return  the value of zfgbb.poll.max_votes
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Boolean getMaxVotes() {
		return maxVotes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.max_votes
	 * @param maxVotes  the value for zfgbb.poll.max_votes
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setMaxVotes(Boolean maxVotes) {
		this.maxVotes = maxVotes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.expire_time
	 * @return  the value of zfgbb.poll.expire_time
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.expire_time
	 * @param expireTime  the value for zfgbb.poll.expire_time
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.hide_results_flag
	 * @return  the value of zfgbb.poll.hide_results_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Boolean getHideResultsFlag() {
		return hideResultsFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.hide_results_flag
	 * @param hideResultsFlag  the value for zfgbb.poll.hide_results_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setHideResultsFlag(Boolean hideResultsFlag) {
		this.hideResultsFlag = hideResultsFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.change_vote_flag
	 * @return  the value of zfgbb.poll.change_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Boolean getChangeVoteFlag() {
		return changeVoteFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.change_vote_flag
	 * @param changeVoteFlag  the value for zfgbb.poll.change_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setChangeVoteFlag(Boolean changeVoteFlag) {
		this.changeVoteFlag = changeVoteFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.created_user_id
	 * @return  the value of zfgbb.poll.created_user_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Integer getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.created_user_id
	 * @param createdUserId  the value for zfgbb.poll.created_user_id
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.guest_vote_flag
	 * @return  the value of zfgbb.poll.guest_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Boolean getGuestVoteFlag() {
		return guestVoteFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.guest_vote_flag
	 * @param guestVoteFlag  the value for zfgbb.poll.guest_vote_flag
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setGuestVoteFlag(Boolean guestVoteFlag) {
		this.guestVoteFlag = guestVoteFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.guest_vote_count
	 * @return  the value of zfgbb.poll.guest_vote_count
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Integer getGuestVoteCount() {
		return guestVoteCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.guest_vote_count
	 * @param guestVoteCount  the value for zfgbb.poll.guest_vote_count
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setGuestVoteCount(Integer guestVoteCount) {
		this.guestVoteCount = guestVoteCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.poll.reset_poll
	 * @return  the value of zfgbb.poll.reset_poll
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public Integer getResetPoll() {
		return resetPoll;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.poll.reset_poll
	 * @param resetPoll  the value for zfgbb.poll.reset_poll
	 * @mbg.generated  Sun Sep 29 01:06:50 EDT 2024
	 */
	public void setResetPoll(Integer resetPoll) {
		this.resetPoll = resetPoll;
	}

	@Override
	public Integer getPkId() {
		return pollId;
	}

	@Override
	public LocalDateTime getUpdatedTime() {
		return updatedTs;
	}

	@Override
	public LocalDateTime getCreatedTime() {
		return createdTs;
	}
}