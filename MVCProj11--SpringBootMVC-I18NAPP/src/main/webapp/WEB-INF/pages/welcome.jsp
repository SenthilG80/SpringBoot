<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="color:red;text-align:center"><spring:message code="home.title"/></h1>
          <h3 style="color:blue;text-align:center"><a href="register"><spring:message code="home.link"/></a></h3>
           <br><br><br>
           <hr>
            <a href="?lang=ta_IN">Tamil</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <a href="?lang=en_US">English</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
             <br><br>
             <h4>Current Locale is ${pageContext.response.locale}</h4>
             <fmt:setLocale value="${pageContext.response.locale}"/>
             
             <jsp:useBean id="dt" class="java.util.Date"/>
             <fmt:formatDate var="fdt" value="${dt}" type="both"/>
             <b>Formatted date and time::${fdt}</b>
             <hr>
             <fmt:formatNumber var="fumber"  value="100000" type="number"/>
                formated number is  :: ${fumber} <br>
               <fmt:formatNumber var="fcurrency"  value="100000" type="currency"/>
                formated number is  :: ${fcurrency} <br>
                 <fmt:formatNumber var="fpercentage"  value="0.221" type="percent"/>
                formated number is  :: ${fpercentage} <br>
              
</body>
</html>