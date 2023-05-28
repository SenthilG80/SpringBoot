package com.nt.sbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	@Autowired
	@Qualifier("myengine")
		private Engine  engine;
	
 public Vehicle() {
	 System.out.println("Vehicle.Vehicle()");
 }
 
 public void move(String SourcePlace, String DestinationPlace) {
	 engine.Start();
	 System.out.println("Journey Started from "+SourcePlace );
	 System.out.println("Journey ........................................ " );
	 engine.Stop();
	 System.out.println("Journey reached destination place "+DestinationPlace );
 }
	

}
