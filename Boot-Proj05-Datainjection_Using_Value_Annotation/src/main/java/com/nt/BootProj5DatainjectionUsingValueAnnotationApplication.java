package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class BootProj5DatainjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
	 ApplicationContext ctx=	SpringApplication.run(BootProj5DatainjectionUsingValueAnnotationApplication.class, args);
	 PatientInfo info=ctx.getBean("pinfo",PatientInfo.class);
	 System.out.println(info);
	((ConfigurableApplicationContext)ctx).close();
	
	}

}
