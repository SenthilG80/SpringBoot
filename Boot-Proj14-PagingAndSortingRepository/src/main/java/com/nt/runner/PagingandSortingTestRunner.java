package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PagingandSortingTestRunner implements CommandLineRunner {
  @Autowired
	private IDoctorMgmtService service;
  
	@Override
	public void run(String... args) throws Exception {
    service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
    
    System.out.println("_______________________________________");
    
    service.showDoctorsBySorting(false,"income", "docName").forEach(System.out::println);
     System.out.println("_______________________________________");
    
   // service.showDoctorsInfo(1,3, true,"docName").forEach(System.out::println);
     Page<Doctor> page=service.showDoctorsInfo(0, 3, false,"docName");
     page.forEach(System.out::println);
     System.out.println( "Current Page Number ::::"+page.getNumber() );
     System.out.println( "Total Page Count ::::"+page.getTotalPages() );
     System.out.println( "Total records ::::"+page.getTotalElements() );
     System.out.println( "is the First Page ::::"+page.isFirst());
     
     service.showDataThroughPagination(3);
	}

}
