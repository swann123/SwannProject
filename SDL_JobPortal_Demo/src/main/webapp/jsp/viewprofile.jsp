<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>SDL_JobPortal_Demo</title>

<style type="text/css">
.card{
	background-color:rgba(150, 150, 150,0.3);
	width:55%;
	border-radius:7px;
	margin:auto;
	}
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		

		<div class="row p-3 my-3">
			<div class="col-sm-12">
			
				<h2 style="margin-left:13px;"><b>Profile</b></h2><br>
				<div class="card">
					
					
					<div class="card-body">
						<h2 class="card-title">
							<s:property value="user.firstName" /> 
							<s:property value="user.lastName" />'s Profile
						</h2>
						
						<img src="profile.png" class="card-img-top" alt="...">
						
						<p class="card-text" style="font-size:20px;"><label> <b>First Name :</b> </label> <s:property value="user.firstName" /></p>
						<p class="card-text" style="font-size:20px;"><label><b> Last Name : </b></label><s:property value="user.lastName" /></p>
						<p class="card-text" style="font-size:20px;"><label><b> Password :</b> </label><s:property value="user.password" /></p>
						<p class="card-text" style="font-size:20px;"><label> <b>Email : </b></label><s:property value="user.email" /></p>
						<p class="card-text" style="font-size:20px;"><label> <b>Job Experience :</b> </label><s:property value="user.jobexperience" /></p>
						<p class="card-text" style="font-size:20px;"><label><b> Education :</b> </label><s:property value="user.education" /></p>

						
					</div>
				</div>





			</div>
		</div>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>