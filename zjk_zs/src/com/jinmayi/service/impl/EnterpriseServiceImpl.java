package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.EnterpriseDao;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EnterpriseService;

@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

	@Resource
	private EnterpriseDao enterpriseDao;

	@Override
	public void save(Enterprise enterprise) {
		enterpriseDao.save(enterprise);
	}

	@Override
	public Integer getEnterprise(Short role, String keyword) {
		return enterpriseDao.getEnterpriseCount(role, keyword);
	}

	@Override
	public List<Enterprise> getEnterprise(Integer pageNow, Integer pageSize, Short role, String keyword) {
		return enterpriseDao.getEnterprises(pageNow, pageSize, role, keyword);
	}

	@Override
	public void changeStatus(Enterprise enterprise) {
		enterpriseDao.changeStaus(enterprise);
	}

	@Override
	public void changeConnect(Enterprise enterprise) {
		enterpriseDao.changeConnect(enterprise);
	}

	@Override
	public void changeStatus1(Enterprise enterprise) {
		enterpriseDao.changeStaus1(enterprise);

	}

	@Override
	public Enterprise getEnterpriseById(Integer id) {
		return enterpriseDao.get(Enterprise.class, id);
	}

	@Override
	public Integer updateEnterprise(Enterprise enterprise) {
		String hql = "update Enterprise set information = ?, isconnect = ?, status = ?, isdelete = ?, "
				+ "updatetime = ?, updateadminid = ?, name = ?, phonenumber = ?, address = ?, "
				+ "company = ?, role = ? where id = ?";
		return enterpriseDao.executeHql(hql,
				new Object[] { enterprise.getInformation(), enterprise.getIsconnect(), enterprise.getStatus(),
						enterprise.getIsdelete(), enterprise.getUpdatetime(), enterprise.getUpdateadminid(),
						enterprise.getName(), enterprise.getPhonenumber(), enterprise.getAddress(),
						enterprise.getCompany(), enterprise.getRole(), enterprise.getId() });
	}

	@Override
	public Enterprise getEnterpriseByCode(String token) {
		String hql = " from Enterprise where isconnect = 0 and status = 0 and isdelete = 0 and code = ?";
		return enterpriseDao.get(hql, new Object[] { token });
	}

	@Override
	public void changePassword(Enterprise enterprise) {
		String hql = " update Enterprise set password = ? where id = ?";
		enterpriseDao.executeHql(hql, new Object[] { enterprise.getPassword(), enterprise.getId() });
	}

	@Override
	public Integer updateScannumber(Integer id) {
		return enterpriseDao.updateScannumber(id);
	}

	@Override
	public Integer updateQrcodeCount(Integer enterpriseid, Integer count) {
		return enterpriseDao.updateQrcodeCount(enterpriseid, count);
	}

	@Override
	public Integer updateUserCount(Integer enterpriseid, Integer count) {
		return enterpriseDao.updateUserCount(enterpriseid, count);
	}

}
