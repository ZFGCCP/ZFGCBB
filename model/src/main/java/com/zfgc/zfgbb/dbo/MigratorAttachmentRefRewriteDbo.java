package com.zfgc.zfgbb.dbo;

import jakarta.annotation.Generated;
import java.time.OffsetDateTime;

public class MigratorAttachmentRefRewriteDbo extends AbstractDbo {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.message_history_id")
    private Integer messageHistoryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.rewritten_ts")
    private OffsetDateTime rewrittenTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.message_history_id")
    public Integer getMessageHistoryId() {
        return messageHistoryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.message_history_id")
    public void setMessageHistoryId(Integer messageHistoryId) {
        this.messageHistoryId = messageHistoryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.rewritten_ts")
    public OffsetDateTime getRewrittenTs() {
        return rewrittenTs;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: zfgbb.migrator_attachment_ref_rewrites.rewritten_ts")
    public void setRewrittenTs(OffsetDateTime rewrittenTs) {
        this.rewrittenTs = rewrittenTs;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public Integer getPkId() {
        return messageHistoryId;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public OffsetDateTime getCreatedTime() {
        return null;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: zfgbb.migrator_attachment_ref_rewrites")
    public OffsetDateTime getUpdatedTime() {
        return null;
    }
}