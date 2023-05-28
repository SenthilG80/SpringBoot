package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj8MoreYmlInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj8MoreYmlInjectionApplication.class, args);
		Employee emp1=ctx.getBean("emp",Employee.class);
		System.out.println(emp1);
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
