package com.zfgc.zfgbb.services.forum;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.dbo.MessageDbo;
import com.zfgc.zfgbb.dbo.MessageDboExample;
import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import com.zfgc.zfgbb.mappers.MessageDboMapper;
import com.zfgc.zfgbb.mappers.UserDboMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class QuotedMessageLookup {

	private final MessageDboMapper messageMapper;

	private final UserDboMapper userMapper;

	public record Resolved(String authorDisplayName, OffsetDateTime createdTs) {}

	public Map<Integer, Resolved> resolve(Set<Integer> messageIds) {
		if (messageIds == null || messageIds.isEmpty()) {
			return Map.of();
		}
		MessageDboExample msgEx = new MessageDboExample();
		msgEx.createCriteria().andMessageIdIn(List.copyOf(messageIds));
		List<MessageDbo> messages = messageMapper.selectByExample(msgEx);
		if (messages.isEmpty()) {
			return Map.of();
		}
		Set<Integer> ownerIds = new HashSet<>();
		for (MessageDbo m : messages) {
			if (m.getOwnerId() != null) {
				ownerIds.add(m.getOwnerId());
			}
		}
		Map<Integer, String> displayByUserId = new HashMap<>();
		if (!ownerIds.isEmpty()) {
			UserDboExample userEx = new UserDboExample();
			userEx.createCriteria().andUserIdIn(List.copyOf(ownerIds));
			for (UserDbo u : userMapper.selectByExample(userEx)) {
				displayByUserId.put(u.getUserId(), u.getDisplayName());
			}
		}
		Map<Integer, Resolved> result = new HashMap<>();
		for (MessageDbo m : messages) {
			String author = m.getOwnerId() == null
					? null
					: displayByUserId.get(m.getOwnerId());
			result.put(m.getMessageId(), new Resolved(author, m.getCreatedTs()));
		}
		return result;
	}

	public Optional<Resolved> resolveOne(Integer messageId) {
		if (messageId == null) {
			return Optional.empty();
		}
		Map<Integer, Resolved> map = resolve(Set.of(messageId));
		return Optional.ofNullable(map.get(messageId));
	}
}
