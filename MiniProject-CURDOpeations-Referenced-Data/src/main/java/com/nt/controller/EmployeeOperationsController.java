package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.Entitys.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
   
	@Autowired
   private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHome() {
	
		return "welcome";
		
	}
	
	@GetMapping("/report")
	public	String showReportData(Map<String,Object> map) {
		List<EmployeeInfo> list=empService.getAllEmpsData();
		map.put("result", list);
		return "show_report";
		
	}
	@GetMapping("/add")
	public	String showAddEmployeeFormPage(@ModelAttribute("emp")EmployeeInfo emp) {

		return "Employee_register";
		
	}
//	@PostMapping("/add")
//	public	String registerEmployee(@ModelAttribute("emp")EmployeeInfo emp,Map<String, Object> map) {
//       String result=empService.addEmployee(emp);
//       List<EmployeeInfo> list=empService.getAllEmpsData();
//       map.put("resultMsg", result);
//       map.put("result", list);
//       
//		return "show_report";
//		
//	}
	
	
//	@PostMapping("/add")
//	public	String registerEmployee(@ModelAttribute("emp")EmployeeInfo emp,Map<String, Object> map) {
//       String result=empService.addEmployee(emp);
//       map.put("resultMsg", result);     
//		return "redirect:report";
//		
//	}
//	
	
	
//	@PostMapping("/add")
//	public	String registerEmployee(@ModelAttribute("emp")EmployeeInfo emp, RedirectAttributes rattrs) {
//       String result=empService.addEmployee(emp);
//       rattrs.addFlashAttribute("resultMsg", result);     
//		return "redirect:report";
//		
//	}
	
	@PostMapping("/add")
	public	String registerEmployee(@ModelAttribute("emp")EmployeeInfo emp, HttpSession ses) {
       String result=empService.addEmployee(emp);
       ses.setAttribute("resultMsg", result);     
		return "redirect:report";
		
	}
	
	@GetMapping("/edit")
	public String showEditPage(@RequestParam("no") int eno, @ModelAttribute("emp")EmployeeInfo info) {
		EmployeeInfo info1=empService.findEmployeeByEno(eno);
		BeanUtils.copyProperties(info1, info);
         return "employee_edit";
		
	}
	
	@PostMapping("/edit")
	public String procesEditFormSubmission(@ModelAttribute("emp")EmployeeInfo info, RedirectAttributes attrs) {
		String resultMsg=empService.updateEmployee(info);
		attrs.addFlashAttribute("resultMsg", resultMsg);
         return "redirect:report";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int eno, RedirectAttributes attrs) {
		String resultMsg=empService.deleteEmployee(eno);
		attrs.addFlashAttribute("resultMsg", resultMsg);
         return "redirect:report";
		
	}
	
	@ModelAttribute("deptNoInfo")
	public List<Integer> populateDepts(){
		System.out.println("EmployeeOperationsController.populateDepts()");
	 return empService.showAllDepts();
	}
}
