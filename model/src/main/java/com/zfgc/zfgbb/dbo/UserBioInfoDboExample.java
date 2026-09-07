package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserBioInfoDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public UserBioInfoDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
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

        public Criteria andCustomTitleIsNull() {
            addCriterion("custom_title is null");
            return (Criteria) this;
        }

        public Criteria andCustomTitleIsNotNull() {
            addCriterion("custom_title is not null");
            return (Criteria) this;
        }

        public Criteria andCustomTitleEqualTo(String value) {
            addCriterion("custom_title =", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleNotEqualTo(String value) {
            addCriterion("custom_title <>", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleGreaterThan(String value) {
            addCriterion("custom_title >", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleGreaterThanOrEqualTo(String value) {
            addCriterion("custom_title >=", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleLessThan(String value) {
            addCriterion("custom_title <", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleLessThanOrEqualTo(String value) {
            addCriterion("custom_title <=", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleLike(String value) {
            addCriterion("custom_title ilike", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleNotLike(String value) {
            addCriterion("custom_title not ilike", value, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleIn(List<String> values) {
            addCriterion("custom_title in", values, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleNotIn(List<String> values) {
            addCriterion("custom_title not in", values, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleBetween(String value1, String value2) {
            addCriterion("custom_title between", value1, value2, "customTitle");
            return (Criteria) this;
        }

        public Criteria andCustomTitleNotBetween(String value1, String value2) {
            addCriterion("custom_title not between", value1, value2, "customTitle");
            return (Criteria) this;
        }

        public Criteria andPersonalTextIsNull() {
            addCriterion("personal_text is null");
            return (Criteria) this;
        }

        public Criteria andPersonalTextIsNotNull() {
            addCriterion("personal_text is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalTextEqualTo(String value) {
            addCriterion("personal_text =", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextNotEqualTo(String value) {
            addCriterion("personal_text <>", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextGreaterThan(String value) {
            addCriterion("personal_text >", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextGreaterThanOrEqualTo(String value) {
            addCriterion("personal_text >=", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextLessThan(String value) {
            addCriterion("personal_text <", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextLessThanOrEqualTo(String value) {
            addCriterion("personal_text <=", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextLike(String value) {
            addCriterion("personal_text ilike", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextNotLike(String value) {
            addCriterion("personal_text not ilike", value, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextIn(List<String> values) {
            addCriterion("personal_text in", values, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextNotIn(List<String> values) {
            addCriterion("personal_text not in", values, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextBetween(String value1, String value2) {
            addCriterion("personal_text between", value1, value2, "personalText");
            return (Criteria) this;
        }

        public Criteria andPersonalTextNotBetween(String value1, String value2) {
            addCriterion("personal_text not between", value1, value2, "personalText");
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

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature ilike", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not ilike", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
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

        public Criteria andAvatarIdIsNull() {
            addCriterion("avatar_id is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIdIsNotNull() {
            addCriterion("avatar_id is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarIdEqualTo(Integer value) {
            addCriterion("avatar_id =", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotEqualTo(Integer value) {
            addCriterion("avatar_id <>", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdGreaterThan(Integer value) {
            addCriterion("avatar_id >", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("avatar_id >=", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdLessThan(Integer value) {
            addCriterion("avatar_id <", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdLessThanOrEqualTo(Integer value) {
            addCriterion("avatar_id <=", value, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdIn(List<Integer> values) {
            addCriterion("avatar_id in", values, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotIn(List<Integer> values) {
            addCriterion("avatar_id not in", values, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdBetween(Integer value1, Integer value2) {
            addCriterion("avatar_id between", value1, value2, "avatarId");
            return (Criteria) this;
        }

        public Criteria andAvatarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("avatar_id not between", value1, value2, "avatarId");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredIsNull() {
            addCriterion("date_registered is null");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredIsNotNull() {
            addCriterion("date_registered is not null");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredEqualTo(OffsetDateTime value) {
            addCriterion("date_registered =", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredNotEqualTo(OffsetDateTime value) {
            addCriterion("date_registered <>", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredGreaterThan(OffsetDateTime value) {
            addCriterion("date_registered >", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("date_registered >=", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredLessThan(OffsetDateTime value) {
            addCriterion("date_registered <", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("date_registered <=", value, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredIn(List<OffsetDateTime> values) {
            addCriterion("date_registered in", values, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredNotIn(List<OffsetDateTime> values) {
            addCriterion("date_registered not in", values, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("date_registered between", value1, value2, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andDateRegisteredNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("date_registered not between", value1, value2, "dateRegistered");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginEqualTo(OffsetDateTime value) {
            addCriterion("last_login =", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotEqualTo(OffsetDateTime value) {
            addCriterion("last_login <>", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThan(OffsetDateTime value) {
            addCriterion("last_login >", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("last_login >=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThan(OffsetDateTime value) {
            addCriterion("last_login <", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("last_login <=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIn(List<OffsetDateTime> values) {
            addCriterion("last_login in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotIn(List<OffsetDateTime> values) {
            addCriterion("last_login not in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("last_login between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("last_login not between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name ilike", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not ilike", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(LocalDate value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(LocalDate value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(LocalDate value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(LocalDate value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(LocalDate value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(LocalDate value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<LocalDate> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<LocalDate> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(LocalDate value1, LocalDate value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(LocalDate value1, LocalDate value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleIsNull() {
            addCriterion("website_title is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleIsNotNull() {
            addCriterion("website_title is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleEqualTo(String value) {
            addCriterion("website_title =", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleNotEqualTo(String value) {
            addCriterion("website_title <>", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleGreaterThan(String value) {
            addCriterion("website_title >", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("website_title >=", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleLessThan(String value) {
            addCriterion("website_title <", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleLessThanOrEqualTo(String value) {
            addCriterion("website_title <=", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleLike(String value) {
            addCriterion("website_title ilike", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleNotLike(String value) {
            addCriterion("website_title not ilike", value, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleIn(List<String> values) {
            addCriterion("website_title in", values, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleNotIn(List<String> values) {
            addCriterion("website_title not in", values, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleBetween(String value1, String value2) {
            addCriterion("website_title between", value1, value2, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleNotBetween(String value1, String value2) {
            addCriterion("website_title not between", value1, value2, "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIsNull() {
            addCriterion("website_url is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIsNotNull() {
            addCriterion("website_url is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlEqualTo(String value) {
            addCriterion("website_url =", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotEqualTo(String value) {
            addCriterion("website_url <>", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlGreaterThan(String value) {
            addCriterion("website_url >", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("website_url >=", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLessThan(String value) {
            addCriterion("website_url <", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLessThanOrEqualTo(String value) {
            addCriterion("website_url <=", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlLike(String value) {
            addCriterion("website_url ilike", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotLike(String value) {
            addCriterion("website_url not ilike", value, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlIn(List<String> values) {
            addCriterion("website_url in", values, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotIn(List<String> values) {
            addCriterion("website_url not in", values, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlBetween(String value1, String value2) {
            addCriterion("website_url between", value1, value2, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlNotBetween(String value1, String value2) {
            addCriterion("website_url not between", value1, value2, "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location ilike", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not ilike", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andTimeFormatIsNull() {
            addCriterion("time_format is null");
            return (Criteria) this;
        }

        public Criteria andTimeFormatIsNotNull() {
            addCriterion("time_format is not null");
            return (Criteria) this;
        }

        public Criteria andTimeFormatEqualTo(String value) {
            addCriterion("time_format =", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatNotEqualTo(String value) {
            addCriterion("time_format <>", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatGreaterThan(String value) {
            addCriterion("time_format >", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatGreaterThanOrEqualTo(String value) {
            addCriterion("time_format >=", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatLessThan(String value) {
            addCriterion("time_format <", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatLessThanOrEqualTo(String value) {
            addCriterion("time_format <=", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatLike(String value) {
            addCriterion("time_format ilike", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatNotLike(String value) {
            addCriterion("time_format not ilike", value, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatIn(List<String> values) {
            addCriterion("time_format in", values, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatNotIn(List<String> values) {
            addCriterion("time_format not in", values, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatBetween(String value1, String value2) {
            addCriterion("time_format between", value1, value2, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andTimeFormatNotBetween(String value1, String value2) {
            addCriterion("time_format not between", value1, value2, "timeFormat");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodIsNull() {
            addCriterion("karma_good is null");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodIsNotNull() {
            addCriterion("karma_good is not null");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodEqualTo(Integer value) {
            addCriterion("karma_good =", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodNotEqualTo(Integer value) {
            addCriterion("karma_good <>", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodGreaterThan(Integer value) {
            addCriterion("karma_good >", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("karma_good >=", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodLessThan(Integer value) {
            addCriterion("karma_good <", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodLessThanOrEqualTo(Integer value) {
            addCriterion("karma_good <=", value, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodIn(List<Integer> values) {
            addCriterion("karma_good in", values, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodNotIn(List<Integer> values) {
            addCriterion("karma_good not in", values, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodBetween(Integer value1, Integer value2) {
            addCriterion("karma_good between", value1, value2, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("karma_good not between", value1, value2, "karmaGood");
            return (Criteria) this;
        }

        public Criteria andKarmaBadIsNull() {
            addCriterion("karma_bad is null");
            return (Criteria) this;
        }

        public Criteria andKarmaBadIsNotNull() {
            addCriterion("karma_bad is not null");
            return (Criteria) this;
        }

        public Criteria andKarmaBadEqualTo(Integer value) {
            addCriterion("karma_bad =", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadNotEqualTo(Integer value) {
            addCriterion("karma_bad <>", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadGreaterThan(Integer value) {
            addCriterion("karma_bad >", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadGreaterThanOrEqualTo(Integer value) {
            addCriterion("karma_bad >=", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadLessThan(Integer value) {
            addCriterion("karma_bad <", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadLessThanOrEqualTo(Integer value) {
            addCriterion("karma_bad <=", value, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadIn(List<Integer> values) {
            addCriterion("karma_bad in", values, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadNotIn(List<Integer> values) {
            addCriterion("karma_bad not in", values, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadBetween(Integer value1, Integer value2) {
            addCriterion("karma_bad between", value1, value2, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andKarmaBadNotBetween(Integer value1, Integer value2) {
            addCriterion("karma_bad not between", value1, value2, "karmaBad");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagIsNull() {
            addCriterion("hide_email_flag is null");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagIsNotNull() {
            addCriterion("hide_email_flag is not null");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagEqualTo(Boolean value) {
            addCriterion("hide_email_flag =", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagNotEqualTo(Boolean value) {
            addCriterion("hide_email_flag <>", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagGreaterThan(Boolean value) {
            addCriterion("hide_email_flag >", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hide_email_flag >=", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagLessThan(Boolean value) {
            addCriterion("hide_email_flag <", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("hide_email_flag <=", value, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagIn(List<Boolean> values) {
            addCriterion("hide_email_flag in", values, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagNotIn(List<Boolean> values) {
            addCriterion("hide_email_flag not in", values, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_email_flag between", value1, value2, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideEmailFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_email_flag not between", value1, value2, "hideEmailFlag");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusIsNull() {
            addCriterion("hide_online_status is null");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusIsNotNull() {
            addCriterion("hide_online_status is not null");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusEqualTo(Boolean value) {
            addCriterion("hide_online_status =", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusNotEqualTo(Boolean value) {
            addCriterion("hide_online_status <>", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusGreaterThan(Boolean value) {
            addCriterion("hide_online_status >", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hide_online_status >=", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusLessThan(Boolean value) {
            addCriterion("hide_online_status <", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("hide_online_status <=", value, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusIn(List<Boolean> values) {
            addCriterion("hide_online_status in", values, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusNotIn(List<Boolean> values) {
            addCriterion("hide_online_status not in", values, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_online_status between", value1, value2, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andHideOnlineStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_online_status not between", value1, value2, "hideOnlineStatus");
            return (Criteria) this;
        }

        public Criteria andGenderIdIsNull() {
            addCriterion("gender_id is null");
            return (Criteria) this;
        }

        public Criteria andGenderIdIsNotNull() {
            addCriterion("gender_id is not null");
            return (Criteria) this;
        }

        public Criteria andGenderIdEqualTo(Integer value) {
            addCriterion("gender_id =", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdNotEqualTo(Integer value) {
            addCriterion("gender_id <>", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdGreaterThan(Integer value) {
            addCriterion("gender_id >", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender_id >=", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdLessThan(Integer value) {
            addCriterion("gender_id <", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdLessThanOrEqualTo(Integer value) {
            addCriterion("gender_id <=", value, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdIn(List<Integer> values) {
            addCriterion("gender_id in", values, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdNotIn(List<Integer> values) {
            addCriterion("gender_id not in", values, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdBetween(Integer value1, Integer value2) {
            addCriterion("gender_id between", value1, value2, "genderId");
            return (Criteria) this;
        }

        public Criteria andGenderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gender_id not between", value1, value2, "genderId");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneIsNull() {
            addCriterion("preferred_timezone is null");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneIsNotNull() {
            addCriterion("preferred_timezone is not null");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneEqualTo(String value) {
            addCriterion("preferred_timezone =", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneNotEqualTo(String value) {
            addCriterion("preferred_timezone <>", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneGreaterThan(String value) {
            addCriterion("preferred_timezone >", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneGreaterThanOrEqualTo(String value) {
            addCriterion("preferred_timezone >=", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneLessThan(String value) {
            addCriterion("preferred_timezone <", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneLessThanOrEqualTo(String value) {
            addCriterion("preferred_timezone <=", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneLike(String value) {
            addCriterion("preferred_timezone ilike", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneNotLike(String value) {
            addCriterion("preferred_timezone not ilike", value, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneIn(List<String> values) {
            addCriterion("preferred_timezone in", values, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneNotIn(List<String> values) {
            addCriterion("preferred_timezone not in", values, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneBetween(String value1, String value2) {
            addCriterion("preferred_timezone between", value1, value2, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneNotBetween(String value1, String value2) {
            addCriterion("preferred_timezone not between", value1, value2, "preferredTimezone");
            return (Criteria) this;
        }

        public Criteria andCustomTitleContains(String value) {
            addCriterion("custom_title ilike", LikePatterns.contains(value), "customTitle");
            return (Criteria) this;
        }

        public Criteria andPersonalTextContains(String value) {
            addCriterion("personal_text ilike", LikePatterns.contains(value), "personalText");
            return (Criteria) this;
        }

        public Criteria andSignatureContains(String value) {
            addCriterion("signature ilike", LikePatterns.contains(value), "signature");
            return (Criteria) this;
        }

        public Criteria andMigrationHashContains(String value) {
            addCriterion("migration_hash ilike", LikePatterns.contains(value), "migrationHash");
            return (Criteria) this;
        }

        public Criteria andRealNameContains(String value) {
            addCriterion("real_name ilike", LikePatterns.contains(value), "realName");
            return (Criteria) this;
        }

        public Criteria andWebsiteTitleContains(String value) {
            addCriterion("website_title ilike", LikePatterns.contains(value), "websiteTitle");
            return (Criteria) this;
        }

        public Criteria andWebsiteUrlContains(String value) {
            addCriterion("website_url ilike", LikePatterns.contains(value), "websiteUrl");
            return (Criteria) this;
        }

        public Criteria andLocationContains(String value) {
            addCriterion("location ilike", LikePatterns.contains(value), "location");
            return (Criteria) this;
        }

        public Criteria andTimeFormatContains(String value) {
            addCriterion("time_format ilike", LikePatterns.contains(value), "timeFormat");
            return (Criteria) this;
        }

        public Criteria andPreferredTimezoneContains(String value) {
            addCriterion("preferred_timezone ilike", LikePatterns.contains(value), "preferredTimezone");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_bio_info")
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