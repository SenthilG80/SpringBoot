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
//        	emp.setEno(101);emp.setEname("Ramanan");emp.setEadd("Chennai");emp.setSalary(90000.0f);
//        	Employee  emp1=new Employee();
//        	emp1.setEno(102);emp1.setEname("Shiva");emp1.setEadd("Ladak");
//        	
//        	
//        	System.out.println(empSerive.savedDocument(emp));
//        	System.out.println(empSerive.savedDocument(emp1));
//        	
//        }catch (Exception e) {
//			e.printStackTrace();
//		}
		
		empSerive.findAllEmployees().forEach(System.out::println);
	}

}
