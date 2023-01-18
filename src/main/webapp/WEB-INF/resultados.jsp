<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Resultados de búsqueda</title>
<link rel="stylesheet" href="estilos.css"/>
</head>
<body>
    <c:if test="${vehiculo != null}">
        <table>
        <tr><td>Placas:</td><td>${vehiculo.placas}</td></tr>
        <tr><td>Marca:</td><td>${vehiculo.marca}</td></tr>
        <tr><td>Modelo:</td><td>${vehiculo.modelo}</td></tr>
        <tr><td>Color:</td><td>${ vehiculo.color }</td></tr>
        <tr><td>Kms:</td><td>${ vehiculo.kilometraje }</td></tr>
        <tr><td>Ingreso:</td><td>${vehiculo.fechaIngresoTexto}</td></tr>
        <tr><td>Salida</td><td>${vehiculo.fechaSalidaTexto}</td></tr>
        </table>
    </c:if>
    <c:if test="${vehiculo == null}">
        <div>No se encontro vehículo</div>
    </c:if>
    <div><a href="forma_busqueda" class="boton">Regresar</a></div>
</body>
</html>