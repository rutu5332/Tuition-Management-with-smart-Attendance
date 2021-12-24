<%-- <%@page import="Database.Data"%>
 --%>
<!DOCTYPE html>
<%@page import="model.AssignmentSubmission"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Assignment"%>
<html>
<head>



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
	

	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
						
						<%
						HttpSession s = request.getSession();
						
						Assignment a = (Assignment)s.getAttribute("assign");
						s.removeAttribute("assign");
						
						%>
							<div class="row">
								<div class="col-sm-6">
									<h1 class="mb-0">
										<%=a.getAssignment_title() %>
									</h1>
								</div>
								<div class="col-sm-3"></div>
								<%SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
								String date = format.format(a.getUpload_date());
								
								 %>
								<div class="col-sm-3"><%=date %></div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h3 class="mb-0">Description :</h3>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12"><%=a.getAssignment_description() %></div>
								
							</div>
							
							

						</div>
					</div>
				</div>
				<div class="col-md-12 mb-3">
					<div class="card">
						<div class="card-body">
						<%
						if(s.getAttribute("res")!=null){
						ArrayList<AssignmentSubmission>as = (ArrayList<AssignmentSubmission>)s.getAttribute("res");
						for(AssignmentSubmission ass : as)
						{
							s.setAttribute("path", ass.getFile());	
						%>
							<div class="d-flex flex-column  ">

								<div class="mt-3">
									<h1> Submitted Responses </h1>
									<hr>
									<div class="row">
										<div class="col-sm-6">
											<h4 class="mb-0">
												<%=ass.getStudent_id() %>
											</h4>
										</div>
										<div class="col-sm-3">
											<a href="download.jsp"><h4><%=ass.getFile() %></h4></a>
										</div>
										<div class="col-sm-3">
										<% 
										String d = format.format(ass.getSub_date());
										%>
											<h4><%=d %></h4>
										</div>
									</div>
									<hr>
									<%}
						}%>

								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- jQuery Version 1.11.0 -->
	<script src="../Assests/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../Assests/js/bootstrap.min.js"></script>

</body>
</html>