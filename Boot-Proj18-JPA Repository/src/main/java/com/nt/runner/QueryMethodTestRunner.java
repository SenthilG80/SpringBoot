package com.nt.runner;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	 private IDoctorMgmtService service;
	 
  
	@Override
	public void run(String... args) throws Exception {
  
		service.showDoctorsByspecialization("healer","care").forEach(System.out::println);
		
		System.out.println("__ ___________ _______________ _________ ________");
		service.showDoctorsByIncome(100.0,1000.00).forEach(row->{
			for(Object obj:row) {
				System.out.print(obj + " ");
				
			}
			System.out.println();
			
		});
		System.out.println("__ ___________ _______________ _________ ________");
		
		service.showDoctorsByIncome(100.0,1000.00).forEach(row->{
			System.out.println(Arrays.toString(row));
			
		});
		
System.out.println("__ ___________ _______________ _________ ________");
		
		//service.showDoctorsByIncomeRange(100.0,1000.00).forEach(System.out::println);
	
System.out.println("============================");

     Doctor doctor=service.searchDoctorBynameDocName("raja");
      System.out.println(doctor);

      System.out.println("============================");

      Object obj= service.searchDoctorDataBynameDocName("raja");
      Object data[]=(Object[])obj;
      for(Object o: data) {
    	  System.out.print(o + " ");
      }
       System.out.println();
       System.out.println("Result is ::" + Arrays.toString(data));
       
       
       System.out.println("============================");

       String otpt= service.searchSpecilizaitonBynameDocName("raja");
       System.out.println("Specialization is  :"+ otpt);
     
       System.out.println("============================");
       
       System.out.println("Unique doctor names count ::" + service.showDoctorNameCount());
       
       System.out.println("============================");
       Object[] results=(Object[])service.showAggregateData();
       System.out.println("Records Count ::" + results[0]);
       System.out.println("Max Income Value ::" + results[1]);
       System.out.println("Min Income Value ::" + results[2]);
       System.out.println("Average Income ::" + results[3]);
       System.out.println("Sum of Income ::" + results[4]);
       
       
       System.out.println("============Non - select operations================");
       int count =service.appraiseDocotrsIncomeBySpecializaiton("care", 10.0);
        System.out.println("Number of Records that are updated are :"+ count);
        
        
        System.out.println("============Delete - Non - select operations================");
         System.out.println("Deleted doctors count ::"+ service.fireDoctorsByIncomeRange(400, 500));
         
         System.out.println("============Native SEQUEL Query================");
         System.out.println(service.insertDoctor("test", "test", 39939));
         
         
         System.out.println("============Show System Date================");
         System.out.println(service.showSystemDate());
         
         System.out.println("============Creating Table================");
         System.out.println(service.createTempDBtable());
	}

}
