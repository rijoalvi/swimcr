<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="/recursos/interfaz/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.1/fullcalendar.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.14.30/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="/recursos/interfaz/css/main.css">

    <script src="/recursos/interfaz/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Asistente de Nataci&oacute;n</a>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<a class="navbar-center" href="#">${pageContext.request.userPrincipal.name}</a>
				</c:if>
			</div>
			<div class="navbar-collapse collapse">
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
                <form class="navbar-form navbar-right" action="${logoutUrl}" method="post" role="form">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                	<button type="submit" class="btn btn-success">Cerrar Sesi&oacute;n</button>
                </form>
            </div>
		</div>
	</div>
	<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron" id="contenedor-aplicacion">
        <div class="container">
            <ul class="nav nav-tabs" role="tablist" id="tabs-container">
                <!--Contenido del template de equipos-->
                <c:forEach var="equipo" items="${equipos}" varStatus="contadorEquipos" >
	                <c:if test="${contadorEquipos.index == 0}">
	                	<c:set var="equipoActivo" value="active"/>
	                </c:if>
	                <c:if test="${contadorEquipos.index > 0}">
	                	<c:set var="equipoActivo" value=""/>
	                </c:if>
	                <li class="${equipoActivo}">
	                	<a href="#tab-${equipo.id}" role="tab" data-toggle="tab" data-id-equipo = "${equipo.id}">${equipo.nombre}</a>
	            	</li>
	            </c:forEach>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content" id="tabs-content-container">
                <!--Contenido del template de entrenamientos-->
                <c:forEach items="${entrenamientos}" var="arregloEntrenamientos" varStatus="contadorEntrenamientos">
                	<c:if test="${contadorEntrenamientos.index == 0}">
                		<c:set var="entrenamientoActivo" value="active"/>
                	</c:if>
	                <c:if test="${contadorEntrenamientos.index > 0}">
	                	<c:set var="entrenamientoActivo" value=""/>
                	</c:if>
                	<div class = "tab-pane ${entrenamientoActivo} " id="tab-${arregloEntrenamientos[0].id_equipo}">
			            <div class = "entrenamientos">
			            	<div class="calendar"></div>
<!--  		                <table class="table">
			                    <tr>
			                        <th>
			                            Entrenamientos <button style="color:#078C19; opacity: 2;" type="button" class="close boton-agregar-entrenamiento">+</button>
			                        </th>
			                    </tr>
			                    <c:forEach items="${arregloEntrenamientos}" var="entrenamiento">
			                    <tr>
			                        <td class="fechaEntrenamiento" data-id-entrenamiento="${entrenamiento.id}">
			                            <a href="#">${entrenamiento.fecha}</a>
			                            <button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-entrenamiento">&times;</button>
			                        </td>
			                    </tr>
			                    </c:forEach>
			                </table>
-->			                
			            </div>
			            <div class = "pruebas">
			                <!--Contenido del template de pruebas-->
			            </div>
			        </div>
                </c:forEach>
            </div>


            <p><a class="btn btn-primary btn-lg hidden" id="boton-volver-entrenamientos" role="button">&laquo; Volver a la lista de entrenamientos</a>
            </p>
        </div>
        <div class="modal-calendario" id="modal-agregar-entrenamiento">
        	<div class="relative-container">
	        	<div class="modal-background"></div>
		       	<form  class="form-guardar-entrenamiento  modal-content" role="form">
		       		<h2>Nuevo Entrenamiento</h2>
		       		<div class="form-group">
		       			<label for="datetime-field">Fecha y hora:</label>
						<div class='input-group date datetimepicker'>
							<input type='text' class="datetime form-control" id="datetime-field" name="datetime-field"/>
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					<div class="form-group">
						<p class="error">Ocurri&oacute; un error al guardar el entrenamiento.</p>
						<button type="submit" class="btn btn-default">Guardar</button>
					</div>
				</form>
			</div>
        </div>
    </div>

	
	<div class="container">
        <hr>
        <footer>
            <p>&copy; Ricardo Alvarado 2015</p>
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
    <script type='text/javascript'>
    	var csrfToken = '${_csrf.token}';
    </script>
    
    <!-- /container -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="/recursos/interfaz/js/foreachPolyfill.js"></script>
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
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment-with-locales.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.1/fullcalendar.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.14.30/js/bootstrap-datetimepicker.min.js"></script>
    <script src='recursos/interfaz/js/vendor/es.js'></script>

    <script src="/recursos/interfaz/js/main.js"></script>
    
    <script type='text/javascript'>  
	  var Swimcr = Swimcr || {};
	  Swimcr.listaEntrenamientos = [
		      <c:forEach items="${entrenamientos}" var="arregloEntrenamientos" varStatus="contadorEntrenamientos">
		      {
		      	'idEquipo': '${arregloEntrenamientos[0].id_equipo}',
		       	'entrenamientos': [
		      		<c:forEach items="${arregloEntrenamientos}" var="entrenamiento" varStatus="contadorArreglo">
		      		{
		       		'id': '${entrenamiento.id}',
		       		'fecha': '${entrenamiento.fecha}'
		       	}
		      		<c:if test="${not contadorArreglo.last}">
		      			,
	      			</c:if>
		       	</c:forEach>
		       		]
		      }
		      <c:if test="${not contadorEntrenamientos.last}">
    			,
			  </c:if>
		     	</c:forEach>
		      ];
    </script>
</body>

</html>