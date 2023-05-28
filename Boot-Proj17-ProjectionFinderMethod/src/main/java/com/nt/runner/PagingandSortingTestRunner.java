package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.view.IResultView;
import com.nt.view.IResultView1;
import com.nt.view.IResultView2;



@Component
public class PagingandSortingTestRunner implements CommandLineRunner {
  @Autowired
	private IDoctorRepository repo;
  
  
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("In Memory Proxy Class is ::"+ repo.getClass());
    Iterable<IResultView> it= repo.findByspecializationIn(List.of("care","healer"));
    it.forEach(doc->{
		System.out.println("In Memory Proxy Class is ::"+ doc.getClass());
    	System.out.println(doc.getdocName()+"--------------------------"+doc.getIncome());
    });
    	System.out.println("________________________________________");
    	Iterable<IResultView1> it1=repo.findByIncomeBetween(100.00, 1000.00,IResultView1.class);
    	
    	  it1.forEach(data->{
    			System.out.println("In Memory Proxy Class is ::"+ data.getClass());
    	    	System.out.println(data.getdocName()+"--------------------------"+data.getspecialization());
    	    });
    	  
    	  Iterable<IResultView2> it2=repo.findByIncomeBetween(100.00, 1000.00,IResultView2.class);
      	
    	  it2.forEach(data1->{
    			System.out.println("In Memory Proxy Class is ::"+ data1.getClass());
    	    	System.out.println(data1.getdocName()+"--------------------------"+data1.getspecialization()+"--------------"+data1.getIncome() );
    	    	
    	    });
	}

}
