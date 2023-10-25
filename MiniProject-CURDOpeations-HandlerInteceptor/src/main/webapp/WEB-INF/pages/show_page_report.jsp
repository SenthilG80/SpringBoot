<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Spring Boot Project</title>
</head>
<body>
<h1 style="color:red;text-align:center">Employee Report -- -- -- Pagination</h1>

<c:choose>
  <c:when test="${!empty pageData.getContent()}">
   <table border="1" bgcolor="cyan" align="center">
       <tr>
           <th>Emp No</th><th>Emp Name</th><th>Emp Designation</th><th>Emp Salary</th><th>Dept Number</th>
       </tr>
        <c:forEach var="emp" items="${pageData.getContent()}">
           <tr>
              <td>${emp.empNo}</td>
              <td>${emp.ename}</td>
              <td>${emp.job}</td>
              <td>${emp.sal}</td>
              <td>${emp.deptno}</td>
              <td><a href="edit?no=${emp.empNo}"><img src="images/edit.jpg" width="25" height="25"></a> </td>
              <td><a href="delete?no=${emp.empNo}"  onclick="return confirm('Give Confirmaiton to delete')" 	><img src="images/delete.jpg" width="25" height="25"></a> </td>
           </tr>
        </c:forEach>
   </table>
   <br><br>
   <center>
    <c:if test="${!pageData.isFirst()}">
       <a href="page_report?page=0">First Page</a>
    </c:if>
     <c:if test="${pageData.hasPrevious()}">
       <a href="page_report?page=${pageData.getNumber()-1}">Previous</a>
    </c:if>
     <c:forEach var="i" begin="0" end="${pageData.getTotalPages() -1 }" step="1">
      [<a href="page_report?page=${i}">${i+1}</a>]
     </c:forEach>
     
      <c:if test="${pageData.hasNext()}">
       <a href="page_report?page=${pageData.getNumber()+1}">Next</a>
    </c:if>
       <c:if test="${!pageData.isLast()}">
       <a href="page_report?page=${pageData.getTotalPages()-1}">Last Page</a>
    </c:if>
     </center>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
</c:choose>
<center>
    <h1 style="color:Green;text-align:center">${resultMsg}</h1>
</center>

<center>
  <a href="./">home <img src="images/Home.jpg" width="50" height="50"></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="add">Add Employee <img src="images/add.jpg" width="50" height="50"></a>
</center>
</body>
</html>
