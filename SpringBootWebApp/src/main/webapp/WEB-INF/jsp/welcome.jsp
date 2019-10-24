<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

</head>
<body>

	<div class="container">

		<h2 align="center">Welcome : ${name}</h2>
	<!-- <h2 align="center">Password : ${password}</h2> -->
	
		<br/>
	
		<center>
		<a href="/listtodos" class="btn btn-secondary btn-lg active" role="button">Manage Todos</a>
		</center>
		
	</div>
	
</body>
</html>
<%@ include file="common/footer.jspf" %>