package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class UserSettingsDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.theme")
    private String theme;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.smiley_set")
    private String smileySet;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_announcements_flag")
    private Boolean notifyAnnouncementsFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_send_body_flag")
    private Boolean notifySendBodyFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.send_happy_birthday_flag")
    private Boolean sendHappyBirthdayFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.theme")
    public String getTheme() {
        return theme;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.smiley_set")
    public String getSmileySet() {
        return smileySet;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.smiley_set")
    public void setSmileySet(String smileySet) {
        this.smileySet = smileySet;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_announcements_flag")
    public Boolean getNotifyAnnouncementsFlag() {
        return notifyAnnouncementsFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_announcements_flag")
    public void setNotifyAnnouncementsFlag(Boolean notifyAnnouncementsFlag) {
        this.notifyAnnouncementsFlag = notifyAnnouncementsFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_send_body_flag")
    public Boolean getNotifySendBodyFlag() {
        return notifySendBodyFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.notify_send_body_flag")
    public void setNotifySendBodyFlag(Boolean notifySendBodyFlag) {
        this.notifySendBodyFlag = notifySendBodyFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.send_happy_birthday_flag")
    public Boolean getSendHappyBirthdayFlag() {
        return sendHappyBirthdayFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.send_happy_birthday_flag")
    public void setSendHappyBirthdayFlag(Boolean sendHappyBirthdayFlag) {
        this.sendHappyBirthdayFlag = sendHappyBirthdayFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_settings.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public Integer getPkId() {
        return userId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_settings")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}