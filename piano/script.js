let asociacion_key_sonido = {};

document.querySelectorAll('.tecla').forEach(function (tecla) {
    asociacion_key_sonido[tecla.getAttribute('data-key')] = tecla.getAttribute('data-nota');

    tecla.onclick = (function () {
        console.log('sonido:', this.getAttribute('data-nota'));
        let sonido = document.getElementById('sonido');
        sonido.pause();
        sonido.src = this.getAttribute('data-nota');
        sonido.play();
    });

});

document.onkeydown = function (evnt) {
    console.log(evnt.key);
    let tecla = evnt.key;
    let sonido_mp3 = asociacion_key_sonido[tecla];
    let sonido = document.getElementById('sonido');
    if (sonido_mp3) {
        sonido.pause();
        sonido.src = sonido_mp3;
        setTimeout(function () {
            sonido.play();
        },150);
        
    }
}