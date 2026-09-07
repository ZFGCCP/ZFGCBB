package com.zfgc.zfgbb.model.users;

public record AccountDeletionPreview(int messageCount, int threadCount, int pollCount, int contentResourceCount,
		int wikiPageCount, int projectCount, int resourceCount, int sentPersonalMessageCount,
		boolean adminReplacementRequired) {
}
