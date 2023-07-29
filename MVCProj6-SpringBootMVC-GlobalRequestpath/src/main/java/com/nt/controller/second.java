package com.nt.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nt.service.ISeasonFinderService;



@Controller
@RequestMapping("/second")
public class second {

	
	@GetMapping("/")
	public String showHome() {
		return "welcome2";
	}
	
	
}
