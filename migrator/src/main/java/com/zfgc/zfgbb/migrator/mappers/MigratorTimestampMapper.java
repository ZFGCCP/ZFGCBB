package com.zfgc.zfgbb.migrator.mappers;

import java.time.OffsetDateTime;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface MigratorTimestampMapper {

	@Update("""
			update zfgbb.message
			set created_ts = #{createdTs},
			    updated_ts = #{updatedTs}
			where message_id = #{messageId}
			""")
	int setMessageTimestamps(
			@Param("messageId") Integer messageId,
			@Param("createdTs") OffsetDateTime createdTs,
			@Param("updatedTs") OffsetDateTime updatedTs);

	@Update("""
			update zfgbb.message_history
			set created_ts = #{createdTs},
			    updated_ts = #{updatedTs}
			where message_history_id = #{messageHistoryId}
			""")
	int setMessageHistoryTimestamps(
			@Param("messageHistoryId") Integer messageHistoryId,
			@Param("createdTs") OffsetDateTime createdTs,
			@Param("updatedTs") OffsetDateTime updatedTs);

	@Update("""
			update zfgbb.karma
			set created_ts = #{createdTs},
			    updated_ts = #{updatedTs}
			where karma_id = #{karmaId}
			""")
	int setKarmaTimestamps(
			@Param("karmaId") Integer karmaId,
			@Param("createdTs") OffsetDateTime createdTs,
			@Param("updatedTs") OffsetDateTime updatedTs);
}
