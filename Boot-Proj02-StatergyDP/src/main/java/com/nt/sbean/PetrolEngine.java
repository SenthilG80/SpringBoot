package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("pEngg")
public class PetrolEngine implements Engine {
	
	 public  PetrolEngine() 
	{
		 System.out.println( "petrol engine constructor");
	 }

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("Pertrol Engine Start");

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("Pertrol Engine Stop");
	}

}
