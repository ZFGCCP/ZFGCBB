package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public UserDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
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

        public Criteria andSsoKeyIsNull() {
            addCriterion("sso_key is null");
            return (Criteria) this;
        }

        public Criteria andSsoKeyIsNotNull() {
            addCriterion("sso_key is not null");
            return (Criteria) this;
        }

        public Criteria andSsoKeyEqualTo(String value) {
            addCriterion("sso_key =", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyNotEqualTo(String value) {
            addCriterion("sso_key <>", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyGreaterThan(String value) {
            addCriterion("sso_key >", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sso_key >=", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyLessThan(String value) {
            addCriterion("sso_key <", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyLessThanOrEqualTo(String value) {
            addCriterion("sso_key <=", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyLike(String value) {
            addCriterion("sso_key ilike", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyNotLike(String value) {
            addCriterion("sso_key not ilike", value, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyIn(List<String> values) {
            addCriterion("sso_key in", values, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyNotIn(List<String> values) {
            addCriterion("sso_key not in", values, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyBetween(String value1, String value2) {
            addCriterion("sso_key between", value1, value2, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andSsoKeyNotBetween(String value1, String value2) {
            addCriterion("sso_key not between", value1, value2, "ssoKey");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNull() {
            addCriterion("active_flag is null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNotNull() {
            addCriterion("active_flag is not null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagEqualTo(Boolean value) {
            addCriterion("active_flag =", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotEqualTo(Boolean value) {
            addCriterion("active_flag <>", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThan(Boolean value) {
            addCriterion("active_flag >", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("active_flag >=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThan(Boolean value) {
            addCriterion("active_flag <", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("active_flag <=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIn(List<Boolean> values) {
            addCriterion("active_flag in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotIn(List<Boolean> values) {
            addCriterion("active_flag not in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("active_flag between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("active_flag not between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name ilike", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not ilike", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name ilike", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not ilike", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIsNull() {
            addCriterion("migration_hash is null");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIsNotNull() {
            addCriterion("migration_hash is not null");
            return (Criteria) this;
        }

        public Criteria andMigrationHashEqualTo(String value) {
            addCriterion("migration_hash =", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotEqualTo(String value) {
            addCriterion("migration_hash <>", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashGreaterThan(String value) {
            addCriterion("migration_hash >", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashGreaterThanOrEqualTo(String value) {
            addCriterion("migration_hash >=", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLessThan(String value) {
            addCriterion("migration_hash <", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLessThanOrEqualTo(String value) {
            addCriterion("migration_hash <=", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashLike(String value) {
            addCriterion("migration_hash ilike", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotLike(String value) {
            addCriterion("migration_hash not ilike", value, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashIn(List<String> values) {
            addCriterion("migration_hash in", values, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotIn(List<String> values) {
            addCriterion("migration_hash not in", values, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashBetween(String value1, String value2) {
            addCriterion("migration_hash between", value1, value2, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andMigrationHashNotBetween(String value1, String value2) {
            addCriterion("migration_hash not between", value1, value2, "migrationHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashIsNull() {
            addCriterion("password_hash is null");
            return (Criteria) this;
        }

        public Criteria andPasswordHashIsNotNull() {
            addCriterion("password_hash is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordHashEqualTo(String value) {
            addCriterion("password_hash =", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashNotEqualTo(String value) {
            addCriterion("password_hash <>", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashGreaterThan(String value) {
            addCriterion("password_hash >", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashGreaterThanOrEqualTo(String value) {
            addCriterion("password_hash >=", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashLessThan(String value) {
            addCriterion("password_hash <", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashLessThanOrEqualTo(String value) {
            addCriterion("password_hash <=", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashLike(String value) {
            addCriterion("password_hash ilike", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashNotLike(String value) {
            addCriterion("password_hash not ilike", value, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashIn(List<String> values) {
            addCriterion("password_hash in", values, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashNotIn(List<String> values) {
            addCriterion("password_hash not in", values, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashBetween(String value1, String value2) {
            addCriterion("password_hash between", value1, value2, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashNotBetween(String value1, String value2) {
            addCriterion("password_hash not between", value1, value2, "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoIsNull() {
            addCriterion("password_algo is null");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoIsNotNull() {
            addCriterion("password_algo is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoEqualTo(String value) {
            addCriterion("password_algo =", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoNotEqualTo(String value) {
            addCriterion("password_algo <>", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoGreaterThan(String value) {
            addCriterion("password_algo >", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoGreaterThanOrEqualTo(String value) {
            addCriterion("password_algo >=", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoLessThan(String value) {
            addCriterion("password_algo <", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoLessThanOrEqualTo(String value) {
            addCriterion("password_algo <=", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoLike(String value) {
            addCriterion("password_algo ilike", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoNotLike(String value) {
            addCriterion("password_algo not ilike", value, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoIn(List<String> values) {
            addCriterion("password_algo in", values, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoNotIn(List<String> values) {
            addCriterion("password_algo not in", values, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoBetween(String value1, String value2) {
            addCriterion("password_algo between", value1, value2, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoNotBetween(String value1, String value2) {
            addCriterion("password_algo not between", value1, value2, "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIsNull() {
            addCriterion("password_salt is null");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIsNotNull() {
            addCriterion("password_salt is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltEqualTo(String value) {
            addCriterion("password_salt =", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotEqualTo(String value) {
            addCriterion("password_salt <>", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltGreaterThan(String value) {
            addCriterion("password_salt >", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltGreaterThanOrEqualTo(String value) {
            addCriterion("password_salt >=", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLessThan(String value) {
            addCriterion("password_salt <", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLessThanOrEqualTo(String value) {
            addCriterion("password_salt <=", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltLike(String value) {
            addCriterion("password_salt ilike", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotLike(String value) {
            addCriterion("password_salt not ilike", value, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltIn(List<String> values) {
            addCriterion("password_salt in", values, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotIn(List<String> values) {
            addCriterion("password_salt not in", values, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltBetween(String value1, String value2) {
            addCriterion("password_salt between", value1, value2, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltNotBetween(String value1, String value2) {
            addCriterion("password_salt not between", value1, value2, "passwordSalt");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsIsNull() {
            addCriterion("locked_until_ts is null");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsIsNotNull() {
            addCriterion("locked_until_ts is not null");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsEqualTo(OffsetDateTime value) {
            addCriterion("locked_until_ts =", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsNotEqualTo(OffsetDateTime value) {
            addCriterion("locked_until_ts <>", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsGreaterThan(OffsetDateTime value) {
            addCriterion("locked_until_ts >", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("locked_until_ts >=", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsLessThan(OffsetDateTime value) {
            addCriterion("locked_until_ts <", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("locked_until_ts <=", value, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsIn(List<OffsetDateTime> values) {
            addCriterion("locked_until_ts in", values, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsNotIn(List<OffsetDateTime> values) {
            addCriterion("locked_until_ts not in", values, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("locked_until_ts between", value1, value2, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andLockedUntilTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("locked_until_ts not between", value1, value2, "lockedUntilTs");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountIsNull() {
            addCriterion("failed_login_count is null");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountIsNotNull() {
            addCriterion("failed_login_count is not null");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountEqualTo(Integer value) {
            addCriterion("failed_login_count =", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountNotEqualTo(Integer value) {
            addCriterion("failed_login_count <>", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountGreaterThan(Integer value) {
            addCriterion("failed_login_count >", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed_login_count >=", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountLessThan(Integer value) {
            addCriterion("failed_login_count <", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountLessThanOrEqualTo(Integer value) {
            addCriterion("failed_login_count <=", value, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountIn(List<Integer> values) {
            addCriterion("failed_login_count in", values, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountNotIn(List<Integer> values) {
            addCriterion("failed_login_count not in", values, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountBetween(Integer value1, Integer value2) {
            addCriterion("failed_login_count between", value1, value2, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andFailedLoginCountNotBetween(Integer value1, Integer value2) {
            addCriterion("failed_login_count not between", value1, value2, "failedLoginCount");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsIsNull() {
            addCriterion("password_changed_ts is null");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsIsNotNull() {
            addCriterion("password_changed_ts is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsEqualTo(OffsetDateTime value) {
            addCriterion("password_changed_ts =", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("password_changed_ts <>", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsGreaterThan(OffsetDateTime value) {
            addCriterion("password_changed_ts >", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("password_changed_ts >=", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsLessThan(OffsetDateTime value) {
            addCriterion("password_changed_ts <", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("password_changed_ts <=", value, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsIn(List<OffsetDateTime> values) {
            addCriterion("password_changed_ts in", values, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("password_changed_ts not in", values, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("password_changed_ts between", value1, value2, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andPasswordChangedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("password_changed_ts not between", value1, value2, "passwordChangedTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsIsNull() {
            addCriterion("tokens_valid_after_ts is null");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsIsNotNull() {
            addCriterion("tokens_valid_after_ts is not null");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsEqualTo(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts =", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsNotEqualTo(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts <>", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsGreaterThan(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts >", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts >=", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsLessThan(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts <", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("tokens_valid_after_ts <=", value, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsIn(List<OffsetDateTime> values) {
            addCriterion("tokens_valid_after_ts in", values, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsNotIn(List<OffsetDateTime> values) {
            addCriterion("tokens_valid_after_ts not in", values, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("tokens_valid_after_ts between", value1, value2, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andTokensValidAfterTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("tokens_valid_after_ts not between", value1, value2, "tokensValidAfterTs");
            return (Criteria) this;
        }

        public Criteria andSsoKeyContains(String value) {
            addCriterion("sso_key ilike", LikePatterns.contains(value), "ssoKey");
            return (Criteria) this;
        }

        public Criteria andDisplayNameContains(String value) {
            addCriterion("display_name ilike", LikePatterns.contains(value), "displayName");
            return (Criteria) this;
        }

        public Criteria andUserNameContains(String value) {
            addCriterion("user_name ilike", LikePatterns.contains(value), "userName");
            return (Criteria) this;
        }

        public Criteria andMigrationHashContains(String value) {
            addCriterion("migration_hash ilike", LikePatterns.contains(value), "migrationHash");
            return (Criteria) this;
        }

        public Criteria andPasswordHashContains(String value) {
            addCriterion("password_hash ilike", LikePatterns.contains(value), "passwordHash");
            return (Criteria) this;
        }

        public Criteria andPasswordAlgoContains(String value) {
            addCriterion("password_algo ilike", LikePatterns.contains(value), "passwordAlgo");
            return (Criteria) this;
        }

        public Criteria andPasswordSaltContains(String value) {
            addCriterion("password_salt ilike", LikePatterns.contains(value), "passwordSalt");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
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