function loadAmigosFuncs(){
		$('.bborrar').click(function() {
			let parentLi = this.parentNode;
			let id = this.getAttribute('data-id');
			console.log("Id de amigo:", id,"::",parentLi);
			
			$.ajax({
				url : `./lista?id=${id}`,
				type: "POST",
				accepts: "application/json"
			}).done(function(data) {
				console.log("data:",data);
				if(data.result){
					parentLi.parentNode.removeChild(parentLi);
				}
			}).fail(function(err){
				console.log("err:",err);
			});
			
		});
		
		$('.estrella').click(function() {
			let parentDiv = this.parentNode;
			let id = this.getAttribute('data-id');
			let puntuacion = this.getAttribute('data-value');
			console.log("Id de amigo:", id,"::",puntuacion);
			
			let estrella = this;
			
			$.ajax({
				url : `./puntuacion?id=${id}&puntuacion=${puntuacion}`,
				type: "POST",
				accepts: "application/json"
			}).done(function(data) {
				console.log("data:",data);
				if(data.result){
					parentDiv.querySelectorAll('.estrella').forEach(function(item){
						item.classList.remove("punto");
					});
					estrella.classList.add("punto");
				}
			}).fail(function(err){
				console.log("err:",err);
			});
			
		});
}

loadAmigosFuncs();

$('#newUserForm').submit(function(e){
	e.preventDefault();
	console.log("enviando:",$('#newUserForm').serialize());
	
	$.ajax({
		url : `./add-user`,
		data: $('#newUserForm').serialize(),
		type: "POST",
		accepts: "application/json"
	}).done(function(data) {
		console.log("data:",data);
		let miamigo=data.amigo;
		if(miamigo){
			$('#listaAmigos').append(`
			<li>
				<span>${miamigo.name}</span>
				<button class="bborrar" data-id="1">Borrar</button>
				<div class="lista-estrellas">
					<span class="estrella" data-id="${miamigo.id}" data-value="5"></span>
					<span class="estrella" data-id="${miamigo.id}" data-value="4"></span>
					<span class="estrella" data-id="${miamigo.id}" data-value="3"></span>
					<span class="estrella" data-id="${miamigo.id}" data-value="2"></span>
					<span class="estrella" data-id="${miamigo.id}" data-value="1"></span>
				</div>
				
			</li>
			`);
			loadAmigosFuncs();
		}
	}).fail(function(err){
		console.log("err:",err);
	});
});










