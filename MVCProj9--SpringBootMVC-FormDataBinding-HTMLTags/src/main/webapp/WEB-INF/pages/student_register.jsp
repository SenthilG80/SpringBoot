<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:yellow; text-align:center">Student Registration Page</h1>

<form action="register" method="POST">
 <table border="0" align="center" bgcolor="cyan">
    <tr>
        <td>Student id::</td>
         <td><input type="text" name="sno"></td>
     </tr>
       <tr>
        <td>Student Name::</td>
         <td><input type="text" name="sname"></td>
     </tr>
        <tr>
        <td>Student address::</td>
         <td><input type="text" name="address"></td>
     </tr>
        <tr>
        <td>Student avg::</td>
         <td><input type="text" name="avg"></td>
     </tr>
       <tr>
         <td colspan="2"><input type="submit"  value="register"></td>
     </tr>
 
 </table>

</form>
</body>
</html>