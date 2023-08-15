package com.nt.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
//@RequestMapping("/second")
public class second {

	
	@GetMapping("/")
	public String showHome() {
		return "welcome2";
	}
	@GetMapping("/season")
	public String showSeason() {

//		return "forward:first/season";
		return "redirect:first/season";
	}
	
}
