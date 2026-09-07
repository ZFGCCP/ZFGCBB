package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

public class BrUserPermissionDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public BrUserPermissionDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
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

        public Criteria andBrUserPermissionIdIsNull() {
            addCriterion("br_user_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdIsNotNull() {
            addCriterion("br_user_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdEqualTo(Integer value) {
            addCriterion("br_user_permission_id =", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdNotEqualTo(Integer value) {
            addCriterion("br_user_permission_id <>", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdGreaterThan(Integer value) {
            addCriterion("br_user_permission_id >", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("br_user_permission_id >=", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdLessThan(Integer value) {
            addCriterion("br_user_permission_id <", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("br_user_permission_id <=", value, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdIn(List<Integer> values) {
            addCriterion("br_user_permission_id in", values, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdNotIn(List<Integer> values) {
            addCriterion("br_user_permission_id not in", values, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("br_user_permission_id between", value1, value2, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andBrUserPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("br_user_permission_id not between", value1, value2, "brUserPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIsNull() {
            addCriterion("user_permission_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIsNotNull() {
            addCriterion("user_permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdEqualTo(Integer value) {
            addCriterion("user_permission_id =", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotEqualTo(Integer value) {
            addCriterion("user_permission_id <>", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThan(Integer value) {
            addCriterion("user_permission_id >", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_permission_id >=", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThan(Integer value) {
            addCriterion("user_permission_id <", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_permission_id <=", value, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdIn(List<Integer> values) {
            addCriterion("user_permission_id in", values, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotIn(List<Integer> values) {
            addCriterion("user_permission_id not in", values, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_permission_id between", value1, value2, "userPermissionId");
            return (Criteria) this;
        }

        public Criteria andUserPermissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_permission_id not between", value1, value2, "userPermissionId");
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
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
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