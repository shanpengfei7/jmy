package com.jinmayi.dao;

import java.util.List;

import com.jinmayi.entity.Employee;

public interface EmployeeDao extends BaseDAO<Employee> {

	/**
	 * �õ����е���ҵԱ��
	 * @return
	 */
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword);
	
	/**
	 * �õ�Ա����������
	 * @return
	 */
	public int getEmployeeCount(Integer enterpriseid, String keyword);
	
	/**
	 * ����Ա��
	 * @param employee
	 */
	public void updateEmployee(Employee employee);
	/**
	 * ɾ��Ա��
	 * @param employee
	 */
	public void deleteEmployee(Employee employee);
	/**
	 * ��֤Ա�����˺��ظ�
	 * @param enterpriseid
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username, Integer eid);
}
