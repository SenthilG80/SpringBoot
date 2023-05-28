package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbean.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj02StatergyDpApplication {

	public static void main(String[] args) {
		
		//getting access to container
		ApplicationContext ctx= SpringApplication.run(BootProj02StatergyDpApplication.class, args);
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		vehicle.move("Chennai", "Tirchendur");
		((ConfigurableApplicationContext)ctx).close(); 
	}

}
