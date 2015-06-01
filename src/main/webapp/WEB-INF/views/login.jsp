<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<body onload='document.loginForm.username.focus();'>
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Asistente de Nataci&oacute;n</a>
				</div>
			</div>
		</div>
		<div class="col-md-2 col-md-offset-5" id="login-container">
			<h1>Bienvenido!</h1>
	
			<form class="form-group" name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
				<input type="text" name='username' placeholder="Nombre de Usuario" class="form-control usuario" value="mkyong"> 
				<input type="password" name='password' placeholder="Contraseña" class="form-control contrasena" value="123456">
				<input class="btn btn-success" id="boton-login" name="submit" type="submit" value="Ingresar" /> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</body>
</html>