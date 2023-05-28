package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCmdRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestCmdRunner.run()");
		System.out.println("Command Line arguments are ::: " +Arrays.toString(args));
		int a=10;
		System.out.println("Square of the given number a ="+ (a*a));

	}

}
