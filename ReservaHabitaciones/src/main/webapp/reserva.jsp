<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Reservar</title>
</head>
<body>
	<h2>Reservar</h2>
	<form action="" method="POST">
		<p>Reserva la habitaci&oacute;n: ${habitacion.direccion} [${habitacion.precioDia}EUR/dia]</p>
		<!-- input type="hidden" name="ppd" value="${habitacion.precioDia}" / -->				
		<div><input type="number" min="1" name="dias" placeholder="Num dias" /></div>		
		<div><button>Reservar</button></div>
	</form>
</body>
</html>