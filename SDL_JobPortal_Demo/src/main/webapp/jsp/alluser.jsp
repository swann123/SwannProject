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
			<div class="col-sm-12">
				<h3> <b>Manage User</b></h3><br>
				
				
			<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Sr.No.</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Password</th>
						<th>Email</th>
						<th>Education</th>
						<th>Action</th>
					</tr>
				</thead>
				<s:iterator value="beanList">
					<tr>
						<td><s:property value="srNo" /></td>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="pass" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="education" /></td>
						<td>
							<a href="deleteUser.action?email=<s:property value="email"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>
					</tr>
					
				</s:iterator>
				
			</table>
		
			
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found related with User.</div>
		</s:else>
		
		
			</div>
		</div>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>