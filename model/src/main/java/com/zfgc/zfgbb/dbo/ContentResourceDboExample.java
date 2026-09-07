package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContentResourceDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public ContentResourceDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
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

        public Criteria andContentResourceIdIsNull() {
            addCriterion("content_resource_id is null");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdIsNotNull() {
            addCriterion("content_resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdEqualTo(Integer value) {
            addCriterion("content_resource_id =", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdNotEqualTo(Integer value) {
            addCriterion("content_resource_id <>", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdGreaterThan(Integer value) {
            addCriterion("content_resource_id >", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_resource_id >=", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdLessThan(Integer value) {
            addCriterion("content_resource_id <", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("content_resource_id <=", value, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdIn(List<Integer> values) {
            addCriterion("content_resource_id in", values, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdNotIn(List<Integer> values) {
            addCriterion("content_resource_id not in", values, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("content_resource_id between", value1, value2, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("content_resource_id not between", value1, value2, "contentResourceId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdIsNull() {
            addCriterion("content_type_id is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdIsNotNull() {
            addCriterion("content_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdEqualTo(Integer value) {
            addCriterion("content_type_id =", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdNotEqualTo(Integer value) {
            addCriterion("content_type_id <>", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdGreaterThan(Integer value) {
            addCriterion("content_type_id >", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_type_id >=", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdLessThan(Integer value) {
            addCriterion("content_type_id <", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("content_type_id <=", value, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdIn(List<Integer> values) {
            addCriterion("content_type_id in", values, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdNotIn(List<Integer> values) {
            addCriterion("content_type_id not in", values, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("content_type_id between", value1, value2, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andContentTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("content_type_id not between", value1, value2, "contentTypeId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdIsNull() {
            addCriterion("uploaded_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdIsNotNull() {
            addCriterion("uploaded_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdEqualTo(Integer value) {
            addCriterion("uploaded_user_id =", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdNotEqualTo(Integer value) {
            addCriterion("uploaded_user_id <>", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdGreaterThan(Integer value) {
            addCriterion("uploaded_user_id >", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("uploaded_user_id >=", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdLessThan(Integer value) {
            addCriterion("uploaded_user_id <", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("uploaded_user_id <=", value, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdIn(List<Integer> values) {
            addCriterion("uploaded_user_id in", values, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdNotIn(List<Integer> values) {
            addCriterion("uploaded_user_id not in", values, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdBetween(Integer value1, Integer value2) {
            addCriterion("uploaded_user_id between", value1, value2, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andUploadedUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("uploaded_user_id not between", value1, value2, "uploadedUserId");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename ilike", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not ilike", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNull() {
            addCriterion("checksum is null");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNotNull() {
            addCriterion("checksum is not null");
            return (Criteria) this;
        }

        public Criteria andChecksumEqualTo(String value) {
            addCriterion("checksum =", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotEqualTo(String value) {
            addCriterion("checksum <>", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThan(String value) {
            addCriterion("checksum >", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThanOrEqualTo(String value) {
            addCriterion("checksum >=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThan(String value) {
            addCriterion("checksum <", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThanOrEqualTo(String value) {
            addCriterion("checksum <=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLike(String value) {
            addCriterion("checksum ilike", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotLike(String value) {
            addCriterion("checksum not ilike", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumIn(List<String> values) {
            addCriterion("checksum in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotIn(List<String> values) {
            addCriterion("checksum not in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumBetween(String value1, String value2) {
            addCriterion("checksum between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotBetween(String value1, String value2) {
            addCriterion("checksum not between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNull() {
            addCriterion("file_ext is null");
            return (Criteria) this;
        }

        public Criteria andFileExtIsNotNull() {
            addCriterion("file_ext is not null");
            return (Criteria) this;
        }

        public Criteria andFileExtEqualTo(String value) {
            addCriterion("file_ext =", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotEqualTo(String value) {
            addCriterion("file_ext <>", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThan(String value) {
            addCriterion("file_ext >", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtGreaterThanOrEqualTo(String value) {
            addCriterion("file_ext >=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThan(String value) {
            addCriterion("file_ext <", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLessThanOrEqualTo(String value) {
            addCriterion("file_ext <=", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtLike(String value) {
            addCriterion("file_ext ilike", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotLike(String value) {
            addCriterion("file_ext not ilike", value, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtIn(List<String> values) {
            addCriterion("file_ext in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotIn(List<String> values) {
            addCriterion("file_ext not in", values, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtBetween(String value1, String value2) {
            addCriterion("file_ext between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andFileExtNotBetween(String value1, String value2) {
            addCriterion("file_ext not between", value1, value2, "fileExt");
            return (Criteria) this;
        }

        public Criteria andMimeTypeIsNull() {
            addCriterion("mime_type is null");
            return (Criteria) this;
        }

        public Criteria andMimeTypeIsNotNull() {
            addCriterion("mime_type is not null");
            return (Criteria) this;
        }

        public Criteria andMimeTypeEqualTo(String value) {
            addCriterion("mime_type =", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeNotEqualTo(String value) {
            addCriterion("mime_type <>", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeGreaterThan(String value) {
            addCriterion("mime_type >", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mime_type >=", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeLessThan(String value) {
            addCriterion("mime_type <", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeLessThanOrEqualTo(String value) {
            addCriterion("mime_type <=", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeLike(String value) {
            addCriterion("mime_type ilike", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeNotLike(String value) {
            addCriterion("mime_type not ilike", value, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeIn(List<String> values) {
            addCriterion("mime_type in", values, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeNotIn(List<String> values) {
            addCriterion("mime_type not in", values, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeBetween(String value1, String value2) {
            addCriterion("mime_type between", value1, value2, "mimeType");
            return (Criteria) this;
        }

        public Criteria andMimeTypeNotBetween(String value1, String value2) {
            addCriterion("mime_type not between", value1, value2, "mimeType");
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

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFilenameContains(String value) {
            addCriterion("filename ilike", LikePatterns.contains(value), "filename");
            return (Criteria) this;
        }

        public Criteria andChecksumContains(String value) {
            addCriterion("checksum ilike", LikePatterns.contains(value), "checksum");
            return (Criteria) this;
        }

        public Criteria andFileExtContains(String value) {
            addCriterion("file_ext ilike", LikePatterns.contains(value), "fileExt");
            return (Criteria) this;
        }

        public Criteria andMimeTypeContains(String value) {
            addCriterion("mime_type ilike", LikePatterns.contains(value), "mimeType");
            return (Criteria) this;
        }

        public Criteria andMigrationHashContains(String value) {
            addCriterion("migration_hash ilike", LikePatterns.contains(value), "migrationHash");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.content_resource")
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