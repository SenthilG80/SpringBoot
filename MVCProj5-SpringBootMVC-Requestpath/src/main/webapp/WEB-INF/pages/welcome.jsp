<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background-color: black;">
 <h1 style="color:yellow;text-align:center">WELCOME.JSP(HOME PAGE)</h1>
 <h1 style="color:white;text-align:center"><a href="season"> 
    <button style="background-color: red; color: white; padding: 10px 20px; border: none; cursor: pointer; font-size: 16px;">
 FIND SEASON
 </button>
 
 </a></h1>
 <br><br>
 <a href="report">Show Report</a>
  <br><br> <br><br>
 <form action="report" method="POST">
     <input type="submit" value="send">
 </form>
 


</body>
</html>