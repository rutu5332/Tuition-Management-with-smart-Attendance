<%-- <%@page import="Database.Data"%>
 --%>
<!DOCTYPE html>
<html>
<head>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
        
       

<title>Assignment Details</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="../Assests/css/myprofile.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="../Assests/css/updateprofile.css" rel="stylesheet">
<link href="../Assests/css/changepswd.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../Assests/css/plugins/social-buttons.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../Assests/css/smartech.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="../Assests/css/bootstrap.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

</head>

<body style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">

	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<br>
	<br>
	<label style="font-size:30px;margin-left:10%;color:#d9534f">Upload Assignment</label><br>
	<form action="../upload" method="post" enctype="multipart/form-data">
	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-2">
									<h4>Assignment Title:</h4>
								</div>
								
								<div class="col-sm-10" style="align-self:  center;">
								<input type="text" name="title" id="title">
								</div>
							</div>
							<hr>
							
							<div class="row">
								<div class="col-sm-2">
									<h4>Description:</h4>
								</div>
								
								<div class="col-sm-10" style="align-self:  center;">
								<textarea rows="3" cols="22" name="desc"></textarea>
								</div>
								
							</div>
							<hr>
							
							<div class="row">
								<div class="col-sm-2">
									<h4>Class:</h4>
								</div>
								
								<div class="col-sm-10" style="align-self:  center;">
								<input type="text" name="class">
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-2">
									<h4>Due Date:</h4>
								</div>
								
								<div class="col-sm-10" style="align-self:  center;">
								<input type="date" name="date">
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-2">
									<h4>Upload File:</h4>
								</div>
								
								<div class="col-sm-10" style="align-self:  center;">
								<input type="file" name="file">
								</div>
							</div>
							<hr>
							
							
							<input type="submit" value="Upload" class="btn btn-danger text-white" style="margin-left:17%;">
							
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
	<!-- jQuery Version 1.11.0 -->
	<script src="../Assests/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../Assests/js/bootstrap.min.js"></script>

</body>
</html>