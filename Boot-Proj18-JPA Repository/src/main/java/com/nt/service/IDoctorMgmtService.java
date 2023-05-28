package com.nt.service;



import java.util.List;



import com.nt.entity.Doctor;

public interface IDoctorMgmtService {

	public List<Doctor> showDoctorsByspecialization(String sp1, String sp2);
	public List<Object[]> showDoctorsByIncome(double start, double end);
	//public List<String> showDoctorsByIncomeRange(double min, double max);

	
	public Doctor searchDoctorBynameDocName(String docName);
	
	public Object searchDoctorDataBynameDocName(String docName);
	
	public String  searchSpecilizaitonBynameDocName(String docName);
	
	public int showDoctorNameCount();
	
	public Object showAggregateData();
	
	public int appraiseDocotrsIncomeBySpecializaiton(String spn,double hkp);
	
	public int fireDoctorsByIncomeRange(double start,double end);
	
	public String insertDoctor(String specialization, String name, double income);
	
	public String showSystemDate();
	
	public String createTempDBtable();
	

    
    
	
}
