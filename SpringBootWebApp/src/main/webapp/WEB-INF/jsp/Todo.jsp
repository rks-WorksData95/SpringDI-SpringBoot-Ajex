<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo</title>

</head>
<body>

	<div class="container">
		
		<h3 align="center">Add Todo For <b>${name}</b></h3>
		
		<form:form method="post" modelAttribute="Todo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input type="text" path="desc" name="desc" placeholder="Enter Todo Description" class="form-control" required="required" />
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>	
			
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" name="targetDate" placeholder="Select Target Date" class="form-control" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>	
			
			<input type="submit" class="btn btn-success" name="Add Todo" value="Add Todo" />	
			
		</form:form>	
		
	</div>
	
</body>
</html>
<%@ include file="common/footer.jspf" %>
<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>
