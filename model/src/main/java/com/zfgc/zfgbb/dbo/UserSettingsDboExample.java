package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserSettingsDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public UserSettingsDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> themeCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
            themeCriteria = new ArrayList<>();
        }

        public List<Criterion> getThemeCriteria() {
            return themeCriteria;
        }

        protected void addThemeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            themeCriteria.add(new Criterion(condition, value, "com.zfgc.zfgbb.typehandler.PgEnumTypeHandler"));
            allCriteria = null;
        }

        protected void addThemeCriterion(String condition, String value1, String value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            themeCriteria.add(new Criterion(condition, value1, value2, "com.zfgc.zfgbb.typehandler.PgEnumTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || themeCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(themeCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
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

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addThemeCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addThemeCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addThemeCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addThemeCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addThemeCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addThemeCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addThemeCriterion("theme ilike", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addThemeCriterion("theme not ilike", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addThemeCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addThemeCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addThemeCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addThemeCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andSmileySetIsNull() {
            addCriterion("smiley_set is null");
            return (Criteria) this;
        }

        public Criteria andSmileySetIsNotNull() {
            addCriterion("smiley_set is not null");
            return (Criteria) this;
        }

        public Criteria andSmileySetEqualTo(String value) {
            addCriterion("smiley_set =", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetNotEqualTo(String value) {
            addCriterion("smiley_set <>", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetGreaterThan(String value) {
            addCriterion("smiley_set >", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetGreaterThanOrEqualTo(String value) {
            addCriterion("smiley_set >=", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetLessThan(String value) {
            addCriterion("smiley_set <", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetLessThanOrEqualTo(String value) {
            addCriterion("smiley_set <=", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetLike(String value) {
            addCriterion("smiley_set ilike", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetNotLike(String value) {
            addCriterion("smiley_set not ilike", value, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetIn(List<String> values) {
            addCriterion("smiley_set in", values, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetNotIn(List<String> values) {
            addCriterion("smiley_set not in", values, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetBetween(String value1, String value2) {
            addCriterion("smiley_set between", value1, value2, "smileySet");
            return (Criteria) this;
        }

        public Criteria andSmileySetNotBetween(String value1, String value2) {
            addCriterion("smiley_set not between", value1, value2, "smileySet");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagIsNull() {
            addCriterion("notify_announcements_flag is null");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagIsNotNull() {
            addCriterion("notify_announcements_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagEqualTo(Boolean value) {
            addCriterion("notify_announcements_flag =", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagNotEqualTo(Boolean value) {
            addCriterion("notify_announcements_flag <>", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagGreaterThan(Boolean value) {
            addCriterion("notify_announcements_flag >", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("notify_announcements_flag >=", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagLessThan(Boolean value) {
            addCriterion("notify_announcements_flag <", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("notify_announcements_flag <=", value, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagIn(List<Boolean> values) {
            addCriterion("notify_announcements_flag in", values, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagNotIn(List<Boolean> values) {
            addCriterion("notify_announcements_flag not in", values, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("notify_announcements_flag between", value1, value2, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyAnnouncementsFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("notify_announcements_flag not between", value1, value2, "notifyAnnouncementsFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagIsNull() {
            addCriterion("notify_send_body_flag is null");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagIsNotNull() {
            addCriterion("notify_send_body_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagEqualTo(Boolean value) {
            addCriterion("notify_send_body_flag =", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagNotEqualTo(Boolean value) {
            addCriterion("notify_send_body_flag <>", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagGreaterThan(Boolean value) {
            addCriterion("notify_send_body_flag >", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("notify_send_body_flag >=", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagLessThan(Boolean value) {
            addCriterion("notify_send_body_flag <", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("notify_send_body_flag <=", value, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagIn(List<Boolean> values) {
            addCriterion("notify_send_body_flag in", values, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagNotIn(List<Boolean> values) {
            addCriterion("notify_send_body_flag not in", values, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("notify_send_body_flag between", value1, value2, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifySendBodyFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("notify_send_body_flag not between", value1, value2, "notifySendBodyFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagIsNull() {
            addCriterion("send_happy_birthday_flag is null");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagIsNotNull() {
            addCriterion("send_happy_birthday_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagEqualTo(Boolean value) {
            addCriterion("send_happy_birthday_flag =", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagNotEqualTo(Boolean value) {
            addCriterion("send_happy_birthday_flag <>", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagGreaterThan(Boolean value) {
            addCriterion("send_happy_birthday_flag >", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("send_happy_birthday_flag >=", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagLessThan(Boolean value) {
            addCriterion("send_happy_birthday_flag <", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("send_happy_birthday_flag <=", value, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagIn(List<Boolean> values) {
            addCriterion("send_happy_birthday_flag in", values, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagNotIn(List<Boolean> values) {
            addCriterion("send_happy_birthday_flag not in", values, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("send_happy_birthday_flag between", value1, value2, "sendHappyBirthdayFlag");
            return (Criteria) this;
        }

        public Criteria andSendHappyBirthdayFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("send_happy_birthday_flag not between", value1, value2, "sendHappyBirthdayFlag");
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

        public Criteria andThemeContains(String value) {
            addThemeCriterion("theme ilike", LikePatterns.contains(value), "theme");
            return (Criteria) this;
        }

        public Criteria andSmileySetContains(String value) {
            addCriterion("smiley_set ilike", LikePatterns.contains(value), "smileySet");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
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