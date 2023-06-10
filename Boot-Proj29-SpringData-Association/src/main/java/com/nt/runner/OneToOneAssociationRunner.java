package com.nt.runner;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.docment.DrivingLicense;
import com.nt.docment.Person;
import com.nt.service.IRTAManagemnetService;

@Component
public class OneToOneAssociationRunner implements CommandLineRunner {
	
@Autowired
 private IRTAManagemnetService rtaService;
	@Override
	public void run(String... args) throws Exception {
		
	try {
		

	 //Save Object Using Parent
		
		Person per =new Person();
		per.setPid(2001);
		per.setPname("Rajesh");
		per.setPaddrs("Chennai");
		
      //Saving child object
		DrivingLicense license=new DrivingLicense();
		license.setLid(new Random().nextLong(1000));
		license.setLicenseType("LMV");
		license.setExpiryDate(LocalDate.of(2043, 10, 20));
		
	//Perform Association
		per.setLicenseDetails(license);
		
		//Access Service
		
		System.out.println(rtaService.registerPerson(per));
	}catch (Exception e) {
		e.printStackTrace();
	}
    System.out.println("___________________________________________");
    try {
		
		Person per =new Person();
		per.setPid(2002);
		per.setPname("Arun");
		per.setPaddrs("Delhi");
		
      //Saving child object
		DrivingLicense license=new DrivingLicense();
		license.setLid(new Random().nextLong(1000));
		license.setLicenseType("HMV");
		license.setExpiryDate(LocalDate.of(2033, 11, 01));
		
	//Perform Association
	    license.setPersonDetails(per);
		
		//Access Service
		
		System.out.println(rtaService.registerDrivingLicense(license));
    }catch (Exception e) {
		e.printStackTrace();
	}
	}

}
