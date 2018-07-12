<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./styles.css">
</head>
<body>
	<header></header>
	<h1>Lista de Amigos</h1>
	<section>
		<ul>
			<c:forEach var="unAmigo" items="${listaAmigos}">
				<li><span>${unAmigo.nombre}</span>
					<button class="bborrar" data-id="${unAmigo.idAmigo}">Borrar</button>
					<div class="lista_estrella">
							<span class='fa fa-star estrella ${unAmigo.puntuacion==5?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="5" ></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==4?"punto":"" }'  data-id="${unAmigo.idAmigo}" data-valor="4" ></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==3?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="3" ></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==2?"punto":"" }' data-id="${unAmigo.idAmigo}" data-valor="2"></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==1?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="1"></span>
							
							
					</div>
					</li>
			</c:forEach>
		</ul>
	</section>
	<h1>Añadir Amigo</h1>
	<form id="formulario">
		<label>Nombre:  </label> <input name="nombreAmigo" id="nombreAmigo"  type="text"></input>
		<button class="bAnadir">Añadir Amigo</button>
	</form>	

	<footer></footer>
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="./script/amigo.js"></script>
</html>