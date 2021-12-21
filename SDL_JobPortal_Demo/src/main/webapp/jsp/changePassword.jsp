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
.container{
	background-color:rgba(150, 150, 150,0.3);
	width:55%;
	border-radius:7px;
	margin:auto;
	}
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br>
	<div class="container">

		

		<div class="row p-3 my-3">
			<div class="col-sm-12">
			<h2 style="text-align:center">Update Password</h2><hr>
			
				<form action="forgetPasswordProcess" method="post">
				
					<div class="form-group">
					<input type="hidden"
							class="form-control" name="hiddenemail" value="<s:property value="user.email" />">
					</div>
					

					<div class="form-group">
						<label><b>New Password</b></label> <input type="password"
							class="form-control" name="pass" required>
					</div>

					<div class="form-group">
						<label><b>Confirm Password</b></label> <input type="password"
							class="form-control" name="con_pass" required>
					</div>
					

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Update Password" />
					</div>

				</form>
			</div>
		</div>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>