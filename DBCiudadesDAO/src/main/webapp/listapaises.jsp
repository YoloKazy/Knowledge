<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<link rel="stylesheet" href="./style.css" />
</head>
<body>
	<h2>Paises</h2>
	<ul>
		<c:forEach items="${listapaises}" var="unPais">
			<li>
				<span>${unPais.name}</span>
				<span>${unPais.code}</span>
				<div>
				<c:forEach items="${unPais.languages}" var="unIdioma">
					<span>${unIdioma.name}(${unIdioma.isOfficial}/${unIdioma.percentage}%)</span>
				</c:forEach>				
				</div>
			</li>
		</c:forEach>
	</ul>

</body>
</html>