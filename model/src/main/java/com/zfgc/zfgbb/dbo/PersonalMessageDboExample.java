package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonalMessageDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public PersonalMessageDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
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

        public Criteria andPersonalMessageIdIsNull() {
            addCriterion("personal_message_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdIsNotNull() {
            addCriterion("personal_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdEqualTo(Integer value) {
            addCriterion("personal_message_id =", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdNotEqualTo(Integer value) {
            addCriterion("personal_message_id <>", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdGreaterThan(Integer value) {
            addCriterion("personal_message_id >", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_message_id >=", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdLessThan(Integer value) {
            addCriterion("personal_message_id <", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("personal_message_id <=", value, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdIn(List<Integer> values) {
            addCriterion("personal_message_id in", values, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdNotIn(List<Integer> values) {
            addCriterion("personal_message_id not in", values, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_id between", value1, value2, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_id not between", value1, value2, "personalMessageId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdIsNull() {
            addCriterion("personal_message_conversation_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdIsNotNull() {
            addCriterion("personal_message_conversation_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdEqualTo(Integer value) {
            addCriterion("personal_message_conversation_id =", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdNotEqualTo(Integer value) {
            addCriterion("personal_message_conversation_id <>", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdGreaterThan(Integer value) {
            addCriterion("personal_message_conversation_id >", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_message_conversation_id >=", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdLessThan(Integer value) {
            addCriterion("personal_message_conversation_id <", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdLessThanOrEqualTo(Integer value) {
            addCriterion("personal_message_conversation_id <=", value, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdIn(List<Integer> values) {
            addCriterion("personal_message_conversation_id in", values, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdNotIn(List<Integer> values) {
            addCriterion("personal_message_conversation_id not in", values, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_conversation_id between", value1, value2, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageConversationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_conversation_id not between", value1, value2, "personalMessageConversationId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdIsNull() {
            addCriterion("sender_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdIsNotNull() {
            addCriterion("sender_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdEqualTo(Integer value) {
            addCriterion("sender_user_id =", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdNotEqualTo(Integer value) {
            addCriterion("sender_user_id <>", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdGreaterThan(Integer value) {
            addCriterion("sender_user_id >", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sender_user_id >=", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdLessThan(Integer value) {
            addCriterion("sender_user_id <", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sender_user_id <=", value, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdIn(List<Integer> values) {
            addCriterion("sender_user_id in", values, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdNotIn(List<Integer> values) {
            addCriterion("sender_user_id not in", values, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sender_user_id between", value1, value2, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sender_user_id not between", value1, value2, "senderUserId");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNull() {
            addCriterion("sender_name is null");
            return (Criteria) this;
        }

        public Criteria andSenderNameIsNotNull() {
            addCriterion("sender_name is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNameEqualTo(String value) {
            addCriterion("sender_name =", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotEqualTo(String value) {
            addCriterion("sender_name <>", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThan(String value) {
            addCriterion("sender_name >", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_name >=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThan(String value) {
            addCriterion("sender_name <", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLessThanOrEqualTo(String value) {
            addCriterion("sender_name <=", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameLike(String value) {
            addCriterion("sender_name ilike", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotLike(String value) {
            addCriterion("sender_name not ilike", value, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameIn(List<String> values) {
            addCriterion("sender_name in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotIn(List<String> values) {
            addCriterion("sender_name not in", values, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameBetween(String value1, String value2) {
            addCriterion("sender_name between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andSenderNameNotBetween(String value1, String value2) {
            addCriterion("sender_name not between", value1, value2, "senderName");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body ilike", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not ilike", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andSentTsIsNull() {
            addCriterion("sent_ts is null");
            return (Criteria) this;
        }

        public Criteria andSentTsIsNotNull() {
            addCriterion("sent_ts is not null");
            return (Criteria) this;
        }

        public Criteria andSentTsEqualTo(OffsetDateTime value) {
            addCriterion("sent_ts =", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsNotEqualTo(OffsetDateTime value) {
            addCriterion("sent_ts <>", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsGreaterThan(OffsetDateTime value) {
            addCriterion("sent_ts >", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("sent_ts >=", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsLessThan(OffsetDateTime value) {
            addCriterion("sent_ts <", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("sent_ts <=", value, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsIn(List<OffsetDateTime> values) {
            addCriterion("sent_ts in", values, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsNotIn(List<OffsetDateTime> values) {
            addCriterion("sent_ts not in", values, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("sent_ts between", value1, value2, "sentTs");
            return (Criteria) this;
        }

        public Criteria andSentTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("sent_ts not between", value1, value2, "sentTs");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderIsNull() {
            addCriterion("deleted_by_sender is null");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderIsNotNull() {
            addCriterion("deleted_by_sender is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderEqualTo(Boolean value) {
            addCriterion("deleted_by_sender =", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderNotEqualTo(Boolean value) {
            addCriterion("deleted_by_sender <>", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderGreaterThan(Boolean value) {
            addCriterion("deleted_by_sender >", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted_by_sender >=", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderLessThan(Boolean value) {
            addCriterion("deleted_by_sender <", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted_by_sender <=", value, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderIn(List<Boolean> values) {
            addCriterion("deleted_by_sender in", values, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderNotIn(List<Boolean> values) {
            addCriterion("deleted_by_sender not in", values, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_by_sender between", value1, value2, "deletedBySender");
            return (Criteria) this;
        }

        public Criteria andDeletedBySenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_by_sender not between", value1, value2, "deletedBySender");
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

        public Criteria andSenderNameContains(String value) {
            addCriterion("sender_name ilike", LikePatterns.contains(value), "senderName");
            return (Criteria) this;
        }

        public Criteria andBodyContains(String value) {
            addCriterion("body ilike", LikePatterns.contains(value), "body");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
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