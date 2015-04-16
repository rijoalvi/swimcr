var data = {
    'id_usuario': 1
};

this.datos = {};

$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/consulta/equipos',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});