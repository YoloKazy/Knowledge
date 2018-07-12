<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>

<!DOCTYPE html>
<html>
<head>
<title>Muro Facebook</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>

	<tl:header page="nuevo" estilo="activo"></tl:header>
	
	<section>
		<div>Bienvenido: ${email}</div>
		<h1>Nuevo artículo</h1>
		<form action="" method="POSt">
			<div class="error">${error}</div>
			<div>
				<textarea name="texto" id="" cols="30" rows="10"
					placeholder="Indica el texto del artículo"></textarea>
			</div>
			<div>
				<button>Guardar</button>
			</div>

		</form>

	</section>
	
	<tl:footer></tl:footer>	

</body>
</html>