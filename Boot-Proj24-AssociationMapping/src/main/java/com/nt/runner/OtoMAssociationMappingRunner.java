package com.nt.runner;

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
//		service.saveDataUsingParent();
//		service.saveDataUsingChild();
//		service.loadDataUsingChild();
//		service.deleteByPerson(52);
//		service.deleteCofPByID(103);
        service.addNewCtoPByID(1);
	}

}
