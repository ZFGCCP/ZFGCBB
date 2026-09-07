package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class PersonalMessageDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_id")
    private Integer personalMessageId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_conversation_id")
    private Integer personalMessageConversationId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_user_id")
    private Integer senderUserId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_name")
    private String senderName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.body")
    private String body;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sent_ts")
    private OffsetDateTime sentTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.deleted_by_sender")
    private Boolean deletedBySender;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_id")
    public Integer getPersonalMessageId() {
        return personalMessageId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_id")
    public void setPersonalMessageId(Integer personalMessageId) {
        this.personalMessageId = personalMessageId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_conversation_id")
    public Integer getPersonalMessageConversationId() {
        return personalMessageConversationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.personal_message_conversation_id")
    public void setPersonalMessageConversationId(Integer personalMessageConversationId) {
        this.personalMessageConversationId = personalMessageConversationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_user_id")
    public Integer getSenderUserId() {
        return senderUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_user_id")
    public void setSenderUserId(Integer senderUserId) {
        this.senderUserId = senderUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_name")
    public String getSenderName() {
        return senderName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sender_name")
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.body")
    public String getBody() {
        return body;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.body")
    public void setBody(String body) {
        this.body = body;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sent_ts")
    public OffsetDateTime getSentTs() {
        return sentTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.sent_ts")
    public void setSentTs(OffsetDateTime sentTs) {
        this.sentTs = sentTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.deleted_by_sender")
    public Boolean getDeletedBySender() {
        return deletedBySender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.deleted_by_sender")
    public void setDeletedBySender(Boolean deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.personal_message.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public Integer getPkId() {
        return personalMessageId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.personal_message")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}