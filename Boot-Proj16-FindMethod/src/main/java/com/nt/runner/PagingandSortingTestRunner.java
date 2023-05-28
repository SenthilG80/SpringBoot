package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;


@Component
public class PagingandSortingTestRunner implements CommandLineRunner {
  @Autowired
	private IDoctorRepository repo;
  
  
	@Override
	public void run(String... args) throws Exception {
    repo.findByDocNameEquals("jobs").forEach(System.out::println);
    repo.findByDocNameIs("jobs").forEach(System.out::println);
    repo.findByDocName("jobs").forEach(System.out::println);
    
    repo.findByIncomeBetween(1.00,1000.09).forEach(System.out::println);
    
  //  repo.findBySpecializationIn(List.of("care")).forEach(System.out::println);
    repo.findByDocNameLike("S%").forEach(System.out::println);
    
    Iterable<Doctor> it=repo.findByIncomeLessThanEqualAndIncomeGreaterThanEqual(50000.00, 1.00);
    it.forEach(System.out::println);
    
    
    System.out.println("_______________________________________");
    
   repo.findByspecializationInOrIncomeBetween(List.of("Jeff","care"),4.00, 100.00).forEach(System.out::println);
   
    
	}

}
