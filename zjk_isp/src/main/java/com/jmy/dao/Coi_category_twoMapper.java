package com.jmy.dao;

import com.jmy.entity.Coi_category_two;
import com.jmy.entity.Coi_category_twoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Coi_category_twoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int countByExample(Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByExample(Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insert(Coi_category_two record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int insertSelective(Coi_category_two record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	List<Coi_category_two> selectByExampleWithBLOBs(Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	List<Coi_category_two> selectByExample(Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	Coi_category_two selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Coi_category_two record,
			@Param("example") Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Coi_category_two record,
			@Param("example") Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByExample(@Param("record") Coi_category_two record, @Param("example") Coi_category_twoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKeySelective(Coi_category_two record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Coi_category_two record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table isp_coi_category_two
	 * @mbggenerated  Mon Mar 27 19:10:41 CST 2017
	 */
	int updateByPrimaryKey(Coi_category_two record);
}