package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Employee;

public interface EmployeeDao extends BaseDAO<Employee> {

	/**
	 * 得到所有的企业员工
	 * @return
	 */
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword);
	
	/**
	 * 得到员工的总人数
	 * @return
	 */
	public int getEmployeeCount(Integer enterpriseid, String keyword);
	
	/**
	 * 更新员工
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	/**
	 * 删除员工
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);
	/**
	 * 验证员工的账号重复
	 * @param enterpriseid
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username, Integer eid);
}
