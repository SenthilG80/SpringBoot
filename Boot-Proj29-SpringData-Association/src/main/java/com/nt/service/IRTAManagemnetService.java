package com.nt.service;

import com.nt.docment.DrivingLicense;
import com.nt.docment.Person;

public interface IRTAManagemnetService {
	public String registerPerson(Person person);
	public String registerDrivingLicense(DrivingLicense license);
	

}
