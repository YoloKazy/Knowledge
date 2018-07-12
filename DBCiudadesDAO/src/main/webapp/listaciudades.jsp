<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<link rel="stylesheet" href="./style.css" />
</head>
<body>
	<h2>Ciudades</h2>

	<form action="" method="GET">
		<div>
			<select name="country" id="">
				<option value="" disabled="true" selected="true" >Selecciona país</option>
				<c:forEach items="${listapaises}" var="unCountry">
					<option value="${unCountry.code}" ${countryCode.equals(unCountry.code)?"selected":""}>${unCountry.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<button>Filtrar</button>
		</div>

	</form>

	<ul>
		<c:forEach items="${listaciudades}" var="unaCity">
			<li>
				<a href="./editar?city=${unaCity.id}">
				<span>(${unaCity.id})</span>
				<span>${unaCity.name}</span>
				<span>${unaCity.district}</span>
				<span>${unaCity.population}</span>
				<span>${unaCity.country.name}| ${unaCity.country.code}</span>
				</a>
				<a href="./borrarciudad?cid=${unaCity.id}&code=${countryCode}">[X]</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>