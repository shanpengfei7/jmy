package com.jinmayi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinmayi.dao.EmployeeDao;
import com.jinmayi.dao.EnterpriseDao;
import com.jinmayi.entity.Employee;
import com.jinmayi.entity.Enterprise;
import com.jinmayi.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private EnterpriseDao enterpriseDao;

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword) {
		return employeeDao.getEmployees(enterpriseid, page, rows, keyword);
	}

	@Override
	public int getEmployeeCount(Integer enterpriseid, String keyword) {
		return employeeDao.getEmployeeCount(enterpriseid, keyword);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.get(Employee.class, id);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public boolean usernameCheck(String username, Integer eid) {
		return employeeDao.checkUsername(username, eid);
	}

	@Override
	public Employee findEmployeeByUsernameAndPassword(String username, String password, String code) {
		Enterprise e = enterpriseDao.getEnterpriseByCode(code);
		if (e == null) {
			return null;
		}
		return employeeDao.get(
				" from Employee e where e.status = 0 and e.username = ? and e.password = ? and e.enterpriseid = ?",
				new Object[] { username, password, e.getId() });
	}

	@Override
	public Integer updatePassword(Employee e) {
		String hql = "update Employee set password = ? where id = ?";
		return employeeDao.executeHql(hql, new Object[] { e.getPassword(), e.getId() });
	}

	@Override
	public Integer updateUsername(Employee e) {
		String hql = "update Employee set username = ? where id = ?";
		return employeeDao.executeHql(hql, new Object[] { e.getUsername(), e.getId() });
	}

}
