<%-- <%@page import="Database.Data"%>
 --%>
<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Quiz"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

<title>Quizes </title>
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
	
	
	<div class="form-group" style="margin-left: 77%;">
		<div class="col-sm-12">
			<a href="UploadQuiz.jsp" class="btn btn-danger text-white" >Upload New Quiz</a>
		</div>
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
						if(s.getAttribute("quizlist")!=null)
						{
							ArrayList<Quiz> list = (ArrayList<Quiz>)s.getAttribute("quizlist");
							//s.removeAttribute("quizlist");
							for(Quiz q:list){
						
							
							%>
							<div class="row">
								<div class="col-sm-4">
									<h5 class="mb-0"><a href="Quiz_Details.jsp"><%=q.getQuiz_title() %></a></h5>
								</div>
								<div class="col-sm-4"><h5>
								<%
								SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
								String utime = format.format(q.getUpload_date());
								%>
								
								<%=utime %></h5></div>
								<div class="col-sm-4"><a href="<%=q.getQuiz_file()%>">Link</a></div>
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