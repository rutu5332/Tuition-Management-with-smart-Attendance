<%@page import="model.Assignment"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>



<title>Assignment Details</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="Assests/css/myprofile.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="Assests/css/updateprofile.css" rel="stylesheet">
<link href="Assests/css/changepswd.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="Assests/css/plugins/social-buttons.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="Assests/css/smartech.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="Assests/css/bootstrap.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

</head>

<body style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">
<%Assignment a=(Assignment)request.getAttribute("ass"); %>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<br>
	<br>
	

	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">

				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-6">
								
									<h1 class="mb-0" >
										<%-- <c:out value="${a.assignment_title}"/> --%>
										<%=a.getAssignment_title() %>
										</h1>
								</div>
								<div class="col-sm-3"></div>
								<div class="col-sm-3"> Due : <h3><%=a.getDue_date() %></h3></div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h3 class="mb-0">Description:</h3>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10"><%=a.getAssignment_description() %>
									</div>
								
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<a href="Assests/Assignments/<%=a.getAssignment_file() %>">
									<h4 class="mb-0"> Click here to view Assignment File </h4></a>
								</div>
								
							</div>
							<hr>
							

						</div>
					</div>
				</div>
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">

								<div class="mt-3">
									<h4> Submit your Work </h4>
									
									<hr>
									<form action="AssignmentController?id=<%=a.getAssignment_id() %>&action=submitAssignment" method="post" enctype="multipart/form-data">
									<input type="file" name="file">
									<button class="btn btn-primary">Submit File</button>
									</form>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>