  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>

<title>Assignment Details</title>
<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="Assests/css/plugins/social-buttons.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="Assests/css/smartech.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="Assests/css/bootstrap.css" rel="stylesheet">

</head>


<body style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">
  
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<br>
	<br>
	

	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
					<h1>Assignments List</h1>
					
						<div class="card-body">
						<div class="row">
							
								<div class="col-sm-6">
									<h3 class="mb-0">Assignment Title</h3>
								</div>
								<div class="col-sm-3"><h3>Upload Date</h3></div>
								<div class="col-sm-3"><h3>Due Date</h3></div>
							</div>
							
						<c:forEach items="${list}" var="a">
							<div class="row">
							
								<div class="col-sm-6">
									<h4 class="mb-0"><a href="AssignmentController?id=${a.assignment_id}&action=assignDetails"><c:out value="${a.assignment_title}"/></a></h4>
								</div>
								<div class="col-sm-3"><h4><c:out value="${a.upload_date}"/></h4></div>
								<div class="col-sm-3"><h4><c:out value="${a.due_date}"/></h4></div>
							</div>
							<hr>
							
							</c:forEach>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="Assests/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="Assests/js/bootstrap.min.js"></script>

</body>
</html>