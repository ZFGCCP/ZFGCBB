package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonalMessageRecipientDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public PersonalMessageRecipientDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
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

        public Criteria andPersonalMessageRecipientIdIsNull() {
            addCriterion("personal_message_recipient_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdIsNotNull() {
            addCriterion("personal_message_recipient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdEqualTo(Integer value) {
            addCriterion("personal_message_recipient_id =", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdNotEqualTo(Integer value) {
            addCriterion("personal_message_recipient_id <>", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdGreaterThan(Integer value) {
            addCriterion("personal_message_recipient_id >", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_message_recipient_id >=", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdLessThan(Integer value) {
            addCriterion("personal_message_recipient_id <", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdLessThanOrEqualTo(Integer value) {
            addCriterion("personal_message_recipient_id <=", value, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdIn(List<Integer> values) {
            addCriterion("personal_message_recipient_id in", values, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdNotIn(List<Integer> values) {
            addCriterion("personal_message_recipient_id not in", values, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_recipient_id between", value1, value2, "personalMessageRecipientId");
            return (Criteria) this;
        }

        public Criteria andPersonalMessageRecipientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_message_recipient_id not between", value1, value2, "personalMessageRecipientId");
            return (Criteria) this;
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

        public Criteria andRecipientUserIdIsNull() {
            addCriterion("recipient_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdIsNotNull() {
            addCriterion("recipient_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdEqualTo(Integer value) {
            addCriterion("recipient_user_id =", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdNotEqualTo(Integer value) {
            addCriterion("recipient_user_id <>", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdGreaterThan(Integer value) {
            addCriterion("recipient_user_id >", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recipient_user_id >=", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdLessThan(Integer value) {
            addCriterion("recipient_user_id <", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("recipient_user_id <=", value, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdIn(List<Integer> values) {
            addCriterion("recipient_user_id in", values, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdNotIn(List<Integer> values) {
            addCriterion("recipient_user_id not in", values, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdBetween(Integer value1, Integer value2) {
            addCriterion("recipient_user_id between", value1, value2, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andRecipientUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recipient_user_id not between", value1, value2, "recipientUserId");
            return (Criteria) this;
        }

        public Criteria andBccIsNull() {
            addCriterion("bcc is null");
            return (Criteria) this;
        }

        public Criteria andBccIsNotNull() {
            addCriterion("bcc is not null");
            return (Criteria) this;
        }

        public Criteria andBccEqualTo(Boolean value) {
            addCriterion("bcc =", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotEqualTo(Boolean value) {
            addCriterion("bcc <>", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccGreaterThan(Boolean value) {
            addCriterion("bcc >", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bcc >=", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccLessThan(Boolean value) {
            addCriterion("bcc <", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccLessThanOrEqualTo(Boolean value) {
            addCriterion("bcc <=", value, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccIn(List<Boolean> values) {
            addCriterion("bcc in", values, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotIn(List<Boolean> values) {
            addCriterion("bcc not in", values, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccBetween(Boolean value1, Boolean value2) {
            addCriterion("bcc between", value1, value2, "bcc");
            return (Criteria) this;
        }

        public Criteria andBccNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bcc not between", value1, value2, "bcc");
            return (Criteria) this;
        }

        public Criteria andReadFlagIsNull() {
            addCriterion("read_flag is null");
            return (Criteria) this;
        }

        public Criteria andReadFlagIsNotNull() {
            addCriterion("read_flag is not null");
            return (Criteria) this;
        }

        public Criteria andReadFlagEqualTo(Boolean value) {
            addCriterion("read_flag =", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotEqualTo(Boolean value) {
            addCriterion("read_flag <>", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagGreaterThan(Boolean value) {
            addCriterion("read_flag >", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("read_flag >=", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagLessThan(Boolean value) {
            addCriterion("read_flag <", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("read_flag <=", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagIn(List<Boolean> values) {
            addCriterion("read_flag in", values, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotIn(List<Boolean> values) {
            addCriterion("read_flag not in", values, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("read_flag between", value1, value2, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("read_flag not between", value1, value2, "readFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNull() {
            addCriterion("deleted_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIsNotNull() {
            addCriterion("deleted_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagEqualTo(Boolean value) {
            addCriterion("deleted_flag =", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotEqualTo(Boolean value) {
            addCriterion("deleted_flag <>", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThan(Boolean value) {
            addCriterion("deleted_flag >", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted_flag >=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThan(Boolean value) {
            addCriterion("deleted_flag <", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted_flag <=", value, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagIn(List<Boolean> values) {
            addCriterion("deleted_flag in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotIn(List<Boolean> values) {
            addCriterion("deleted_flag not in", values, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_flag between", value1, value2, "deletedFlag");
            return (Criteria) this;
        }

        public Criteria andDeletedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted_flag not between", value1, value2, "deletedFlag");
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
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
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