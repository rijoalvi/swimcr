var idUsuario = -1;
var vistaPrincipal;
$(document).ready(function () {
    $('#boton-login').on("click", function (e) {
        var data = {
            'nombre_usuario': $('.usuario').val(),
            'contrasena': $('.contrasena').val()
        };
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/login',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json'
        }).done(function (data) {
            idUsuario = parseInt(data.id[0]);
            vistaPrincipal = new Asistente.vistaPrincipal().render();
            $('#login-container').fadeOut();
        }).fail(function () {
            alert("Error al loguearse. Por favor inténtelo de nuevo");
            $('.usuario').val("");
            $('.contrasena').val("");
        });


    });
    $('.nav-tabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
});