package com.jinmayi.service;

import java.util.List;

import com.jinmayi.entity.Employee;

public interface EmployeeService {

	/**
	 * ������ҵԱ��
	 * 
	 * @param employee
	 */
	public void save(Employee employee);

	/**
	 * �õ����е���ҵԱ��
	 * 
	 * @return
	 */
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword);

	/**
	 * �õ�Ա����������
	 * 
	 * @return
	 */
	public int getEmployeeCount(Integer enterpriseid, String keyword);

	/**
	 * ͨ��ID��ʾԱ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(Integer id);

	/**
	 * ͨ��ID�Ը��ĵ�Ա����Ϣ�Ľ��и��£����棩
	 * 
	 * @param id
	 */
	public void updateEmployee(Employee employee);

	/**
	 * ͨ��ID��Ա����ɾ�����Ա�Ϊ��1��
	 * 
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);

	/**
	 * ͨ����˾ID��֤Ա���˺�
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
