var idUsuario = -1;
var vistaPrincipal;
$(document).ready(function () {
	_.templateSettings = {
	  interpolate: /<@(.+?)@>/g
	};
	$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
		  var token;
		  if (!options.crossDomain) {
		    token = csrfToken;
		    if (token) {
		      return jqXHR.setRequestHeader('X-CSRF-Token', token);
		    }
		  }
		});
	vistaPrincipal = new Asistente.vistaPrincipal().render();
    
    $('.nav-tabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
});