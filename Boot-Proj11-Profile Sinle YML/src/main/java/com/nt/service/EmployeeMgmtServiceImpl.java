
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO empDAO;
	

	@Override
	public String registerEmployee	(Employee emp)throws Exception{
		double grossSalary=emp.getSalary() + (emp.getSalary()*0.4f);
		double netSalary=grossSalary - (grossSalary * 0.2f);
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
		int count=empDAO.insert(emp);
		
		return count == 0? "Employee Registration Failed to entry" : "Employee Registered and the salary  =" + emp.getSalary() + "----" + emp.getGrossSalary() + "----" + emp.getNetSalary();
	}

}
