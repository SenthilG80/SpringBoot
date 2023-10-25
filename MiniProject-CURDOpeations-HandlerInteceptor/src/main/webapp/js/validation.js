/**
 * 
 */

 function validate(frm){
	 
	 // empty the existing error message
	   document.getElementById("enameErr").innerHTML="";
	   document.getElementById("jobErr").innerHTML="";
	   document.getElementById("salErr").innerHTML="";
	   document.getElementById("deptnoErr").innerHTML="";
	 
	 let name=frm.ename.value;
	  let desg=frm.job.value;
	  let salary=frm.sal.value;
	  let dno=frm.deptno.value;
	  
	  let isValid=true;
	  if(name==""){
		  document.getElementById("enameErr").innerHTML="CV: Employee name is mandatory";
		  isValid=false;
	  }
	  else if(name.length<5 || name.length >15){
		  document.getElementById("enameErr").innerHTML="CV: Employee name must be < 5 & > 15";
		  	  isValid=false;
	  }
	  
	  
	    if(desg==""){
		  document.getElementById("jobErr").innerHTML="CV: Employee job is mandatory";
		  isValid=false;
	  }
	  else if(desg.length<5 || desg.length >10){
		  document.getElementById("jobErr").innerHTML="CV: Employee job must be < 5 & > 10";
		  	  isValid=false;
	  }
	  
	  
	      if(sal==""){
		  document.getElementById("salErr").innerHTML="CV:Employee salary is mandatory";
		  isValid=false;
	  }
	      else if (isNaN(salary)){
		  		  document.getElementById("salErr").innerHTML="CV:Employee salary must be Numeric";
                   isValid=false;
	  }
	       else if(salary < 10000 || salary > 200000){
		     document.getElementById("salErr").innerHTML="CV:Employee salary must be in the range of 10k to 2 L";
		  	  isValid=false;
	  }
	  
	        if(dno==""){
		      document.getElementById("deptnoErr").innerHTML="CV:Employee department is mandatory";
		     isValid=false;
	  }
	  
	  frm.vflag.value="yes";
	   alert("Client side validation");
	    return isValid;
 }