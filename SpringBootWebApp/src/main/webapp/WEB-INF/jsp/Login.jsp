<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
	
	<div class="container">
	
		<form action="login" method="post">
			
			<h3 align="center">Login</h3>
			
			<fieldset class="form-group">
				<label>Username</label>
				<input type="text" name="name" placeholder="Enter Username" class="form-control" required="required" />
			</fieldset>	
			
			<fieldset class="form-group">
				<label>Password</label>
				<input type="password" name="password" placeholder="Enter password" class="form-control" required="required" />
			</fieldset>	
				
			<input type="submit" class="btn btn-success" name="LogIn" value="LogIn" />
		
		</form>
		
	</div>
	
</body>
</html>
<%@ include file="common/footer.jspf" %>