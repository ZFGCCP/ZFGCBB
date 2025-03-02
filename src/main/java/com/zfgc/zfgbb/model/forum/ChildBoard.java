package com.zfgc.zfgbb.model.forum;

public class ChildBoard {
	private Integer boardId;
	private String boardName;
	private Integer parentBoardId;
	public Integer getBoardId() {
		return boardId;
	}
	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public Integer getParentBoardId() {
		return parentBoardId;
	}
	public void setParentBoardId(Integer parentBoardId) {
		this.parentBoardId = parentBoardId;
	}

}