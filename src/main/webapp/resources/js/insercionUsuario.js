var data = {
    'nombre_usuario': 'pacojimenez',
    'contrasena': '26',
    'nombre': 'Paco',
    'apellidos': 'jimenez',
    'email': 'paco@jimenez.com',
    'tipo': 1,
    'edad': 25,
    'categoria': 3,
    'especialidad': 1
};
this.datos = {};

$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/gestion/usuario',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});