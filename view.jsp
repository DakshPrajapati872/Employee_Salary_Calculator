<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
   table, th, td { border: 4px solid black; }
</style>
</head>
<body  style='background-color:powderblue;'>
<h1>Department Table</h1>
<table>
 <thread>
<tr>
<th>Department Name </th>
<th>Number_of_Employees </th>
 </tr>
</thread>			        
<%
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","MySQL123@#");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from department");
	
	while(rs.next()) {
		
		
		
		
	
		out.print("<tbody>");
        out.print("<tr>");
        out.print("<td>"+rs.getString(1)+"</td>");
        out.print("<td>"+rs.getInt(2)+"</td>"); 
        out.print("</tr>");
        out.print("</tbody>");
		
	
	}
			
	
	con.close();
}

catch(Exception e){
	System.out.println(e);
	
}

%>
</table>
</body>
</html>