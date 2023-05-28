package com.nt.service;

import com.nt.document.Employee;

public interface IEmpManagementService {
	  public String savedDocument(Employee emp);
	  public Iterable<Employee> findAllEmployees();
	  
}
