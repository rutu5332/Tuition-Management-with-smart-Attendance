	
<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">
	<div class="navbar-header">

		<a class="navbar-brand" href="index.jsp"><img src="Assests/img/logo.png" alt="logo" />
			Tuition Management</a>
	</div>
	<!-- /.navbar-header -->
	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a href="index.jsp"> <i
				class="fa fa-home fa-fw"></i> <b>Home</b>
		</a></li>
		
		<li class="dropdown"><a data-toggle="dropdown" href="#"> Task <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="AssignmentController?action=viewAssignment">Assignments</a>
				<li class="divider"></li>
				<li><a href="QuizController?action=viewQuiz">
						Quiz</a></li>
			</ul></li>
		<li><a href="StudyMaterialController?action=viewMaterials"> 
		Study Material

		</a>
			</li>

		<!-- /.dropdown -->
		<li class="dropdown"><a data-toggle="dropdown" href="#"> Profile <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="StudentController"><i class="fa fa-user fa-fw"></i>
						My Profile</a></li>

				<li class="divider"></li>
				<li><a href="logout.jsp" class="dropdown-button"><i
						class="fa fa-sign-out fa-fw"></i> Logout</a></li>
			</ul></li>

		<li class="dropdown"><a href="contactus.jsp"> <i
				class="fa fa-phone fa-fw"></i> contact us
		</a></li>

	</ul>
</nav>
