
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="color:red;text-align:center"> <sp:message code="customer.form.title" /></h1>
 <frm:form modelAttribute="cust">
  <table border="1" align="center" bgcolor="cyan">
  	<tr>
  	    <td>><sp:message code= "customer.form.name"/> </td>
  	      <td>><frm:input path= "cname"/> </td>
  	</tr>
  	  	<tr>
  	    <td>><sp:message code= "customer.form.addrs"/> </td>
  	      <td>><frm:input path= "caddrs"/> </td>
  	</tr>
  	  	<tr>
  	    <td>><sp:message code= "customer.form.billAmt"/> </td>
  	      <td>><frm:input path= "billAmount"/> </td>
  	</tr>
  	  	<tr>
  	      <td><input type="submit" value="<sp:message code= "customer.form.submit"/>"/> </td>
  	</tr>
  </table>
 </frm:form>
 <br><br>
 <p align="center">
  <a href="?lang=ta_IN">Tamil</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="?lang=en_IN">English</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 </p>
 
</body>
</html>