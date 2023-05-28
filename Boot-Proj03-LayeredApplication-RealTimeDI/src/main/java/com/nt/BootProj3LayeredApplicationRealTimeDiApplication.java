package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj3LayeredApplicationRealTimeDiApplication {

	public static void main(String[] args) {
		//read inputs from  the user 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee Name ");
		String name=sc.next();
		System.out.println("Enter the Employee  Designation");
		String desg=sc.next();
		System.out.println("Enter the Basic Salary");
		double  basicSalary=sc.nextDouble();
	
		
		Employee emp=new Employee();
		emp.setEname(name);
		emp.setDesg(desg);
		emp.setSalary(basicSalary);
		
		ApplicationContext ctx= SpringApplication.run(BootProj3LayeredApplicationRealTimeDiApplication.class, args);
		
		PayrollOperationsController controller =	 ctx.getBean("payrollController",PayrollOperationsController.class);
		
		System.out.println("After IOC Container Creation");
		try {
			String result=controller.processEmployee(emp);
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem");
		}
		sc.close();
		((ConfigurableApplicationContext)ctx).close();
		
		
	}

}
