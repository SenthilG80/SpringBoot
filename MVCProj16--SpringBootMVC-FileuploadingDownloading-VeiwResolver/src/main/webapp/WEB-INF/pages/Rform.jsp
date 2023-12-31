<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="color:red;text-align:center">File Uploading </h1>
 <frm:form modelAttribute="js" enctype="multipart/form-data">
  <table border="1" align="center" bgcolor="cyan">
  	<tr>
  	    <td>Job Seeker Name</td>
  	      <td>><frm:input path= "jsName"/> </td>
  	</tr>
  	  	<tr>
  	    <td>>Job Seeker Address </td>
  	      <td>><frm:input path= "jsAddrs"/> </td>
  	</tr>
  	  	<tr>
  	    <td>>Job Seeker Resume(File)</td>
  	      <td>><frm:input type="file" path= "resume"/> </td>
  	</tr>
  	<tr>
  	      <td>>Job Seeker Photo(File)</td>
  	      <td>><frm:input type="file" path= "photo"/> </td>
  	</tr>
  	  	<tr>
  	      <td><input type="submit" value="register"/> </td>
  	</tr>
  </table>
 </frm:form>

 
</body>
</html>