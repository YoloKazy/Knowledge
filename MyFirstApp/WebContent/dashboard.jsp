<%@page import="com.ricardo.modelos.Mensaje"%>
<%
	Mensaje unMensaje = (Mensaje) request.getAttribute("mensaje");
	Mensaje unMensaje2 = (Mensaje) request.getAttribute("mensaje2");
	Mensaje unMensaje3 = (Mensaje) request.getAttribute("mensaje3");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css" />
</head>
<body>
	<h1>Mensajes</h1>
	<div class="message izquierda">
		<div>
			<p><%=unMensaje.getRemitente()%></p>
			<p><%=unMensaje.getReceptor()%></p>
			<p><%=unMensaje.getTexto()%></p>
		</div>
	</div>

	<div class="message derecha">
		<div>
			<p><%=unMensaje2.getRemitente()%></p>
			<p><%=unMensaje2.getReceptor()%></p>
			<p><%=unMensaje2.getTexto()%></p>
		</div>
	</div>
	
	<%if(unMensaje3!=null){%>
	<div class="message izquierda">
		<div>
			<p><%=unMensaje3.getRemitente()%></p>
			<p><%=unMensaje3.getReceptor()%></p>
			<p><%=unMensaje3.getTexto()%></p>
		</div>
	</div>
	<%}%>

	<div>
		<form action="" method="POST">
			<input type="hidden" name="remitente" value="Yo" />
			<input type="hidden" name="receptor" value="Pedrita"/>
			<div>
				<textarea name="mensaje" id="" cols="30" rows="3"></textarea>
			</div>
			<div>
				<button>Responder</button>
			</div>
		</form>
	</div>

</body>
</html>

















