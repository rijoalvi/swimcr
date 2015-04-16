var data = {
    'id_entrenamiento': 1,
    'distancia': 200,
    'estilo': 2,
    'consecutivo': 6,
    'tipo': 'calentamiento'
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
});


