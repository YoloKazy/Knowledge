function loadAmigosFuncis(){
$('.bborrar').click(function(){
	let parent=this.parentNode;
	let id=this.getAttribute('data-id');
	console.log('Hola',id);
	$.ajax({
		  url: `./lista?id=${id}`,
		  type:"POST",
		  accepts:"application/json"
		}).done(function(data) {
			console.log(data);
			if(data.result){
				parent.remove();
			}
		 
		}).fail(function(error){
			console.log("error",error);
		});
});

$('.estrella').click(function(){
	let parentDiv=this.parentNode;
	let idValor=this.getAttribute('data-valor');
	let id=this.getAttribute('data-id');
	console.log("Id Amigo:: "+id+ " :: Id valoracion :: " +idValor +"  parent :: ",parent );
	let estrella=this
	$.ajax({
		  url: `./puntuacion?id=${id}&idValor=${idValor}`,
		  type:"POST",
		  accepts:"application/json"
		}).done(function(data) {
			if(data.result){
				parentDiv.querySelectorAll('.estrella').forEach(function(item){
					item.classList.remove("punto");
				});
				estrella.classList.add("punto");
			}
			

		 
		}).fail(function(error){
			console.log("error",error);
		});
});

}


loadAmigosFuncis();

$('.bAnadir').click(function(e){
	e.preventDefault();
	let frmAnadir=$('#formulario').serialize();
	console.log('El formulario  :  ',frmAnadir);
	$.ajax({
		  url: `./anadir`,
		  type:"POST",
		  accepts:"application/json",
		  data:frmAnadir
		}).done(function(unAmigo) {
			console.log(unAmigo);
			if(unAmigo){
				$("ul").append(`<li>
				<span>${unAmigo.nombre}</span>
					<button class="bborrar" data-id="${unAmigo.idAmigo}">Borrar</button>
					<div class="lista_estrella">
					
							<span class='fa fa-star estrella ${unAmigo.puntuacion==5?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="5" ></span>
							<span class=' fa fa-star estrella ${unAmigo.puntuacion==4?"punto":"" }'  data-id="${unAmigo.idAmigo}" data-valor="4" ></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==3?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="3" ></span>
							<span class='fa fa-star estrella ${unAmigo.puntuacion==2?"punto":"" }' data-id="${unAmigo.idAmigo}" data-valor="2"></span>
							<span class=' fa fa-star estrella ${unAmigo.puntuacion==1?"punto":"" } '  data-id="${unAmigo.idAmigo}" data-valor="1"></span>
					</div>
				
				</li>`);	
				loadAmigosFuncis();
			}
		 
		}).fail(function(error){
			console.log("error",error);
		});
});


