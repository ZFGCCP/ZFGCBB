package com.zfgc.zfgbb.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zfgc.zfgbb.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContactInfo extends BaseModel {
    @JsonIgnore
    private Integer userId;
    private EmailAddress emailAddress;
    private Boolean allowEmailFlag;
    private Boolean allowPmFlag;

    @Override
    public Integer getId() {
        return userId;
    }

    @Override
    public void setId(Integer id) {
        this.userId = id;
    }
} 