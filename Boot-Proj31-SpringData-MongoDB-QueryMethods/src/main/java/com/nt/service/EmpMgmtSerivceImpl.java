package com.nt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployRepository;

@Service("EmpService")
public class EmpMgmtSerivceImpl implements IEmpManagementService {
	
	@Autowired
	private IEmployRepository empRepo;

	@Override
	public List<Object[]> fetchEmpsDataByAddrs(String addrs) {

		return empRepo.getEmpsDataByAddrs(addrs);
	}

	@Override
	public List<Employee> fetchEmpsFullDataByAddrs(String addrs) {
	   return empRepo.getEmpsFullDataByAddrs(addrs);
	}

	@Override
	public List<Object[]> fetchEmpsDataBySalaryAndAddrs(double Salary, String addrs) {
		// TODO Auto-generated method stub
		return empRepo.getEmpsDataBySalaryAndAddrs(Salary, addrs);
	}

	@Override
	public List<Object[]> fetchEmpsDataBySalaryRange(double start, double end) {
		// TODO Auto-generated method stub
		return empRepo.getEmpsDataBySalaryRange(start, end);
	}

	@Override
	public List<Employee> fetchEmployeeFullDataByAddress(String addrs1, String addrs2) {
		return empRepo.getFullEmployeeByAddress(addrs1, addrs2);
	}

	@Override
	public List<Employee> fetchEmployeeDataByInitChars(String initialChars) {
		
		return empRepo.getEmployeeDataByEnameInitialChars(initialChars);
	}

	@Override
	public int fetchEmployeeCountBySalaryRange(double start, double end) {
	
		return empRepo.getEmployeeCountBySalaryRange(start, end);
	}

	@Override
	public List<Employee> fetchEmployeeByEnameSorted() {
		// TODO Auto-generated method stub
		return empRepo.getEmployeesByEnameSorting();
	}

	@Override
	public int removeNullEnoEmployees() {
		return empRepo.removeEmptyEnoEmployees();
	}

	@Override
	public boolean checkEmployeesAvailabilitySalaryRange(double start, double end) {

		return empRepo.existsEmployeeBySalaryRange(start, end);
	}
	


}
