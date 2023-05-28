package com.nt.service;



import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {

	 public String deleteDoctorsByIdsInBatch(List<Integer> ids);
	 public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... Properties);
	 public Doctor findDoctorById(Integer Id);
	 
	

}
