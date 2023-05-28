package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Employee_Date_Time;

public interface IEmployeeMgmtService {
	
	public Employee_Date_Time saveEmployee(Employee_Date_Time employee);
	public List<Employee_Date_Time> getAllEmployees();
	public List<Integer> showEmployeeAgesByDesg(String desg);
	Optional<Employee_Date_Time> findByename(String name);

}
