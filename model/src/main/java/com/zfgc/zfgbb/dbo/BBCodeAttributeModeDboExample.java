package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class BBCodeAttributeModeDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public BBCodeAttributeModeDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
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

        public Criteria andBbCodeAttributeModeIdIsNull() {
            addCriterion("bb_code_attribute_mode_id is null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdIsNotNull() {
            addCriterion("bb_code_attribute_mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdEqualTo(Integer value) {
            addCriterion("bb_code_attribute_mode_id =", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotEqualTo(Integer value) {
            addCriterion("bb_code_attribute_mode_id <>", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdGreaterThan(Integer value) {
            addCriterion("bb_code_attribute_mode_id >", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bb_code_attribute_mode_id >=", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdLessThan(Integer value) {
            addCriterion("bb_code_attribute_mode_id <", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdLessThanOrEqualTo(Integer value) {
            addCriterion("bb_code_attribute_mode_id <=", value, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdIn(List<Integer> values) {
            addCriterion("bb_code_attribute_mode_id in", values, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotIn(List<Integer> values) {
            addCriterion("bb_code_attribute_mode_id not in", values, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_attribute_mode_id between", value1, value2, "bbCodeAttributeModeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeModeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_attribute_mode_id not between", value1, value2, "bbCodeAttributeModeId");
            return (Criteria) this;
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

        public Criteria andContentIsAttributeFlagIsNull() {
            addCriterion("content_is_attribute_flag is null");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagIsNotNull() {
            addCriterion("content_is_attribute_flag is not null");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagEqualTo(Boolean value) {
            addCriterion("content_is_attribute_flag =", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotEqualTo(Boolean value) {
            addCriterion("content_is_attribute_flag <>", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagGreaterThan(Boolean value) {
            addCriterion("content_is_attribute_flag >", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("content_is_attribute_flag >=", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagLessThan(Boolean value) {
            addCriterion("content_is_attribute_flag <", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("content_is_attribute_flag <=", value, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagIn(List<Boolean> values) {
            addCriterion("content_is_attribute_flag in", values, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotIn(List<Boolean> values) {
            addCriterion("content_is_attribute_flag not in", values, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("content_is_attribute_flag between", value1, value2, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andContentIsAttributeFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("content_is_attribute_flag not between", value1, value2, "contentIsAttributeFlag");
            return (Criteria) this;
        }

        public Criteria andOpenTagIsNull() {
            addCriterion("open_tag is null");
            return (Criteria) this;
        }

        public Criteria andOpenTagIsNotNull() {
            addCriterion("open_tag is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTagEqualTo(String value) {
            addCriterion("open_tag =", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotEqualTo(String value) {
            addCriterion("open_tag <>", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagGreaterThan(String value) {
            addCriterion("open_tag >", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagGreaterThanOrEqualTo(String value) {
            addCriterion("open_tag >=", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLessThan(String value) {
            addCriterion("open_tag <", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLessThanOrEqualTo(String value) {
            addCriterion("open_tag <=", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagLike(String value) {
            addCriterion("open_tag ilike", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotLike(String value) {
            addCriterion("open_tag not ilike", value, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagIn(List<String> values) {
            addCriterion("open_tag in", values, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotIn(List<String> values) {
            addCriterion("open_tag not in", values, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagBetween(String value1, String value2) {
            addCriterion("open_tag between", value1, value2, "openTag");
            return (Criteria) this;
        }

        public Criteria andOpenTagNotBetween(String value1, String value2) {
            addCriterion("open_tag not between", value1, value2, "openTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagIsNull() {
            addCriterion("close_tag is null");
            return (Criteria) this;
        }

        public Criteria andCloseTagIsNotNull() {
            addCriterion("close_tag is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTagEqualTo(String value) {
            addCriterion("close_tag =", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotEqualTo(String value) {
            addCriterion("close_tag <>", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagGreaterThan(String value) {
            addCriterion("close_tag >", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagGreaterThanOrEqualTo(String value) {
            addCriterion("close_tag >=", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLessThan(String value) {
            addCriterion("close_tag <", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLessThanOrEqualTo(String value) {
            addCriterion("close_tag <=", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagLike(String value) {
            addCriterion("close_tag ilike", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotLike(String value) {
            addCriterion("close_tag not ilike", value, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagIn(List<String> values) {
            addCriterion("close_tag in", values, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotIn(List<String> values) {
            addCriterion("close_tag not in", values, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagBetween(String value1, String value2) {
            addCriterion("close_tag between", value1, value2, "closeTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagNotBetween(String value1, String value2) {
            addCriterion("close_tag not between", value1, value2, "closeTag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIsNull() {
            addCriterion("output_content_flag is null");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIsNotNull() {
            addCriterion("output_content_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagEqualTo(Boolean value) {
            addCriterion("output_content_flag =", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotEqualTo(Boolean value) {
            addCriterion("output_content_flag <>", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagGreaterThan(Boolean value) {
            addCriterion("output_content_flag >", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("output_content_flag >=", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagLessThan(Boolean value) {
            addCriterion("output_content_flag <", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("output_content_flag <=", value, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagIn(List<Boolean> values) {
            addCriterion("output_content_flag in", values, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotIn(List<Boolean> values) {
            addCriterion("output_content_flag not in", values, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("output_content_flag between", value1, value2, "outputContentFlag");
            return (Criteria) this;
        }

        public Criteria andOutputContentFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("output_content_flag not between", value1, value2, "outputContentFlag");
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

        public Criteria andOpenTagContains(String value) {
            addCriterion("open_tag ilike", LikePatterns.contains(value), "openTag");
            return (Criteria) this;
        }

        public Criteria andCloseTagContains(String value) {
            addCriterion("close_tag ilike", LikePatterns.contains(value), "closeTag");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute_mode")
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