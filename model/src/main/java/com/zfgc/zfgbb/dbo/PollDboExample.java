package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PollDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public PollDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPollIdIsNull() {
            addCriterion("poll_id is null");
            return (Criteria) this;
        }

        public Criteria andPollIdIsNotNull() {
            addCriterion("poll_id is not null");
            return (Criteria) this;
        }

        public Criteria andPollIdEqualTo(Integer value) {
            addCriterion("poll_id =", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdNotEqualTo(Integer value) {
            addCriterion("poll_id <>", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdGreaterThan(Integer value) {
            addCriterion("poll_id >", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("poll_id >=", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdLessThan(Integer value) {
            addCriterion("poll_id <", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdLessThanOrEqualTo(Integer value) {
            addCriterion("poll_id <=", value, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdIn(List<Integer> values) {
            addCriterion("poll_id in", values, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdNotIn(List<Integer> values) {
            addCriterion("poll_id not in", values, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdBetween(Integer value1, Integer value2) {
            addCriterion("poll_id between", value1, value2, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollIdNotBetween(Integer value1, Integer value2) {
            addCriterion("poll_id not between", value1, value2, "pollId");
            return (Criteria) this;
        }

        public Criteria andPollQuestionIsNull() {
            addCriterion("poll_question is null");
            return (Criteria) this;
        }

        public Criteria andPollQuestionIsNotNull() {
            addCriterion("poll_question is not null");
            return (Criteria) this;
        }

        public Criteria andPollQuestionEqualTo(String value) {
            addCriterion("poll_question =", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionNotEqualTo(String value) {
            addCriterion("poll_question <>", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionGreaterThan(String value) {
            addCriterion("poll_question >", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("poll_question >=", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionLessThan(String value) {
            addCriterion("poll_question <", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionLessThanOrEqualTo(String value) {
            addCriterion("poll_question <=", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionLike(String value) {
            addCriterion("poll_question ilike", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionNotLike(String value) {
            addCriterion("poll_question not ilike", value, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionIn(List<String> values) {
            addCriterion("poll_question in", values, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionNotIn(List<String> values) {
            addCriterion("poll_question not in", values, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionBetween(String value1, String value2) {
            addCriterion("poll_question between", value1, value2, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andPollQuestionNotBetween(String value1, String value2) {
            addCriterion("poll_question not between", value1, value2, "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andThreadIdIsNull() {
            addCriterion("thread_id is null");
            return (Criteria) this;
        }

        public Criteria andThreadIdIsNotNull() {
            addCriterion("thread_id is not null");
            return (Criteria) this;
        }

        public Criteria andThreadIdEqualTo(Integer value) {
            addCriterion("thread_id =", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotEqualTo(Integer value) {
            addCriterion("thread_id <>", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThan(Integer value) {
            addCriterion("thread_id >", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("thread_id >=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThan(Integer value) {
            addCriterion("thread_id <", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdLessThanOrEqualTo(Integer value) {
            addCriterion("thread_id <=", value, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdIn(List<Integer> values) {
            addCriterion("thread_id in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotIn(List<Integer> values) {
            addCriterion("thread_id not in", values, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdBetween(Integer value1, Integer value2) {
            addCriterion("thread_id between", value1, value2, "threadId");
            return (Criteria) this;
        }

        public Criteria andThreadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("thread_id not between", value1, value2, "threadId");
            return (Criteria) this;
        }

        public Criteria andCreatedTsIsNull() {
            addCriterion("created_ts is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTsIsNotNull() {
            addCriterion("created_ts is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTsEqualTo(OffsetDateTime value) {
            addCriterion("created_ts =", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("created_ts <>", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsGreaterThan(OffsetDateTime value) {
            addCriterion("created_ts >", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("created_ts >=", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsLessThan(OffsetDateTime value) {
            addCriterion("created_ts <", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("created_ts <=", value, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsIn(List<OffsetDateTime> values) {
            addCriterion("created_ts in", values, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("created_ts not in", values, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("created_ts between", value1, value2, "createdTs");
            return (Criteria) this;
        }

        public Criteria andCreatedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("created_ts not between", value1, value2, "createdTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsIsNull() {
            addCriterion("updated_ts is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsIsNotNull() {
            addCriterion("updated_ts is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsEqualTo(OffsetDateTime value) {
            addCriterion("updated_ts =", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("updated_ts <>", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsGreaterThan(OffsetDateTime value) {
            addCriterion("updated_ts >", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("updated_ts >=", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsLessThan(OffsetDateTime value) {
            addCriterion("updated_ts <", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("updated_ts <=", value, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsIn(List<OffsetDateTime> values) {
            addCriterion("updated_ts in", values, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("updated_ts not in", values, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("updated_ts between", value1, value2, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andUpdatedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("updated_ts not between", value1, value2, "updatedTs");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagIsNull() {
            addCriterion("voting_locked_flag is null");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagIsNotNull() {
            addCriterion("voting_locked_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagEqualTo(Boolean value) {
            addCriterion("voting_locked_flag =", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagNotEqualTo(Boolean value) {
            addCriterion("voting_locked_flag <>", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagGreaterThan(Boolean value) {
            addCriterion("voting_locked_flag >", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("voting_locked_flag >=", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagLessThan(Boolean value) {
            addCriterion("voting_locked_flag <", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("voting_locked_flag <=", value, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagIn(List<Boolean> values) {
            addCriterion("voting_locked_flag in", values, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagNotIn(List<Boolean> values) {
            addCriterion("voting_locked_flag not in", values, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("voting_locked_flag between", value1, value2, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andVotingLockedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("voting_locked_flag not between", value1, value2, "votingLockedFlag");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(OffsetDateTime value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(OffsetDateTime value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(OffsetDateTime value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<OffsetDateTime> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagIsNull() {
            addCriterion("hide_results_flag is null");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagIsNotNull() {
            addCriterion("hide_results_flag is not null");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagEqualTo(Boolean value) {
            addCriterion("hide_results_flag =", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagNotEqualTo(Boolean value) {
            addCriterion("hide_results_flag <>", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagGreaterThan(Boolean value) {
            addCriterion("hide_results_flag >", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hide_results_flag >=", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagLessThan(Boolean value) {
            addCriterion("hide_results_flag <", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("hide_results_flag <=", value, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagIn(List<Boolean> values) {
            addCriterion("hide_results_flag in", values, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagNotIn(List<Boolean> values) {
            addCriterion("hide_results_flag not in", values, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_results_flag between", value1, value2, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andHideResultsFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_results_flag not between", value1, value2, "hideResultsFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagIsNull() {
            addCriterion("change_vote_flag is null");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagIsNotNull() {
            addCriterion("change_vote_flag is not null");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagEqualTo(Boolean value) {
            addCriterion("change_vote_flag =", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagNotEqualTo(Boolean value) {
            addCriterion("change_vote_flag <>", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagGreaterThan(Boolean value) {
            addCriterion("change_vote_flag >", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("change_vote_flag >=", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagLessThan(Boolean value) {
            addCriterion("change_vote_flag <", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("change_vote_flag <=", value, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagIn(List<Boolean> values) {
            addCriterion("change_vote_flag in", values, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagNotIn(List<Boolean> values) {
            addCriterion("change_vote_flag not in", values, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("change_vote_flag between", value1, value2, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andChangeVoteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("change_vote_flag not between", value1, value2, "changeVoteFlag");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNull() {
            addCriterion("created_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIsNotNull() {
            addCriterion("created_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdEqualTo(Integer value) {
            addCriterion("created_user_id =", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotEqualTo(Integer value) {
            addCriterion("created_user_id <>", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThan(Integer value) {
            addCriterion("created_user_id >", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_user_id >=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThan(Integer value) {
            addCriterion("created_user_id <", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("created_user_id <=", value, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdIn(List<Integer> values) {
            addCriterion("created_user_id in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotIn(List<Integer> values) {
            addCriterion("created_user_id not in", values, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("created_user_id between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("created_user_id not between", value1, value2, "createdUserId");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagIsNull() {
            addCriterion("guest_vote_flag is null");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagIsNotNull() {
            addCriterion("guest_vote_flag is not null");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagEqualTo(Boolean value) {
            addCriterion("guest_vote_flag =", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagNotEqualTo(Boolean value) {
            addCriterion("guest_vote_flag <>", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagGreaterThan(Boolean value) {
            addCriterion("guest_vote_flag >", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("guest_vote_flag >=", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagLessThan(Boolean value) {
            addCriterion("guest_vote_flag <", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("guest_vote_flag <=", value, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagIn(List<Boolean> values) {
            addCriterion("guest_vote_flag in", values, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagNotIn(List<Boolean> values) {
            addCriterion("guest_vote_flag not in", values, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("guest_vote_flag between", value1, value2, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("guest_vote_flag not between", value1, value2, "guestVoteFlag");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountIsNull() {
            addCriterion("guest_vote_count is null");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountIsNotNull() {
            addCriterion("guest_vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountEqualTo(Integer value) {
            addCriterion("guest_vote_count =", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountNotEqualTo(Integer value) {
            addCriterion("guest_vote_count <>", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountGreaterThan(Integer value) {
            addCriterion("guest_vote_count >", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("guest_vote_count >=", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountLessThan(Integer value) {
            addCriterion("guest_vote_count <", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountLessThanOrEqualTo(Integer value) {
            addCriterion("guest_vote_count <=", value, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountIn(List<Integer> values) {
            addCriterion("guest_vote_count in", values, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountNotIn(List<Integer> values) {
            addCriterion("guest_vote_count not in", values, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountBetween(Integer value1, Integer value2) {
            addCriterion("guest_vote_count between", value1, value2, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andGuestVoteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("guest_vote_count not between", value1, value2, "guestVoteCount");
            return (Criteria) this;
        }

        public Criteria andResetPollIsNull() {
            addCriterion("reset_poll is null");
            return (Criteria) this;
        }

        public Criteria andResetPollIsNotNull() {
            addCriterion("reset_poll is not null");
            return (Criteria) this;
        }

        public Criteria andResetPollEqualTo(Integer value) {
            addCriterion("reset_poll =", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollNotEqualTo(Integer value) {
            addCriterion("reset_poll <>", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollGreaterThan(Integer value) {
            addCriterion("reset_poll >", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollGreaterThanOrEqualTo(Integer value) {
            addCriterion("reset_poll >=", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollLessThan(Integer value) {
            addCriterion("reset_poll <", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollLessThanOrEqualTo(Integer value) {
            addCriterion("reset_poll <=", value, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollIn(List<Integer> values) {
            addCriterion("reset_poll in", values, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollNotIn(List<Integer> values) {
            addCriterion("reset_poll not in", values, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollBetween(Integer value1, Integer value2) {
            addCriterion("reset_poll between", value1, value2, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andResetPollNotBetween(Integer value1, Integer value2) {
            addCriterion("reset_poll not between", value1, value2, "resetPoll");
            return (Criteria) this;
        }

        public Criteria andMaxVotesIsNull() {
            addCriterion("max_votes is null");
            return (Criteria) this;
        }

        public Criteria andMaxVotesIsNotNull() {
            addCriterion("max_votes is not null");
            return (Criteria) this;
        }

        public Criteria andMaxVotesEqualTo(Integer value) {
            addCriterion("max_votes =", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesNotEqualTo(Integer value) {
            addCriterion("max_votes <>", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesGreaterThan(Integer value) {
            addCriterion("max_votes >", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_votes >=", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesLessThan(Integer value) {
            addCriterion("max_votes <", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesLessThanOrEqualTo(Integer value) {
            addCriterion("max_votes <=", value, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesIn(List<Integer> values) {
            addCriterion("max_votes in", values, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesNotIn(List<Integer> values) {
            addCriterion("max_votes not in", values, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesBetween(Integer value1, Integer value2) {
            addCriterion("max_votes between", value1, value2, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMaxVotesNotBetween(Integer value1, Integer value2) {
            addCriterion("max_votes not between", value1, value2, "maxVotes");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIsNull() {
            addCriterion("migration_hash is null");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIsNotNull() {
            addCriterion("migration_hash is not null");
            return (Criteria) this;
        }

        public Criteria andMigrationHashEqualTo(String value) {
            addCriterion("migration_hash =", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotEqualTo(String value) {
            addCriterion("migration_hash <>", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashGreaterThan(String value) {
            addCriterion("migration_hash >", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashGreaterThanOrEqualTo(String value) {
            addCriterion("migration_hash >=", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLessThan(String value) {
            addCriterion("migration_hash <", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLessThanOrEqualTo(String value) {
            addCriterion("migration_hash <=", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLike(String value) {
            addCriterion("migration_hash ilike", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotLike(String value) {
            addCriterion("migration_hash not ilike", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIn(List<String> values) {
            addCriterion("migration_hash in", values, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotIn(List<String> values) {
            addCriterion("migration_hash not in", values, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashBetween(String value1, String value2) {
            addCriterion("migration_hash between", value1, value2, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotBetween(String value1, String value2) {
            addCriterion("migration_hash not between", value1, value2, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andAnswerTextIsNull() {
            addCriterion("answer_text is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTextIsNotNull() {
            addCriterion("answer_text is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTextEqualTo(String value) {
            addCriterion("answer_text =", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextNotEqualTo(String value) {
            addCriterion("answer_text <>", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextGreaterThan(String value) {
            addCriterion("answer_text >", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextGreaterThanOrEqualTo(String value) {
            addCriterion("answer_text >=", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextLessThan(String value) {
            addCriterion("answer_text <", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextLessThanOrEqualTo(String value) {
            addCriterion("answer_text <=", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextLike(String value) {
            addCriterion("answer_text ilike", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextNotLike(String value) {
            addCriterion("answer_text not ilike", value, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextIn(List<String> values) {
            addCriterion("answer_text in", values, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextNotIn(List<String> values) {
            addCriterion("answer_text not in", values, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextBetween(String value1, String value2) {
            addCriterion("answer_text between", value1, value2, "answerText");
            return (Criteria) this;
        }

        public Criteria andAnswerTextNotBetween(String value1, String value2) {
            addCriterion("answer_text not between", value1, value2, "answerText");
            return (Criteria) this;
        }

        public Criteria andPollQuestionContains(String value) {
            addCriterion("poll_question ilike", LikePatterns.contains(value), "pollQuestion");
            return (Criteria) this;
        }

        public Criteria andMigrationHashContains(String value) {
            addCriterion("migration_hash ilike", LikePatterns.contains(value), "migrationHash");
            return (Criteria) this;
        }

        public Criteria andAnswerTextContains(String value) {
            addCriterion("answer_text ilike", LikePatterns.contains(value), "answerText");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll")
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}