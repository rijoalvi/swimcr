var idUsuario = -1;
var vistaPrincipal;
$(document).ready(function () {
	$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
		  var token;
		  if (!options.crossDomain) {
		    token = csrfToken;
		    if (token) {
		      return jqXHR.setRequestHeader('X-CSRF-Token', token);
		    }
		  }
		});    
    $('.nav-tabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
	$.get("/recursos/interfaz/template.html",
			function (data) {
				$('body').append(data);
				window.vistaPrincipal = new window.Asistente.vistaPrincipal().render();
			},
			"html"
			);
});