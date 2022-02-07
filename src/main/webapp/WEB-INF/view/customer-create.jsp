<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>ElCorp | Customer</title>
<style>
	.error { color:red }
</style>
</head>
<body>
	<form:form action="submit" modelAttribute="customer">
		First Name: <form:input path="firstName" />
		<br> <br>
		Last Name *: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br> <br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>