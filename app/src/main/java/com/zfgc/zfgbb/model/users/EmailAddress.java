package com.zfgc.zfgbb.model.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class EmailAddress extends BaseModel {
	@JsonIgnore
	private Integer emailAddressId;
    private String emailAddress;
    private Boolean spammerFlag;
    
	@Override
	public Integer getId() {
		return emailAddressId;
	}
	@Override
	public void setId(Integer id) {
		emailAddressId = id;
	}
}