package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class BBCodeAttributeDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public BBCodeAttributeDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
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

        public Criteria andBbCodeAttributeIdIsNull() {
            addCriterion("bb_code_attribute_id is null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdIsNotNull() {
            addCriterion("bb_code_attribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdEqualTo(Integer value) {
            addCriterion("bb_code_attribute_id =", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdNotEqualTo(Integer value) {
            addCriterion("bb_code_attribute_id <>", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdGreaterThan(Integer value) {
            addCriterion("bb_code_attribute_id >", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bb_code_attribute_id >=", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdLessThan(Integer value) {
            addCriterion("bb_code_attribute_id <", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdLessThanOrEqualTo(Integer value) {
            addCriterion("bb_code_attribute_id <=", value, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdIn(List<Integer> values) {
            addCriterion("bb_code_attribute_id in", values, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdNotIn(List<Integer> values) {
            addCriterion("bb_code_attribute_id not in", values, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_attribute_id between", value1, value2, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andBbCodeAttributeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bb_code_attribute_id not between", value1, value2, "bbCodeAttributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeIsNull() {
            addCriterion("attribute_data_type is null");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeIsNotNull() {
            addCriterion("attribute_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeEqualTo(Integer value) {
            addCriterion("attribute_data_type =", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeNotEqualTo(Integer value) {
            addCriterion("attribute_data_type <>", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeGreaterThan(Integer value) {
            addCriterion("attribute_data_type >", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("attribute_data_type >=", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeLessThan(Integer value) {
            addCriterion("attribute_data_type <", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeLessThanOrEqualTo(Integer value) {
            addCriterion("attribute_data_type <=", value, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeIn(List<Integer> values) {
            addCriterion("attribute_data_type in", values, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeNotIn(List<Integer> values) {
            addCriterion("attribute_data_type not in", values, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeBetween(Integer value1, Integer value2) {
            addCriterion("attribute_data_type between", value1, value2, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeDataTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("attribute_data_type not between", value1, value2, "attributeDataType");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexIsNull() {
            addCriterion("attribute_index is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexIsNotNull() {
            addCriterion("attribute_index is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexEqualTo(Integer value) {
            addCriterion("attribute_index =", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexNotEqualTo(Integer value) {
            addCriterion("attribute_index <>", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexGreaterThan(Integer value) {
            addCriterion("attribute_index >", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("attribute_index >=", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexLessThan(Integer value) {
            addCriterion("attribute_index <", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexLessThanOrEqualTo(Integer value) {
            addCriterion("attribute_index <=", value, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexIn(List<Integer> values) {
            addCriterion("attribute_index in", values, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexNotIn(List<Integer> values) {
            addCriterion("attribute_index not in", values, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexBetween(Integer value1, Integer value2) {
            addCriterion("attribute_index between", value1, value2, "attributeIndex");
            return (Criteria) this;
        }

        public Criteria andAttributeIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("attribute_index not between", value1, value2, "attributeIndex");
            return (Criteria) this;
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name ilike", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not ilike", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andNameContains(String value) {
            addCriterion("name ilike", LikePatterns.contains(value), "name");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.bb_code_attribute")
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