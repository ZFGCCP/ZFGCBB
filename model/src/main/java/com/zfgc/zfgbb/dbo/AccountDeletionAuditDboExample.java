package com.zfgc.zfgbb.dbo;

import com.zfgc.zfgbb.persistence.LikePatterns;
import jakarta.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountDeletionAuditDboExample {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected String orderByClause;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected boolean distinct;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected List<Criteria> oredCriteria;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected Integer limit;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected Integer offset;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public AccountDeletionAuditDboExample() {
        oredCriteria = new ArrayList<>();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public String getOrderByClause() {
        return orderByClause;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public boolean isDistinct() {
        return distinct;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public Integer getLimit() {
        return limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public Integer getOffset() {
        return offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
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

        public Criteria andDeletionIdIsNull() {
            addCriterion("deletion_id is null");
            return (Criteria) this;
        }

        public Criteria andDeletionIdIsNotNull() {
            addCriterion("deletion_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeletionIdEqualTo(Integer value) {
            addCriterion("deletion_id =", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdNotEqualTo(Integer value) {
            addCriterion("deletion_id <>", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdGreaterThan(Integer value) {
            addCriterion("deletion_id >", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deletion_id >=", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdLessThan(Integer value) {
            addCriterion("deletion_id <", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdLessThanOrEqualTo(Integer value) {
            addCriterion("deletion_id <=", value, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdIn(List<Integer> values) {
            addCriterion("deletion_id in", values, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdNotIn(List<Integer> values) {
            addCriterion("deletion_id not in", values, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdBetween(Integer value1, Integer value2) {
            addCriterion("deletion_id between", value1, value2, "deletionId");
            return (Criteria) this;
        }

        public Criteria andDeletionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deletion_id not between", value1, value2, "deletionId");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotIsNull() {
            addCriterion("subject_user_id_snapshot is null");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotIsNotNull() {
            addCriterion("subject_user_id_snapshot is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotEqualTo(Integer value) {
            addCriterion("subject_user_id_snapshot =", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotNotEqualTo(Integer value) {
            addCriterion("subject_user_id_snapshot <>", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotGreaterThan(Integer value) {
            addCriterion("subject_user_id_snapshot >", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_user_id_snapshot >=", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotLessThan(Integer value) {
            addCriterion("subject_user_id_snapshot <", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotLessThanOrEqualTo(Integer value) {
            addCriterion("subject_user_id_snapshot <=", value, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotIn(List<Integer> values) {
            addCriterion("subject_user_id_snapshot in", values, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotNotIn(List<Integer> values) {
            addCriterion("subject_user_id_snapshot not in", values, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotBetween(Integer value1, Integer value2) {
            addCriterion("subject_user_id_snapshot between", value1, value2, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectUserIdSnapshotNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_user_id_snapshot not between", value1, value2, "subjectUserIdSnapshot");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymIsNull() {
            addCriterion("subject_pseudonym is null");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymIsNotNull() {
            addCriterion("subject_pseudonym is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymEqualTo(String value) {
            addCriterion("subject_pseudonym =", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymNotEqualTo(String value) {
            addCriterion("subject_pseudonym <>", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymGreaterThan(String value) {
            addCriterion("subject_pseudonym >", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymGreaterThanOrEqualTo(String value) {
            addCriterion("subject_pseudonym >=", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymLessThan(String value) {
            addCriterion("subject_pseudonym <", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymLessThanOrEqualTo(String value) {
            addCriterion("subject_pseudonym <=", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymLike(String value) {
            addCriterion("subject_pseudonym ilike", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymNotLike(String value) {
            addCriterion("subject_pseudonym not ilike", value, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymIn(List<String> values) {
            addCriterion("subject_pseudonym in", values, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymNotIn(List<String> values) {
            addCriterion("subject_pseudonym not in", values, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymBetween(String value1, String value2) {
            addCriterion("subject_pseudonym between", value1, value2, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andSubjectPseudonymNotBetween(String value1, String value2) {
            addCriterion("subject_pseudonym not between", value1, value2, "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(String value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(String value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(String value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(String value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(String value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(String value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLike(String value) {
            addCriterion("mode ilike", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotLike(String value) {
            addCriterion("mode not ilike", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<String> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<String> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(String value1, String value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(String value1, String value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andInitiatedByIsNull() {
            addCriterion("initiated_by is null");
            return (Criteria) this;
        }

        public Criteria andInitiatedByIsNotNull() {
            addCriterion("initiated_by is not null");
            return (Criteria) this;
        }

        public Criteria andInitiatedByEqualTo(String value) {
            addCriterion("initiated_by =", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByNotEqualTo(String value) {
            addCriterion("initiated_by <>", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByGreaterThan(String value) {
            addCriterion("initiated_by >", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByGreaterThanOrEqualTo(String value) {
            addCriterion("initiated_by >=", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByLessThan(String value) {
            addCriterion("initiated_by <", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByLessThanOrEqualTo(String value) {
            addCriterion("initiated_by <=", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByLike(String value) {
            addCriterion("initiated_by ilike", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByNotLike(String value) {
            addCriterion("initiated_by not ilike", value, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByIn(List<String> values) {
            addCriterion("initiated_by in", values, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByNotIn(List<String> values) {
            addCriterion("initiated_by not in", values, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByBetween(String value1, String value2) {
            addCriterion("initiated_by between", value1, value2, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andInitiatedByNotBetween(String value1, String value2) {
            addCriterion("initiated_by not between", value1, value2, "initiatedBy");
            return (Criteria) this;
        }

        public Criteria andRequestedTsIsNull() {
            addCriterion("requested_ts is null");
            return (Criteria) this;
        }

        public Criteria andRequestedTsIsNotNull() {
            addCriterion("requested_ts is not null");
            return (Criteria) this;
        }

        public Criteria andRequestedTsEqualTo(OffsetDateTime value) {
            addCriterion("requested_ts =", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("requested_ts <>", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsGreaterThan(OffsetDateTime value) {
            addCriterion("requested_ts >", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("requested_ts >=", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsLessThan(OffsetDateTime value) {
            addCriterion("requested_ts <", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("requested_ts <=", value, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsIn(List<OffsetDateTime> values) {
            addCriterion("requested_ts in", values, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("requested_ts not in", values, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("requested_ts between", value1, value2, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andRequestedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("requested_ts not between", value1, value2, "requestedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsIsNull() {
            addCriterion("confirmed_ts is null");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsIsNotNull() {
            addCriterion("confirmed_ts is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsEqualTo(OffsetDateTime value) {
            addCriterion("confirmed_ts =", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("confirmed_ts <>", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsGreaterThan(OffsetDateTime value) {
            addCriterion("confirmed_ts >", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("confirmed_ts >=", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsLessThan(OffsetDateTime value) {
            addCriterion("confirmed_ts <", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("confirmed_ts <=", value, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsIn(List<OffsetDateTime> values) {
            addCriterion("confirmed_ts in", values, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("confirmed_ts not in", values, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("confirmed_ts between", value1, value2, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andConfirmedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("confirmed_ts not between", value1, value2, "confirmedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsIsNull() {
            addCriterion("executed_ts is null");
            return (Criteria) this;
        }

        public Criteria andExecutedTsIsNotNull() {
            addCriterion("executed_ts is not null");
            return (Criteria) this;
        }

        public Criteria andExecutedTsEqualTo(OffsetDateTime value) {
            addCriterion("executed_ts =", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsNotEqualTo(OffsetDateTime value) {
            addCriterion("executed_ts <>", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsGreaterThan(OffsetDateTime value) {
            addCriterion("executed_ts >", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("executed_ts >=", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsLessThan(OffsetDateTime value) {
            addCriterion("executed_ts <", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("executed_ts <=", value, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsIn(List<OffsetDateTime> values) {
            addCriterion("executed_ts in", values, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsNotIn(List<OffsetDateTime> values) {
            addCriterion("executed_ts not in", values, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("executed_ts between", value1, value2, "executedTs");
            return (Criteria) this;
        }

        public Criteria andExecutedTsNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("executed_ts not between", value1, value2, "executedTs");
            return (Criteria) this;
        }

        public Criteria andMessageCountIsNull() {
            addCriterion("message_count is null");
            return (Criteria) this;
        }

        public Criteria andMessageCountIsNotNull() {
            addCriterion("message_count is not null");
            return (Criteria) this;
        }

        public Criteria andMessageCountEqualTo(Integer value) {
            addCriterion("message_count =", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountNotEqualTo(Integer value) {
            addCriterion("message_count <>", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountGreaterThan(Integer value) {
            addCriterion("message_count >", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_count >=", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountLessThan(Integer value) {
            addCriterion("message_count <", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountLessThanOrEqualTo(Integer value) {
            addCriterion("message_count <=", value, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountIn(List<Integer> values) {
            addCriterion("message_count in", values, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountNotIn(List<Integer> values) {
            addCriterion("message_count not in", values, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountBetween(Integer value1, Integer value2) {
            addCriterion("message_count between", value1, value2, "messageCount");
            return (Criteria) this;
        }

        public Criteria andMessageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("message_count not between", value1, value2, "messageCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountIsNull() {
            addCriterion("content_resource_count is null");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountIsNotNull() {
            addCriterion("content_resource_count is not null");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountEqualTo(Integer value) {
            addCriterion("content_resource_count =", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountNotEqualTo(Integer value) {
            addCriterion("content_resource_count <>", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountGreaterThan(Integer value) {
            addCriterion("content_resource_count >", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_resource_count >=", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountLessThan(Integer value) {
            addCriterion("content_resource_count <", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountLessThanOrEqualTo(Integer value) {
            addCriterion("content_resource_count <=", value, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountIn(List<Integer> values) {
            addCriterion("content_resource_count in", values, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountNotIn(List<Integer> values) {
            addCriterion("content_resource_count not in", values, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountBetween(Integer value1, Integer value2) {
            addCriterion("content_resource_count between", value1, value2, "contentResourceCount");
            return (Criteria) this;
        }

        public Criteria andContentResourceCountNotBetween(Integer value1, Integer value2) {
            addCriterion("content_resource_count not between", value1, value2, "contentResourceCount");
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

        public Criteria andSubjectPseudonymContains(String value) {
            addCriterion("subject_pseudonym ilike", LikePatterns.contains(value), "subjectPseudonym");
            return (Criteria) this;
        }

        public Criteria andModeContains(String value) {
            addCriterion("mode ilike", LikePatterns.contains(value), "mode");
            return (Criteria) this;
        }

        public Criteria andInitiatedByContains(String value) {
            addCriterion("initiated_by ilike", LikePatterns.contains(value), "initiatedBy");
            return (Criteria) this;
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="do_not_delete_during_merge")
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
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