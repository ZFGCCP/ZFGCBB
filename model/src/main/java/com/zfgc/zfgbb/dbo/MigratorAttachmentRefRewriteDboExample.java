package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class MigratorAttachmentRefRewriteDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public MigratorAttachmentRefRewriteDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
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

        public Criteria andMessageHistoryIdIsNull() {
            addCriterion("message_history_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdIsNotNull() {
            addCriterion("message_history_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdEqualTo(Integer value) {
            addCriterion("message_history_id =", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdNotEqualTo(Integer value) {
            addCriterion("message_history_id <>", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdGreaterThan(Integer value) {
            addCriterion("message_history_id >", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_history_id >=", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdLessThan(Integer value) {
            addCriterion("message_history_id <", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_history_id <=", value, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdIn(List<Integer> values) {
            addCriterion("message_history_id in", values, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdNotIn(List<Integer> values) {
            addCriterion("message_history_id not in", values, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdBetween(Integer value1, Integer value2) {
            addCriterion("message_history_id between", value1, value2, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andMessageHistoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_history_id not between", value1, value2, "messageHistoryId");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsIsNull() {
            addCriterion("rewritten_ts is null");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsIsNotNull() {
            addCriterion("rewritten_ts is not null");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsEqualTo(OffsetDateTime value) {
            addCriterion("rewritten_ts =", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsNotEqualTo(OffsetDateTime value) {
            addCriterion("rewritten_ts <>", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsGreaterThan(OffsetDateTime value) {
            addCriterion("rewritten_ts >", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("rewritten_ts >=", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsLessThan(OffsetDateTime value) {
            addCriterion("rewritten_ts <", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("rewritten_ts <=", value, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsIn(List<OffsetDateTime> values) {
            addCriterion("rewritten_ts in", values, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsNotIn(List<OffsetDateTime> values) {
            addCriterion("rewritten_ts not in", values, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("rewritten_ts between", value1, value2, "rewrittenTs");
            return (Criteria) this;
        }

        public Criteria andRewrittenTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("rewritten_ts not between", value1, value2, "rewrittenTs");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
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