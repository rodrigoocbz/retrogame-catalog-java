<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alumnoad
  Date: 29/06/2026
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videojuego</title>
</head>
<body>
<h1>Info Videojuego</h1>

<table>
    <tbody>
    <tr>
        <th>Codigo</th>
        <td><c:out value='${videojuego.codigo}'/></td>
    </tr>
    <tr>
        <th>Titulo</th>
        <td><c:out value='${videojuego.titulo}'/></td>
    </tr>
    <tr>
        <th>Precio</th>
        <td><c:out value='${videojuego.precio}'/></td>
    </tr>

    <tr>
        <th>stock</th>
        <td><c:out value='${videojuego.stock}'/></td>
    </tr>


    <tr>
        <th>fechaLanzamiento</th>
        <td><c:out value='${videojuego.fechaLanzamiento}'/></td>
    </tr>

    <tr>
        <th>codigoSerial</th>
        <td><c:out value='${videojuego.codigoSerial}'/></td>
    </tr>

    <tr>
        <th>correoProveedor</th>
        <td><c:out value='${videojuego.correoProveedor}'/></td>
    </tr>

    <tr>
        <th>valoracion</th>
        <td><c:out value='${videojuego.valoracion}'/></td>
    </tr>

    <tr>
        <th>categoria</th>
        <td><c:out value='${videojuego.categoria}'/></td>
    </tr>
    <tr>
        <th>urlImagen</th>
        <td> <img src="<c:out value='${videojuego.urlImagen}'/>" width="60"/></td>
    </tr>
    </tbody>
</table>



<c:set var="volver" value="${mvc.uri('getVideojuegos')}"/>
<a href="${volver}">Volver al listado</a>
</body>
</html>
