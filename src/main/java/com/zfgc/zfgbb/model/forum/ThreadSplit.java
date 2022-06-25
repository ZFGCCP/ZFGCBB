package com.zfgc.zfgbb.model.forum;

import java.util.ArrayList;
import java.util.List;

public class ThreadSplit {
	private Integer threadId;
	private Integer boardId;
	private List<Integer> messageIdsToMove = new ArrayList<>();
	private String newThreadTitle;
	private Boolean moveAllAfterSpecifiedFlg = false;
	
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public List<Integer> getMessageIdsToMove() {
		return messageIdsToMove;
	}
	public void setMessageIdsToMove(List<Integer> messageIdsToMove) {
		this.messageIdsToMove = messageIdsToMove;
	}
	public String getNewThreadTitle() {
		return newThreadTitle;
	}
	public void setNewThreadTitle(String newThreadTitle) {
		this.newThreadTitle = newThreadTitle;
	}
	public Boolean getMoveAllAfterSpecifiedFlg() {
		return moveAllAfterSpecifiedFlg;
	}
	public void setMoveAllAfterSpecifiedFlg(Boolean moveAllAfterSpecifiedFlg) {
		this.moveAllAfterSpecifiedFlg = moveAllAfterSpecifiedFlg;
	}
}