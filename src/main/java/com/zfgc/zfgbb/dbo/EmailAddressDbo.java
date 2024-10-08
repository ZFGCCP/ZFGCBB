package com.zfgc.zfgbb.dbo;

import java.time.LocalDate;

import com.zfgc.zfgbb.dbo.AbstractDbo;
import java.time.LocalDateTime;

public class EmailAddressDbo extends AbstractDbo{
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.email_address_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private Integer emailAddressId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.email_address
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private String emailAddress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.created_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private LocalDateTime createdTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.updated_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private LocalDateTime updatedTs;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.spammer_flag
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private Boolean spammerFlag;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column zfgbb.email_address.user_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	private Integer userId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.email_address_id
	 * @return  the value of zfgbb.email_address.email_address_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public Integer getEmailAddressId() {
		return emailAddressId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.email_address_id
	 * @param emailAddressId  the value for zfgbb.email_address.email_address_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setEmailAddressId(Integer emailAddressId) {
		this.emailAddressId = emailAddressId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.email_address
	 * @return  the value of zfgbb.email_address.email_address
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.email_address
	 * @param emailAddress  the value for zfgbb.email_address.email_address
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.created_ts
	 * @return  the value of zfgbb.email_address.created_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public LocalDateTime getCreatedTs() {
		return createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.created_ts
	 * @param createdTs  the value for zfgbb.email_address.created_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setCreatedTs(LocalDateTime createdTs) {
		this.createdTs = createdTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.updated_ts
	 * @return  the value of zfgbb.email_address.updated_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public LocalDateTime getUpdatedTs() {
		return updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.updated_ts
	 * @param updatedTs  the value for zfgbb.email_address.updated_ts
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setUpdatedTs(LocalDateTime updatedTs) {
		this.updatedTs = updatedTs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.spammer_flag
	 * @return  the value of zfgbb.email_address.spammer_flag
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public Boolean getSpammerFlag() {
		return spammerFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.spammer_flag
	 * @param spammerFlag  the value for zfgbb.email_address.spammer_flag
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setSpammerFlag(Boolean spammerFlag) {
		this.spammerFlag = spammerFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column zfgbb.email_address.user_id
	 * @return  the value of zfgbb.email_address.user_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column zfgbb.email_address.user_id
	 * @param userId  the value for zfgbb.email_address.user_id
	 * @mbg.generated  Thu Aug 22 20:55:49 EDT 2024
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public Integer getPkId() {
		return emailAddressId;
	}

	@Override
	public LocalDateTime getUpdatedTime() {
		return updatedTs;
	}

	@Override
	public LocalDateTime getCreatedTime() {
		return createdTs;
	}
}