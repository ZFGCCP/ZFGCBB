package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserWarningDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public UserWarningDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
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

        public Criteria andUserWarningIdIsNull() {
            addCriterion("user_warning_id is null");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdIsNotNull() {
            addCriterion("user_warning_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdEqualTo(Integer value) {
            addCriterion("user_warning_id =", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdNotEqualTo(Integer value) {
            addCriterion("user_warning_id <>", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdGreaterThan(Integer value) {
            addCriterion("user_warning_id >", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_warning_id >=", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdLessThan(Integer value) {
            addCriterion("user_warning_id <", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_warning_id <=", value, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdIn(List<Integer> values) {
            addCriterion("user_warning_id in", values, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdNotIn(List<Integer> values) {
            addCriterion("user_warning_id not in", values, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdBetween(Integer value1, Integer value2) {
            addCriterion("user_warning_id between", value1, value2, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserWarningIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_warning_id not between", value1, value2, "userWarningId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdIsNull() {
            addCriterion("issued_by_user_id is null");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdIsNotNull() {
            addCriterion("issued_by_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdEqualTo(Integer value) {
            addCriterion("issued_by_user_id =", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdNotEqualTo(Integer value) {
            addCriterion("issued_by_user_id <>", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdGreaterThan(Integer value) {
            addCriterion("issued_by_user_id >", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("issued_by_user_id >=", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdLessThan(Integer value) {
            addCriterion("issued_by_user_id <", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("issued_by_user_id <=", value, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdIn(List<Integer> values) {
            addCriterion("issued_by_user_id in", values, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdNotIn(List<Integer> values) {
            addCriterion("issued_by_user_id not in", values, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdBetween(Integer value1, Integer value2) {
            addCriterion("issued_by_user_id between", value1, value2, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("issued_by_user_id not between", value1, value2, "issuedByUserId");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameIsNull() {
            addCriterion("issued_by_name is null");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameIsNotNull() {
            addCriterion("issued_by_name is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameEqualTo(String value) {
            addCriterion("issued_by_name =", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameNotEqualTo(String value) {
            addCriterion("issued_by_name <>", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameGreaterThan(String value) {
            addCriterion("issued_by_name >", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameGreaterThanOrEqualTo(String value) {
            addCriterion("issued_by_name >=", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameLessThan(String value) {
            addCriterion("issued_by_name <", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameLessThanOrEqualTo(String value) {
            addCriterion("issued_by_name <=", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameLike(String value) {
            addCriterion("issued_by_name ilike", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameNotLike(String value) {
            addCriterion("issued_by_name not ilike", value, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameIn(List<String> values) {
            addCriterion("issued_by_name in", values, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameNotIn(List<String> values) {
            addCriterion("issued_by_name not in", values, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameBetween(String value1, String value2) {
            addCriterion("issued_by_name between", value1, value2, "issuedByName");
            return (Criteria) this;
        }

        public Criteria andIssuedByNameNotBetween(String value1, String value2) {
            addCriterion("issued_by_name not between", value1, value2, "issuedByName");
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

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Integer value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Integer value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Integer value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Integer value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Integer value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Integer> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Integer> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Integer value1, Integer value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andIssuedTsIsNull() {
            addCriterion("issued_ts is null");
            return (Criteria) this;
        }

        public Criteria andIssuedTsIsNotNull() {
            addCriterion("issued_ts is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedTsEqualTo(OffsetDateTime value) {
            addCriterion("issued_ts =", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("issued_ts <>", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsGreaterThan(OffsetDateTime value) {
            addCriterion("issued_ts >", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("issued_ts >=", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsLessThan(OffsetDateTime value) {
            addCriterion("issued_ts <", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("issued_ts <=", value, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsIn(List<OffsetDateTime> values) {
            addCriterion("issued_ts in", values, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("issued_ts not in", values, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("issued_ts between", value1, value2, "issuedTs");
            return (Criteria) this;
        }

        public Criteria andIssuedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("issued_ts not between", value1, value2, "issuedTs");
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

        public Criteria andIssuedByNameContains(String value) {
            addCriterion("issued_by_name ilike", LikePatterns.contains(value), "issuedByName");
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
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