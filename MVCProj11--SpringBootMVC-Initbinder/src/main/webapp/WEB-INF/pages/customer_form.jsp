<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Spring Boot Project</title>
</head>
<body>

<h1 style="color:yellow; text-align:center">Customer Registration Page</h1>

<frm:form modelAttribute="cust">
<p style="color:red;text-align:center"><frm:errors path="*"/></p>
 <table border="0" align="center" bgcolor="cyan">
      <tr>
        <td>Customer Number::</td>
         <td><frm:input path="cno"/></td>
     </tr>
       <tr>
        <td>Customer Name::</td>
         <td><frm:input path="cname"/></td>
     </tr>
        <tr>
           <td>Customer billAmount::</td>
           <td><frm:input path="billAmount"/></td>
        </tr>
        <tr>
           <td>Customer DOB::</td>
           <td><frm:input path="dob" type="date"/></td>
       </tr>
       <tr>
           <td>Customer DOJ::</td>
           <td><frm:input path="doj" type="date"/></td>
       </tr>
       
       <tr>
           <td>Customer Date of Purchase::</td>
           <td><frm:input path="dop" type="datetime-local"/></td>
       </tr>
   
       <tr>
         <td colspan="2"><input type="submit"  value="register"></td>
     </tr>
 
 </table>

</frm:form>
</body>
</html>