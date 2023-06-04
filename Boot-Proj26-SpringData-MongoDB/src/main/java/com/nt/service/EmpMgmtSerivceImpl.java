package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployRepository;

@Service("EmpService")
public class EmpMgmtSerivceImpl implements IEmpManagementService {
	
	@Autowired
	private IEmployRepository empRepo;
	

	@Override
	public String savedDocument(Employee emp) {
	 String idValue=empRepo.insert(emp).getId();
	 
		return "Employee is saved with id value"+idValue;
	}


	@Override
	public Iterable<Employee> findAllEmployees() {
     
		return empRepo.findAll();
	}


	@Override
	public Employee findEmployeeById(String id) {

		return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid ID"));
		
	}


	@Override
	public String modifyEmployeewithNewSalary(String id, float hikePercantage) {
        Optional<Employee> opt=empRepo.findById(id);
         if(opt.isPresent()) {
        	 Employee emp=opt.get();
        	 emp.setSalary(emp.getSalary()+(emp.getSalary()*hikePercantage/100.0f));
        	 String idVal=empRepo.save(emp).getId();
        	 return idVal +" document is updated";
         }
        
		return id+"document is not found";
	}


	@Override
	public String removeEmployee(String id) {
		 Optional<Employee> opt=empRepo.findById(id);
         if(opt.isPresent()) {
        	 Employee emp=opt.get();
        	 empRepo.delete(emp);
        	 return id+"Document is deleted";
         }else{
        	 return id+"Document is not deleted";
         }
	
	}


	@Override
	public List<Employee> searchEmployeeByEmpleData(Employee emp, boolean asc, String... props) {
		 
		Example<Employee> example=Example.of(emp);
		Sort sort =Sort.by(asc?Direction.ASC:Direction.DESC,props);
		List<Employee> list	=empRepo.findAll(example,sort);
		return list;
	}


	@Override
	public String registerEmployee(Employee emp) {
		String id=UUID.randomUUID().toString();
		System.out.println(id); 
		emp.setId(id);
		String idVal=empRepo.insert(emp).getId();
		return "Employee doc is saved with id value::"+idVal;
	}

}
