package com.zfgc.zfgbb.model.users;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import com.zfgc.zfgbb.model.User;
import com.zfgc.zfgbb.model.forum.Message;
import com.zfgc.zfgbb.model.forum.MessageHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class UserKarmaView extends BaseModel {
	private Integer karmaId;
    private Integer receivingUserId;
    private Integer messageId;
    private String description;
    private Boolean isPositive;
    @JsonIgnore
    private OffsetDateTime karmaGivenTs;
    private Integer commentingUserId;
    private Integer threadId;
    private String commentingUser;
    
	@Override
	public Integer getId() {
		return karmaId;
	}
	@Override
	public void setId(Integer id) {
		karmaId = id;
	}
	
	public String getKarmaGivenTsAsString() {
		if(karmaGivenTs != null) {
			return karmaGivenTs.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
		return "";
	}

	public void setKarmaGivenTsAsString(String ts) {
		if(!StringUtils.isEmpty(ts)) {
			karmaGivenTs = OffsetDateTime.parse(ts, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}
}
