<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>ElCorp | Student</title>
</head>
<body>
	<h3>${title}</h3>
	<p>${message} <a href="">Back Home</a></p>
	<p>Country: ${student.country}</p>
	<p>Language: ${student.language}</p>
	<p>Operating Systems</p>
	<ul>
		<c:forEach var="os" items="${student.operatingSystems}">
			<li>${os}</li>
		</c:forEach>
	</ul>
</body>
</html>