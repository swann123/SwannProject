<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<h4 style="margin-left:13px;"><b>Forget Password Request Email</b></h4><br>
	<div class="container">

		

		<div class="row p-3 my-3">
			<div class="col-sm-12">
				
				<form action="findemail" method="post">

					<div class="form-group" >
						<h2 style="text-align:center">Forget Password</h2><hr>
					</div>

					<div class="form-group">
						<label><b>Enter Your Email</b></label>
						 <input type="email" class="form-control" name="email" required>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Find Email" />
					</div>

				</form>
			</div>
		</div>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>