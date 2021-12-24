<html>
<head>

	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
        
       

        <!-- Favicon -->
        <link rel="shortcut icon" href="../Assests/favicon.ico" type="image/x-icon">
        <link rel="icon" href="../Assests/favicon.ico" type="image/x-icon">
        
        <!-- Bootstrap Core CSS -->
        <link href="../Assests/css/bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../Assests/css/smartech.css" rel="stylesheet">
		<link href="../Assests/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <title>Tuition Management</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%-- 
<%
		if(session.getAttribute("userEmail") == null)
			response.sendRedirect("../login.jsp");
		else{
			int t=Integer.parseInt(session.getAttribute("userType").toString());
			if(t != 3)
				response.sendRedirect("../login.jsp");
		}
%>
 --%>	
	<br><br>
	<label style="font-size:30px;margin-left:30%;">Make Announcement</label><br>
	<label style="font-size:15px;margin-left:30%;color:red;">*write your announcements in given area..</label>
	<div >
	<form action="../announce" method="post">
	<textarea name="announcement" rows="10" style="border:2px solid black; width : 40%; margin-left:30%; margin-top:4%;text-align:center;margin-bottom:20px;" placeholder="Do announcements here..">
	
	</textarea>

			<div class="form-group" style="margin-left: 29%;">
				<div class="col-sm-12">
					<button class="btn btn-dark text-white">Upload</button>
				</div>
			</div>

		</form>
	</div>
	
        <script src="../Assests/js/jquery-1.11.0.js"></script>
        <script src="../Assests/js/bootstrap.min.js"></script>
</body>
</html>