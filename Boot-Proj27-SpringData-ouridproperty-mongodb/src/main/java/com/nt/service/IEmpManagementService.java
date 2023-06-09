package com.nt.service;



import java.util.List;

import com.nt.document.Employee;

public interface IEmpManagementService {
	  public String savedDocument(Employee emp);
	  public Iterable<Employee> findAllEmployees();
	  public Employee findEmployeeById(Integer id);
	  public List<Employee> fetchEmployeeBySalaryRange(double start,  double end);
	  public Employee fetchEmployeeByName(String name);
	  
	  
	  
	  
}
