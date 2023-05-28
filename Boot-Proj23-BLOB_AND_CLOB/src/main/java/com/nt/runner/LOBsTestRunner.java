package com.nt.runner;

 import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMarriageSeekerServiceMgmt;



@Component
public class LOBsTestRunner implements CommandLineRunner {
	
	@Autowired
 private IMarriageSeekerServiceMgmt msService;
	
    
     
    
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
	    System.out.println("Marraige Seeker Name");
		String name=sc.next();
		
		
	    System.out.println("Marraige Seeker Address");
	    String address=sc.next(); 
		
	    System.out.println("Marraige Seeker Indian");
	    boolean  indian=sc.nextBoolean(); 
	    
	    System.out.println("Marraige Seeker DOB (YYYY-MM-DDTHH:MM:SS");
	    String sdob=sc.next();
	    
	    
	    System.out.println("Marraige Seeker Photo file path");
	    sc.nextLine();
	    String  photoPath=sc.nextLine();
	    
	    
	    System.out.println("Marraige Seeker resume file path");
	    String  resumePath=sc.nextLine();
	    
	    //Convert String date value
	    
	    LocalDateTime dob=LocalDateTime.parse(sdob);
	    
	    InputStream is=new FileInputStream(photoPath);
	    byte[] photoContent=new byte[is.available()];
	    photoContent=is.readAllBytes();
	    
	    
	    File file=new File(resumePath);
	    Reader reader=new FileReader(file);
	    char[] resumeContent=new char[(int) file.length()];
	    reader.read(resumeContent);
	    reader.close();
	    
	    MarriageSeeker seeker=new MarriageSeeker(name,address,indian,dob,photoContent,resumeContent);
	    try {
	    	String msg=msService.registerMarriageSeeker(seeker);
	    	System.out.println(msg);
	    	
	    	MarriageSeeker s1=msService.searchSeekerById(1);
	    		if(s1!=null) {
	    			System.out.println(s1.getMsid() + " " +s1.getMsName() + " " + s1.getMsAddress() + " "+ s1.getDob() +" " + s1.getIndian());
	    		   byte[] photoContent1=s1.getMsphoto();
	    		   OutputStream os=new FileOutputStream("Picture1.jpg");
	    		   os.write(photoContent1);
	    		   os.flush();
	    		   os.close();
	    		   
	    		   char[] resumeContent1=s1.getMsresume();
	    		   Writer writer=new FileWriter("Resume.docx");
	    		   writer.write(resumeContent1);
	    		   writer.flush();
	    		   writer.close();
	    		   
	    		   System.out.println("LOB are retrieved");
	    		} 
	    }catch (Exception e) {
			e.printStackTrace();
		}

	}

}
