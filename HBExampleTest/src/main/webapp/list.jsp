<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h2>Employee list</h2>
	
	<ul>
	<c:forEach items="${employees}" var="unEmp">
		<li><a href="./detalle?eid=${unEmp.id}">${unEmp.firstName}</a>
			(<c:forEach items="${unEmp.roles}" var="unRol">${unRol.name},</c:forEach>)
		</li>
	</c:forEach>
	</ul>
	
</body>
</html>