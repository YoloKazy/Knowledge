<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tl"%>

<!DOCTYPE html>
<html>
<head>
<title>Muro Facebook</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<tl:header page="perfil" estilo="rojo"></tl:header>
	
	<form method="POST" action="" novalidate>
		<div>
			${usuario.email}
		</div>
		<div>
			<input type="text" name="nombre" placeholder="nombre" required value="${usuario.nombre}"/>
			<div class="error">${errors.get("nombre")}</div>
		</div>
		
		<div>
			<input type="password" name="password" placeholder="password" required minlength="3"/>
			<div class="error">${errors.get("pass")}</div>
		</div>
		<div>
			<input type="password" name="repassword" placeholder="repassword" required minlength="3"/>			
		</div>
		<div>
			<input type="number" name="edad" placeholder="edad" required min="14" max="100" value="${usuario.edad}"/>
			<div class="error">${errors.get("edad")}</div>
		</div>
		<div>
			Sexo:
			<div class="error">${errors.get("sexo")}</div>
			<div><input type="radio" id="v" name="sexo" required value="1" ${usuario.sexo==1?"checked":""} /><label for="v">V</label></div>
			<div><input type="radio" id="m" name="sexo" required value="2" ${usuario.sexo==2?"checked":""} /><label for="m">M</label></div>
		</div>
		<button>Guardar</button>
	</form>
	<tl:footer></tl:footer>

</body>
</html>