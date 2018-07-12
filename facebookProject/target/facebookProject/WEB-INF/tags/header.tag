<%@ attribute name="page" required="true" type="java.lang.String" %>
<%@ attribute name="estilo" required="true" type="java.lang.String" %>

<header>
	<div>
		<img src="./imgs/logo.jpg" alt="" />
	</div>
	<nav>
		<ul>
			<li><a href="./" class="${page=="home"?estilo:""}">Home</a></li>
			<li><a href="./muro" class="${page=="muro"?estilo:""}">Muro</a></li>
			<li><a href="./nuevo" class='${page=="nuevo"?estilo:""}'>Nuevo</a></li>
			<li><a href="./perfil" class='${page=="perfil"?estilo:""}'>${email}</a></li>
			<li><a href="./logout">Salir</a></li>
		</ul>
	</nav>

</header>