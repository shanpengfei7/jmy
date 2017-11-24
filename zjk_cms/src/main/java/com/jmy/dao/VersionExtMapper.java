package com.jmy.dao;

import com.jmy.entity.VersionExt;
import com.jmy.entity.VersionExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionExtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int countByExample(VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int deleteByExample(VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int insert(VersionExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int insertSelective(VersionExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    List<VersionExt> selectByExampleWithBLOBs(VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    List<VersionExt> selectByExample(VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    VersionExt selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByExampleSelective(@Param("record") VersionExt record, @Param("example") VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") VersionExt record, @Param("example") VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByExample(@Param("record") VersionExt record, @Param("example") VersionExtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByPrimaryKeySelective(VersionExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(VersionExt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table version_ext
     *
     * @mbggenerated Sat Jun 17 10:59:42 CST 2017
     */
    int updateByPrimaryKey(VersionExt record);
}