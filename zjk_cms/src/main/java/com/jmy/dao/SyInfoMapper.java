package com.jmy.dao;

import com.jmy.entity.SyInfo;
import com.jmy.entity.SyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int countByExample(SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int deleteByExample(SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int insert(SyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int insertSelective(SyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    List<SyInfo> selectByExampleWithBLOBs(SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    List<SyInfo> selectByExample(SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    SyInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") SyInfo record, @Param("example") SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") SyInfo record, @Param("example") SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByExample(@Param("record") SyInfo record, @Param("example") SyInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByPrimaryKeySelective(SyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(SyInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table syinfo
     *
     * @mbggenerated Tue May 09 20:51:18 CST 2017
     */
    int updateByPrimaryKey(SyInfo record);
}