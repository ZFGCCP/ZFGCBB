package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PollChoiceDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public PollChoiceDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
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

        public Criteria andPollChoiceIdIsNull() {
            addCriterion("poll_choice_id is null");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdIsNotNull() {
            addCriterion("poll_choice_id is not null");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdEqualTo(Integer value) {
            addCriterion("poll_choice_id =", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdNotEqualTo(Integer value) {
            addCriterion("poll_choice_id <>", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdGreaterThan(Integer value) {
            addCriterion("poll_choice_id >", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("poll_choice_id >=", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdLessThan(Integer value) {
            addCriterion("poll_choice_id <", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("poll_choice_id <=", value, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdIn(List<Integer> values) {
            addCriterion("poll_choice_id in", values, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdNotIn(List<Integer> values) {
            addCriterion("poll_choice_id not in", values, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdBetween(Integer value1, Integer value2) {
            addCriterion("poll_choice_id between", value1, value2, "pollChoiceId");
            return (Criteria) this;
        }

        public Criteria andPollChoiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("poll_choice_id not between", value1, value2, "pollChoiceId");
            return (Criteria) this;
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

        public Criteria andChoiceTextIsNull() {
            addCriterion("choice_text is null");
            return (Criteria) this;
        }

        public Criteria andChoiceTextIsNotNull() {
            addCriterion("choice_text is not null");
            return (Criteria) this;
        }

        public Criteria andChoiceTextEqualTo(String value) {
            addCriterion("choice_text =", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextNotEqualTo(String value) {
            addCriterion("choice_text <>", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextGreaterThan(String value) {
            addCriterion("choice_text >", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextGreaterThanOrEqualTo(String value) {
            addCriterion("choice_text >=", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextLessThan(String value) {
            addCriterion("choice_text <", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextLessThanOrEqualTo(String value) {
            addCriterion("choice_text <=", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextLike(String value) {
            addCriterion("choice_text ilike", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextNotLike(String value) {
            addCriterion("choice_text not ilike", value, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextIn(List<String> values) {
            addCriterion("choice_text in", values, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextNotIn(List<String> values) {
            addCriterion("choice_text not in", values, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextBetween(String value1, String value2) {
            addCriterion("choice_text between", value1, value2, "choiceText");
            return (Criteria) this;
        }

        public Criteria andChoiceTextNotBetween(String value1, String value2) {
            addCriterion("choice_text not between", value1, value2, "choiceText");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNull() {
            addCriterion("active_flag is null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNotNull() {
            addCriterion("active_flag is not null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagEqualTo(Boolean value) {
            addCriterion("active_flag =", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotEqualTo(Boolean value) {
            addCriterion("active_flag <>", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThan(Boolean value) {
            addCriterion("active_flag >", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active_flag >=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThan(Boolean value) {
            addCriterion("active_flag <", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("active_flag <=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIn(List<Boolean> values) {
            addCriterion("active_flag in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotIn(List<Boolean> values) {
            addCriterion("active_flag not in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("active_flag between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("active_flag not between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andVotesIsNull() {
            addCriterion("votes is null");
            return (Criteria) this;
        }

        public Criteria andVotesIsNotNull() {
            addCriterion("votes is not null");
            return (Criteria) this;
        }

        public Criteria andVotesEqualTo(Integer value) {
            addCriterion("votes =", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotEqualTo(Integer value) {
            addCriterion("votes <>", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThan(Integer value) {
            addCriterion("votes >", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesGreaterThanOrEqualTo(Integer value) {
            addCriterion("votes >=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThan(Integer value) {
            addCriterion("votes <", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesLessThanOrEqualTo(Integer value) {
            addCriterion("votes <=", value, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesIn(List<Integer> values) {
            addCriterion("votes in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotIn(List<Integer> values) {
            addCriterion("votes not in", values, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesBetween(Integer value1, Integer value2) {
            addCriterion("votes between", value1, value2, "votes");
            return (Criteria) this;
        }

        public Criteria andVotesNotBetween(Integer value1, Integer value2) {
            addCriterion("votes not between", value1, value2, "votes");
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

        public Criteria andSeqnoIsNull() {
            addCriterion("seqno is null");
            return (Criteria) this;
        }

        public Criteria andSeqnoIsNotNull() {
            addCriterion("seqno is not null");
            return (Criteria) this;
        }

        public Criteria andSeqnoEqualTo(Integer value) {
            addCriterion("seqno =", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoNotEqualTo(Integer value) {
            addCriterion("seqno <>", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoGreaterThan(Integer value) {
            addCriterion("seqno >", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seqno >=", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoLessThan(Integer value) {
            addCriterion("seqno <", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoLessThanOrEqualTo(Integer value) {
            addCriterion("seqno <=", value, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoIn(List<Integer> values) {
            addCriterion("seqno in", values, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoNotIn(List<Integer> values) {
            addCriterion("seqno not in", values, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoBetween(Integer value1, Integer value2) {
            addCriterion("seqno between", value1, value2, "seqno");
            return (Criteria) this;
        }

        public Criteria andSeqnoNotBetween(Integer value1, Integer value2) {
            addCriterion("seqno not between", value1, value2, "seqno");
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

        public Criteria andChoiceTextContains(String value) {
            addCriterion("choice_text ilike", LikePatterns.contains(value), "choiceText");
            return (Criteria) this;
        }

        public Criteria andMigrationHashContains(String value) {
            addCriterion("migration_hash ilike", LikePatterns.contains(value), "migrationHash");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.poll_choice")
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