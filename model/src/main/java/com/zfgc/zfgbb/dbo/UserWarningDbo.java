package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class UserWarningDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_warning_id")
    private Integer userWarningId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_user_id")
    private Integer issuedByUserId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_name")
    private String issuedByName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.body")
    private String body;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.points")
    private Integer points;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_ts")
    private OffsetDateTime issuedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_warning_id")
    public Integer getUserWarningId() {
        return userWarningId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_warning_id")
    public void setUserWarningId(Integer userWarningId) {
        this.userWarningId = userWarningId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_user_id")
    public Integer getIssuedByUserId() {
        return issuedByUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_user_id")
    public void setIssuedByUserId(Integer issuedByUserId) {
        this.issuedByUserId = issuedByUserId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_name")
    public String getIssuedByName() {
        return issuedByName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_by_name")
    public void setIssuedByName(String issuedByName) {
        this.issuedByName = issuedByName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.body")
    public String getBody() {
        return body;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.body")
    public void setBody(String body) {
        this.body = body;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.points")
    public Integer getPoints() {
        return points;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_ts")
    public OffsetDateTime getIssuedTs() {
        return issuedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.issued_ts")
    public void setIssuedTs(OffsetDateTime issuedTs) {
        this.issuedTs = issuedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_warning.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public Integer getPkId() {
        return userWarningId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_warning")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}