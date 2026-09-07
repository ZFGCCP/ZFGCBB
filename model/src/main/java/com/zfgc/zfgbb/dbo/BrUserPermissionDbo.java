package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class BrUserPermissionDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.br_user_permission_id")
    private Integer brUserPermissionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_permission_id")
    private Integer userPermissionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.br_user_permission_id")
    public Integer getBrUserPermissionId() {
        return brUserPermissionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.br_user_permission_id")
    public void setBrUserPermissionId(Integer brUserPermissionId) {
        this.brUserPermissionId = brUserPermissionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_permission_id")
    public Integer getUserPermissionId() {
        return userPermissionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_permission_id")
    public void setUserPermissionId(Integer userPermissionId) {
        this.userPermissionId = userPermissionId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.br_user_permission.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public Integer getPkId() {
        return brUserPermissionId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public OffsetDateTime getCreatedTime() {
        return null;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.br_user_permission")
    public OffsetDateTime getUpdatedTime() {
        return null;
    }
}