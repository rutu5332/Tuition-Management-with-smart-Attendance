
<!DOCTYPE html>
<%@page import="model.StudyMaterial"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

<title>Video Lecture</title>
<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../Assests/css/plugins/social-buttons.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../Assests/css/smartech.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="../Assests/css/bootstrap.css" rel="stylesheet">

</head>

<body style="font-family: Helvetica Neue, Helvetica, Arial, sans-serif;">

	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<br>
	
	<div class="form-group" style="margin-left: 75%;">
		<div class="col-sm-12">
			<a href="UploadLecture.jsp" class="btn btn-danger text-white" >Upload New Lecture</a>
		</div>
	</div>
	<br><br>
	<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
						<%
						HttpSession s = request.getSession();
						if( s.getAttribute("lec")!=null)
						{
						ArrayList<StudyMaterial> list =(ArrayList<StudyMaterial>) s.getAttribute("lec");
						
						for(StudyMaterial sm: list){
							System.out.println(sm.getMaterial_file()+sm.getMaterial_title());
						%>
							<div class="row">
								<div class="col-sm-9">
									<h3 class="mb-0"><%=sm.getMaterial_title() %></h3>
								</div>
								
								<div class="col-sm-3"><h4><a target="_blank" 
								href="<%=sm.getMaterial_file()%>">
								link</a></h4></div>
							</div>	
							<hr>
							<%}} %>
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