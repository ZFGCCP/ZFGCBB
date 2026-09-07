package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class PersonalMessageRecipientDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_recipient_id")
    private Integer personalMessageRecipientId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_id")
    private Integer personalMessageId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.recipient_user_id")
    private Integer recipientUserId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.bcc")
    private Boolean bcc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.read_flag")
    private Boolean readFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.deleted_flag")
    private Boolean deletedFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_recipient_id")
    public Integer getPersonalMessageRecipientId() {
        return personalMessageRecipientId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_recipient_id")
    public void setPersonalMessageRecipientId(Integer personalMessageRecipientId) {
        this.personalMessageRecipientId = personalMessageRecipientId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_id")
    public Integer getPersonalMessageId() {
        return personalMessageId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.personal_message_id")
    public void setPersonalMessageId(Integer personalMessageId) {
        this.personalMessageId = personalMessageId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.recipient_user_id")
    public Integer getRecipientUserId() {
        return recipientUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.recipient_user_id")
    public void setRecipientUserId(Integer recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.bcc")
    public Boolean getBcc() {
        return bcc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.bcc")
    public void setBcc(Boolean bcc) {
        this.bcc = bcc;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.read_flag")
    public Boolean getReadFlag() {
        return readFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.read_flag")
    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.deleted_flag")
    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.deleted_flag")
    public void setDeletedFlag(Boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message_recipient.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public Integer getPkId() {
        return personalMessageRecipientId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message_recipient")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}