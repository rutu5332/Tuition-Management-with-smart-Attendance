<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>

<title>Study Documents</title>
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
			
	<c:forEach items="${list}" var="s">
				<div class="col-md-6">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row"> 
								<div class="col-sm-12"><h2><c:out value="${s.material_title}"/></h2> </div>
								<div class="col-sm-12"><h3>Upload Date:<c:out value="${s.upload_date}"/></h3> </div>
								<div class="col-sm-12"><h1><a href="Assests/Study_Materials/${s.material_file}">
									Link</a></h1>
	</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>

			</div>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="Assests/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="Assests/js/bootstrap.min.js"></script>

</body>
</html>