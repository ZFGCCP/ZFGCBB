package com.zfgc.zfgbb.mappers;

import com.zfgc.zfgbb.dbo.UserDbo;
import com.zfgc.zfgbb.dbo.UserDboExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDboMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	long countByExample(UserDboExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int deleteByExample(UserDboExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int insert(UserDbo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int insertSelective(UserDbo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	List<UserDbo> selectByExample(UserDboExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	UserDbo selectByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int updateByExampleSelective(@Param("record") UserDbo record, @Param("example") UserDboExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int updateByExample(@Param("record") UserDbo record, @Param("example") UserDboExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int updateByPrimaryKeySelective(UserDbo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zfgbb.user
	 * @mbg.generated  Tue Sep 17 23:06:54 EDT 2024
	 */
	int updateByPrimaryKey(UserDbo record);
}