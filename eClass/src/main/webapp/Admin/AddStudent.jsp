
<!DOCTYPE html>
<html>
<head>
<title>Add Student</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../Assests/favicon.ico" type="image/x-icon">
<link rel="icon" href="../Assests/favicon.ico" type="image/x-icon">

<link href="../Assests/css/addUser.css" rel="stylesheet">
<!--  <link href="css/changepswd.css" rel="stylesheet"> -->

<script src="../Assests/js/jquery-1.11.0.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../Assests/js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">

<link href="../Assests/css/bootstrap.css" rel="stylesheet">
<link href="../Assests/css/plugins/social-buttons.css" rel="stylesheet">
<link href="../Assests/css/smartech.css" rel="stylesheet">
<link href="../Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
</head>
<body
	style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 16px;">

	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<%
			/* if(session.getAttribute("userEmail") == null){
				response.sendRedirect("../login.jsp");
			}
			else{
				int t=Integer.parseInt(session.getAttribute("userType").toString());
				if(t != 1)
					response.sendRedirect("../login.jsp");
			} */
	
		%>
		<div id="outer-box">
			<div class="container">
				<div class="main-body">
					<div class="container" id="show">
						<div class="row gutters-sm">
						<h1 class="form-heading">ADD STUDENT</h1>
							<div class="col-md-4 mb-3">
								<img src="../Assests/img/add.png" alt="image"
									style="height: 100%; width: 100%" /><br>
								
							</div>
							
							<div class="col-lg-8">
								
								<div class="card">
									<div class="card-body">
									 <!--  Add User Form -->
										<form action="../AddStudent" method="post" name="AddUserForm" enctype="multipart/form-data">
											

											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Student Name</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="Name *" name="name" id="name">
													<span id="name-error" style="color:red; font-size:12px;"></span>
												</div>
												
											</div>

											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Class</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<select class="form-control" id="class" name="class">
														<option value="0">-- Select --</option>
														<option value="11">11</option>
														<option value="12">12</option>
													</select>
													<span id="class-error" style="color:red; font-size:12px;"></span>
												</div>
												
											</div>
											
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">DOB</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="date" class="form-control"
														 name="dob" id="dob">
													<span id="dob-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
											
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Mobile</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="+91 9999999999" name="mob" id="mob">
													<span id="mob-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
		
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Email</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="john@example.com" name="email" id="email">
													<span id="email-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
											
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Parent's Name</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="Name *" name="pname" id="pname">
													<span id="pname-error" style="color:red; font-size:12px;"></span>
												</div>
												
											</div>
															
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Parent's Mobile</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="+91 9999999999" name="pmob" id="pmob">
													<span id="pmob-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
											
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Parent's Email</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="text" class="form-control"
														placeholder="john@example.com" name="pemail" id="pemail">
													<span id="pemail-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
											
											<div class="row mb-3" style="display: initial;">
												<div class="col-sm-3">
													<h5 class="mb-0">Image</h5>
												</div>
												<div class="col-sm-9 text-secondary">
													<input type="file" class="form-control"
														 name="img1" id="img1">
													<span id="img1-error" style="color:red; font-size:12px;"></span>
												</div>
											</div>
											
											<div class="row" style="display: initial;">
												<div class="col-sm-3"></div>
												<div class="col-sm-9 text-secondary">
													<input type="submit" class="btn btn-primary px-4"
														value="Submit" id="addUser">
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

 <script src="../Assests/js/adduser.js"> </script> 

</html>