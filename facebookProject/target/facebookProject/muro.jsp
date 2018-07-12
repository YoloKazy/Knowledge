<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>

<!DOCTYPE html>
<html>
<head>
<title>Muro Facebook</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<tl:header page="muro" estilo="rojo"></tl:header>

	<section>
		<c:forEach var="unArt" items="${articulos}" varStatus="counter">

			<div class="articulo">
				<div class="texto">${unArt.texto}</div>
				<div class="autor">${unArt.usuario}</div>
				<div>
					<form action="" method="POSt">
						<div>
							<input type="hidden" name="article" value="${unArt.ida}" />
						</div>
						<div>
							<input type="text" name="autor" value=""
								placeholder="Indica tu nombre" />
						</div>
						<div>
							<textarea name="comentario" placeholder="Tu comentario"></textarea>
						</div>
						<div>
							<button>Comentar</button>
						</div>
					</form>
				</div>
				<div class="comentarios">
					<c:forEach var="unCom" items="${unArt.comentarios}"
						varStatus="counterb">
						<div class="comentario">
							<div>${unCom.comentario}</div>
							<div>${unCom.autor}</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>

	</section>

	<tl:footer></tl:footer>

</body>
</html>