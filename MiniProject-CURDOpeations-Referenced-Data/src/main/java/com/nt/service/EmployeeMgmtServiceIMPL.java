package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Entitys.EmployeeInfo;
import com.nt.repository.IDepartmentrRepositroy;
import com.nt.repository.IEmployeeInfoRepository;

@Service("empService")
public class EmployeeMgmtServiceIMPL implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeInfoRepository empRepo;
	
	@Autowired
	private IDepartmentrRepositroy deptRepo;

	@Override
	public List<EmployeeInfo> getAllEmpsData() {
		// TODO Auto-generated method stub
		List<EmployeeInfo> list=(List<EmployeeInfo>) empRepo.findAll();
		
		return list	;
	}

	@Override
	public String addEmployee(EmployeeInfo emp) {
        Integer idVal=empRepo.save(emp).getEmpNo(); 
		return  "Employee is registered with the Id value" + idVal;
	}

	@Override
	public EmployeeInfo findEmployeeByEno(int eno) {
		// TODO Auto-generated method stub
		return empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public String updateEmployee(EmployeeInfo emp) {
		Optional<EmployeeInfo> opt=empRepo.findById(emp.getEmpNo());
		  if (opt.isPresent()) {
			  int idVal =empRepo.save(emp).getEmpNo();
			  return idVal + "Employee details are updated";
		  }
		return emp.getEmpNo() + "employee is not found";
	}

	@Override
	public String deleteEmployee(int no) {
		Optional<EmployeeInfo> opt=empRepo.findById(no);
		  if (opt.isPresent()) {
			  empRepo.deleteById(no);
			  return no + "Employee is deleted";
		  }
		return no + "Employee not found for deletion";
	}

	@Override
	public List<Integer> showAllDepts() {
		List<Integer> list=deptRepo.getAllDeptnos();
		return list;
	}
	
	

}
