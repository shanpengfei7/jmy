package com.jmy.dao;

import com.jmy.entity.PageNotice;
import com.jmy.entity.PageNoticeExample;
import com.jmy.entity.PageNoticeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageNoticeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int countByExample(PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int deleteByExample(PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int insert(PageNoticeWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int insertSelective(PageNoticeWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	List<PageNoticeWithBLOBs> selectByExampleWithBLOBs(PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	List<PageNotice> selectByExample(PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	PageNoticeWithBLOBs selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByExampleSelective(@Param("record") PageNoticeWithBLOBs record,
			@Param("example") PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") PageNoticeWithBLOBs record,
			@Param("example") PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByExample(@Param("record") PageNotice record, @Param("example") PageNoticeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByPrimaryKeySelective(PageNoticeWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(PageNoticeWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table page_notice
	 * @mbggenerated  Thu Jun 15 15:30:48 CST 2017
	 */
	int updateByPrimaryKey(PageNotice record);
}