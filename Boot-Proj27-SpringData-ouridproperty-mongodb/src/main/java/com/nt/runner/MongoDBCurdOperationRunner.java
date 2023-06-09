package com.nt.runner;

import java.util.Random;

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
//		Employee emp=new Employee();
//		emp.setEno(new Random().nextInt(10000));
//		emp.setEname("Rajesh");
//		emp.setSalary(101010.0f);
//		emp.setEadd("Chennai");
//		emp.setVaccinated(true);
//		System.out.println(empSerive.savedDocument(emp));
//		System.out.println("_____________________________________");
//		
//		empSerive.findAllEmployees().forEach(System.out::println);
//		
//		System.out.println("_____________________________________");
//		
//		System.out.println(empSerive.findEmployeeById(411));
//		
//		empSerive.fetchEmployeeBySalaryRange(100000.0, 200000.0).forEach(System.out::println);
		System.out.println(empSerive.fetchEmployeeByName("Rajesh"));
	}	
	

}
