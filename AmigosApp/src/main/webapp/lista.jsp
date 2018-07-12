<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<h1>Lista de amigos</h1>
	<ul id="listaAmigos">
		<c:forEach items="${amigos}" var="unAmigo">
			<li>
				<span>${unAmigo.name}</span>
				<button class="bborrar" data-id="${unAmigo.id}">Borrar</button>
				<div class="lista-estrellas">
					<span class='estrella ${unAmigo.puntuacion==5?"punto":""}' data-id="${unAmigo.id}" data-value="5"></span>
					<span class='estrella ${unAmigo.puntuacion==4?"punto":""}' data-id="${unAmigo.id}" data-value="4"></span>
					<span class='estrella ${unAmigo.puntuacion==3?"punto":""}' data-id="${unAmigo.id}" data-value="3"></span>
					<span class='estrella ${unAmigo.puntuacion==2?"punto":""}' data-id="${unAmigo.id}" data-value="2"></span>
					<span class='estrella ${unAmigo.puntuacion==1?"punto":""}' data-id="${unAmigo.id}" data-value="1"></span>
				</div>
				
			</li>
		</c:forEach>
	</ul>
	
	<form action="" method="POST" id="newUserForm">
		<div>
			<input type="text" name="nombre" />
			<div><button>Enviar</button></div>
		</div>
	</form>
	
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./script/script.js"></script>
</html>