package com.nt.service;
import java.util.List;



import com.nt.entity.doctor;
	
public interface IDoctorService {
	 public String registerDoctor(doctor doctor);
//	public String registerGroupOfDoctors(Iterable<doctor> doctors);
//	public long 	fetchDoctorsCount();
//	public boolean checkDoctorAvailability(Integer id);
//	public Iterable<doctor> showAllDoctors();
//	public  Iterable<doctor> showAllDoctorsByIds(Iterable<Integer> ids);
//    public doctor showDoctorById(Integer id);
//	public doctor showDoctorById2(Integer id);
//	public doctor showDoctorById3(Integer id);
//	public String updateDoctorIncomeById(Integer id, float hikePercentage);
//	public String registerOrUpdateDoctor(doctor dr);
//	public String deleteDoctorById(Integer id);
//	public String deleteDoctor(doctor dr);
//	public String removeAllDoctors();
	public String removeDoctorsByIds(List<Integer> ids);
	
	
	
	
	
	 	 	
	
	

}
