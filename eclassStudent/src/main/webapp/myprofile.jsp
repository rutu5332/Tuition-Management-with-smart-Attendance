<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>



<title>Tuition Management</title>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="Assests/css/myprofile.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="Assests/css/updateprofile.css" rel="stylesheet">
<link href="Assests/css/changepswd.css" rel="stylesheet">
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
	
	<%Student s=(Student)request.getAttribute("stu"); %>
		<div class="container">
		<div class="main-body">
			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<br> <img src="Assests/img/<%= s.getImage()%>" alt="Student"
									class="rounded-circle" width="150">
								<div class="mt-3">
									<h4>
										<%//out.println(fnm ); %>
									</h4>
				
									<h3>
										Profile Picture
									</h3>
									
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-8">
					<div class="card mb-3">
						<div class="card-body">
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Name</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<%=s.getStudent_name() %>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Email</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<%=s.getStudent_email() %>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Class</h5>
								</div>
								<div class="col-sm-9 text-secondary"><%=s.getStudent_class() %></div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Student's Mobile</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<%=s.getStudent_phoneno() %>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Parent Name</h5>
								</div>
								<div class="col-sm-9 text-secondary"><%=s.getParent_name() %></div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Parent Email</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<%=s.getParent_email() %>
								</div>
							</div>
							<hr>

							<div class="row">
								<div class="col-sm-3">
									<h5 class="mb-0">Parent Mobile</h5>
								</div>
								<div class="col-sm-9 text-secondary">
									<%=s.getParent_phoneno() %>
								</div>
							</div>

							<hr>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>

function checkJS()
{
	var img=$('#img1').val();
	var ext=img.substr(img.indexOf('.')+1);
	if(img == ""){
		$("#img1-error").html("* Please Select Image.");
		$('#img1').css('border', '1px solid red');
		changeImg.img1.focus();
		return false;
	}
	else if(!(ext == "jpeg" || ext == "jpg" )){
		$("#img1-error").html("* Please Select jpeg/jpg Images.");
		$('#img1').css('border', '1px solid red');
		changeImg.img1.focus();
		return false;
	}
	else{
		$('#img1-error').html('');
		$('#img1').css('border-color', '');
	}
}

function checkJS_Pass()
{
	
	
		var code=$("#oldpsw").val();
		var opass=$("#old").val();
		var npsw=$("#password").val();
		var cpsw=$("#cpassword").val();
		var re = /[0-9]+/;
		var re2 = /[a-z]+/;
		var re3 = /[A-Z]+/;
		
		 if(code==''){
			$('#errorold').html('please enter old password');
			subscribe.oldpsw.focus();
			return false;
		}
		 else if(opass != code){
			 $('#errorold').html('Wrong Old Password.');
			subscribe.oldpsw.focus();
			return false;
		 }
		 else
			{
				$('#errorold').html('');
			}
		 
		 if(npsw==''){
				$('#errorpswd').html('please enter new password');
				subscribe.password.focus();
				return false;
			}
		else if((npsw.length)<8)
		{
			$('#errorpswd').html('minimum 8 characters required');
			subscribe.password.focus();
			return false;
		}
	   	else if(!re.test(npsw)) 
	  	{
	   		$('#errorpswd').html('at least one number(0-9) required');
		        subscribe.password.focus();
		        return false;
    	}
	      	
	      	
	    else if(!re2.test(npsw)) 
	  	{
	    	$('#errorpswd').html('at least one lowercase letter(a-z) required');
	    	subscribe.password.focus();
		        return false;
		 }
	      	
	    else if(!re3.test(subscribe.password.value)) 
	  	{
	    	$('#errorpswd').html('at least one uppercase letter(A-Z) required');
	    	subscribe.password.focus();
	        	return false;
    	}
		else
		{
			$('#errorpswd').html('');
		}
		 
		if(cpsw=='')
		{
			$('#errorcpsw').html('please enter confirm password');
			subscribe.cpassword.focus();
			return false;
		}
		else if(npsw!=cpsw)
		{
			$('#errorcpsw').html("password mismatch");
			subscribe.cpassword.focus();
			return false;
		}
		else
		{
			$('#errorcpsw').html('');
		}
		
		window.location.href="changepswd.jsp?oldpsw="+code+"&password="+cpsw;					
}
</script>
</body>
</html>