package com.zfgc.zfgbb.authorization.access;

import lombok.RequiredArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

import com.zfgc.zfgbb.authorization.AuthorityTiers;
import com.zfgc.zfgbb.model.users.User;

@Component
@RequiredArgsConstructor
public class ForumAccessRules {

	private static final String ROLE_FORUM_WRITE = "ROLE_ZFGC_FORUM_WRITE";
	private static final String ROLE_FORUM_MODERATE = "ROLE_ZFGC_FORUM_MODERATE";

	private final AuthorityTiers tiers;

	public record ThreadState(Integer threadId, Integer boardId, Integer ownerUserId, boolean locked,
			boolean recycled) {}

	public record MessageState(Integer messageId, Integer ownerUserId, ThreadState thread) {}

	public boolean allowsThreadAction(User actor, String action, Supplier<Optional<ThreadState>> threadState) {
		if (!tiers.authenticated(actor))
			return false;
		return switch (action) {
			case "thread.reply" -> threadState.get().filter(thread -> canReplyToThread(actor, thread)).isPresent();
			case "thread.restore" -> moderatorAllowed(actor);
			default -> false;
		};
	}

	public boolean allowsMessageAction(User actor, String action, Supplier<Optional<MessageState>> messageState) {
		if (!tiers.authenticated(actor))
			return false;
		return switch (action) {
			case "message.restore" -> moderatorAllowed(actor);
			case "message.delete" -> allowsMessageDelete(actor, messageState);
			case "message.edit" -> editableMessage(actor, messageState).isPresent();
			default -> false;
		};
	}

	public Optional<MessageState> editableMessage(User actor, Supplier<Optional<MessageState>> messageState) {
		if (!tiers.authenticated(actor) || tiers.isReadOnly(actor))
			return Optional.empty();
		return messageState.get()
				.filter(message -> message.thread() != null)
				.filter(message -> canEditMessage(actor, message));
	}

	public boolean canEditMessage(User actor, MessageState message) {
		if (!tiers.authenticated(actor) || tiers.isReadOnly(actor))
			return false;
		boolean owner = actor.getUserId().equals(message.ownerUserId());
		return tiers.hasRole(actor, ROLE_FORUM_MODERATE)
				|| (owner && !message.thread().locked() && !message.thread().recycled());
	}

	public boolean canReplyToThread(User actor, ThreadState thread) {
		if (!tiers.authenticated(actor) || tiers.isReadOnly(actor) || thread.recycled())
			return false;
		return (!thread.locked() && tiers.hasRole(actor, ROLE_FORUM_WRITE)) || tiers.hasRole(actor, ROLE_FORUM_MODERATE);
	}

	public boolean canDeleteMessage(User actor, MessageState message) {
		return canEditMessage(actor, message);
	}

	public boolean canRestoreThread(User actor, ThreadState thread) {
		if (!tiers.authenticated(actor) || tiers.isReadOnly(actor))
			return false;
		return thread.recycled() && tiers.hasRole(actor, ROLE_FORUM_MODERATE);
	}

	public boolean canRestoreMessage(User actor, MessageState message) {
		return canRestoreThread(actor, message.thread());
	}

	public boolean isForumModerator(User actor) {
		return tiers.authenticated(actor) && tiers.hasRole(actor, ROLE_FORUM_MODERATE);
	}

	public Set<String> permittedThreadActions(User actor, ThreadState thread) {
		if (!tiers.authenticated(actor))
			return Set.of();
		Set<String> permitted = new LinkedHashSet<>();
		if (canReplyToThread(actor, thread))
			permitted.add("thread.reply");
		if (moderatorAllowed(actor)) {
			permitted.add("thread.delete");
			permitted.add("thread.move");
			permitted.add("thread.lock");
			permitted.add("thread.pin");
			permitted.add("thread.split");
		}
		if (canRestoreThread(actor, thread))
			permitted.add("thread.restore");
		return permitted;
	}

	public Set<String> permittedMessageActions(User actor, MessageState message) {
		if (message.thread() == null || !tiers.authenticated(actor))
			return Set.of();
		Set<String> permitted = new LinkedHashSet<>();
		if (canDeleteMessage(actor, message))
			permitted.add("message.delete");
		if (canEditMessage(actor, message))
			permitted.add("message.edit");
		if (canRestoreMessage(actor, message))
			permitted.add("message.restore");
		return permitted;
	}

	private boolean allowsMessageDelete(User actor, Supplier<Optional<MessageState>> messageState) {
		if (tiers.isReadOnly(actor))
			return false;
		if (tiers.hasRole(actor, ROLE_FORUM_MODERATE))
			return true;
		return messageState.get()
				.filter(message -> message.thread() != null)
				.filter(message -> actor.getUserId().equals(message.ownerUserId()))
				.filter(message -> !message.thread().locked() && !message.thread().recycled())
				.isPresent();
	}

	private boolean moderatorAllowed(User actor) {
		return !tiers.isReadOnly(actor) && tiers.hasRole(actor, ROLE_FORUM_MODERATE);
	}
}
