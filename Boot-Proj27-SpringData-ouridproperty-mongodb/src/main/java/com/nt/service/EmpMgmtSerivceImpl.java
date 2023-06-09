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
	public String savedDocument(Employee emp) {
	 Integer idValue=empRepo.insert(emp).getEno();
	 
		return "Employee is saved with id value"+idValue;
	}


	@Override
	public Iterable<Employee> findAllEmployees() {
     
		return empRepo.findAll();
	}


	@Override
	public Employee findEmployeeById(Integer id) {

		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid ID"));
		
	}


	@Override
	public List<Employee> fetchEmployeeBySalaryRange(double start, double end) {
		return empRepo.findBySalaryBetween(start, end);
	}


	@Override
	public Employee fetchEmployeeByName(String name) {

		return empRepo.findByEname(name);
	}


	

}
