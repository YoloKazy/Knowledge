if(document.getElementById('btn_hola')) document.getElementById('btn_hola').onclick = function() {
	alert('Hola mundo!!!');
}

if(document.getElementById("btn_login")) document.querySelector("#btn_login").onclick=function(evnt){
	evnt.preventDefault();
	
	let validEmail=document.querySelector("input[name=email]").checkValidity();
	let validPass=document.querySelector("input[name=password]").checkValidity();
	
	if(!validEmail || !validPass) {
		document.querySelector("#showerror").innerHTML="Datos mal formados";
	}else{
		document.forms[0].submit();
	}
}