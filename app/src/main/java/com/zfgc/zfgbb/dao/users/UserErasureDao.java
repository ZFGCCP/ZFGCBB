package com.zfgc.zfgbb.dao.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zfgc.zfgbb.mappers.custom.UserDeletionMapper;
import com.zfgc.zfgbb.model.users.UserSummary;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserErasureDao {

	private final UserDeletionMapper userDeletionMapper;

	public List<UserSummary> listUsers() {
		return userDeletionMapper.listUsers();
	}

	public Optional<Integer> findUserIdBySsoKey(String ssoKey) {
		return userDeletionMapper.findUserIdBySsoKey(ssoKey);
	}

	public boolean isSiteAdmin(Integer userId) {
		return userDeletionMapper.isSiteAdmin(userId);
	}

	public int reassignThreads(Integer userId, Integer sentinelId) {
		return userDeletionMapper.reassignThreads(userId, sentinelId);
	}

	public int reassignContentResources(Integer userId, Integer sentinelId) {
		return userDeletionMapper.reassignContentResources(userId, sentinelId);
	}

	public int reassignPolls(Integer userId, Integer sentinelId) {
		return userDeletionMapper.reassignPolls(userId, sentinelId);
	}

	public int resequencePostInThread(List<Integer> threadIds) {
		return userDeletionMapper.resequencePostInThread(threadIds);
	}

	public int deleteUserPollVotes(Integer userId) {
		return userDeletionMapper.deleteUserPollVotes(userId);
	}

	public int deleteUserPollChoices(Integer userId) {
		return userDeletionMapper.deleteUserPollChoices(userId);
	}

	public int acquireAdminRosterLock() {
		return userDeletionMapper.acquireAdminRosterLock();
	}

	public int countSiteAdmins() {
		return userDeletionMapper.countSiteAdmins();
	}

	public Optional<String> findPrimaryEmailAddress(Integer userId) {
		return userDeletionMapper.findPrimaryEmailAddress(userId);
	}

	public Optional<String> findUserName(Integer userId) {
		return userDeletionMapper.findUserName(userId);
	}

	public int neutralizeUserRow(Integer userId, String ssoKeyToken) {
		return userDeletionMapper.neutralizeUserRow(userId, ssoKeyToken);
	}

	public Optional<Integer> findBioAvatarId(Integer userId) {
		return userDeletionMapper.findBioAvatarId(userId);
	}

	public int scrubUserBioInfo(Integer userId) {
		return userDeletionMapper.scrubUserBioInfo(userId);
	}

	public int deleteUserContactTypes(Integer userId) {
		return userDeletionMapper.deleteUserContactTypes(userId);
	}

	public List<Integer> findEmailAddressIds(Integer userId) {
		return userDeletionMapper.findEmailAddressIds(userId);
	}

	public int deleteEmailAddressIfUnreferenced(Integer emailAddressId) {
		return userDeletionMapper.deleteEmailAddressIfUnreferenced(emailAddressId);
	}

	public int countOwnedMessages(Integer userId) {
		return userDeletionMapper.countOwnedMessages(userId);
	}

	public int countOwnedThreads(Integer userId) {
		return userDeletionMapper.countOwnedThreads(userId);
	}

	public List<Integer> findOwnedMessageIds(Integer userId, int limit) {
		return userDeletionMapper.findOwnedMessageIds(userId, limit);
	}

	public int deleteAttachmentRefRewritesForMessages(List<Integer> messageIds) {
		return userDeletionMapper.deleteAttachmentRefRewritesForMessages(messageIds);
	}

	public List<Integer> findAttachmentIdsForMessages(List<Integer> messageIds) {
		return userDeletionMapper.findAttachmentIdsForMessages(messageIds);
	}

	public int scrubAttachmentMigrationHashesForMessages(List<Integer> messageIds) {
		return userDeletionMapper.scrubAttachmentMigrationHashesForMessages(messageIds);
	}

	public List<Integer> findAttachmentContentResourceIds(List<Integer> messageIds) {
		return userDeletionMapper.findAttachmentContentResourceIds(messageIds);
	}

	public List<Integer> findHistoryIpAddressIds(List<Integer> messageIds) {
		return userDeletionMapper.findHistoryIpAddressIds(messageIds);
	}

	public int deleteHistoryForMessages(List<Integer> messageIds) {
		return userDeletionMapper.deleteHistoryForMessages(messageIds);
	}

	public int scrubHistoryForMessages(List<Integer> messageIds) {
		return userDeletionMapper.scrubHistoryForMessages(messageIds);
	}

	public int deleteUnreferencedIpAddresses(List<Integer> ipAddressIds) {
		return userDeletionMapper.deleteUnreferencedIpAddresses(ipAddressIds);
	}

	public int deleteMessagesByIds(List<Integer> messageIds) {
		return userDeletionMapper.deleteMessagesByIds(messageIds);
	}

	public int reassignAndScrubMessages(List<Integer> messageIds, Integer sentinelId) {
		return userDeletionMapper.reassignAndScrubMessages(messageIds, sentinelId);
	}

	public List<Integer> findOwnedPollIds(Integer userId) {
		return userDeletionMapper.findOwnedPollIds(userId);
	}

	public List<Integer> findVotedPollChoiceIds(Integer userId) {
		return userDeletionMapper.findVotedPollChoiceIds(userId);
	}

	public int recountPollChoiceVotes(List<Integer> pollChoiceIds) {
		return userDeletionMapper.recountPollChoiceVotes(pollChoiceIds);
	}

	public List<Integer> findParticipantConversationIds(Integer userId) {
		return userDeletionMapper.findParticipantConversationIds(userId);
	}

	public int scrubSentPersonalMessages(Integer userId) {
		return userDeletionMapper.scrubSentPersonalMessages(userId);
	}

	public int gcEmptyConversationsAmong(List<Integer> conversationIds) {
		return userDeletionMapper.gcEmptyConversationsAmong(conversationIds);
	}

	public List<Integer> findOwnedContentEntityIdsByType(Integer userId, String entityType) {
		return userDeletionMapper.findOwnedContentEntityIdsByType(userId, entityType);
	}

	public List<Integer> findEntityReleasedContentResourceIds(List<Integer> entityIds) {
		return userDeletionMapper.findEntityReleasedContentResourceIds(entityIds);
	}

	public List<Integer> findOwnedHardDeletableWikiPageIds(Integer userId) {
		return userDeletionMapper.findOwnedHardDeletableWikiPageIds(userId);
	}

	public List<Integer> findOwnedTemplateLinkedWikiPageIds(Integer userId) {
		return userDeletionMapper.findOwnedTemplateLinkedWikiPageIds(userId);
	}

	public int nullRetainedEntityWikiPageLinks(List<Integer> pageIds) {
		return userDeletionMapper.nullRetainedEntityWikiPageLinks(pageIds);
	}

	public List<Integer> findWikiPageContentResourceIds(List<Integer> pageIds) {
		return userDeletionMapper.findWikiPageContentResourceIds(pageIds);
	}

	public int nullWikiPageCreators(Integer userId) {
		return userDeletionMapper.nullWikiPageCreators(userId);
	}

	public int scrubRetainedWikiRevisions(Integer userId) {
		return userDeletionMapper.scrubRetainedWikiRevisions(userId);
	}

	public int scrubRetainedContentEntities(Integer userId) {
		return userDeletionMapper.scrubRetainedContentEntities(userId);
	}

	public int scrubProjectNewsAuthors(Integer userId) {
		return userDeletionMapper.scrubProjectNewsAuthors(userId);
	}

	public int nullTeamCreators(Integer userId) {
		return userDeletionMapper.nullTeamCreators(userId);
	}

	public int nullAwardGranters(Integer userId) {
		return userDeletionMapper.nullAwardGranters(userId);
	}

	public Optional<Integer> findAvatarContentResourceId(Integer avatarId) {
		return userDeletionMapper.findAvatarContentResourceId(avatarId);
	}

	public List<Integer> findUnreferencedContentResourceIds(List<Integer> resourceIds) {
		return userDeletionMapper.findUnreferencedContentResourceIds(resourceIds);
	}

	public List<Integer> findOwnedUnreferencedContentResourceIds(Integer userId, int limit) {
		return userDeletionMapper.findOwnedUnreferencedContentResourceIds(userId, limit);
	}

	public int scrubIssuedWarnings(Integer userId) {
		return userDeletionMapper.scrubIssuedWarnings(userId);
	}

	public int nullModerationLogActors(Integer userId) {
		return userDeletionMapper.nullModerationLogActors(userId);
	}

	public int scrubModerationLogTargets(Integer userId) {
		return userDeletionMapper.scrubModerationLogTargets(userId);
	}

	public int scrubModerationLogTargetsByName(String userName) {
		return userDeletionMapper.scrubModerationLogTargetsByName(userName);
	}

	public int nullMigrationConflictResolvers(Integer userId) {
		return userDeletionMapper.nullMigrationConflictResolvers(userId);
	}

	public int scrubGivenReactions(Integer userId) {
		return userDeletionMapper.scrubGivenReactions(userId);
	}

	public List<Integer> findOwnedThreadIds(Integer userId) {
		return userDeletionMapper.findOwnedThreadIds(userId);
	}

	public List<Integer> findThreadIdsForMessages(List<Integer> messageIds) {
		return userDeletionMapper.findThreadIdsForMessages(messageIds);
	}

	public List<Integer> findEmptyThreadIdsAmong(List<Integer> threadIds) {
		return userDeletionMapper.findEmptyThreadIdsAmong(threadIds);
	}

	public List<Integer> findPollIdsOnThreads(List<Integer> threadIds) {
		return userDeletionMapper.findPollIdsOnThreads(threadIds);
	}

	public int deleteVotesForPollsOnThreads(List<Integer> threadIds) {
		return userDeletionMapper.deleteVotesForPollsOnThreads(threadIds);
	}

	public int deleteChoicesForPollsOnThreads(List<Integer> threadIds) {
		return userDeletionMapper.deleteChoicesForPollsOnThreads(threadIds);
	}

	public int deleteThreadsByIds(List<Integer> threadIds) {
		return userDeletionMapper.deleteThreadsByIds(threadIds);
	}
}
