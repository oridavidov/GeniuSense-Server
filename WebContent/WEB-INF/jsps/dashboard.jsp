<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Real Time Information</title>
</head>
<body>
	<h2>Real Time Information</h2>
	
	<table class="datatable">	
	<tr><td>Temperature</td><td>Humidity</td><td>Light</td><td>Time</td></tr>
	<c:forEach var="data" items="${dataTicks}">
		<tr>
		<td><c:out value="${data.temperature}"></c:out></td>
		<td><c:out value="${data.humidity}"></c:out></td>
		<td><c:out value="${data.light}"></c:out></td>
		<td><c:out value="${data.time}"></c:out></td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>