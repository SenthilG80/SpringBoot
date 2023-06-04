package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmpManagementService;

@Component
public class MongoDBCurdOperationRunner implements CommandLineRunner {
	
	@Autowired
	 private IEmpManagementService empSerive;
	 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//        try {
//        	Employee  emp=new Employee();
//       	    emp.setEno(105);emp.setEname("Vetrivel");emp.setEadd("Thiruchendur");emp.setSalary(100000.0f);
//      	    Employee  emp1=new Employee();
//       	    emp1.setEno(106);emp1.setEname("Veravel");emp1.setEadd("Thiruthani");
//       	
//       	
//      	    System.out.println(empSerive.savedDocument(emp));
//         	System.out.println(empSerive.savedDocument(emp1));
//      	
//       }catch (Exception e) {
//	          e.printStackTrace();
//	}
//		
//		empSerive.findAllEmployees().forEach(System.out::println);
		
// System.out.println(empSerive.findEmployeeById("6471f22fa5f44b4397b020d2"));
//		System.out.println(empSerive.modifyEmployeewithNewSalary("6471f22fa5f44b4397b020d2", 20.0f));
//	System.out.println(empSerive.removeEmployee("6471f22fa5f44b4397b020d2"));
//	 Employee emp=new Employee();
//	 emp.setSalary(90000.0f); 
//	 empSerive.searchEmployeeByEmpleData(emp, true, "ename").forEach(System.out::println);
		
	Employee emp=new Employee();
	  emp.setEno(334);emp.setEname("Alliswell");emp.setEadd("PonneriChennai");emp.setSalary(100000.0f);
	  System.out.print(empSerive.registerEmployee(emp));
	}
	

}
