package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("doctorService")
public class DoctorServiceMgmtImpl implements IDoctorManagmentService {
  
	@Autowired
	private EntityManager manager;
	@Override
	public List<Doctor> showDoctorsByIncomeRange(double start, double end) {
    //Create StoredProcedureQuery Object Pointing PL/SQL procedure 
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME",Doctor.class);
   //register both IN,OUT params by specifying their mode
		query.registerStoredProcedureParameter(1, double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3,Doctor.class, ParameterMode.REF_CURSOR);
        
        // set Value to IN Param
        
        query.setParameter(1, start);
        query.setParameter(2, end);
        
        //Call PL/SQL Procedure
        

		List<Doctor> list= query.getResultList();
        
		return list; 
	}

}
