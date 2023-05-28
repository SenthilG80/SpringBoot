package com.nt.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("TestApplicationRunner.run()");
		System.out.println("Non option Arguments = " +args.getNonOptionArgs());
		System.out.println("option arguments name and values");
		for( String name:args.getOptionNames()) {
			System.err.println(name +"------"+ args.getOptionValues(name));
		}
		
    
	}

}
