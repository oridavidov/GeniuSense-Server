<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/scripts/jquery-1.11.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To SmartSence</title>


<script type="text/javascript">
	function showJSONTickData(data) {
		$("#numberofdata").text(data.size);	
		$("#tickdata").html("");
		for (var i=0; i<data.dataticks.length; i++) {
			var datatick = data.dataticks[i];
			$("#tickdata").append(datatick.temperature);
		}
	}

	function onLoad() {
		updateData();
		window.setInterval(updateData, 10000);
	}
	
	function updateData() {
		$.getJSON("<c:url value="/getdata"/>", showJSONTickData);
	}
	
	$(document).ready(onLoad);
</script>

</head>
<body>
	<h2>Welcom To Smart Sence</h2>
	
	number of data: <span id="numberofdata">0</span>
	
	<div id=tickdata>
		
	</div>

	<sec:authorize access="!isAuthenticated()">
		<p>
			<a href="${pageContext.request.contextPath}/dashboard"> Go To My
				Acount</a>
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/register"> Register
				New User</a>
		</p>
	</sec:authorize>



	<sec:authorize access="isAuthenticated()">
		<p>
			<a href="<c:url value='/j_spring_security_logout' />">Log Out</a>
		</p>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>
			<a href="<c:url value='/admin' />">Admin page</a>
		</p>
	</sec:authorize>




</body>
</html>