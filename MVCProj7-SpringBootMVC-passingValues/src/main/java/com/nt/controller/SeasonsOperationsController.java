package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nt.service.ISeasonFinderService;


@Controller
public class SeasonsOperationsController {
	
	@Autowired
	private ISeasonFinderService service;
	
	@GetMapping("/")
	public String showHome(Map<String,Object> map) {
		map.put("name", "SaiRam");
		map.put("name2", "Vel Muruga");
		map.put("Vnames", new String[]{"raj","chinna","munna"});
		map.put("friendsnames", List.of("ramesh","suresh","dinesh"));
	    map.put("phoneNumbers",Set.of(111111L,222222L,6666666L));
	    map.put("idDetails",Map.of("aadhar",454545L,"voterid",45435345L,"panNo",6554656345L));
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
