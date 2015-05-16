<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
    <meta name="Asistente de Nataci&oacute;n" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="/recursos/interfaz/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 50px;
            padding-bottom: 20px;
        }
    </style>
    <link rel="stylesheet" href="/recursos/interfaz/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/recursos/interfaz/css/main.css">

    <script src="/recursos/interfaz/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
	
	
	
	
	<div class="container">
        <hr>
        <footer>
            <p>&copy; Ricardo Alvarado &amp; Joseiby Hern&aacute;ndez 2014</p>
        </footer>
    </div>
    <div class="hidden">
        <table class="table">
            <tr id="placeholder-prueba">
                <td>
                     <select class="form-control distancia">
                         <option value="25" selected>25</option>
                         <option value="50">50</option>
                         <option value="100">100</option>
                         <option value="200">200</option>
                         <option value="300">300</option>
                         <option value="400">400</option>
                         <option value="500">500</option>
                         <option value="600">600</option>
                         <option value="700">700</option>
                         <option value="800">800</option>
                         <option value="900">900</option>
                         <option value="1000">1000</option>
                         <option value="1500">1500</option>
                     </select>
                </td>
                <td>
                    <select class="form-control estilo">
                        <option value="1" selected="">Libre</option>
                        <option value="2">Dorso</option>
                        <option value="3">Pecho</option>
                        <option value="4">Mariposa</option>
                    </select>
                </td>
                <td>
                    <input type="text" class="form-control tipoPrueba" placeholder="Tipo de prueba (Ejemplo: Calentamiento)">
                </td>
                <td>
                    <button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-prueba">×</button>
                </td>
            </tr>
        </table>
    </div>
    
    <!-- /container -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="/recursos/interfaz/js/vendor/underscore-min.js"></script>
    <script src="/recursos/interfaz/js/vendor/backbone-min.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/modelos/equipo.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/modelos/entrenamiento.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/modelos/prueba.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/modelos/tiempo.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/modelos/usuario.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/colecciones/equipos.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/colecciones/entrenamientos.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/colecciones/pruebas.js"></script>
    <script src="/recursos/interfaz/js/backbone-app/vistas/vistaPrincipal.js"></script>
    <script src="/recursos/interfaz/js/vendor/bootstrap.min.js"></script>

    <script src="/recursos/interfaz/js/main.js"></script>
</body>

</html>