<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Admin only!!!

	<table Class="datatable">

		<tr>
			<td>User_Id</td><td>Unit_Id</td><td>Username</td><td>Emain</td>
			<td>Password</td><td>Enabled</td><td>Created</td><td>Last Login</td>
			<td>Authority</td>
		</tr>
		
		<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.user_id}"></c:out></td><td><c:out  value="${user.unit_id}"></c:out></td>
			<td><c:out value="${user.username}"></c:out></td><td><c:out value="${user.email}"></c:out></td>
			<td><c:out value="${user.password}"></c:out></td><td><c:out value="${user.enabled}"></c:out></td>
			<td><c:out value="${user.created}"></c:out></td><td><c:out  value="${user.lastlogin}"></c:out></td>
			<td><c:out value="${user.authority}"></c:out></td>
		</tr>	
		</c:forEach>

	</table>

</body>
</html>