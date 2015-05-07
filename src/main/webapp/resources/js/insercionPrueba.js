var data = {
	id: 27,
    id_entrenamiento: 1,
    distancia: 400,
    estilo: 2,
    consecutivo: 3,
    tipo: 'velocidad'
};

var data2 = {
	    id_entrenamiento: 1,
	    distancia: 400,
	    estilo: 2,
	    consecutivo: 6,
	    tipo: 'afloje'
	};
this.datos = {};
$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/gestion/entrenamiento/prueba',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
    alert('data'),
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/gestion/entrenamiento/prueba',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data2),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});


