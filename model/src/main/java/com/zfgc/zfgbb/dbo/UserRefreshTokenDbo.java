package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class UserRefreshTokenDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_refresh_token_id")
    private Integer userRefreshTokenId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_id")
    private Integer userId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.token_hash")
    private String tokenHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.issued_ts")
    private OffsetDateTime issuedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.expires_ts")
    private OffsetDateTime expiresTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_flag")
    private Boolean revokedFlag;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.updated_ts")
    private OffsetDateTime updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.rotated_ts")
    private OffsetDateTime rotatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.family_id")
    private String familyId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.successor_id")
    private Integer successorId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_ts")
    private OffsetDateTime revokedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_refresh_token_id")
    public Integer getUserRefreshTokenId() {
        return userRefreshTokenId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_refresh_token_id")
    public void setUserRefreshTokenId(Integer userRefreshTokenId) {
        this.userRefreshTokenId = userRefreshTokenId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_id")
    public Integer getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.token_hash")
    public String getTokenHash() {
        return tokenHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.token_hash")
    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.issued_ts")
    public OffsetDateTime getIssuedTs() {
        return issuedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.issued_ts")
    public void setIssuedTs(OffsetDateTime issuedTs) {
        this.issuedTs = issuedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.expires_ts")
    public OffsetDateTime getExpiresTs() {
        return expiresTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.expires_ts")
    public void setExpiresTs(OffsetDateTime expiresTs) {
        this.expiresTs = expiresTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_flag")
    public Boolean getRevokedFlag() {
        return revokedFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_flag")
    public void setRevokedFlag(Boolean revokedFlag) {
        this.revokedFlag = revokedFlag;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.updated_ts")
    public OffsetDateTime getUpdatedTs() {
        return updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.updated_ts")
    public void setUpdatedTs(OffsetDateTime updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.rotated_ts")
    public OffsetDateTime getRotatedTs() {
        return rotatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.rotated_ts")
    public void setRotatedTs(OffsetDateTime rotatedTs) {
        this.rotatedTs = rotatedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.family_id")
    public String getFamilyId() {
        return familyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.family_id")
    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.successor_id")
    public Integer getSuccessorId() {
        return successorId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.successor_id")
    public void setSuccessorId(Integer successorId) {
        this.successorId = successorId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_ts")
    public OffsetDateTime getRevokedTs() {
        return revokedTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.user_refresh_token.revoked_ts")
    public void setRevokedTs(OffsetDateTime revokedTs) {
        this.revokedTs = revokedTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public Integer getPkId() {
        return userRefreshTokenId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.user_refresh_token")
    public OffsetDateTime getUpdatedTime() {
        return updatedTs;
    }
}