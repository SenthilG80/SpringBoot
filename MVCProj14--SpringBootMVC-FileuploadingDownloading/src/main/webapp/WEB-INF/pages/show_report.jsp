<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center">Employee Report Page</h1>
<c:choose>
  <c:when test="${!empty jsInfo}">
   <table border="1" bgcolor="cyan" align="center">
       <tr>
           <th>JsId</th><th>JsName</th><th>Js Address</th><th>resume</th><th>Photo</th>
       </tr>
        <c:forEach var="js" items="${jsInfo}">
        <tr>
              <td>${js.jsId}</td>
              <td>${js.jsName}</td>
              <td>${js.jsAddrs}</td>
              <td><a href="download?id=${js.jsId}&type=resume">download resume</a></td>
              <td><a href="download?id=${js.jsId}&type=photo">download photo</a></td>
           </tr>
        </c:forEach>
   </table>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
</c:choose>
</body>
</html>