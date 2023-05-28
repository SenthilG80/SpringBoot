package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private EntityManager manager;
	@Override
	public List<Employee_Info> showEmployeeBySalaryRange(double start, double end) {
    StoredProcedureQuery query=manager.createStoredProcedureQuery("p_emp_details_by_salaryRange", Employee_Info.class);
    query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
    query.setParameter(1, start);
    query.setParameter(2, end);
    List<Employee_Info> list=query.getResultList();
    return list;
		
		
	}

}
