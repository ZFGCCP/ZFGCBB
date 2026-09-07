package com.zfgc.zfgbb.mappers.custom;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zfgc.zfgbb.model.users.UserSummary;

public interface UserDeletionMapper {

	@Select("""
			select u.user_id as userId, u.user_name as userName, u.display_name as displayName,
			       exists(select 1 from zfgbb.user_permission_view v
			              where v.user_id = u.user_id and v.permission_code = 'ZFGC_SITE_ADMIN') as siteAdmin
			from zfgbb."user" u
			order by u.user_id
			""")
	List<UserSummary> listUsers();

	@Select("select user_id from zfgbb.\"user\" where sso_key = #{ssoKey}")
	Optional<Integer> findUserIdBySsoKey(@Param("ssoKey") String ssoKey);

	@Select("""
			select exists(
			  select 1 from zfgbb.user_permission_view v
			  where v.user_id = #{userId} and v.permission_code = 'ZFGC_SITE_ADMIN')
			""")
	boolean isSiteAdmin(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.thread set created_user_id = #{sentinelId}, migration_hash = null
			where created_user_id = #{userId}
			""")
	int reassignThreads(@Param("userId") Integer userId, @Param("sentinelId") Integer sentinelId);

	@Update("""
			update zfgbb.content_resource set uploaded_user_id = #{sentinelId}, migration_hash = null
			where uploaded_user_id = #{userId}
			""")
	int reassignContentResources(@Param("userId") Integer userId, @Param("sentinelId") Integer sentinelId);

	@Update("""
			update zfgbb.poll set created_user_id = #{sentinelId}, migration_hash = null
			where created_user_id = #{userId}
			""")
	int reassignPolls(@Param("userId") Integer userId, @Param("sentinelId") Integer sentinelId);

	@Update("""
			<script>
			update zfgbb.message m
			set post_in_thread = s.rn
			from (
			  select message_id,
			         row_number() over (partition by thread_id order by post_in_thread, message_id) as rn
			  from zfgbb.message
			  where thread_id in
			    <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>
			) s
			where m.message_id = s.message_id
			</script>
			""")
	int resequencePostInThread(@Param("threadIds") List<Integer> threadIds);

	@Delete("""
			delete from zfgbb.user_poll_choice where poll_choice_id in
			  (select poll_choice_id from zfgbb.poll_choice where poll_id in
			    (select poll_id from zfgbb.poll where created_user_id = #{userId}))
			""")
	int deleteUserPollVotes(@Param("userId") Integer userId);

	@Delete("""
			delete from zfgbb.poll_choice where poll_id in
			  (select poll_id from zfgbb.poll where created_user_id = #{userId})
			""")
	int deleteUserPollChoices(@Param("userId") Integer userId);

	@Select("select 1 from (select pg_advisory_xact_lock(hashtext('zfgbb_admin_roster')::bigint)) lock_acquired")
	int acquireAdminRosterLock();

	@Select("""
			select count(distinct v.user_id) from zfgbb.user_permission_view v
			where v.permission_code = 'ZFGC_SITE_ADMIN'
			""")
	int countSiteAdmins();

	@Select("""
			select ea.email_address from zfgbb.email_address ea
			join zfgbb.user_contact_info uci on uci.email_address_id = ea.email_address_id
			where uci.user_id = #{userId}
			limit 1
			""")
	Optional<String> findPrimaryEmailAddress(@Param("userId") Integer userId);

	@Select("select user_name from zfgbb.\"user\" where user_id = #{userId}")
	Optional<String> findUserName(@Param("userId") Integer userId);

	@Update("""
			update zfgbb."user"
			set display_name = '[deleted]', user_name = '[deleted]', sso_key = #{ssoKeyToken},
			    migration_hash = null, password_hash = null, password_algo = null, password_salt = null,
			    password_changed_ts = null, locked_until_ts = null, failed_login_count = 0,
			    active_flag = false, tokens_valid_after_ts = current_timestamp, updated_ts = current_timestamp
			where user_id = #{userId}
			""")
	int neutralizeUserRow(@Param("userId") Integer userId, @Param("ssoKeyToken") String ssoKeyToken);

	@Select("select avatar_id from zfgbb.user_bio_info where user_id = #{userId}")
	Optional<Integer> findBioAvatarId(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.user_bio_info
			set real_name = null, birth_date = null, location = null, website_title = null, website_url = null,
			    signature = null, personal_text = null, custom_title = null, gender_id = null,
			    preferred_timezone = null, migration_hash = null, avatar_id = null, updated_ts = current_timestamp
			where user_id = #{userId}
			""")
	int scrubUserBioInfo(@Param("userId") Integer userId);

	@Delete("delete from zfgbb.user_contact_types where user_id = #{userId}")
	int deleteUserContactTypes(@Param("userId") Integer userId);

	@Select("select email_address_id from zfgbb.user_contact_info where user_id = #{userId}")
	List<Integer> findEmailAddressIds(@Param("userId") Integer userId);

	@Delete("""
			delete from zfgbb.email_address ea where ea.email_address_id = #{emailAddressId}
			and not exists (select 1 from zfgbb.user_contact_info uci where uci.email_address_id = ea.email_address_id)
			""")
	int deleteEmailAddressIfUnreferenced(@Param("emailAddressId") Integer emailAddressId);

	@Select("select count(*) from zfgbb.message where owner_id = #{userId}")
	int countOwnedMessages(@Param("userId") Integer userId);

	@Select("select count(*) from zfgbb.thread where created_user_id = #{userId}")
	int countOwnedThreads(@Param("userId") Integer userId);

	@Select("select message_id from zfgbb.message where owner_id = #{userId} order by message_id limit #{limit}")
	List<Integer> findOwnedMessageIds(@Param("userId") Integer userId, @Param("limit") int limit);

	@Delete("""
			<script>
			delete from zfgbb.migrator_attachment_ref_rewrites where message_history_id in
			  (select message_history_id from zfgbb.message_history where message_id in
			    <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>)
			</script>
			""")
	int deleteAttachmentRefRewritesForMessages(@Param("messageIds") List<Integer> messageIds);

	@Select("""
			<script>
			select file_attachment_id from zfgbb.file_attachments where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	List<Integer> findAttachmentIdsForMessages(@Param("messageIds") List<Integer> messageIds);

	@Update("""
			<script>
			update zfgbb.file_attachments set migration_hash = null where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	int scrubAttachmentMigrationHashesForMessages(@Param("messageIds") List<Integer> messageIds);

	@Select("""
			<script>
			select distinct content_resource_id from zfgbb.file_attachments where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	List<Integer> findAttachmentContentResourceIds(@Param("messageIds") List<Integer> messageIds);

	@Select("""
			<script>
			select distinct ip_address_id from zfgbb.message_history
			where ip_address_id is not null and message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	List<Integer> findHistoryIpAddressIds(@Param("messageIds") List<Integer> messageIds);

	@Delete("""
			<script>
			delete from zfgbb.message_history where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	int deleteHistoryForMessages(@Param("messageIds") List<Integer> messageIds);

	@Update("""
			<script>
			update zfgbb.message_history set ip_address_id = null, migration_hash = null
			where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	int scrubHistoryForMessages(@Param("messageIds") List<Integer> messageIds);

	@Delete("""
			<script>
			delete from zfgbb.ip_address ip where ip.ip_address_id in
			  <foreach item='ipAddressId' collection='ipAddressIds' open='(' separator=',' close=')'>#{ipAddressId}</foreach>
			and not exists (select 1 from zfgbb.message_history mh where mh.ip_address_id = ip.ip_address_id)
			</script>
			""")
	int deleteUnreferencedIpAddresses(@Param("ipAddressIds") List<Integer> ipAddressIds);

	@Delete("""
			<script>
			delete from zfgbb.message where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	int deleteMessagesByIds(@Param("messageIds") List<Integer> messageIds);

	@Update("""
			<script>
			update zfgbb.message set owner_id = #{sentinelId}, migration_hash = null
			where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	int reassignAndScrubMessages(@Param("messageIds") List<Integer> messageIds,
			@Param("sentinelId") Integer sentinelId);

	@Select("select poll_id from zfgbb.poll where created_user_id = #{userId}")
	List<Integer> findOwnedPollIds(@Param("userId") Integer userId);

	@Select("""
			select distinct poll_choice_id from zfgbb.user_poll_choice
			where user_id = #{userId} and poll_choice_id is not null
			""")
	List<Integer> findVotedPollChoiceIds(@Param("userId") Integer userId);

	@Update("""
			<script>
			update zfgbb.poll_choice pc
			set votes = (select count(*) from zfgbb.user_poll_choice upc where upc.poll_choice_id = pc.poll_choice_id)
			where pc.poll_choice_id in
			  <foreach item='pollChoiceId' collection='pollChoiceIds' open='(' separator=',' close=')'>#{pollChoiceId}</foreach>
			</script>
			""")
	int recountPollChoiceVotes(@Param("pollChoiceIds") List<Integer> pollChoiceIds);

	@Select("""
			select distinct pm.personal_message_conversation_id from zfgbb.personal_message pm
			where pm.sender_user_id = #{userId}
			union
			select distinct pm.personal_message_conversation_id from zfgbb.personal_message pm
			join zfgbb.personal_message_recipient pr on pr.personal_message_id = pm.personal_message_id
			where pr.recipient_user_id = #{userId}
			""")
	List<Integer> findParticipantConversationIds(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.personal_message
			set sender_user_id = null, sender_name = '[deleted]', updated_ts = current_timestamp
			where sender_user_id = #{userId}
			""")
	int scrubSentPersonalMessages(@Param("userId") Integer userId);

	@Delete("""
			<script>
			delete from zfgbb.personal_message_conversation c
			where c.personal_message_conversation_id in
			  <foreach item='conversationId' collection='conversationIds' open='(' separator=',' close=')'>#{conversationId}</foreach>
			and not exists (select 1 from zfgbb.personal_message pm
			  where pm.personal_message_conversation_id = c.personal_message_conversation_id)
			</script>
			""")
	int gcEmptyConversationsAmong(@Param("conversationIds") List<Integer> conversationIds);

	@Select("""
			select content_entity_id from zfgbb.content_entity
			where created_user_id = #{userId} and entity_type = #{entityType}
			""")
	List<Integer> findOwnedContentEntityIdsByType(@Param("userId") Integer userId,
			@Param("entityType") String entityType);

	@Select("""
			<script>
			select ce.preview_content_resource_id as content_resource_id from zfgbb.content_entity ce
			where ce.preview_content_resource_id is not null and ce.content_entity_id in
			  <foreach item='entityId' collection='entityIds' open='(' separator=',' close=')'>#{entityId}</foreach>
			union
			select ps.content_resource_id from zfgbb.project_screenshot ps
			where ps.content_entity_id in
			  <foreach item='entityId' collection='entityIds' open='(' separator=',' close=')'>#{entityId}</foreach>
			union
			select pd.content_resource_id from zfgbb.project_download pd
			where pd.content_entity_id in
			  <foreach item='entityId' collection='entityIds' open='(' separator=',' close=')'>#{entityId}</foreach>
			union
			select r.download_content_resource_id from zfgbb.resource r
			where r.download_content_resource_id is not null and r.content_entity_id in
			  <foreach item='entityId' collection='entityIds' open='(' separator=',' close=')'>#{entityId}</foreach>
			</script>
			""")
	List<Integer> findEntityReleasedContentResourceIds(@Param("entityIds") List<Integer> entityIds);

	@Select("""
			select wp.wiki_page_id from zfgbb.wiki_page wp
			where wp.created_user_id = #{userId}
			and not exists (select 1 from zfgbb.content_template ct where ct.wiki_page_id = wp.wiki_page_id)
			""")
	List<Integer> findOwnedHardDeletableWikiPageIds(@Param("userId") Integer userId);

	@Select("""
			select wp.wiki_page_id from zfgbb.wiki_page wp
			where wp.created_user_id = #{userId}
			and exists (select 1 from zfgbb.content_template ct where ct.wiki_page_id = wp.wiki_page_id)
			""")
	List<Integer> findOwnedTemplateLinkedWikiPageIds(@Param("userId") Integer userId);

	@Update("""
			<script>
			update zfgbb.content_entity set wiki_page_id = null where wiki_page_id in
			  <foreach item='pageId' collection='pageIds' open='(' separator=',' close=')'>#{pageId}</foreach>
			</script>
			""")
	int nullRetainedEntityWikiPageLinks(@Param("pageIds") List<Integer> pageIds);

	@Select("""
			<script>
			select content_resource_id from zfgbb.wiki_page
			where content_resource_id is not null and wiki_page_id in
			  <foreach item='pageId' collection='pageIds' open='(' separator=',' close=')'>#{pageId}</foreach>
			</script>
			""")
	List<Integer> findWikiPageContentResourceIds(@Param("pageIds") List<Integer> pageIds);

	@Update("update zfgbb.wiki_page set created_user_id = null where created_user_id = #{userId}")
	int nullWikiPageCreators(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.wiki_page_revision
			set author_user_id = null, author_name = '[deleted]', migration_hash = null
			where author_user_id = #{userId}
			""")
	int scrubRetainedWikiRevisions(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.content_entity set created_user_id = null, author_name = '[deleted]', migration_hash = null
			where created_user_id = #{userId}
			""")
	int scrubRetainedContentEntities(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.project_news set author_user_id = null, author_name = '[deleted]'
			where author_user_id = #{userId}
			""")
	int scrubProjectNewsAuthors(@Param("userId") Integer userId);

	@Update("update zfgbb.team set created_user_id = null where created_user_id = #{userId}")
	int nullTeamCreators(@Param("userId") Integer userId);

	@Update("update zfgbb.user_award set granted_by_user_id = null where granted_by_user_id = #{userId}")
	int nullAwardGranters(@Param("userId") Integer userId);

	@Select("select content_resource_id from zfgbb.avatar where avatar_id = #{avatarId}")
	Optional<Integer> findAvatarContentResourceId(@Param("avatarId") Integer avatarId);

	String CONTENT_RESOURCE_UNREFERENCED_PREDICATES = """
			and not exists (select 1 from zfgbb.avatar a where a.content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.file_attachments fa where fa.content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.permission_group pg where pg.star_image = cr.content_resource_id)
			and not exists (select 1 from zfgbb.wiki_page wp where wp.content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.content_entity ce where ce.preview_content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.project_screenshot ps where ps.content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.project_download pd where pd.content_resource_id = cr.content_resource_id)
			and not exists (select 1 from zfgbb.resource r where r.download_content_resource_id = cr.content_resource_id)
			""";

	@Select("""
			<script>
			select cr.content_resource_id from zfgbb.content_resource cr
			where cr.content_resource_id in
			  <foreach item='resourceId' collection='resourceIds' open='(' separator=',' close=')'>#{resourceId}</foreach>
			""" + CONTENT_RESOURCE_UNREFERENCED_PREDICATES + """
			</script>
			""")
	List<Integer> findUnreferencedContentResourceIds(@Param("resourceIds") List<Integer> resourceIds);

	@Select("""
			select cr.content_resource_id from zfgbb.content_resource cr
			where cr.uploaded_user_id = #{userId}
			""" + CONTENT_RESOURCE_UNREFERENCED_PREDICATES + """
			order by cr.content_resource_id
			limit #{limit}
			""")
	List<Integer> findOwnedUnreferencedContentResourceIds(@Param("userId") Integer userId, @Param("limit") int limit);

	@Update("""
			update zfgbb.user_warning set issued_by_user_id = null, issued_by_name = '[deleted]'
			where issued_by_user_id = #{userId}
			""")
	int scrubIssuedWarnings(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.moderation_log set actor_user_id = null
			where actor_user_id = #{userId}
			""")
	int nullModerationLogActors(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.moderation_log
			set target_user_id = null, target_name = '[deleted]'
			where target_user_id = #{userId}
			""")
	int scrubModerationLogTargets(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.moderation_log
			set target_name = '[deleted]'
			where target_user_id is null and lower(target_name) = lower(#{userName})
			""")
	int scrubModerationLogTargetsByName(@Param("userName") String userName);

	@Update("update zfgbb.migration_conflict set resolved_by_user_id = null where resolved_by_user_id = #{userId}")
	int nullMigrationConflictResolvers(@Param("userId") Integer userId);

	@Update("""
			update zfgbb.reaction set reactor_user_id = null, comment = null, migration_hash = null
			where reactor_user_id = #{userId}
			""")
	int scrubGivenReactions(@Param("userId") Integer userId);

	@Select("select thread_id from zfgbb.thread where created_user_id = #{userId}")
	List<Integer> findOwnedThreadIds(@Param("userId") Integer userId);

	@Select("""
			<script>
			select distinct thread_id from zfgbb.message where message_id in
			  <foreach item='messageId' collection='messageIds' open='(' separator=',' close=')'>#{messageId}</foreach>
			</script>
			""")
	List<Integer> findThreadIdsForMessages(@Param("messageIds") List<Integer> messageIds);

	@Select("""
			<script>
			select t.thread_id from zfgbb.thread t
			where t.thread_id in
			  <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>
			and not exists (select 1 from zfgbb.message m where m.thread_id = t.thread_id)
			</script>
			""")
	List<Integer> findEmptyThreadIdsAmong(@Param("threadIds") List<Integer> threadIds);

	@Select("""
			<script>
			select poll_id from zfgbb.poll where thread_id in
			  <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>
			</script>
			""")
	List<Integer> findPollIdsOnThreads(@Param("threadIds") List<Integer> threadIds);

	@Delete("""
			<script>
			delete from zfgbb.user_poll_choice where poll_choice_id in
			  (select pc.poll_choice_id from zfgbb.poll_choice pc
			   join zfgbb.poll p on p.poll_id = pc.poll_id
			   where p.thread_id in
			     <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>)
			</script>
			""")
	int deleteVotesForPollsOnThreads(@Param("threadIds") List<Integer> threadIds);

	@Delete("""
			<script>
			delete from zfgbb.poll_choice where poll_id in
			  (select poll_id from zfgbb.poll where thread_id in
			    <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>)
			</script>
			""")
	int deleteChoicesForPollsOnThreads(@Param("threadIds") List<Integer> threadIds);

	@Delete("""
			<script>
			delete from zfgbb.thread where thread_id in
			  <foreach item='threadId' collection='threadIds' open='(' separator=',' close=')'>#{threadId}</foreach>
			</script>
			""")
	int deleteThreadsByIds(@Param("threadIds") List<Integer> threadIds);
}
