package com.nt.service;

import java.util.List;

import com.nt.document.Employee;





public interface IEmpManagementService {
	 public List<Object[]> fetchEmpsDataByAddrs(String addrs);
	 public List<Employee> fetchEmpsFullDataByAddrs(String addrs);
	 public List<Object[]> fetchEmpsDataBySalaryAndAddrs(double Salary,String addrs);
	 public List<Object[]> fetchEmpsDataBySalaryRange(double start,double end);
	 public List<Employee> fetchEmployeeFullDataByAddress(String addrs1,String addrs2);
	 public List<Employee> fetchEmployeeDataByInitChars(String initialChars);
	 public int fetchEmployeeCountBySalaryRange( double start, double end);
	 public List<Employee> fetchEmployeeByEnameSorted();
	 public int removeNullEnoEmployees();
	 public boolean checkEmployeesAvailabilitySalaryRange(double start, double end);
}
