package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Employee;

public interface EmployeeService {

	/**
	 * 保存企业员工
	 * 
	 * @param employee
	 */
	public void save(Employee employee);

	/**
	 * 得到所有的企业员工
	 * 
	 * @return
	 */
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword);

	/**
	 * 得到员工的总人数
	 * 
	 * @return
	 */
	public int getEmployeeCount(Integer enterpriseid, String keyword);

	/**
	 * 通过ID显示员工信息
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(Integer id);

	/**
	 * 通过ID对更改的员工信息的进行更新（保存）
	 * 
	 * @param id
	 */
	public void updateEmployee(Employee employee);

	/**
	 * 通过ID对员工的删除属性变为“1”
	 * 
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);

	/**
	 * 通过公司ID验证员工账号
	 * 
	 * @param enterpriseid
	 * @param username
	 * @return
	 */
	public boolean usernameCheck(String username, Integer eid);

	public Employee findEmployeeByUsernameAndPassword(String username, String password, String code);

	public Integer updatePassword(Employee e);

	public Integer updateUsername(Employee e);
}
