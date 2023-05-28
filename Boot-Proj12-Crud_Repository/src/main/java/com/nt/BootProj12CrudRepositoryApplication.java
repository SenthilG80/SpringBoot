package com.nt;


import java.util.List;

//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.doctor;
//import com.nt.entity.doctor;
 import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootProj12CrudRepositoryApplication {
	
	public static void main(String[] args) {
		System.out.println("Boot APP - After Main Method");
	ApplicationContext ctx=SpringApplication.run(BootProj12CrudRepositoryApplication.class, args);
	System.out.println("Boot APP - Before get Bean Method");
	IDoctorService service=ctx.getBean("doctorservice",IDoctorService.class);

	
	try {
		doctor doctor1=new doctor();
		doctor1.setDocName("elon"); doctor1.setSpecialization("scientist"); doctor1.setIncome(45.66);
		String resultMsg=service.registerDoctor(doctor1);
		System.out.println(resultMsg);	
		
		
//		doctor doctor1=new doctor();
//		doctor1.setDocName("Ram"); doctor1.setSpecialization("All is WELL"); doctor1.setIncome(45.66);
//		doctor doctor2=new doctor();
//		doctor2.setDocName("Krishna"); doctor2.setSpecialization("All is WELL"); doctor2.setIncome(45.66);
//		doctor doctor3=new doctor();
//		doctor3.setDocName("Muruga"); doctor3.setSpecialization("All is WELL"); doctor3.setIncome(45.66);
//	  String msg= service.registerGroupOfDoctors((List.of(doctor1,doctor2,doctor3)));
//	  System.out.println(msg);
//	  
//	  // For Counting Number of Records
//	  System.out.println("Count of records -- :" + service.fetchDoctorsCount() );
//	  
//	  //Check whether doctor id exists or not
//	  System.out.println("Doctor Exists -- :" +  service.checkDoctorAvailability(52));
//	  
//	  //Retrieving all the rows from database and display
//	  Iterable<doctor> it =service.showAllDoctors();
//	  it.forEach(doc->{
//		  System.out.println(doc);
//	  });
//	  System.out.println("--------------------------------------");
//	  it.forEach(doc->System.out.println(doc)); 
//	  System.out.println("--------------------------------------");
//	  it.forEach(System.out::println);
//	  System.out.println("--------------------------------------");
//	  
//	  for(doctor doc:it) {
//		  System.out.println(doc);
//	  }
//	  
	  // Show doctors by IDS:
	//  service.showAllDoctorsByIds(List.of(100,101,102,103,104,105,106)).forEach(System.out::println);
	  
	  //optional API - to remove null pointer exception
	  
//	  doctor dr=service.showDoctorById(101);
//	  System.out.println(dr);
//	  //optional API - Alternate method
//	  doctor d2=service.showDoctorById2(101);
//	  System.out.println(d2);
//	  
//	  //optional API - Instead of throwing exception passing one more object
//	  doctor d3=service.showDoctorById3(10221);
//	  System.out.println(d3);
//	  System.out.println("---------------------------------------------------------------");
//	  //Partial update of object
//	  System.out.println(service.showDoctorById(101));
//	  String d4=service.updateDoctorIncomeById(101, 20.0f);
//	  System.out.println(d4);
//	  System.out.println(service.showDoctorById(101));
//	  System.out.println("---------------------------------------------------------------");
//	  
	  // Full updation
//	  doctor df=new doctor();
//	  df.setDocId(12223); df.setDocName("Senthil"); df.setIncome(23434.4334);df.setSpecialization("Healing");
//	  
//	  System.out.println(service.registerOrUpdateDoctor(df));
	  
	  // Delete the record by doctor id
//	  System.out.println(service.deleteDoctorById(1));
	  
	  //Delete the record by doctor object
//	  doctor d11=new doctor();
//	  d11.setDocId(101); d11.setDocName("All is well and fine");
//	  System.out.println(service.deleteDoctor(d11));
	  
	  //Delete  all the records
	 //  System.out.println(service.removeAllDoctors());
		
    // Delete group of records
		System.out.println(service.removeDoctorsByIds(List.of(2,223)));
	}catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("Boot APP - Before Closing conneciton");
	((ConfigurableApplicationContext) ctx).close();
	
	}

}
