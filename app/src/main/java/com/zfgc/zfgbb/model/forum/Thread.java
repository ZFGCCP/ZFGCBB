package com.zfgc.zfgbb.model.forum;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.users.User;
import com.zfgc.zfgbb.model.users.Permission;
import com.zfgc.zfgbb.model.Securable;

import lombok.Data;

@Data
public class Thread extends BaseModel implements Securable {
	@JsonIgnore
	private Integer threadId;
    private String threadName;
    private Boolean lockedFlag = false;
    private Boolean pinnedFlag = false;
    private Integer boardId;
    private String boardName;
    private Integer createdUserId;

    private User createdUser;
    private Integer postCount;
    private Integer viewCount = 0;
    private Integer pageCount;
    
	@JsonIgnore
    private List<Permission> boardPermissions = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    
    private LatestMessage latestMessage;
    
    private Poll pollInfo;
    
	@Override
	public Integer getId() {
		return threadId;
	}
	@Override
	public void setId(Integer id) {
		threadId = id;
	}

	@Override
	@JsonIgnore
	public List<Permission> getPermissions() {
		return getBoardPermissions();
	}
	
}