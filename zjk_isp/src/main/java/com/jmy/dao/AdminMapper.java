package com.jmy.dao;

import com.jmy.entity.Admin;
import com.jmy.entity.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int countByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insert(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insertSelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	List<Admin> selectByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	Admin selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKeySelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_admin
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKey(Admin record);
}