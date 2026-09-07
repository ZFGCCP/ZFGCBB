package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class AccountDeletionAuditDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.deletion_id")
    private Integer deletionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_user_id_snapshot")
    private Integer subjectUserIdSnapshot;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_pseudonym")
    private String subjectPseudonym;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.mode")
    private String mode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.initiated_by")
    private String initiatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.requested_ts")
    private OffsetDateTime requestedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.confirmed_ts")
    private OffsetDateTime confirmedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.executed_ts")
    private OffsetDateTime executedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.message_count")
    private Integer messageCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.content_resource_count")
    private Integer contentResourceCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.deletion_id")
    public Integer getDeletionId() {
        return deletionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.deletion_id")
    public void setDeletionId(Integer deletionId) {
        this.deletionId = deletionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_user_id_snapshot")
    public Integer getSubjectUserIdSnapshot() {
        return subjectUserIdSnapshot;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_user_id_snapshot")
    public void setSubjectUserIdSnapshot(Integer subjectUserIdSnapshot) {
        this.subjectUserIdSnapshot = subjectUserIdSnapshot;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_pseudonym")
    public String getSubjectPseudonym() {
        return subjectPseudonym;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.subject_pseudonym")
    public void setSubjectPseudonym(String subjectPseudonym) {
        this.subjectPseudonym = subjectPseudonym;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.mode")
    public String getMode() {
        return mode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.initiated_by")
    public String getInitiatedBy() {
        return initiatedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.initiated_by")
    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.requested_ts")
    public OffsetDateTime getRequestedTs() {
        return requestedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.requested_ts")
    public void setRequestedTs(OffsetDateTime requestedTs) {
        this.requestedTs = requestedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.confirmed_ts")
    public OffsetDateTime getConfirmedTs() {
        return confirmedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.confirmed_ts")
    public void setConfirmedTs(OffsetDateTime confirmedTs) {
        this.confirmedTs = confirmedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.executed_ts")
    public OffsetDateTime getExecutedTs() {
        return executedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.executed_ts")
    public void setExecutedTs(OffsetDateTime executedTs) {
        this.executedTs = executedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.message_count")
    public Integer getMessageCount() {
        return messageCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.message_count")
    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.content_resource_count")
    public Integer getContentResourceCount() {
        return contentResourceCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.content_resource_count")
    public void setContentResourceCount(Integer contentResourceCount) {
        this.contentResourceCount = contentResourceCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.account_deletion_audit.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public Integer getPkId() {
        return deletionId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.account_deletion_audit")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}