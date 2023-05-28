package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("dEngg")
public class DieselEngine implements Engine {
	
	 public  DieselEngine() 
	{
		 System.out.println("Diesel Engine Constructor");
	 }

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("Diesel Engine Start");

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("Diesel Engine Stop");

	}

}
