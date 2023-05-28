package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOtoMManagementService;

@Component
public class OtoMAssociationMappingRunner implements CommandLineRunner {
  
	  @Autowired
	  private IOtoMManagementService service;
	  
	@Override
	public void run(String... args) throws Exception {
         List<Object[]> list=service.fetchDataUsingJoins();
         
         list.forEach(row->{
        	  for(Object val:row) {
        		  
        		  System.out.println(val+"  ");
        	  }
        	  System.out.println();
         });
	}

}
