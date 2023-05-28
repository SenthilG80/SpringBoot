package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmentServiceImpl implements IDoctorMgmtService {
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
	  List<Doctor> list=doctorRepo.findAllById(ids);
	   doctorRepo.deleteAllByIdInBatch(ids);
		return list.size() + "Records are deleted";
	}

	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... Properties) {
      Sort sort=Sort.by(ascOrder?Direction.ASC : Direction.DESC, Properties);
      Example<Doctor> example=Example.of(exDoctor);
   	List<Doctor> l1=doctorRepo.findAll(example,sort);
      
      
      
		return l1;
	}

	@Override
	public Doctor findDoctorById(Integer Id) {
	  //Doctor doctor=doctorRepo.getById(Id);
	  Doctor doctor=doctorRepo.getReferenceById(Id);
		return doctor;
	}
 
	
		
	}


