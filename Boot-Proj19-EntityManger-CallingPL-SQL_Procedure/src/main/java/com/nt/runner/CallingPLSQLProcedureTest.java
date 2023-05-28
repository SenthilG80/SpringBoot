package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorManagmentService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {
 
	 @Autowired
	 private IDoctorManagmentService service;
     
	@Override
	public void run(String... args) throws Exception {
		
		try {
		service.showDoctorsByIncomeRange(10.0, 500.0).forEach(System.out::println);
		
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
