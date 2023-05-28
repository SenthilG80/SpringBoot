package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;

@Component
public class DateAndTimetestRunner implements CommandLineRunner {
  
	@Autowired
	private IEmployeeMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Employee_Date_Time[] emp = new Employee_Date_Time[6];
		    emp[0] = new Employee_Date_Time("Gopalakrishnan G","SE",LocalDateTime.of(1953,3,13,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));
		    emp[1] = new Employee_Date_Time("Umamaheswari G","HM", LocalDateTime.of(1956,3,4,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));
		    emp[2] = new Employee_Date_Time("Karthik G","AO",LocalDateTime.of(1982,6,2,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));
		    emp[3] = new Employee_Date_Time("Pratosh Krishnan","CD",LocalDateTime.of(2010,11,03,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));
		    emp[4] = new Employee_Date_Time("Senthil G","TH",LocalDateTime.of(1980,8,8,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));
		    emp[5] = new Employee_Date_Time("Vijayalakshmi S","HM",LocalDateTime.of(1984,8,13,15,10,3), LocalTime.of(17,45), LocalDate.of(2020,10,30));

		
	
		    for (int i = 0; i < 6; i++) {
		    	Optional<Employee_Date_Time> existingEmployee=service.findByename(emp[i].getEname());
		    	if(existingEmployee.isPresent()) {
		    		System.out.println("Employee  " +emp[i].getEname()+"  is already present");
		    	}else {
		    		Employee_Date_Time savedEmployee=service.saveEmployee(emp[i]);
		    		  System.out.println("Employee added  " + savedEmployee.getEname() + "  sucessfully");
		    		
		    	}}
		    
		
		    }catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		
		try {
			service.getAllEmployees().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		try {
			service.showEmployeeAgesByDesg("SE").forEach(System.out::println);
			service.showEmployeeAgesByDesg("HM").forEach(System.out::println);
			service.showEmployeeAgesByDesg("AO").forEach(System.out::println);
			service.showEmployeeAgesByDesg("CD").forEach(System.out::println);
			service.showEmployeeAgesByDesg("TH").forEach(System.out::println);
			service.showEmployeeAgesByDesg("HM").forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
