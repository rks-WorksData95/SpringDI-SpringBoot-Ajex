<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.ajaxdemo.Repository.countryRepository"%>
<%@page import="com.ajaxdemo.model.country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

	<!-- Font Awesome -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Bootstrap core CSS -->
<!-- 		<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"> -->
	<!-- Material Design Bootstrap -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.9/css/mdb.min.css" rel="stylesheet">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
  src="http://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<style type="text/css">

#btn
{
    padding: 0px;
    font-weight: 10px;
    font-size: 20px;
    height: 40px;
    width:90px;
    border-radius: 40px;
}

.requerido
{
	color: red;
}

</style>

<script type="text/javascript">

function validate()
{
	var countryValue=document.getElementById("countryId").value;
	var cityValue=document.getElementById("cityId").value;
	if(countryValue==0)
	{
		alert("Country Value : "+countryValue);
		document.getElementById("countryError").innerHTML="Please, Select Country";
		return false;
	}
	if(cityValue==0)
	{
		alert("City Value : "+cityValue);
		document.getElementById("cityError").innerHTML="Please, Select City";
		return false;
	}
	return true;
}

</script>



</head>
<body>
	
	<form name="saveData", action="/saveData", method="get">
		<div class="container">
			
			<%
				List<country> countryList=(List<country>)request.getAttribute("countryList");
			%>
						
			<div class="form-group">
				<label>Country</label>
				<select name="country" id="countryId" class="form-control" required>
					<option value="" selected disabled hidden>Select Country</option>
					<% for(country coun:countryList) 
					   {
					%>
							<option value="<%=coun.getId() %>"><%=coun.getName() %></option>
					<%
						}
					%>
				</select>
				<span id="countryError" style="color: red;"></span>
			</div>
			
			<div class="form-group">
				<label>City</label>
				<select name="city" id="cityId" class="form-control" required>
					<option value="" selected disabled hidden>Select City</option>
				</select>
				<span id="cityError" style="color: red;"></span>
			</div>

			<input type="submit" id="btn" class=".btn btn-info" value="Submit">
			
		</div>
	</form>
	
	<script type="text/javascript">
   $(document).ready(function() {
    $("#countryId").change(function() {
      var countryId = $(this).find(":selected").val();
      var json = {
       "countryId" : countryId
      };
 
      $.ajax({
       type : "POST",
       contentType : "application/json",
       url : "/getData/"+countryId,
       data : JSON.stringify(json),
       dataType : 'json',
       cache : false,
       timeout : 600000,
       success : function(data) {
    	   console.log(data);
        var html = '';
        var len = data.length;
        html += '<option value="" selected disabled hidden>Select City</option>';
        for (var i = 0; i < len; i++) {
         html += '<option value="' + data[i].id + '">'
           + data[i].name
           + '</option>';
        }
        html += '</option>';
        $('#cityId').html(html);
       },
       error : function(e) {
        alert(e);
       }
      });
    });
   });
  </script>
	
</body>
</html>