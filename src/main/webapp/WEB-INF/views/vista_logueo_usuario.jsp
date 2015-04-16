<%-- 
    Document   : hello
    Created on : May 8, 2014, 10:17:30 AM
    Author     : r.alvarado
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titulo}</title>
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="/recursos/js/logueoUsuario.js"></script>
    </head>
    <body>
        <h1>${titulo}</h1>
        <p>${descripcion1}</p>
        <c:if test="${not empty listaDescripcion}">
            <ul>
        	<c:forEach var="elemLista" items="${listaDescripcion}">
                    <li>${elemLista}</li>
		</c:forEach>
            </ul>
	</c:if>
        <p>${descripcion2}</p>
        <c:if test="${not empty listaEjemplos}">
            <p>
        	<c:forEach var="elemLista" items="${listaEjemplos}">
                    ${elemLista}<br />&nbsp;&nbsp;
		</c:forEach>
            </p>
	</c:if>
    </body>
</html>
