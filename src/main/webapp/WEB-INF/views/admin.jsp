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
        .navbar-center{
		    position: absolute;
		    width: 100%;
		    left: 0;
		    text-align: center;
		    margin: auto;
		}
    </style>
    <link rel="stylesheet" href="/recursos/interfaz/css/bootstrap-theme.min.css">
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
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	
	<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron" id="contenedor-aplicacion">
        <div class="container">
            <ul class="nav nav-tabs" role="tablist" id="tabs-container">
                <!--Contenido del template de equipos-->
                <c:forEach var="equipo" items="${equipos}" varStatus="contador" >
	                <c:if test="${contador.count == 0}">
	                	<li class="active">
	                </c:if>
	                <c:if test="${contador.count > 0}">
	                	<li>
	                </c:if>
	                	<a href="#${equipo.id}" role="tab" data-toggle="tab" data-id-equipo = "${equipo.id}">${equipo.nombre}</a>
	            	</li>
	            </c:forEach>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content" id="tabs-content-container">
                <!--Contenido del template de entrenamientos-->
            </div>


            <p><a class="btn btn-primary btn-lg hidden" id="boton-volver-entrenamientos" role="button">&laquo; Volver a la lista de entrenamientos</a>
            </p>
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
    <script type='text/html' id='templateEquipos'> <!-- esto va dentro del id "tabs-container"-->
         <@ for (var i = 0; i < equipos.length; i++) { @>
            <li <@if(i == 0) {@>class="active"<@}@>>
                <a href="#<@= equipos[i].id @>" role="tab" data-toggle="tab" data-id-equipo = "<@= equipos[i].id @>"><@= equipos[i].nombre @></a>
            </li>
        <@ }; @>
    </script>

    <script type="text/html" id="templateEntrenamientos"> <!--esto va dentro del id "tabs-content-container"-->
        <div class = "tab-pane active" id="tab-<@= entrenamientos.equipoId @>">
            <div class = "entrenamientos">
                <table class="table">
                    <tr>
                        <th>
                            Entrenamientos <button style="color:#078C19; opacity: 2;" type="button" class="close boton-agregar-entrenamiento">+</button>
                        </th>
                    </tr>
                     <@ for (var i = 0; i < entrenamientos.length; i++) { @>
                    <tr>
                        <td class="fechaEntrenamiento" data-id-entrenamiento="<@= entrenamientos[i].id @>">
                            <a href="#"><@= entrenamientos[i].fecha @></a>
                            <button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-entrenamiento">&times;</button>
                        </td>
                    </tr>
                    <@ }; @>
                </table>
            </div>
            <div class = "pruebas">
                <!--Contenido del template de pruebas-->
            </div>
        </div>
    </script>



    <script type='text/html' id='templatePruebas'>
        <table class="table">
            <tr>
                <th>Distancia</th>
                <th>Estilo</th>
                <th>Tipo</th>
                <th><button style="color:#078C19; opacity: 2;" type="button" class="close boton-agregar-prueba">+</button></th>
            </tr>
            <@ for (var i = 0; i < pruebas.length; i++) { @>
            <tr>
                <td>
                     <select class="form-control distancia">
                    <@ var distancia = 25;
                       while ( distancia < 1600 ) {@>
                         <option value="<@= distancia @>" <@ if(pruebas[i].distancia == distancia) { @> selected <@ } @> ><@= distancia @></option>
                        <@ if (distancia < 200) {
                                distancia = distancia * 2;
                            }
                            else if (distancia < 1000) {
                                distancia = distancia +100;
                            }
                            else {
                                distancia = distancia + 500;
                            }
                        }
                    @>
                     </select>
                </td>
                <td>
                    <select class="form-control estilo">
                        <option value="1" <@ if(pruebas[i].estilo == 1) { @> selected <@ } @> >Libre</option>
                        <option value="2" <@ if(pruebas[i].estilo == 2) { @> selected <@ } @> >Dorso</option>
                        <option value="3" <@ if(pruebas[i].estilo == 3) { @> selected <@ } @> >Pecho</option>
                        <option value="4" <@ if(pruebas[i].estilo == 4) { @> selected <@ } @> >Mariposa</option>
                    </select>
                </td>
                <td>
                    <input type="text" class="form-control tipoPrueba" placeholder="Tipo de prueba (Ejemplo: Calentamiento)" value = "<@= pruebas[i].tipo @>">
                </td>
                <td>
                    <button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-prueba">&times;</button>
                </td>
            </tr>
            <@ } @>
        </table>
    </script>
    
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