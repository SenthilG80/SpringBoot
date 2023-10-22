package com.nt.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("CustomerOperationsController.showHomePage()");
		return "welcome";
	}
	@GetMapping("/customer_register")
	public String showCustomerFormPage(@ModelAttribute("cust")Customer cust ) {
		System.out.println("CustomerOperationsController.showCustomerFormPage()");
		return "customer_form";
	}
	
	@PostMapping("/customer_register")
	public String processCustomerForm(@ModelAttribute("cust")Customer cust, Map<String, Object> map) {
		System.out.println("CustomerOperationsController.processCustomerForm()");
		System.out.println("ModelObjectData::" +cust);
		map.put("custData", cust);
		return "show_result";
	}
	
	@InitBinder
	public void myDataBinder(WebDataBinder binder) {
		System.out.println("CustomerOperationsController.myDataBinder()");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf1, true));
	}
}
