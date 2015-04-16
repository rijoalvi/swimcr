var data = {
    'id_equipo': 1
};

this.datos = {};

$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/consulta/entrenamiento',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});