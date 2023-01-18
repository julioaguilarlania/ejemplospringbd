<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <title>Búsqueda de Vehículo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <button type="button"
            onclick="location.href='forma_nuevo'">Agregar</button>
        <form action="buscar">
        <div>
        <label>Placas:</label>
        <input type="text" name="placas"/>
        </div>
        <div>
        <button type="submit">Buscar</button>
        </div>
        <hr>
        <div>
            <h2> Vehiculos registrados </h2>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Placas</th>
                        <th scope="col">Color</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Modelo</th>
                        <th scope="col">Kilometraje</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var = "v" items="${vehiculos}">
                        <tr>
                            <td>${v.placas}</td>
                            <td>${v.color}</td>
                            <td>${v.marca}</td>
                            <td>${v.modelo}</td>
                            <td>${v.kilometraje}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </form>
        </div>
    </body>
</html>