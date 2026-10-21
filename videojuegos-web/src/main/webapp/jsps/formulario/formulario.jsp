<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${mvc.locale}"/>

<c:choose>
    <c:when test="${action eq 'INSERT'}">
        <c:set var="title" value="Insertar"/>
        <c:set var="long_title" value="Insertar info del videojuego"/>
        <c:set var="uriDestino" value="${mvc.uri('insertVideojuego')}"/>
        <c:set var="method" value="POST"/>
        <c:set var="disabled" value=""/>
        <c:set var="submit_label" value="Insertar"/>
    </c:when>

    <c:when test="${action eq 'UPDATE'}">
        <c:set var="title" value="Actualizar"/>
        <c:set var="long_title" value="Actualizar info del videojuego"/>
        <c:set var="uriDestino" value="${mvc.uri('updateVideojuego', {'codigo': form.codigo})}"/>
        <c:set var="method" value="PUT"/>
        <c:set var="disabled" value=""/>
        <c:set var="submit_label" value="Actualizar"/>
    </c:when>

    <c:when test="${action eq 'DELETE'}">
        <c:set var="title" value="Eliminar"/>
        <c:set var="long_title" value="Eliminar info del videojuego"/>
        <c:set var="uriDestino" value="${mvc.uri('deleteGame', {'codigo': form.codigo})}"/>
        <c:set var="method" value="DELETE"/>
        <c:set var="disabled" value="disabled"/>
        <c:set var="submit_label" value="Eliminar"/>
    </c:when>
</c:choose>

<html>
<head>
    <title>${title}</title>
</head>
<body>

<h1>${long_title}</h1>

<form method="post" action="${uriDestino}" enctype="application/x-www-form-urlencoded">
    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}"/>
    <input type="hidden" name="_method" value="${method}">
    <input type="hidden" name="codigo" value="<c:out value='${form.codigo}'/>">

    <label for="titulo">Titulo</label>
    <input type="text" name="titulo" id="titulo" value="<c:out value='${form.titulo}'/>" ${disabled}>
    <c:if test="${not empty errores.titulo}">
        <ul>
            <c:forEach var="mensaje" items="${errores.titulo}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="precio">Precio (€):</label>
    <input id="precio" type="text" name="precio" value="<fmt:formatNumber value='${form.precio}' groupingUsed='false' maxFractionDigits='2'/>" ${disabled}>
    <c:if test="${not empty errores.precio}">
        <ul>
            <c:forEach var="mensaje" items="${errores.precio}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="stock">Stock:</label>
    <input id="stock" type="text" name="stock" value="<c:out value='${form.stock}'/>" ${disabled}>
    <c:if test="${not empty errores.stock}">
        <ul>
            <c:forEach var="mensaje" items="${errores.stock}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="fechaLanzamiento">Fecha de Lanzamiento:</label>
    <input id="fechaLanzamiento" type="text" name="fechaLanzamiento" value="<c:out value='${form.fechaLanzamiento}'/>" ${disabled}>
    <c:if test="${not empty errores.fechaLanzamiento}">
        <ul>
            <c:forEach var="mensaje" items="${errores.fechaLanzamiento}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="codigoSerial">Código Serial:</label>
    <input id="codigoSerial" type="text" name="codigoSerial" value="<c:out value='${form.codigoSerial}'/>" ${disabled}>
    <c:if test="${not empty errores.codigoSerial}">
        <ul>
            <c:forEach var="mensaje" items="${errores.codigoSerial}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="correoProveedor">Correo del Proveedor:</label>
    <input id="correoProveedor" type="email" name="correoProveedor" value="<c:out value='${form.correoProveedor}'/>" ${disabled}>
    <c:if test="${not empty errores.correoProveedor}">
        <ul>
            <c:forEach var="mensaje" items="${errores.correoProveedor}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="valoracion">Valoración (0.0 - 10.0):</label>
    <input id="valoracion" type="text" name="valoracion" value="<fmt:formatNumber value='${form.valoracion}' groupingUsed='false' maxFractionDigits='2'/>" ${disabled}>
    <c:if test="${not empty errores.valoracion}">
        <ul>
            <c:forEach var="mensaje" items="${errores.valoracion}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="categoria">Categoría:</label>
    <input id="categoria" type="text" name="categoria" value="<c:out value='${form.categoria}'/>" ${disabled}>
    <c:if test="${not empty errores.categoria}">
        <ul>
            <c:forEach var="mensaje" items="${errores.categoria}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <label for="urlImagen">URL de la Carátula:</label>
    <input id="urlImagen" type="url" name="urlImagen" value="<c:out value='${form.urlImagen}'/>" ${disabled}>
    <c:if test="${not empty errores.urlImagen}">
        <ul>
            <c:forEach var="mensaje" items="${errores.urlImagen}">
                <li><c:out value='${mensaje}'/></li>
            </c:forEach>
        </ul>
    </c:if>

    <input type="submit" value="${submit_label}">
</form>

</body>
</html>