package com.nt.controller;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Controller
public class ShowHomeController {
	
	//@RequestMapping("/home")
	@RequestMapping("/")
	public String showHomePage() {
		
		//return lvm
		return "welcome";
		
	}
//	
//@RequestMapping("/process")
//	public String processRequest(Map<String, Object> map) { 
//		map.put("attr1", "val1");
//		map.put("sysDate", new Date());
//		
//		//return lvm
//		return "show_results";
//		
//	}
	
//	@RequestMapping("/process")
//	public Model processRequest( ) {
//		Model model=new BindingAwareModelMap();
//		model.addAttribute("attr1","val1");
//		model.addAttribute("sysDate", LocalDateTime.now());
//		return model;
//		
//	}
	
//	@RequestMapping("/process")
//	public ModelAndView processRequest( ) {
//		System.out.println("ShowHomeController.processRequest()");
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("attr1","val1");
//		mav.addObject("sysDate", LocalDateTime.now());
//		return mav;
//		
//	}
	
//	@RequestMapping("/process")
//	public void processRequest(Map<String,Object> map ) {
//	
//		map.put("attr1","val1");
//		map.put("sysDate", LocalDateTime.now());
//	
//		
//	}
	
//	@RequestMapping("/process")
//	public String processRequest(Map<String, Object> map) { 
//		map.put("attr1", "val1");
//		map.put("sysDate",  LocalDateTime.now());
//		
//		//return lvm
//		return "forward:report";
//		
//	}
//	@RequestMapping("/report")
//	public String reportRequest(Map<String, Object> map) { 
//
//		
//		//return lvm
//		return "report";
//		
//	}
	
	
	/*
	 * @RequestMapping("/process") public String processRequest(HttpServletRequest
	 * req) { req.setAttribute("attr1", "HELLO");
	 * 
	 * //return lvm return "forward:report";
	 * 
	 * }
	 * 
	 * @RequestMapping("/report") public String reportRequest(HttpServletRequest
	 * req) {
	 * 
	 * System.out.println("ShowHomeController.processRequest()");
	 * System.out.println("reqest attribute vale ::::"+req.getAttribute("attr1"));
	 * 
	 * 
	 * //return lvm return "report";
	 * 
	 * }
	 */
	/*
	@Autowired
	private ServletConfig cg;
	@Autowired
	private ServletContext sc;	
	@RequestMapping("/process")
	public String processRequest(HttpSession  ses) { 
		System.out.println("ShowHomeController.processReqest()");
	     System.out.println("DS logical name :: " + cg.getServletName());
	     System.out.println("Web Application Name :: " + sc.getContextPath());
		   ses.setAttribute("attr1", "HELLO");
		   ses.setAttribute("sysDate", LocalDateTime.now());
		   return "show_results";
			
	}
	*/
	@RequestMapping("/process")
	public void processRequest(HttpServletResponse  res) throws Exception { 
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  pw.println("<h1> hello, how are you</h1>");
			
	}

}
