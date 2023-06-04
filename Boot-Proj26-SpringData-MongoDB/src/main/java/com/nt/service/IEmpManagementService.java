package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmpManagementService {
	  public String savedDocument(Employee emp);
	  public Iterable<Employee> findAllEmployees();
	  public Employee findEmployeeById(String id);
	  public String modifyEmployeewithNewSalary(String id, float hikePercantage);
	  public String removeEmployee (String id);
	  public List<Employee> searchEmployeeByEmpleData(Employee emp, boolean asc,String... props);
	  public String registerEmployee(Employee emp);
	  
	  
	  
}
