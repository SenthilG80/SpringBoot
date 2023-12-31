package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerInfoMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileuploadoperationsController {

@Autowired
 private 	IJobSeekerInfoMgmtService jsService;
 
 @GetMapping("/")
 public String showHomePage() {
	 return "welcome";
 }
 
 @GetMapping("/js_register")
 public String showJobSeekerRegistrationFormPage(@ModelAttribute("js") JobSeeker seeker) {
  return "js_register_form";
 }
 
 @Autowired
 private Environment env;
 @PostMapping("/js_register")
 public String registerJobSeeker(@ModelAttribute("js") JobSeeker seeker, Map<String, Object> map) {
    String location=env.getRequiredProperty("upload.store");
    
    File file=new File(location);
    if(!file.exists())
    	file.mkdir();
    //get the names of the uploaded files
    String resumeFileName=seeker.getResume().getOriginalFilename();
    String photoFileName=seeker.getPhoto().getOriginalFilename();
    
    //get the Inputstream representing the uploaded files
   try ( InputStream resumeIS=seeker.getResume().getInputStream();
		   InputStream photoIS=seeker.getPhoto().getInputStream();
		   //create output stream pointing to files
		   OutputStream resumeOS=new FileOutputStream(location + "\\" + resumeFileName);
		   OutputStream photoOS=new FileOutputStream(location + "\\" + photoFileName);
 
		   )
   {
	   IOUtils.copy(photoIS, photoOS);
	   IOUtils.copy( resumeIS, resumeOS);
	   
	   //Convert  Model class obj data to entity object data
	   
	   JobSeekerInfo jsInfo=new JobSeekerInfo();
	   jsInfo.setJsName(seeker.getJsName());
	   jsInfo.setJsAddrs(seeker.getJsAddrs());
	   jsInfo.setResumePath(location + "\\" + resumeFileName);
	   jsInfo.setPhotoPath(location + "\\" + photoFileName);
	   
	   //use service class
	   String resultMsg=jsService.registerJobSeeker(jsInfo);
	   //add result to model attributes
	   map.put("resultMsg", resultMsg);
	   map.put("resumeFileName", resumeFileName);
	   map.put("photoFileName", photoFileName);
   }catch (Exception e) {
	e.printStackTrace();

}
 
    
	 return "show_result";
 }
 
 @GetMapping("/js_report")
  public String show_Report(Map<String, Object> map){
	 List<JobSeekerInfo> list=jsService.getAllJobSeekersInfo();
	   map.put("jsInfo", list);
	   return "show_report";
  }
 
 @Autowired
 private ServletContext sc;
 @GetMapping("/download")
 public String downloadFile(@RequestParam("id") Integer id,
		 @RequestParam(name = "type", required = false) String type,
		                                             HttpServletResponse res) {
	 String fileLocation=null;
	 if(type.equalsIgnoreCase("resume"))
		    fileLocation=jsService.findResumePathById(id);
	 else
		   fileLocation=jsService.findPhotoPathById(id);
	 
	 File file=new File(fileLocation);
	  long length=file.length();
	  res.setContentLengthLong(length);
	  
	  String mimeType=sc.getMimeType(fileLocation);
	  mimeType=mimeType==null?"application/octet-stream":mimeType;
	  res.setContentType(mimeType);
	  
	  try(InputStream is=new FileInputStream(file);
			  OutputStream os=res.getOutputStream();){
		  
		  res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
		  IOUtils.copy(is, os);
		  
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  
	 
	 return null;
 }
 
}
