<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de amigos</h1>
	<ul>
		<c:forEach items="amigos" val="unAmigo">
			<li>
				<span>${unAmigo}</span>
				<button>Borrar</button>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>