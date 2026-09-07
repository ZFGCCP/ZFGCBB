package com.zfgc.zfgbb.model.forum;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class Message extends BaseModel {
	@JsonIgnore
	private Integer messageId;
	private Integer ownerId;
	private Integer threadId;
	private Integer postInThread;
	
	private User createdUser;

	@Builder.Default
	private List<FileAttachment> fileAttachments = new ArrayList<>();

	@Builder.Default
	private MessageHistory currentMessage = new MessageHistory();

	@Override
	public Integer getId() {
		return messageId;
	}

	@Override
	public void setId(Integer id) {
		messageId = id;
	}
	
	@JsonIgnore
	public OffsetDateTime getLatestMessageTs() {
		return currentMessage.getCreatedTs();
	}
	
}