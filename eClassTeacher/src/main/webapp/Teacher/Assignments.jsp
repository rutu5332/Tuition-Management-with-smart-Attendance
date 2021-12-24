<%-- <%@page import="Database.Data"%>
 --%>
<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Assignment"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

<title>Assignment Details</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
        
       

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
			<a href="UploadAssignment.jsp" class="btn btn-danger text-white" >Upload New Assignment</a>
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
							if(s.getAttribute("result")!=null)
							{
								ArrayList<Assignment> list = (ArrayList<Assignment> )s.getAttribute("result");
								//s.removeAttribute("result");
								for(Assignment as : list)
								{
						%>
							<div class="row">
								<div class="col-sm-9">
									<h3 class="mb-0"><a href="../ass_detail?id=<%=as.getAssignment_id()%>"><%=as.getAssignment_title() %></a></h3>
								</div><%
								SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
								String uploaddate = format.format(as.getUpload_date());
								%>
								<div class="col-sm-3"><h5><%=uploaddate %></h5></div>
								
							</div>
							<hr>
							<%}
							} %>
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