<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <title>Captura de Vehículo</title>
    </head>
    <body>
        <c:if test="${error != null}">
            <div class="error"> ${error} </div>
        </c:if>
        <form action="guardar">
        <div>
        <label>Placas:</label>
        <input type="text" name="placas" value="${vehiculo.placas}"/>
        </div>
        <div>
        <label>Marca:</label>
        <input type="text" name="marca" value="${vehiculo.marca}"/>
        </div>
        <div>
        <label>Modelo:</label>
        <input type="text" name="modelo" value="${vehiculo.modelo}"/>
        </div>
        <div>
        <label>Color:</label>
        <input type="text" name="color" value="${vehiculo.color}"/>
        </div>
        <div>
        <label>Kilometraje:</label>
        <input type="text" name="kilometraje" value="${vehiculo.kilometraje}"/>
        </div>
        <div>
        <label>Ingreso:</label>
        <input type="text" name="fechaIngresoTexto" value="${vehiculo.fechaIngresoTexto}"/>
        </div>
        <div>
        <label>Salida:</label>
        <input type="text" name="fechaSalidaTexto" value="${vehiculo.fechaSalidaTexto}"/>
        </div>
        <div>
        <button type="submit">Guardar</button>
        </div>
        </form>
    </body>
</html>