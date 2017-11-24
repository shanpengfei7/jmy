package com.jinmayi.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jinmayi.dao.EmployeeDao;
import com.jinmayi.entity.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDAOImpl<Employee> implements EmployeeDao {

	@Override
	public List<Employee> getEmployees(Integer enterpriseid, Integer page, Integer rows, String keyword) {
		if(keyword == null || keyword.equals("")) {
			return find(" from Employee where isdelete = ? and enterpriseid = ? order by id desc", new Object[]{0, enterpriseid}, page, rows);
		} else {
			if(keyword.contains("ÄÐ")) {
				return find(" from Employee where isdelete = ? and enterpriseid = ? and sex = 1 order by id desc", new Object[]{0, enterpriseid}, page, rows);
			} else if(keyword.contains("Å®")) {
				return find(" from Employee where isdelete = ? and enterpriseid = ? and sex = 2 order by id desc", new Object[]{0, enterpriseid}, page, rows);
			}else {
				return find(" from Employee where isdelete = ? and enterpriseid = ? order by id desc", new Object[]{0, enterpriseid}, page, rows);
			}
		}
	}

	@Override
	public int getEmployeeCount(Integer enterpriseid, String keyword) {
		List<Employee> employees = null;
		try {
			if(keyword == null || keyword.equals("")) {
				employees = find(" from Employee where isdelete = ? and enterpriseid = ?", new Object[]{0, enterpriseid});
			} else {
				if(keyword.contains("ÄÐ")) {
					employees = find(" from Employee where isdelete = ? and enterpriseid = ? and sex = 1", new Object[]{0, enterpriseid});
				} else if(keyword.contains("Å®")) {
					employees = find(" from Employee where isdelete = ? and enterpriseid = ? and sex = 2", new Object[]{0, enterpriseid});
				} else {
					employees = find(" from Employee where isdelete = ? and enterpriseid = ? and "
							+ "concat (name, jobnumber, phonenumber, username, createtime, updatetime, power"
							+ ") like ?", new Object[]{0, enterpriseid, "%" + keyword + "%"});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees.size();
	}

	@Override
	public void updateEmployee(Employee employee) {
		executeHql("update Employee set name = ?, sex = ?, jobnumber = ?, "
				+ "phonenumber = ?, status = ?, updatetime = ?, updateenterpriseid = ?, power = ? where id = ?", 
				new Object[]{employee.getName(), employee.getSex(), employee.getJobnumber(),
						employee.getPhonenumber(), employee.getStatus(), System.currentTimeMillis(), 
						employee.getUpdateenterpriseid(), employee.getPower(), employee.getId()});
	}

	@Override
	public void deleteEmployee(Employee employee) {
		executeHql("update Employee set isdelete = 1 where id = ?", new Object[]{employee.getId()});
	}

	@Override
	public boolean checkUsername(String username, Integer eid) {
		List<Employee> employees = find(" from Employee where isdelete = 0 and username = ? and enterpriseid = ?", new Object[]{username, eid});
		
		if(employees.size() > 0){
			return true;
		} else {
			return false;
		}
	}
	
}
