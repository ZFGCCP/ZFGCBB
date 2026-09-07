package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class UserDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.sso_key")
    private String ssoKey;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.active_flag")
    private Boolean activeFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.display_name")
    private String displayName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_name")
    private String userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.migration_hash")
    private String migrationHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_hash")
    private String passwordHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_algo")
    private String passwordAlgo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_salt")
    private String passwordSalt;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.locked_until_ts")
    private OffsetDateTime lockedUntilTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.failed_login_count")
    private Integer failedLoginCount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_changed_ts")
    private OffsetDateTime passwordChangedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.tokens_valid_after_ts")
    private OffsetDateTime tokensValidAfterTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.sso_key")
    public String getSsoKey() {
        return ssoKey;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.sso_key")
    public void setSsoKey(String ssoKey) {
        this.ssoKey = ssoKey;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.active_flag")
    public Boolean getActiveFlag() {
        return activeFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.active_flag")
    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.display_name")
    public String getDisplayName() {
        return displayName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_name")
    public String getUserName() {
        return userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.migration_hash")
    public String getMigrationHash() {
        return migrationHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.migration_hash")
    public void setMigrationHash(String migrationHash) {
        this.migrationHash = migrationHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_hash")
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_algo")
    public String getPasswordAlgo() {
        return passwordAlgo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_algo")
    public void setPasswordAlgo(String passwordAlgo) {
        this.passwordAlgo = passwordAlgo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_salt")
    public String getPasswordSalt() {
        return passwordSalt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_salt")
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.locked_until_ts")
    public OffsetDateTime getLockedUntilTs() {
        return lockedUntilTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.locked_until_ts")
    public void setLockedUntilTs(OffsetDateTime lockedUntilTs) {
        this.lockedUntilTs = lockedUntilTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.failed_login_count")
    public Integer getFailedLoginCount() {
        return failedLoginCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.failed_login_count")
    public void setFailedLoginCount(Integer failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_changed_ts")
    public OffsetDateTime getPasswordChangedTs() {
        return passwordChangedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.password_changed_ts")
    public void setPasswordChangedTs(OffsetDateTime passwordChangedTs) {
        this.passwordChangedTs = passwordChangedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.tokens_valid_after_ts")
    public OffsetDateTime getTokensValidAfterTs() {
        return tokensValidAfterTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user.tokens_valid_after_ts")
    public void setTokensValidAfterTs(OffsetDateTime tokensValidAfterTs) {
        this.tokensValidAfterTs = tokensValidAfterTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public Integer getPkId() {
        return userId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}