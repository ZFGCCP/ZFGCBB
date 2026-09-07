package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRefreshTokenDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public UserRefreshTokenDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
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

        public Criteria andUserRefreshTokenIdIsNull() {
            addCriterion("user_refresh_token_id is null");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdIsNotNull() {
            addCriterion("user_refresh_token_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdEqualTo(Integer value) {
            addCriterion("user_refresh_token_id =", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdNotEqualTo(Integer value) {
            addCriterion("user_refresh_token_id <>", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdGreaterThan(Integer value) {
            addCriterion("user_refresh_token_id >", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_refresh_token_id >=", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdLessThan(Integer value) {
            addCriterion("user_refresh_token_id <", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_refresh_token_id <=", value, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdIn(List<Integer> values) {
            addCriterion("user_refresh_token_id in", values, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdNotIn(List<Integer> values) {
            addCriterion("user_refresh_token_id not in", values, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdBetween(Integer value1, Integer value2) {
            addCriterion("user_refresh_token_id between", value1, value2, "userRefreshTokenId");
            return (Criteria) this;
        }

        public Criteria andUserRefreshTokenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_refresh_token_id not between", value1, value2, "userRefreshTokenId");
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

        public Criteria andTokenHashIsNull() {
            addCriterion("token_hash is null");
            return (Criteria) this;
        }

        public Criteria andTokenHashIsNotNull() {
            addCriterion("token_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTokenHashEqualTo(String value) {
            addCriterion("token_hash =", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashNotEqualTo(String value) {
            addCriterion("token_hash <>", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashGreaterThan(String value) {
            addCriterion("token_hash >", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashGreaterThanOrEqualTo(String value) {
            addCriterion("token_hash >=", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashLessThan(String value) {
            addCriterion("token_hash <", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashLessThanOrEqualTo(String value) {
            addCriterion("token_hash <=", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashLike(String value) {
            addCriterion("token_hash ilike", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashNotLike(String value) {
            addCriterion("token_hash not ilike", value, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashIn(List<String> values) {
            addCriterion("token_hash in", values, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashNotIn(List<String> values) {
            addCriterion("token_hash not in", values, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashBetween(String value1, String value2) {
            addCriterion("token_hash between", value1, value2, "tokenHash");
            return (Criteria) this;
        }

        public Criteria andTokenHashNotBetween(String value1, String value2) {
            addCriterion("token_hash not between", value1, value2, "tokenHash");
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

        public Criteria andExpiresTsIsNull() {
            addCriterion("expires_ts is null");
            return (Criteria) this;
        }

        public Criteria andExpiresTsIsNotNull() {
            addCriterion("expires_ts is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresTsEqualTo(OffsetDateTime value) {
            addCriterion("expires_ts =", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsNotEqualTo(OffsetDateTime value) {
            addCriterion("expires_ts <>", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsGreaterThan(OffsetDateTime value) {
            addCriterion("expires_ts >", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("expires_ts >=", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsLessThan(OffsetDateTime value) {
            addCriterion("expires_ts <", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("expires_ts <=", value, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsIn(List<OffsetDateTime> values) {
            addCriterion("expires_ts in", values, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsNotIn(List<OffsetDateTime> values) {
            addCriterion("expires_ts not in", values, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("expires_ts between", value1, value2, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andExpiresTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("expires_ts not between", value1, value2, "expiresTs");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagIsNull() {
            addCriterion("revoked_flag is null");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagIsNotNull() {
            addCriterion("revoked_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagEqualTo(Boolean value) {
            addCriterion("revoked_flag =", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagNotEqualTo(Boolean value) {
            addCriterion("revoked_flag <>", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagGreaterThan(Boolean value) {
            addCriterion("revoked_flag >", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("revoked_flag >=", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagLessThan(Boolean value) {
            addCriterion("revoked_flag <", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("revoked_flag <=", value, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagIn(List<Boolean> values) {
            addCriterion("revoked_flag in", values, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagNotIn(List<Boolean> values) {
            addCriterion("revoked_flag not in", values, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("revoked_flag between", value1, value2, "revokedFlag");
            return (Criteria) this;
        }

        public Criteria andRevokedFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("revoked_flag not between", value1, value2, "revokedFlag");
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

        public Criteria andTokenHashContains(String value) {
            addCriterion("token_hash ilike", LikePatterns.contains(value), "tokenHash");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
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