<%@ page isELIgnored="false"  import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
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
 <br><br> <br><br>
 <c:if test="${!empty name}">
   <h1 style="color:yellow;text-align:center"> <b> Model attributes data is :: ${name}, ${name2} </b></h1>
   </c:if>
    <br><br> <br><br>
     <c:if test="${!empty friendsnames}">
       <h1 style="color:yellow;text-align:center"> <b> Collection Model attributes data is :: <%=Arrays.toString((String[])request.getAttribute("Vnames"))%>, ${friendsnames} </b></h1>
    </c:if>
    <br><br> <br><br>
       <h1 style="color:yellow;text-align:center"> <b> Collection Model attributes data is :: ${phoneNumbers}, ${idDetails} </b></h1>
    <br><br> <br><br>
         <c:if test="${!empty empData}">
     <h1 style="color:yellow;text-align:center"> <b> Model attributes data is :: ${empData}</b></h1>
         </c:if>
        <br><br> <br><br>
        <c:choose>
            <c:when test="${!empty listEmps}">
                  <table border="1" bgcolor ="cyan" align="center">
                  	<tr>
                  	<th>empno</th><th>ename</th><th>job</th><th>salary</th>
                     </tr>
                  	<c:forEach var="e" items="${listEmps}">
                  	 <tr>
                  	    <td>${e.empno}</td>
                  	    <td>${e.ename}</td>
                  	    <td>${e.job}</td>
                  	    <td>${e.salary}</td>
                     </tr>
                  	</c:forEach>  
                  </table>
            </c:when>
            <c:otherwise>
            <h1 style='color:green';text-align:center'>Records not found</h1>
            
            </c:otherwise>
        </c:choose>
            <br><br> <br><br>
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