<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alumnoad
  Date: 29/06/2026
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videojuego</title>
</head>
<body>

<h1>Listado de videojuegos</h1>

<c:set var="insertar" value="${mvc.uri('getFormularioInsert')}"/>
<a href="${insertar}">Insertar</a>

<table>

    <thead>
        <tr>
            <td>Codigo:</td>
            <td>Titulo:</td>
            <td>Imagen</td>
            <td>Acciones</td>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="videojuego" items="${videojuegos}">
            <c:set var="videojuegoo" value="${mvc.uri('getVideojuego',{'codigo':videojuego.codigo})}"/>
            <c:set var="update" value="${mvc.uri('getFormularioUpdate',{'codigo':videojuego.codigo})}"/>
            <c:set var="delete" value="${mvc.uri('getFormularioDelete',{'codigo':videojuego.codigo})}"/>



            <tr>
                <td> <a href="${videojuegoo}">${videojuego.codigo}</a></td>
                <td><c:out value='${videojuego.titulo}'/></td>
                <td><img src="<c:out value='${videojuego.urlImagen}'/>" width="300"></td>
                <td><a href="${update}">Actualizar</a>    <a href="${delete}">Eliminar</a></td>

            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
