<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Student"%>
<%@page import="java.util.* "%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Alex Grozav">

<title>Student Details</title>

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
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-right">
								<div class="btn-group">
								  <button type="button" class="btn btn-default panel-collapse" onclick="location.href ='AddStudent.jsp'" >
										<i class="fa fa-plus-square"></i> Add Student
									</button>
								 </div>
								<div class="btn-group">
									<button type="button" class="btn btn-default panel-collapse">
										<i class="fa fa-caret-up"></i>
									</button>
								</div>
							</div>
							<h4 class="margin-none">
								<i class="fa fa-user fa-fw"></i> Student Details
							</h4>

						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table" id="dataTables-example" style="text-align:center;">
									<thead>
										<tr>
											<th style="text-align:center;">#</th>
											<th style="text-align:center;">Image</th>
											<th style="text-align:center;">Name</th>
											<th style="text-align:center;">Class</th>
											<th style="text-align:center;">Email</th>
											<th style="text-align:center;">Mobile</th>
											<th style="text-align:center;">DOB</th>
											<th style="text-align:center;">Parent Name</th>
											<th style="text-align:center;">Parent Email</th>
											<th style="text-align:center;">Parent Mobile</th>
											
										</tr>
									</thead>
									<tbody>
									<%
										 int i=1;
										 if(session.getAttribute("result") != null){
											ArrayList<Student> list = (ArrayList<Student>)session.getAttribute("result");
											//session.removeAttribute("result");
											for (Student a : list){
												SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
												String date = format.format(a.getDob());
											%>
										<tr>
											<td><%=i++ %></td>
											<td><img src="../Assests/images/<%=a.getImage() %>"  style="height:25px;width:30px;"></td>
											<td><%=a.getStudent_name() %></td>
											<td><%=a.getStudent_class() %></td>
											<td><%=a.getStudent_email() %></td>
											<td><%=a.getStudent_phoneno() %></td>
											<td><%=date %></td>
											<td><%=a.getParent_name() %></td>
											<td><%=a.getParent_email() %></td>
											<td><%=a.getParent_phoneno() %></td>
											
										</tr>
										<% 
											}
										}
										
										
									%>

									</tbody>
								</table>
							</x>
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