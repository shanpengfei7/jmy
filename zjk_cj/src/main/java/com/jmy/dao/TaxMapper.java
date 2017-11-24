package com.jmy.dao;

import com.jmy.entity.Tax;
import com.jmy.entity.TaxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaxMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int countByExample(TaxExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int deleteByExample(TaxExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int insert(Tax record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int insertSelective(Tax record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	List<Tax> selectByExample(TaxExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	Tax selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Tax record, @Param("example") TaxExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByExample(@Param("record") Tax record, @Param("example") TaxExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByPrimaryKeySelective(Tax record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tax
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByPrimaryKey(Tax record);
}