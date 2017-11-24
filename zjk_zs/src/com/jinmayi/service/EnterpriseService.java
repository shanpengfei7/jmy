package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Enterprise;

public interface EnterpriseService {

	/**
	 * 保存企业
	 * 
	 * @param enterprise
	 */
	public void save(Enterprise enterprise);

	/**
	 * 得到企业的总数
	 * 
	 * @return
	 */
	public Integer getEnterprise(Short role, String keyword);

	/**
	 * 通过总条数得到公司的列表
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> getEnterprise(Integer pageNow, Integer pageSize, Short role, String keyword);

	/**
	 * 通过ID更改公司的状态1
	 * 
	 * @param id
	 * @return
	 */
	public void changeStatus(Enterprise enterprise);

	public void changeConnect(Enterprise enterprise);

	/**
	 * 通过ID更改公司的状态2
	 * 
	 * @param id
	 * @return
	 */
	public void changeStatus1(Enterprise enterprise);

	public Enterprise getEnterpriseById(Integer id);

	public Integer updateEnterprise(Enterprise enterprise);

	/**
	 * 通过企业码得到企业信息
	 * 
	 * @param token
	 * @return
	 */
	public Enterprise getEnterpriseByCode(String token);

	/**
	 * 修改密码
	 * 
	 * @param enterprise
	 */
	public void changePassword(Enterprise enterprise);

	public Integer updateScannumber(Integer id);

	public Integer updateQrcodeCount(Integer enterpriseid, Integer count);

	public Integer updateUserCount(Integer enterpriseid, Integer count);

}
