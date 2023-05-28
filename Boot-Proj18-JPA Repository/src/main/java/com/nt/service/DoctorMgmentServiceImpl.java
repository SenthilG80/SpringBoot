package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;
 
@Service
public class DoctorMgmentServiceImpl implements IDoctorMgmtService {
	@Autowired
	private IDoctorRepository doctorRepo;


	@Override
	public List<Doctor> showDoctorsByspecialization(String sp1, String sp2) {
	
		List<Doctor> list=doctorRepo.searchDoctorsBySpecialization(sp1, sp2 );
		return list;
		
		
	}


	@Override
	public List<Object[]> showDoctorsByIncome(double start, double end) {
		List<Object[]> list=doctorRepo.searchDoctorsByIncome(start, end );
		return list;
	}


//	@Override
//	public List<String> showDoctorsByIncomeRange(double min, double max) {
//		List<String> list=doctorRepo.searchAllDoctorsByIncomeRange(min, max);
//		return list;
//	}


	@Override
	public Doctor searchDoctorBynameDocName(String docName) {
		Doctor doc=doctorRepo.showDoctorInfoByName(docName).orElseThrow(()-> new IllegalArgumentException("Doctor not found"));
		return doc;
		
	}


	@Override
	public Object searchDoctorDataBynameDocName(String docName) {
		Object obj=doctorRepo.showDoctorDataByName(docName);
		return obj;
	}


	@Override
	public String searchSpecilizaitonBynameDocName(String docName) {
		String result=doctorRepo.showSpecializationByName(docName);
		return result;
		
	}


	@Override
	public int showDoctorNameCount() {
		int count=doctorRepo.fetchDoctorsNameCount();
		return count;
		
	}


	@Override
	public Object showAggregateData() {
	   Object obj=doctorRepo.fetchAggregateData();
	   return obj;
	}


	@Override
	public int appraiseDocotrsIncomeBySpecializaiton(String spn, double hkp) {
		int count=doctorRepo.hikeDoctosIncomeBySpecialization(spn, hkp);
		return count;
		
	}


	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return doctorRepo.removeDocotrsByIncomeRange(start, end);
	}


	@Override
	public String insertDoctor(String specialization,String name,  double income) {
		int count =doctorRepo.registerDoctor(name, specialization, income);
		return count==0?"Doctor not registered":"Doctor is registered";
		
	}


	@Override
	public String showSystemDate() {
		return doctorRepo.showSystemDate();
				
	}


	@Override
	public String createTempDBtable() {
		int count=doctorRepo.createTempTable();
		return count==0?"DB Table Created":"DB Table Not Created";
				
	}

	} 

	
		
	


