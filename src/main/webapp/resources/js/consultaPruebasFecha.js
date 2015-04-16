var data = {
    'id_equipo': 1,
    'fecha': '2014-06-24'
};

this.datos = {};

$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/consulta/entrenamiento/fecha',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});