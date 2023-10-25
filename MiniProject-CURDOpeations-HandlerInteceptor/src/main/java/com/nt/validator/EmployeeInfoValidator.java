package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.Entitys.EmployeeInfo;

@Component
public class EmployeeInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(EmployeeInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeInfoValidator.validate()");
		// TODO Auto-generated method stub
       EmployeeInfo emp=(EmployeeInfo)target;
       
       if(emp.getEname()==null || emp.getEname().length()==0 ||emp.getEname()=="")
    	   errors.rejectValue("ename", "emp.name.required");
       else if (emp.getEname().length()<5 || emp.getEname().length() >15)
    	   errors.rejectValue("ename", "emp.name.length");
       
       if(emp.getJob()==null || emp.getJob().length()==0 ||emp.getJob()=="")
    	   errors.rejectValue("job", "emp.job.required");
       else if (emp.getJob().length()<5 || emp.getJob().length() >10)
    	   errors.rejectValue("job", "emp.job.length");
       
       if(!errors.hasFieldErrors("sal")) {
       if(emp.getSal()==null )
    	   errors.rejectValue("sal", "emp.salary.required");
       else if (emp.getSal()<10000 || emp.getSal() >200000)
    	   errors.rejectValue("sal", "emp.salary.range");
       }
       if(emp.getDeptno()==null )
    	   errors.rejectValue("deptno", "emp.deptno.required");

       
	}

}
