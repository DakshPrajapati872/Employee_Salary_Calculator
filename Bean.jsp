<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.telusko.Student">
<jsp:setProperty name="obj" property="name" value="Daksh"/>
<jsp:setProperty name="obj" property="n" value="10"/>

<h1>Entered Name is :</h1>
<jsp:getProperty name="obj" property="name"/>
<br>
<!--  Square is :
<jsp:getProperty name="obj" property="n"/>-->
<%
int a=obj.getn();
out.println(a);
%>

</jsp:useBean>
</body>
</html>