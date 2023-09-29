<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<%
	String name = (String) session.getAttribute("name");
	%>
	<%
	String name1 = (String) request.getAttribute("name");
	%>
	<h2>Login Successfully</h2>
	<h2>
		Hello
		<%
	if (name1 == null)
		out.println(name);
	else
		out.println(name1);
	%>!
	</h2>
	<form action="/HMS/Register" method="get">
		<pre>
		<input type="submit" value="User List">
	</pre>
	</form>
	<a href="logout.jsp">Logout</a>
</body>
</html>