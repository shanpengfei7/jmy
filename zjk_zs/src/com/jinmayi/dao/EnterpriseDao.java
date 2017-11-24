package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Enterprise;

public interface EnterpriseDao extends BaseDAO<Enterprise> {

	public Enterprise findEnterpriseByUsernameAndPassword(String username, String password);

	public Integer getEnterpriseCount(Short role, String keyword);

	public List<Enterprise> getEnterprises(Integer pageNow, Integer pageSize, Short role, String keyword);

	public void changeStaus(Enterprise enterprise);

	public void changeConnect(Enterprise enterprise);

	public void changeStaus1(Enterprise enterprise);

	public Enterprise getEnterpriseByCode(String code);

	public Integer updateScannumber(Integer id);

	public Integer updateQrcodeCount(Integer enterpriseid, Integer count);

	public Integer updateUserCount(Integer enterpriseid, Integer count);
}
