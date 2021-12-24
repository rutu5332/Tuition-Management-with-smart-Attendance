<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Student"%>
<%@page import="model.Attendance"%>
<%@page import="java.util.* "%>


<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Alex Grozav">

<title>Attendance</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../Assests/favicon.ico" type="image/x-icon">
<link rel="icon" href="../Assests/favicon.ico" type="image/x-icon">

<!-- Bootstrap Core CSS -->
<link href="../Assests/css/bootstrap.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../Assests/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../Assests/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../Assests/css/smartech.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- Animate CSS -->
<link href="../Assests/css/animate.css" rel="stylesheet">

</head>

<body>
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
		<%
		Calendar cal = Calendar.getInstance();
		int yr=cal.get(Calendar.YEAR);
		int m =cal.get(Calendar.MONTH)+1;
		%>
		<div id="page-wrapper">
			<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb text-xs">
							<li><a href="#">Today's Attendance</a></li>
							<li class="pull-right" > <a href="monthly.jsp?month=<%=m %>&year=<%=yr %>" 
							style="background-color:#ef4238; color:white; text-decoration:none;padding:5px;"> 
							Monthly Attendance </a> </li>
						</ol>
					</div>
				</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-right">
								<div class="btn-group">
									<button type="button" class="btn btn-default panel-collapse">
										<i class="fa fa-caret-up"></i>
									</button>
								</div>
							</div>
							<h4 class="margin-none">
								<i class="fa fa-desktop fa-fw"></i> Today's Attendance Details
							</h4>

						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table" id="dataTables-example"
									style="text-align: center;">
									<thead>
										<tr>
											<th style="text-align: center;">#</th>
											<th style="text-align: center;">Image</th>
											<th style="text-align: center;">Name</th>
											<th style="text-align: center;">class</th>
											<th style="text-align: center;">Email</th>
											<th style="text-align: center;">In Time</th>
										</tr>
									</thead>
									<tbody>
									<%
										 int i=1;
										 if(session.getAttribute("result") != null){
											HashMap<Student,Attendance> list = (HashMap<Student,Attendance>)session.getAttribute("result");
											//session.removeAttribute("result");
											for (Map.Entry<Student,Attendance> e : list.entrySet())
											{
												Student s=e.getKey();
												Attendance a =e.getValue();
												
											%>
										<tr>
											<td><%=i++ %></td>
											<td><img src="../Assests/images/<%=s.getImage() %>"  style="height:25px;width:30px;"></td>
											<td><%=s.getStudent_name() %></td>
											<td><%=s.getStudent_class() %></td>
											<td><%=s.getStudent_email() %></td>
											
											<td><%=a.getIntime() %></td>
											
										</tr>
										<% 
											}
										}
										
										
									%>
										

									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="../Assests/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../Assests/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../Assests/js/plugins/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="../Assests/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="../Assests/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- Sparkline JavaScript -->
	<script src="../Assests/js/plugins/sparkline/sparkline.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../Assests/js/smartech.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
</body>


</html>