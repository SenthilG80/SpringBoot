
package com.nt.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;


@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		return  "welcome";
	}
	
	@GetMapping("/register")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		return  "customer_form";
	}
 
	
	@PostMapping("/register")
	public String processCustomerFormSubmission(Map<String, Object> map,@ModelAttribute("cust") Customer cust) {
		if(cust.getBillAmount()<20000)
			map.put("resultMsg","customer is economy customer");
		else
			map.put("resultMsg","customer is Luxury customer");
		
		return "show_result";
	}
}
