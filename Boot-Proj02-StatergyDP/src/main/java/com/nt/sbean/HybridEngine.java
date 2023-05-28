package com.nt.sbean;

import org.springframework.stereotype.Component;

@Component("hEngg")
public class HybridEngine implements Engine {
	
	 public  HybridEngine() 
	{
		 System.out.println("Hybrid Engine Constructor");
	 }

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid Engine Start");

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid Engine Stop");

	}

}
