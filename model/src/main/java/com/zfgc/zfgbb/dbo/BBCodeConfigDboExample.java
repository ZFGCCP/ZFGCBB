package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class BBCodeConfigDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public BBCodeConfigDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
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

        public Criteria andBbCodeConfigIdIsNull() {
            addCriterion("bb_code_config_id is null");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdIsNotNull() {
            addCriterion("bb_code_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdEqualTo(Integer value) {
            addCriterion("bb_code_config_id =", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotEqualTo(Integer value) {
            addCriterion("bb_code_config_id <>", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdGreaterThan(Integer value) {
            addCriterion("bb_code_config_id >", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bb_code_config_id >=", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdLessThan(Integer value) {
            addCriterion("bb_code_config_id <", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdLessThanOrEqualTo(Integer value) {
            addCriterion("bb_code_config_id <=", value, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdIn(List<Integer> values) {
            addCriterion("bb_code_config_id in", values, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotIn(List<Integer> values) {
            addCriterion("bb_code_config_id not in", values, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_config_id between", value1, value2, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andBbCodeConfigIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_config_id not between", value1, value2, "bbCodeConfigId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code ilike", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not ilike", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andEndTagIsNull() {
            addCriterion("end_tag is null");
            return (Criteria) this;
        }

        public Criteria andEndTagIsNotNull() {
            addCriterion("end_tag is not null");
            return (Criteria) this;
        }

        public Criteria andEndTagEqualTo(String value) {
            addCriterion("end_tag =", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagNotEqualTo(String value) {
            addCriterion("end_tag <>", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagGreaterThan(String value) {
            addCriterion("end_tag >", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagGreaterThanOrEqualTo(String value) {
            addCriterion("end_tag >=", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagLessThan(String value) {
            addCriterion("end_tag <", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagLessThanOrEqualTo(String value) {
            addCriterion("end_tag <=", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagLike(String value) {
            addCriterion("end_tag ilike", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagNotLike(String value) {
            addCriterion("end_tag not ilike", value, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagIn(List<String> values) {
            addCriterion("end_tag in", values, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagNotIn(List<String> values) {
            addCriterion("end_tag not in", values, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagBetween(String value1, String value2) {
            addCriterion("end_tag between", value1, value2, "endTag");
            return (Criteria) this;
        }

        public Criteria andEndTagNotBetween(String value1, String value2) {
            addCriterion("end_tag not between", value1, value2, "endTag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagIsNull() {
            addCriterion("process_content_flag is null");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagIsNotNull() {
            addCriterion("process_content_flag is not null");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagEqualTo(Boolean value) {
            addCriterion("process_content_flag =", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagNotEqualTo(Boolean value) {
            addCriterion("process_content_flag <>", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagGreaterThan(Boolean value) {
            addCriterion("process_content_flag >", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("process_content_flag >=", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagLessThan(Boolean value) {
            addCriterion("process_content_flag <", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("process_content_flag <=", value, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagIn(List<Boolean> values) {
            addCriterion("process_content_flag in", values, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagNotIn(List<Boolean> values) {
            addCriterion("process_content_flag not in", values, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("process_content_flag between", value1, value2, "processContentFlag");
            return (Criteria) this;
        }

        public Criteria andProcessContentFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("process_content_flag not between", value1, value2, "processContentFlag");
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

        public Criteria andSelfClosingFlagIsNull() {
            addCriterion("self_closing_flag is null");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagIsNotNull() {
            addCriterion("self_closing_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagEqualTo(Boolean value) {
            addCriterion("self_closing_flag =", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagNotEqualTo(Boolean value) {
            addCriterion("self_closing_flag <>", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagGreaterThan(Boolean value) {
            addCriterion("self_closing_flag >", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("self_closing_flag >=", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagLessThan(Boolean value) {
            addCriterion("self_closing_flag <", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("self_closing_flag <=", value, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagIn(List<Boolean> values) {
            addCriterion("self_closing_flag in", values, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagNotIn(List<Boolean> values) {
            addCriterion("self_closing_flag not in", values, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("self_closing_flag between", value1, value2, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andSelfClosingFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("self_closing_flag not between", value1, value2, "selfClosingFlag");
            return (Criteria) this;
        }

        public Criteria andCodeContains(String value) {
            addCriterion("code ilike", LikePatterns.contains(value), "code");
            return (Criteria) this;
        }

        public Criteria andEndTagContains(String value) {
            addCriterion("end_tag ilike", LikePatterns.contains(value), "endTag");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_config")
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