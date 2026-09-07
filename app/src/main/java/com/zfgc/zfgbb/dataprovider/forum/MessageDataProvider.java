package com.zfgc.zfgbb.dataprovider.forum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;
import com.zfgc.zfgbb.dao.cms.ContentResourceDao;
import com.zfgc.zfgbb.dao.forum.AllMessagesInThreadViewDao;
import com.zfgc.zfgbb.dao.forum.BoardPermissionViewDao;
import com.zfgc.zfgbb.dao.forum.CurrentMessageDao;
import com.zfgc.zfgbb.dao.forum.FileAttachmentsDao;
import com.zfgc.zfgbb.dao.forum.MessageDao;
import com.zfgc.zfgbb.dao.forum.MessageHistoryDao;
import com.zfgc.zfgbb.dao.users.UserDao;
import com.zfgc.zfgbb.dataprovider.AbstractDataProvider;
import com.zfgc.zfgbb.dataprovider.users.UserDataProvider;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDbo;
import com.zfgc.zfgbb.dbo.AllMessagesInThreadViewDboExample;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDbo;
import com.zfgc.zfgbb.dbo.BoardPermissionViewDboExample;
import com.zfgc.zfgbb.dbo.ContentResourceDbo;
import com.zfgc.zfgbb.dbo.ContentResourceDboExample;
import com.zfgc.zfgbb.dbo.CurrentMessageDbo;
import com.zfgc.zfgbb.dbo.CurrentMessageDboExample;
import com.zfgc.zfgbb.dbo.FileAttachmentDbo;
import com.zfgc.zfgbb.dbo.FileAttachmentDboExample;
import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.MessageHistoryDbo;
import com.zfgc.zfgbb.dbo.MessageHistoryDboExample;
import com.zfgc.zfgbb.exception.ZfgcNotFoundException;
import com.zfgc.zfgbb.mapstruct.forum.MessageMap;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.model.forum.FileAttachment;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MessageDataProvider extends AbstractDataProvider {
	private final MessageDao messageDao;
	
	private final MessageHistoryDao messageHistoryDao;

	private final CurrentMessageDao currentMessageDao;
	
	private final UserDataProvider userDataProvider;

	private final FileAttachmentsDao fileAttachmentsDao;

	private final ContentResourceDao contentResourceDao;

	private final BoardPermissionViewDao boardPermissionViewDao;

	private final AllMessagesInThreadViewDao allMessagesInThreadViewDao;

	private final MessageMap messageMap;
	
	public Message getMessage(Integer messageId) {
		Message message = map(messageDao.find(messageId).orElseThrow(ZfgcNotFoundException::new), Message.class);
		MessageHistoryDboExample ex = new MessageHistoryDboExample();
		ex.createCriteria().andMessageIdEqualTo(messageId).andCurrentFlagEqualTo(true);
		List<MessageHistory> history = super.convertDboListToModel(messageHistoryDao.get(ex), MessageHistory.class);
		message.setCurrentMessage(history.get(0));
		
		return message;
	}
	
	public Message saveMessage(Message message) {
		MessageDbo messageDbo = map(message, MessageDbo.class);
		
		messageDbo = messageDao.save(messageDbo);
		
		MessageHistory history = message.getCurrentMessage();
		history.setMessageId(messageDbo.getMessageId());
		MessageHistoryDbo historyDbo = map(history, MessageHistoryDbo.class);
		historyDbo.setMessageText(history.getUnparsedText());
		// New history rows are always the current revision; the older revision (if any)
		// will be flipped to false when an edit comes in. Default here so the caller
		// doesn't have to set it on every fresh post.
		if (historyDbo.getCurrentFlag() == null) {
			historyDbo.setCurrentFlag(true);
		}
		historyDbo = messageHistoryDao.save(historyDbo);
		
		Message result = map(messageDbo, Message.class);
		result.setCurrentMessage(map(historyDbo, MessageHistory.class));
		
		return result;
	}
	
	public List<Message> getMessagesForThread(Integer threadId, Integer page, Integer count){
		Integer start = ((page - 1)*count) + 1;
		CurrentMessageDboExample ex = new CurrentMessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId)
						   .andPostInThreadBetween(start, start + count - 1);
		ex.setOrderByClause("post_in_thread asc");

		List<Message> messages = currentMessageDao.get(ex)
						 .stream()
						 .map(this::mapMessage).toList();

		hydrateAttachments(messages);
		return messages;
	}

	private void hydrateAttachments(List<Message> messages) {
		List<Integer> messageIds = messages.stream()
				.map(Message::getMessageId)
				.filter(id -> id != null)
				.toList();
		if (messageIds.isEmpty()) return;

		FileAttachmentDboExample faEx = new FileAttachmentDboExample();
		faEx.createCriteria().andMessageIdIn(messageIds);
		List<FileAttachmentDbo> attachmentDbos = fileAttachmentsDao.get(faEx);
		if (attachmentDbos.isEmpty()) return;

		List<Integer> resourceIds = attachmentDbos.stream()
				.map(FileAttachmentDbo::getContentResourceId).distinct().toList();
		ContentResourceDboExample crEx = new ContentResourceDboExample();
		crEx.createCriteria().andContentResourceIdIn(resourceIds);
		Map<Integer, ContentResourceDbo> resourceById = contentResourceDao.get(crEx).stream()
				.collect(Collectors.toMap(ContentResourceDbo::getContentResourceId, r -> r));

		Map<Integer, List<FileAttachment>> byMessageId = attachmentDbos.stream()
				.collect(Collectors.groupingBy(FileAttachmentDbo::getMessageId,
						Collectors.mapping(fa -> {
							ContentResourceDbo cr = resourceById.get(fa.getContentResourceId());
							return FileAttachment.builder()
									.fileAttachmentId(fa.getFileAttachmentId())
									.contentResourceId(fa.getContentResourceId())
									.filename(cr != null ? cr.getFilename() : null)
									.mimeType(cr != null ? cr.getMimeType() : null)
									.fileSize(cr != null ? cr.getFileSize() : null)
									.downloads(fa.getDownloads())
									.build();
						}, Collectors.toList())));

		messages.forEach(m -> m.setFileAttachments(
				byMessageId.getOrDefault(m.getMessageId(), Collections.emptyList())));
	}
	
	private Message mapMessage(CurrentMessageDbo msgDbo){
		 
		 MessageHistory hist = map(msgDbo, MessageHistory.class);
		 hist.setUnparsedText(hist.getMessageText());
		 
		 User createdUser = userDataProvider.findUser(msgDbo.getOwnerId())
				 .orElseGet(User::orphaned);
		 
		 return messageMap.toModel(msgDbo, createdUser)
		 		   .toBuilder()
		 		   .currentMessage(hist)
		 		   .build();
	}
	
	public Message postMessageToThread(Integer threadId, Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getCurrentMessage(), "message history cannot be null.");
		Preconditions.checkNotNull(threadId, "threadId cannot be null.");
		//ensure we have the right thread set
		message.setThreadId(threadId);
		MessageDbo db = map(message, MessageDbo.class);
		
		//insert a message history record
		MessageHistoryDbo histDb = map(message.getCurrentMessage(), 
											  MessageHistoryDbo.class);
		
		histDb = messageHistoryDao.save(histDb);
		
		Message result = map(messageDao.save(db), Message.class);
		result.setCurrentMessage(map(histDb, MessageHistory.class));
		
		return result;
	}
	
	public Message editMessage(Message message) {
		Preconditions.checkNotNull(message, "message cannot be null.");
		Preconditions.checkNotNull(message.getCurrentMessage(), "message history cannot be null.");
		
		MessageHistoryDbo histDb = map(message, MessageHistoryDbo.class);
		messageHistoryDao.save(histDb);
		
		return getMessage(message.getMessageId());
	}
	
	public void deleteMessagesForThread(Integer threadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		
		List<MessageDbo> messages = messageDao.get(ex);
		List<Integer> messageIds = messages.stream().map(MessageDbo::getMessageId).collect(Collectors.toList());
		MessageHistoryDboExample hEx = new MessageHistoryDboExample();
		hEx.createCriteria().andMessageIdIn(messageIds);
		
		messageHistoryDao.deleteWhere(hEx);
		messageDao.deleteWhere(ex);
	}
	
	public void moveMessagesToNewThread(List<Integer> messageIds, Integer newThreadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andMessageIdIn(messageIds);
		
		List<MessageDbo> messages = messageDao.get(ex);
		messages.forEach(msg -> {
			msg.setThreadId(newThreadId);
			messageDao.save(msg);
		});
	}
	
	public Long getTotalPostsInThread(Integer threadId) {
		MessageDboExample ex = new MessageDboExample();
		ex.createCriteria().andThreadIdEqualTo(threadId);
		Long count = messageDao.count(ex);
		
		return count;
	}
	
	public List<Message> getMessagesByUser(Integer userId, Integer pageNumber, Integer count, List<Integer> permissionIds){
		int resolvedPageNumber = pageNumber == null || pageNumber < 1 ? 1 : pageNumber;
		int pageSize = count == null || count < 1 ? 25 : Math.min(count, 50);
		long offset = (long) (resolvedPageNumber - 1) * pageSize;
		if (offset > Integer.MAX_VALUE)
			return List.of();

		List<Integer> visibleBoardIds = visibleBoardIds(permissionIds);
		if (visibleBoardIds.isEmpty())
			return List.of();

		AllMessagesInThreadViewDboExample pageExample = new AllMessagesInThreadViewDboExample();
		pageExample.createCriteria().andLastPostedUserIdEqualTo(userId).andBoardIdIn(visibleBoardIds);
		pageExample.setOrderByClause("post_ts desc");
		pageExample.setLimit(pageSize);
		pageExample.setOffset((int) offset);
		List<Integer> pageMessageIds = allMessagesInThreadViewDao.get(pageExample).stream()
				.map(AllMessagesInThreadViewDbo::getMessageId).toList();
		if (pageMessageIds.isEmpty())
			return List.of();

		CurrentMessageDboExample bodyExample = new CurrentMessageDboExample();
		bodyExample.createCriteria().andMessageIdIn(pageMessageIds);
		Map<Integer, CurrentMessageDbo> bodiesByMessageId = currentMessageDao.get(bodyExample).stream()
				.collect(Collectors.toMap(CurrentMessageDbo::getMessageId, Function.identity()));
		return pageMessageIds.stream()
				.map(bodiesByMessageId::get)
				.filter(Objects::nonNull)
				.map(this::mapMessage)
				.toList();
	}

	private List<Integer> visibleBoardIds(List<Integer> permissionIds) {
		if (permissionIds == null || permissionIds.isEmpty())
			return List.of();
		BoardPermissionViewDboExample visibleExample = new BoardPermissionViewDboExample();
		visibleExample.createCriteria().andPermissionIdIn(permissionIds);
		return boardPermissionViewDao.get(visibleExample).stream()
				.map(BoardPermissionViewDbo::getBoardId).distinct().toList();
	}
}