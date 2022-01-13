<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.*" %>
    <%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! 

public String insertTable(String dept,int n) {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","MySQL123@#");
		String s="insert into department(Department_Name,Number_of_employess) values(?,?)";
		PreparedStatement stmt=con.prepareStatement(s);
		
		
		stmt.setString(1,dept);
		stmt.setInt(2, n);
		
		
	int r=stmt.executeUpdate();
		
		
		if(r>0) {
			return ("Department Added Successfully");
			
		}
				
		
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
		
	}
	
	return ("Department Not Added ");
	
}



%>
<%! 

public String deleteTable(String dept,int n) {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","MySQL123@#");
		String s="delete from department where Department_Name=?";
		
		PreparedStatement stmt=con.prepareStatement(s);
		
		
		stmt.setString(1, dept);
		
		stmt.executeUpdate();
		
		
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	
	return ("Department Not Deleted");
	
}



%>
<%= new java.util.Date() %>
<%String dept=request.getParameter("department");
dept=dept.trim();
dept=dept.toUpperCase();
int n=Integer.parseInt(request.getParameter("employee"));

out.println(deleteTable(dept,n));
out.println(insertTable(dept,n));

//response.sendRedirect("AddView.jsp");


%>
</body>
</html>