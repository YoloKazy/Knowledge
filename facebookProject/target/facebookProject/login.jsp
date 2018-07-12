<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<h1>Acceder</h1>

	<div class="error" id="showerror">${error}</div>

	<form method="POST" action="" novalidate>
		<div>
			<input type="email" name="email" placeholder="email" required/>
		</div>
		<div>
			<input type="password" name="password" placeholder="password" required minlength="3"/>
		</div>
		<button id="btn_login">Entrar</button>
	</form>
</body>
</html>