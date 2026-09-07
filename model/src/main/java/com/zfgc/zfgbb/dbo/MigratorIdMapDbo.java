package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class MigratorIdMapDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.migrator_id_map_id")
    private Long migratorIdMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.entity_type")
    private String entityType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.legacy_id")
    private Integer legacyId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.zfgbb_id")
    private Integer zfgbbId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.created_ts")
    private OffsetDateTime createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.migrator_id_map_id")
    public Long getMigratorIdMapId() {
        return migratorIdMapId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.migrator_id_map_id")
    public void setMigratorIdMapId(Long migratorIdMapId) {
        this.migratorIdMapId = migratorIdMapId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.entity_type")
    public String getEntityType() {
        return entityType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.entity_type")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.legacy_id")
    public Integer getLegacyId() {
        return legacyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.legacy_id")
    public void setLegacyId(Integer legacyId) {
        this.legacyId = legacyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.zfgbb_id")
    public Integer getZfgbbId() {
        return zfgbbId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.zfgbb_id")
    public void setZfgbbId(Integer zfgbbId) {
        this.zfgbbId = zfgbbId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.created_ts")
    public OffsetDateTime getCreatedTs() {
        return createdTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_id_map.created_ts")
    public void setCreatedTs(OffsetDateTime createdTs) {
        this.createdTs = createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public Integer getPkId() {
        return null;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public OffsetDateTime getCreatedTime() {
        return createdTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_id_map")
    public OffsetDateTime getUpdatedTime() {
        return null;
    }
}