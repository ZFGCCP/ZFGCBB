package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class PermissionGroupDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public PermissionGroupDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
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

        public Criteria andPermissionGroupIdIsNull() {
            addCriterion("permission_group_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdIsNotNull() {
            addCriterion("permission_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdEqualTo(Integer value) {
            addCriterion("permission_group_id =", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdNotEqualTo(Integer value) {
            addCriterion("permission_group_id <>", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdGreaterThan(Integer value) {
            addCriterion("permission_group_id >", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_group_id >=", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdLessThan(Integer value) {
            addCriterion("permission_group_id <", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("permission_group_id <=", value, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdIn(List<Integer> values) {
            addCriterion("permission_group_id in", values, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdNotIn(List<Integer> values) {
            addCriterion("permission_group_id not in", values, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("permission_group_id between", value1, value2, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_group_id not between", value1, value2, "permissionGroupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name ilike", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not ilike", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description ilike", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not ilike", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andMinPostsIsNull() {
            addCriterion("min_posts is null");
            return (Criteria) this;
        }

        public Criteria andMinPostsIsNotNull() {
            addCriterion("min_posts is not null");
            return (Criteria) this;
        }

        public Criteria andMinPostsEqualTo(Integer value) {
            addCriterion("min_posts =", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsNotEqualTo(Integer value) {
            addCriterion("min_posts <>", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsGreaterThan(Integer value) {
            addCriterion("min_posts >", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_posts >=", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsLessThan(Integer value) {
            addCriterion("min_posts <", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsLessThanOrEqualTo(Integer value) {
            addCriterion("min_posts <=", value, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsIn(List<Integer> values) {
            addCriterion("min_posts in", values, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsNotIn(List<Integer> values) {
            addCriterion("min_posts not in", values, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsBetween(Integer value1, Integer value2) {
            addCriterion("min_posts between", value1, value2, "minPosts");
            return (Criteria) this;
        }

        public Criteria andMinPostsNotBetween(Integer value1, Integer value2) {
            addCriterion("min_posts not between", value1, value2, "minPosts");
            return (Criteria) this;
        }

        public Criteria andParentGroupIsNull() {
            addCriterion("parent_group is null");
            return (Criteria) this;
        }

        public Criteria andParentGroupIsNotNull() {
            addCriterion("parent_group is not null");
            return (Criteria) this;
        }

        public Criteria andParentGroupEqualTo(Integer value) {
            addCriterion("parent_group =", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupNotEqualTo(Integer value) {
            addCriterion("parent_group <>", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupGreaterThan(Integer value) {
            addCriterion("parent_group >", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_group >=", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupLessThan(Integer value) {
            addCriterion("parent_group <", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupLessThanOrEqualTo(Integer value) {
            addCriterion("parent_group <=", value, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupIn(List<Integer> values) {
            addCriterion("parent_group in", values, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupNotIn(List<Integer> values) {
            addCriterion("parent_group not in", values, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupBetween(Integer value1, Integer value2) {
            addCriterion("parent_group between", value1, value2, "parentGroup");
            return (Criteria) this;
        }

        public Criteria andParentGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_group not between", value1, value2, "parentGroup");
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

        public Criteria andStarImageIsNull() {
            addCriterion("star_image is null");
            return (Criteria) this;
        }

        public Criteria andStarImageIsNotNull() {
            addCriterion("star_image is not null");
            return (Criteria) this;
        }

        public Criteria andStarImageEqualTo(Integer value) {
            addCriterion("star_image =", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageNotEqualTo(Integer value) {
            addCriterion("star_image <>", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageGreaterThan(Integer value) {
            addCriterion("star_image >", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_image >=", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageLessThan(Integer value) {
            addCriterion("star_image <", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageLessThanOrEqualTo(Integer value) {
            addCriterion("star_image <=", value, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageIn(List<Integer> values) {
            addCriterion("star_image in", values, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageNotIn(List<Integer> values) {
            addCriterion("star_image not in", values, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageBetween(Integer value1, Integer value2) {
            addCriterion("star_image between", value1, value2, "starImage");
            return (Criteria) this;
        }

        public Criteria andStarImageNotBetween(Integer value1, Integer value2) {
            addCriterion("star_image not between", value1, value2, "starImage");
            return (Criteria) this;
        }

        public Criteria andGroupNameContains(String value) {
            addCriterion("group_name ilike", LikePatterns.contains(value), "groupName");
            return (Criteria) this;
        }

        public Criteria andDescriptionContains(String value) {
            addCriterion("description ilike", LikePatterns.contains(value), "description");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.permission_group")
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