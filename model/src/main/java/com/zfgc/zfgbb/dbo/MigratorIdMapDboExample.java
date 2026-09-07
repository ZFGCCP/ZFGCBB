package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class MigratorIdMapDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public MigratorIdMapDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
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

        public Criteria andMigratorIdMapIdIsNull() {
            addCriterion("migrator_id_map_id is null");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdIsNotNull() {
            addCriterion("migrator_id_map_id is not null");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdEqualTo(Long value) {
            addCriterion("migrator_id_map_id =", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdNotEqualTo(Long value) {
            addCriterion("migrator_id_map_id <>", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdGreaterThan(Long value) {
            addCriterion("migrator_id_map_id >", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdGreaterThanOrEqualTo(Long value) {
            addCriterion("migrator_id_map_id >=", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdLessThan(Long value) {
            addCriterion("migrator_id_map_id <", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdLessThanOrEqualTo(Long value) {
            addCriterion("migrator_id_map_id <=", value, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdIn(List<Long> values) {
            addCriterion("migrator_id_map_id in", values, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdNotIn(List<Long> values) {
            addCriterion("migrator_id_map_id not in", values, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdBetween(Long value1, Long value2) {
            addCriterion("migrator_id_map_id between", value1, value2, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andMigratorIdMapIdNotBetween(Long value1, Long value2) {
            addCriterion("migrator_id_map_id not between", value1, value2, "migratorIdMapId");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNull() {
            addCriterion("entity_type is null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNotNull() {
            addCriterion("entity_type is not null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeEqualTo(String value) {
            addCriterion("entity_type =", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotEqualTo(String value) {
            addCriterion("entity_type <>", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThan(String value) {
            addCriterion("entity_type >", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("entity_type >=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThan(String value) {
            addCriterion("entity_type <", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThanOrEqualTo(String value) {
            addCriterion("entity_type <=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLike(String value) {
            addCriterion("entity_type ilike", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotLike(String value) {
            addCriterion("entity_type not ilike", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIn(List<String> values) {
            addCriterion("entity_type in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotIn(List<String> values) {
            addCriterion("entity_type not in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeBetween(String value1, String value2) {
            addCriterion("entity_type between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotBetween(String value1, String value2) {
            addCriterion("entity_type not between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andLegacyIdIsNull() {
            addCriterion("legacy_id is null");
            return (Criteria) this;
        }

        public Criteria andLegacyIdIsNotNull() {
            addCriterion("legacy_id is not null");
            return (Criteria) this;
        }

        public Criteria andLegacyIdEqualTo(Integer value) {
            addCriterion("legacy_id =", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdNotEqualTo(Integer value) {
            addCriterion("legacy_id <>", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdGreaterThan(Integer value) {
            addCriterion("legacy_id >", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("legacy_id >=", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdLessThan(Integer value) {
            addCriterion("legacy_id <", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdLessThanOrEqualTo(Integer value) {
            addCriterion("legacy_id <=", value, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdIn(List<Integer> values) {
            addCriterion("legacy_id in", values, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdNotIn(List<Integer> values) {
            addCriterion("legacy_id not in", values, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdBetween(Integer value1, Integer value2) {
            addCriterion("legacy_id between", value1, value2, "legacyId");
            return (Criteria) this;
        }

        public Criteria andLegacyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("legacy_id not between", value1, value2, "legacyId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdIsNull() {
            addCriterion("zfgbb_id is null");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdIsNotNull() {
            addCriterion("zfgbb_id is not null");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdEqualTo(Integer value) {
            addCriterion("zfgbb_id =", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdNotEqualTo(Integer value) {
            addCriterion("zfgbb_id <>", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdGreaterThan(Integer value) {
            addCriterion("zfgbb_id >", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("zfgbb_id >=", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdLessThan(Integer value) {
            addCriterion("zfgbb_id <", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdLessThanOrEqualTo(Integer value) {
            addCriterion("zfgbb_id <=", value, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdIn(List<Integer> values) {
            addCriterion("zfgbb_id in", values, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdNotIn(List<Integer> values) {
            addCriterion("zfgbb_id not in", values, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdBetween(Integer value1, Integer value2) {
            addCriterion("zfgbb_id between", value1, value2, "zfgbbId");
            return (Criteria) this;
        }

        public Criteria andZfgbbIdNotBetween(Integer value1, Integer value2) {
            addCriterion("zfgbb_id not between", value1, value2, "zfgbbId");
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

        public Criteria andEntityTypeContains(String value) {
            addCriterion("entity_type ilike", LikePatterns.contains(value), "entityType");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
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