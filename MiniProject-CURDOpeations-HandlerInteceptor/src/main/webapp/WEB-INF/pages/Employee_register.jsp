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
<script type="text/javascript" src="js/validation.js"></script>
<h1 style="color:yellow; text-align:center">Employee Registration Page</h1>

<frm:form modelAttribute="emp" onsubmit="return validate(this)">
<p style="color:red;text-align:center"><frm:errors path="*"/></p>
 <table border="0" align="center" bgcolor="cyan">
       <tr>
        <td>Employee Name::</td>
         <td><frm:input path="ename"/><span id="enameErr"></span></td>
     </tr>
        <tr>
        <td>Employee Job::</td>
         <td><frm:input path="job"/><span id="jobErr"></span></td>
     </tr>
        <tr>
        <td>Employee Salary::</td>
         <td><frm:input path="sal"/><span id="salErr"></span></td>
     </tr>
     <tr>
        <td>Dept Number:</td>
         <td><frm:select path="deptno">
                       <frm:options items="${deptNoInfo}"/>
                       	 <%-- <frm:option value="10">10</frm:option>
                         <frm:option value="20">20</frm:option> --%>
                         </frm:select><span id="deptnoErr"></span></td>
     </tr>
       <tr>
         <td colspan="2"><input type="submit"  value="register"></td>
     </tr>
 
 </table>
   <frm:hidden path="vflag"/>
</frm:form>
</body>
</html>