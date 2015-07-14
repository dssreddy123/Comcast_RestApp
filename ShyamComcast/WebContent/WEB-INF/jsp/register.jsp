<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-body">
			<springform:form modelAttribute="userForm" method="post" action="add">
				<springform:label path="username">User name:</springform:label>
				<springform:input path="username" type="text" />
				<springform:label path="emailAddress">Email address:</springform:label>
				<springform:input path="emailAddress" type="email" />
				<input class="btn btn-primary" type="submit" value="Add User" />
			</springform:form>
		</div>
	</div>
</body>
</html>