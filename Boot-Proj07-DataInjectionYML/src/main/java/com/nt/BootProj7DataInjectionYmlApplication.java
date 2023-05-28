package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.CustomerInfo;

@SpringBootApplication
public class BootProj7DataInjectionYmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj7DataInjectionYmlApplication.class, args);
		CustomerInfo custinfo=ctx.getBean("cust",CustomerInfo.class);
		System.out.println(custinfo);
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
