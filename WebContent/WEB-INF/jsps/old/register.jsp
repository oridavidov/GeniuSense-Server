<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/jquery-1.11.2.min.js"></script>

<script type="text/javascript">
function onLoad() {
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpassword").keyup(checkPasswordsMatch);
	
	$("#validated").submit(checkPasswordsMatch);
}

function checkPasswordsMatch() {
	var password = $("#password").val();
	var confirmpassword = $("#confirmpassword").val();
	var valid = false;
	
	if (password.length > 3) {
		if (password == confirmpassword) {
			$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
			$("#matchpass").addClass("valid");
			$("#matchpass").removeClass("error");
			valid = true;
		}else {
			$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
			$("#matchpass").addClass("error");
			$("#matchpass").removeClass("valid");
			valid = false;
		}		
	}	
	return valid;
}

$(document).ready(onLoad);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
</head>
<body>
	<h2>Register New User</h2>
	
		
		
	<sf:form id="validated" method="post" action="${pageContext.request.contextPath}/usercreated" commandName="user">
	<table class="logintable">
	<!-- the name attribute needs to match the POJO members, and they
	     needs to have set methods -->
	<tr><td calss="label">Unit ID:</td><td><sf:input       path="unit_id"  name="unit_id"  type="text"     /><br/><sf:errors path="unit_id"  cssClass="error"></sf:errors></td></tr>
	<tr><td calss="label">Username:</td><td><sf:input      path="username" name="username" type="text"     /><br/><sf:errors path="username" cssClass="error"></sf:errors></td></tr>
	<tr><td calss="label">Email:</td><td><sf:input         path="email"    name="email"    type="text"     /><br/><sf:errors path="email"    cssClass="error"></sf:errors></td></tr>
	<tr><td calss="label">Password:</td><td><sf:input 	   id="password"   path="password" name="password" type="password" /><br/><sf:errors path="password" cssClass="error"></sf:errors></td></tr>	
	<tr><td calss="label">Confirm Password:</td><td><input id="confirmpassword"   type="password" name="confirmpassword"><div id="matchpass"></div></td></tr>	
	
	<tr><td> </td><td><input value="Register" type="submit"></td></tr>	
	
	</table>
	</sf:form>	
	
</body>
</html>