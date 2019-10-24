<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<%@ include file="common/header.jspf"%>
	<%@ include file="common/navigation.jspf"%>
		
		<div class="container">
			
			<div class="alert alert-danger alert-dismissible" role="alert">
				
			    Application has encountered an error. Please contact support on ...
			    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			</div>
			
		</div>
	<%@ include file="common/footer.jspf"%>
</body>
</html>