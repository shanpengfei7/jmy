package com.jmy.dao;

import com.jmy.entity.Coi_category_one;
import com.jmy.entity.Coi_category_oneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Coi_category_oneMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int countByExample(Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByExample(Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insert(Coi_category_one record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insertSelective(Coi_category_one record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	List<Coi_category_one> selectByExampleWithBLOBs(Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	List<Coi_category_one> selectByExample(Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	Coi_category_one selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Coi_category_one record,
			@Param("example") Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Coi_category_one record,
			@Param("example") Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExample(@Param("record") Coi_category_one record, @Param("example") Coi_category_oneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKeySelective(Coi_category_one record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Coi_category_one record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_one
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKey(Coi_category_one record);
}