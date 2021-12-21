<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="s" uri="/struts-tags"%>

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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		

		<div class="row p-3 my-3">
			<div class="col-sm-6">
				<h3> <b>Search Results</b></h3><br>
				
				<s:iterator value="userbeanList">
				
				<div class="media">
				
				  <img src="profile.png" style="width:10%;" class="mr-3" alt="...">
				  <div class="media-body">
				    <h5 class="mt-0">
				    
				    <a href="viewProfile?userid=<s:property value='id'/>">
				    	<s:property value="firstName" /></a>
				    	
				    </h5>
				    
				   <s:property value="email" />
				  </div>
				</div>
				<hr>
				</s:iterator>
				
				
			</div>
		</div>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>