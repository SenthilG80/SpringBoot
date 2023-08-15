package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
 @GetMapping("/")	
  public String showHome() {
	  return "welcome";
  }
 
 @GetMapping("/register")
 public String showFormPage() {
	 return "student_register";
 }
 @PostMapping("/register")
 public String processStudent(@ModelAttribute("stud") Student st, Map<String,Object> map) {
	System.out.println("Student "+st);
	 String result=null;
	  if(st.getAvg()<35.0f)
	         result="Need to Improve";
	  else if(st.getAvg()>40.0f && st.getAvg()<60.0f)
		     result="Second Class";
	  else if(st.getAvg()>60.0f && st.getAvg()<80.0f)
		     result="First Class";
	  else
		     result="First Class with Distinction";
	  
	 map.put("resultMsg", result);	
	return "Show_Result";
	 
	 
 }
 
}
