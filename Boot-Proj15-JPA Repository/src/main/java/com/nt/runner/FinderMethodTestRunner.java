package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;
import com.nt.service.IDoctorMgmtService;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	 private IDoctorRepository doctorRepo;
	 
  
	@Override
	public void run(String... args) throws Exception {
  
     
	}

}
