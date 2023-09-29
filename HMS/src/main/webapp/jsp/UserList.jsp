<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.HMS.Beans.user"%>
<%
ArrayList<user> ul = (ArrayList<user>) request.getAttribute("UserData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<a href="jsp/Welcome.jsp">back</a>
	<h1>User List</h1>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Password</td>
		</tr>
		<%
		for (user u : ul) {
		%>
		<tr>
			<td><%=u.getName()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getPassword()%></td>
			<td>
				<a href="jsp/UserList.jsp?id=u.getName() />">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>