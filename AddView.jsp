<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body style="background-color: powderblue;">
<h1 style="text-align: center;">ADD VIEW DEPARTMENT</h1>
	<form method="post" action="insert.jsp">
		<h2 style="text-align: center; color: blue;">Enter Department
			Name :</h2>
		<style>
.temp123 {
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
</style>
		<div class="temp123">
			<input type="text" name="department" required />
		</div>
		<h2 style="text-align: center; color: blue;">Enter Number Of
			Employees :</h2>
		<style>
.temp124 {
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
</style>
		<div class="temp124">
			<input type="number" name="employee" required />
		</div>
		<br>
		<div style="text-align: center">
			<input type="submit" value="Submit" />
		</div>
		<br>

	</form>

<form action="view.jsp" method="Post">
<style>
.temp124 {
	margin: 0 auto;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
</style>
<div style="text-align: center">
    <input type="submit"value="View">
    </div>
</form>
</body>
</html>