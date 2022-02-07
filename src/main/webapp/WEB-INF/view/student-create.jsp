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
		Country: <form:select path="country">
			<form:options items="${student.countryOptions}" />
			<!-- <form:option value="china" label="China" />
			<form:option value="uae" label="UAE" />
			<form:option value="usa" label="USA" /> -->
		</form:select>
		<br> <br>
		English: <form:radiobutton path="language" value="English"/>
		Tamil: <form:radiobutton path="language" value="Tamil"/>
		Malayalam: <form:radiobutton path="language" value="Malayalam"/>
		<br> <br>
		Windows: <form:checkbox path="operatingSystems" value="Windows"/>
		Mac: <form:checkbox path="operatingSystems" value="Mac"/>
		Linux: <form:checkbox path="operatingSystems" value="Linux"/>
		<br> <br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>