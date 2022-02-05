<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>ElCorp | Student</title>
</head>
<body>
	<form:form action="submit" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<br> <br>
		Last Name: <form:input path="lastName" />
		<br> <br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>