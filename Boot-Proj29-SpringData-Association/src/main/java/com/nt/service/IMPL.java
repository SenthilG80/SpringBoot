package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.docment.DrivingLicense;
import com.nt.docment.Person;
import com.nt.repository.IDrivingLicenseRepository;
import com.nt.repository.IPersonRepository;

@Service("RTA Service")
public class IMPL implements IRTAManagemnetService {
@Autowired
 private IPersonRepository personRepo;
@Autowired
 private IDrivingLicenseRepository licenseRepo;
 
	@Override
	public String registerPerson(Person person) {
		Integer idVal=personRepo.save(person).getPid();
		return "Person and his driving license is saved with id value:"+idVal;
	}

	@Override
	public String registerDrivingLicense(DrivingLicense license) {
		Long idVal=licenseRepo.save(license).getLid();
		return "Driving License and Associated Person is saved with id value:"+ idVal;
	}

}
