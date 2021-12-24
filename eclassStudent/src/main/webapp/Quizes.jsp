  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<title>Quizes </title>
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
					<h1>Quiz List</h1>
					
						<div class="card-body">
						<div class="row">
							
								<div class="col-sm-6">
									<h2 class="mb-0">Quiz Title</h2>
								</div>
								<div class="col-sm-3"><h2>Upload Date</h2></div>
								<div class="col-sm-3"><h2>Due Date</h2></div>
							</div>
							
						<c:forEach items="${list}" var="q">
							<div class="row">
							
								<div class="col-sm-6">
									<h3 class="mb-0"><a href="QuizController?id=${q.quiz_id}&action=quizDetails"><c:out value="${q.quiz_title}"/></a></h3>
								</div>
								<div class="col-sm-3"><h3><c:out value="${q.upload_date}"/></h3></div>
								<div class="col-sm-3"><h3><c:out value="${q.due_date}"/></h3></div>
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