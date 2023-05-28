package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repository.EmployeeDateTimeRepository;

@Service
public class EmployeeMgmtSerivceImpl implements IEmployeeMgmtService {
  
	@Autowired
	 private EmployeeDateTimeRepository empRepo;
	

	
	@Override
	public Employee_Date_Time saveEmployee(Employee_Date_Time employee) {
		return empRepo.save(employee);
		
	}

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
	 return empRepo.findAll();
	}

	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		 return empRepo.getEmployeeAgesByDesg(desg);
	}

	@Override
	public Optional<Employee_Date_Time> findByename(String name) {
		
		return empRepo.findByename(name);
	}



}
