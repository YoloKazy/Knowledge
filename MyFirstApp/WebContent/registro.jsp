<%@page import="com.ricardo.modelos.Usuario"%>
<%@page import="java.util.Hashtable"%>
<%
	Hashtable errors = (Hashtable)request.getAttribute("errors");
	Usuario newU = request.getAttribute("usuario")!=null?(Usuario)request.getAttribute("usuario"):null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css" />
</head>
<body>
	<h1>Regístrate</h1>

	<form method="POST" action="" novalidate>
		<div>
			<input type="text" name="nombre" placeholder="nombre" required value="<%=(newU!=null?newU.getNombre():"")%>"/>
			<div class="error"><%=(errors!=null?(errors.get("nombre")!=null?errors.get("nombre"):""):"")%></div>
		</div>
		<div>
			<input type="email" name="email" placeholder="email" required value="<%=(newU!=null?newU.getEmail():"")%>"/>
			<div class="error"><%=(errors!=null?(errors.get("email")!=null?errors.get("email"):""):"")%></div>
		</div>
		<div>
			<input type="password" name="password" placeholder="password" required minlength="3"/>
			<div class="error"><%=(errors!=null?(errors.get("pass")!=null?errors.get("pass"):""):"")%></div>
		</div>
		<div>
			<input type="password" name="repassword" placeholder="repassword" required minlength="3"/>			
		</div>
		<div>
			<input type="number" name="edad" placeholder="edad" required min="14" max="100" value="<%=(newU!=null?newU.getEdad():"")%>"/>
			<div class="error"><%=(errors!=null?(errors.get("edad")!=null?errors.get("edad"):""):"")%></div>
		</div>
		<div>
			Sexo:
			<div class="error"><%=(errors!=null?(errors.get("sexo")!=null?errors.get("sexo"):""):"")%></div>
			<div><input type="radio" id="v" name="sexo" required value="1" <%=(newU!=null?(newU.getSexo()==1?"checked":""):"")%> /><label for="v">V</label></div>
			<div><input type="radio" id="m" name="sexo" required value="2" <%=(newU!=null?(newU.getSexo()==2?"checked":""):"")%>/><label for="m">M</label></div>
		</div>
		<button>Registrar</button>
	</form>
</body>
<script src="./script.js"></script>
</html>