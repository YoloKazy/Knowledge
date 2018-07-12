<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h2>Editar ciudad: ${city.name}</h2>
	<section>
		<form action="" method="post">
			<div><input type="hidden" name="cid" value="${city.id}"/></div>
			<div><input type="text" name="nombre" placeholder="Nombre" value="${city.name}"/></div>
			<div><input type="text" name="countrycode" placeholder="Código de país" value="${city.countryCode}"/></div>
			<div><input type="text" name="district" placeholder="Distrito" value="${city.district}"/></div>
			<div><input type="number" name="population" placeholder="Población" value="${city.population}"/></div>
			<div></div>
			<button>Guardar</button>
		</form>
	</section>
</body>
</html>