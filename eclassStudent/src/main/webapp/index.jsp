 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

        <!-- Favicon -->
        <link rel="shortcut icon" href="Assests/favicon.ico" type="image/x-icon">
        <link rel="icon" href="Assests/favicon.ico" type="image/x-icon">
        
        <!-- Bootstrap Core CSS -->
        <link href="Assests/css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="Assests/css/smartech.css" rel="stylesheet">
		<link href="Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>Tuition Management</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%
		/* if(session.getAttribute("userEmail") == null)
			response.sendRedirect("../login.jsp");
		else{
			int t=Integer.parseInt(session.getAttribute("userType").toString());
			if(t != 3)
				response.sendRedirect("../login.jsp");
		} */
%>
	
	<br><br>
	<label style="font-size:30px;margin-left:30%;">Your Today's Attendance Time : <%out.println(request.getAttribute("time")); %></label>
	
	<div style="border:2px solid black; width : 40%; margin-left:30%; margin-top:10%;text-align:center;">
		<h2 style="text-decoration:underline; font-weight:bold;"> Announcements </h2>
		<c:forEach items="${list}" var="a">
		
	<h3><c:out value="${a.announcement_date}"/>-<c:out value="${a.announcement_desc}"/></h3>
	
		</c:forEach>
	</div>
	
        <script src="Assests/js/jquery-1.11.0.js"></script>
        <script src="Assests/js/bootstrap.min.js"></script>
</body>
</html>