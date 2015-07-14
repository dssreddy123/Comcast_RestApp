<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<style type="text/css">
#bodyWrapper {
	width: 1080px;
	margin: 0 auto;
}

table {
	width: 100%;
}

td {
	padding: 10px;
	vertical-align: top;
}

.panel-heading {
	padding: 5px 8px;
}

.panel-heading h3 {
	margin: 5px;
}
</style>
</head>
<body>
	<div id="bodyWrapper">
		<br>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Add user:</h3>
			</div>
			<div class="panel-body">
				<jsp:include page="/comcast/register"></jsp:include>
			</div>
		</div>

		<table>
			<tr>
				<td>
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">Go!</button>
							</span>
						</div>
						<!-- /input-group -->
					</div> <!-- /.col-lg-6 -->
					<div style="clear: both;"></div>
					<div class="panel panel-default">

						<div class="panel-body">
							<h1>
								${model.user.username } <small>${model.user.emailAddress }</small>
							</h1>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
								value="${model.user.dateRegistered}" />
						</div>
					</div>
				</td>
				<td>
					<ul class="list-group">
						<c:forEach items="${model.users}" var="entry" varStatus="status">
							<li class="list-group-item">${entry.value.username }</li>
							<li class="list-group-item">${entry.value.emailAddress }</li>

						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>