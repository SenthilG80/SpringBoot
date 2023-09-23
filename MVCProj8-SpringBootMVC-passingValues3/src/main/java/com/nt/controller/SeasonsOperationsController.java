package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.nt.model.Employee;
import com.nt.service.ISeasonFinderService;


@Controller
public class SeasonsOperationsController {
	
	@Autowired
	private ISeasonFinderService service;
	
	@GetMapping("/")
	public String showHome(Map<String,Object> map) {
		//Simple Parameter
		map.put("name", "SaiRam");
		map.put("name2", "Vel Muruga");
		
		//Collections and Arrays
		map.put("Vnames", new String[]{"raj","chinna","munna"});
		map.put("friendsnames", List.of("ramesh","suresh","dinesh"));
	    map.put("phoneNumbers",Set.of(111111L,222222L,6666666L));
	    map.put("idDetails",Map.of("aadhar",454545L,"voterid",45435345L,"panNo",6554656345L));
	    
	    
	    //for Model class obj as the Model attribute
	    Employee emp=new Employee();
	    emp.setEname("Me");
	    emp.setEmpno(2344);
	    emp.setJob("Software Engineer");
	    emp.setSalary(45454545.90);
	    map.put("empData", emp);
	    
	    //collection of Model class obj
	    Employee emp1=new Employee(234,"SaiBaba","God",1.1);
	    Employee emp2=new Employee(334,"Muruga","G",2.1);
	    Employee emp3=new Employee(434,"Shivan","om",3.1);
	    Employee emp4=new Employee(534,"Samyaburuth Amman","Amma",4.1);
	    List<Employee> listEmps=List.of(emp1,emp2,emp3,emp4);
	    map.put("listEmps", listEmps);
	    
	    
	    
		return "welcome";
	}
	
	@GetMapping({"/season","/season1","/season2","/season3"})
	public String showSeason(Map<String,Object> map) {
		String msg=service.findSeason();
		map.put("resultMsg",msg);
		return "display";
	}
	
	@GetMapping("/report")
	public String showReport1() {
	 System.out.println("SeasonsOperationsController.showReport1() --- GET");
		return "report1";
	}
	
	
	@PostMapping("/report")
	public String showReport2() {
	System.out.println("SeasonsOperationsController.showReport2() -- POST");
		return "report2";
	}
}
