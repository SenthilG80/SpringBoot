<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:yellow; text-align:center">Employee Edit Page</h1>

<frm:form modelAttribute="emp">
 <table border="0" align="center" bgcolor="cyan">
 <tr>
        <td>Employee Number::</td>
         <td><frm:input path="empNo" readonly="true"/></td>
     </tr>
       <tr>
        <td>Employee Name::</td>
         <td><frm:input path="ename"/></td>
     </tr>
        <tr>
        <td>Employee Job::</td>
         <td><frm:input path="job"/></td>
     </tr>
        <tr>
        <td>Employee Salary::</td>
         <td><frm:input path="sal"/></td>
     </tr>
       <tr>
         <td colspan="2"><input type="submit"  value="update"></td>
     </tr>
 
 </table>

</frm:form>
</body>
</html>