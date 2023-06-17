package com.nt.runner;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmpManagementService;

@Component
public class MongoDBQueryMethodTestRunner implements CommandLineRunner {
	
	@Autowired
	 private IEmpManagementService empSerive;
	 
	@Override
	public void run(String... args) throws Exception {
//	 List<Object[]> list=empSerive.fetchEmpsDataByAddrs("Chennai");
//	 list.forEach(row->{
//		 for(Object val:row) {
//			 System.out.print(val+" ");
//		 }
//		 System.out.println();
//		 
//	 });
//	System.out.println("___________________________________________");
//	empSerive.fetchEmpsFullDataByAddrs("Thiruchendur").forEach(System.out::println);
//	System.out.println("___________________________________________");
//	empSerive.fetchEmpsDataBySalaryAndAddrs(90000,"Thiruchendur").forEach(
//			row->{
//				System.out.println(Arrays.toString(row));
//			});
//	
//
//    empSerive.fetchEmpsDataBySalaryRange(1000, 100000).forEach(
//    		row->{
//    			System.out.println(Arrays.toString(row));
//    		});
//    
//    System.out.println("___________________________________________");
//	empSerive.fetchEmployeeFullDataByAddress("Chennai","Thiruchendur").forEach(System.out::println);
//	
	System.out.println("___________ RegExpression - starting with letter______________");
	empSerive.fetchEmployeeDataByInitChars("^r").forEach(System.out::println);
	System.out.println("___________ RegExpression - Contains letter______________");
	empSerive.fetchEmployeeDataByInitChars("S").forEach(System.out::println);
	System.out.println("___________ RegExpression -Ending with letter______________");
	empSerive.fetchEmployeeDataByInitChars("a$").forEach(System.out::println);
	System.out.println("___________ Employe Count by Salary______________");
	int c=empSerive.fetchEmployeeCountBySalaryRange(0, 97000);
	System.out.println("Employee count in this salary is :"+c);
	System.out.println("___________ Sorting______________");
	empSerive.fetchEmployeeByEnameSorted().forEach(System.out::println);
//	System.out.println("___________ Deletion of records______________");
//System.out.println("Null Eno Employees deleted are::"+ empSerive.removeNullEnoEmployees());
	System.out.println("___________ Exists or not in Particular Salary Range______________");
	System.out.println("In this Partical range of salary has ::"+ empSerive.checkEmployeesAvailabilitySalaryRange(30000,55000));
	
	}
	}
	  
	

