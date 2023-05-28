package com.nt;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication

public class BootProj4LayeredApplicationRealTimeDiMySqLtestingApplication {
	
	@Autowired
	private Environment env; 
	
	@Bean(name="c3PODs")
	@Profile("test")
	public ComboPooledDataSource createC3P0Ds() throws Exception{
		System.out.println("Inside ComboPooledDataSource");
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));
		
		cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3P0.minSize")));
		cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3P0.maxSize")));
		return cds;
	}


	public static void main(String[] args) {
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
		
		ApplicationContext ctx= SpringApplication.run(BootProj4LayeredApplicationRealTimeDiMySqLtestingApplication.class, args);
		
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
