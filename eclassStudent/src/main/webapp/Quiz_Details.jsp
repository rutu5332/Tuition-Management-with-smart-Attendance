<%@page import="model.Quiz"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<title>Quiz</title>
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
<%Quiz q=(Quiz)request.getAttribute("quiz"); %>
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
									<h1 class="mb-0">
										<%=q.getQuiz_title() %>
									</h1>
								</div>
								<div class="col-sm-3"></div>
								<div class="col-sm-3"><h4> Due <%=q.getDue_date() %></h4></div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h3 class="mb-0">Description :</h3>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-10"><%=q.getQuiz_desc() %> 
								</div>
								
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-12">
									<a href="<%=q.getQuiz_file() %>"><h4 class="mb-0"> Link for Quiz</h4></a>
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
									
									
									
								<a href="QuizController?id=<%=q.getQuiz_id() %>&action=submitQuiz">	
									
								<button class="btn btn-primary"
			>Mark As Done</button></a>
								</div>
							</div>
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