<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListTodos</title>

	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

</head>
<body>

	<div class="container">

		<h3 align="center">Todos Of <b>${name}</b></h3>
		<br/>
		<table border="1" align="center" class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>User</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.user}</td>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy" /></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-success" href="/updatetodo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/deletetodo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<div><center><a class="btn btn-secondary btn-lg active" href="/addtodo">Add Todo</a></center></div>

	
	</div>
	
</body>
</html>
<%@ include file="common/footer.jspf" %>