package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserKarmaViewDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public UserKarmaViewDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
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

        public Criteria andKarmaIdIsNull() {
            addCriterion("karma_id is null");
            return (Criteria) this;
        }

        public Criteria andKarmaIdIsNotNull() {
            addCriterion("karma_id is not null");
            return (Criteria) this;
        }

        public Criteria andKarmaIdEqualTo(Integer value) {
            addCriterion("karma_id =", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdNotEqualTo(Integer value) {
            addCriterion("karma_id <>", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdGreaterThan(Integer value) {
            addCriterion("karma_id >", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("karma_id >=", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdLessThan(Integer value) {
            addCriterion("karma_id <", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdLessThanOrEqualTo(Integer value) {
            addCriterion("karma_id <=", value, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdIn(List<Integer> values) {
            addCriterion("karma_id in", values, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdNotIn(List<Integer> values) {
            addCriterion("karma_id not in", values, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdBetween(Integer value1, Integer value2) {
            addCriterion("karma_id between", value1, value2, "karmaId");
            return (Criteria) this;
        }

        public Criteria andKarmaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("karma_id not between", value1, value2, "karmaId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdIsNull() {
            addCriterion("receiving_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdIsNotNull() {
            addCriterion("receiving_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdEqualTo(Integer value) {
            addCriterion("receiving_user_id =", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdNotEqualTo(Integer value) {
            addCriterion("receiving_user_id <>", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdGreaterThan(Integer value) {
            addCriterion("receiving_user_id >", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiving_user_id >=", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdLessThan(Integer value) {
            addCriterion("receiving_user_id <", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("receiving_user_id <=", value, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdIn(List<Integer> values) {
            addCriterion("receiving_user_id in", values, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdNotIn(List<Integer> values) {
            addCriterion("receiving_user_id not in", values, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdBetween(Integer value1, Integer value2) {
            addCriterion("receiving_user_id between", value1, value2, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andReceivingUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receiving_user_id not between", value1, value2, "receivingUserId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description ilike", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not ilike", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIsPositiveIsNull() {
            addCriterion("is_positive is null");
            return (Criteria) this;
        }

        public Criteria andIsPositiveIsNotNull() {
            addCriterion("is_positive is not null");
            return (Criteria) this;
        }

        public Criteria andIsPositiveEqualTo(Boolean value) {
            addCriterion("is_positive =", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveNotEqualTo(Boolean value) {
            addCriterion("is_positive <>", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveGreaterThan(Boolean value) {
            addCriterion("is_positive >", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_positive >=", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveLessThan(Boolean value) {
            addCriterion("is_positive <", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_positive <=", value, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveIn(List<Boolean> values) {
            addCriterion("is_positive in", values, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveNotIn(List<Boolean> values) {
            addCriterion("is_positive not in", values, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_positive between", value1, value2, "isPositive");
            return (Criteria) this;
        }

        public Criteria andIsPositiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_positive not between", value1, value2, "isPositive");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsIsNull() {
            addCriterion("karma_given_ts is null");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsIsNotNull() {
            addCriterion("karma_given_ts is not null");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsEqualTo(OffsetDateTime value) {
            addCriterion("karma_given_ts =", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsNotEqualTo(OffsetDateTime value) {
            addCriterion("karma_given_ts <>", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsGreaterThan(OffsetDateTime value) {
            addCriterion("karma_given_ts >", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("karma_given_ts >=", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsLessThan(OffsetDateTime value) {
            addCriterion("karma_given_ts <", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("karma_given_ts <=", value, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsIn(List<OffsetDateTime> values) {
            addCriterion("karma_given_ts in", values, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsNotIn(List<OffsetDateTime> values) {
            addCriterion("karma_given_ts not in", values, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("karma_given_ts between", value1, value2, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andKarmaGivenTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("karma_given_ts not between", value1, value2, "karmaGivenTs");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdIsNull() {
            addCriterion("commenting_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdIsNotNull() {
            addCriterion("commenting_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdEqualTo(Integer value) {
            addCriterion("commenting_user_id =", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdNotEqualTo(Integer value) {
            addCriterion("commenting_user_id <>", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdGreaterThan(Integer value) {
            addCriterion("commenting_user_id >", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commenting_user_id >=", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdLessThan(Integer value) {
            addCriterion("commenting_user_id <", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("commenting_user_id <=", value, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdIn(List<Integer> values) {
            addCriterion("commenting_user_id in", values, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdNotIn(List<Integer> values) {
            addCriterion("commenting_user_id not in", values, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdBetween(Integer value1, Integer value2) {
            addCriterion("commenting_user_id between", value1, value2, "commentingUserId");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commenting_user_id not between", value1, value2, "commentingUserId");
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

        public Criteria andCommentingUserIsNull() {
            addCriterion("commenting_user is null");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIsNotNull() {
            addCriterion("commenting_user is not null");
            return (Criteria) this;
        }

        public Criteria andCommentingUserEqualTo(String value) {
            addCriterion("commenting_user =", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserNotEqualTo(String value) {
            addCriterion("commenting_user <>", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserGreaterThan(String value) {
            addCriterion("commenting_user >", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserGreaterThanOrEqualTo(String value) {
            addCriterion("commenting_user >=", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserLessThan(String value) {
            addCriterion("commenting_user <", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserLessThanOrEqualTo(String value) {
            addCriterion("commenting_user <=", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserLike(String value) {
            addCriterion("commenting_user ilike", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserNotLike(String value) {
            addCriterion("commenting_user not ilike", value, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserIn(List<String> values) {
            addCriterion("commenting_user in", values, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserNotIn(List<String> values) {
            addCriterion("commenting_user not in", values, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserBetween(String value1, String value2) {
            addCriterion("commenting_user between", value1, value2, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andCommentingUserNotBetween(String value1, String value2) {
            addCriterion("commenting_user not between", value1, value2, "commentingUser");
            return (Criteria) this;
        }

        public Criteria andDescriptionContains(String value) {
            addCriterion("description ilike", LikePatterns.contains(value), "description");
            return (Criteria) this;
        }

        public Criteria andCommentingUserContains(String value) {
            addCriterion("commenting_user ilike", LikePatterns.contains(value), "commentingUser");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_karma_view")
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