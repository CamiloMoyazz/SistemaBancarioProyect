<%-- 
    Document   : transferir
    Created on : 19 jul. 2021, 16:22:57
    Author     : Chalabera
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<c:if test="${errores != null}">
    <div class="columns is-centered mb-1">
        <div class="column  mt-2 is-8">
            <div class="notification is-danger mt-4">
                <h6 class="subtitle">EXISTEN ERRORES EN LOS DATOS!</h6>
                <div class="content">
                    <ul>
                        <c:forEach items="${errores}" var="error">
                            <li>${error}</li>
                        </c:forEach>	
                    </ul>
                </div>
            </div>
        </div>
    </div>
</c:if>  
<c:if test="${exito != null}">
    <div class="columns is-centered mb-1">
        <div class="column  mt-2 is-8">
            <div class="notification is-success mt-4">
                <h6 class="subtitle">${exito}</h6>
            </div>
        </div>
    </div>
</c:if>  



<main class="container">
    <!-- FORMULARIO DE INICIO DE SESION -->
    <div class="columns is-centered mt-4">
        <div class="column is-4 mt-2">
            <form method="POST" action="transferirController.do">
                <!-- COMIENZO DEL CARD -->
                <div class="card mt-3">
                    <div class="card-header has-background-info-dark">
                        <h1 class="card-header-title has-text-primary-light">Transferir a Terceros</h1>
                    </div>
                    <!-- CONTENIDO DEL CARD , AQUI ESTAN LOS ELEMENTOS DEL FORMULARIO -->
                    <div class="card-content">
                        <!-- NUM CUENTA DE ORIGEN -->
                        <div class="field">
                            <label class="label" for="origen-txt">Numero Cuenta Origen</label>
                            <div class="control">
                                <input class="input is-rounded" type="text" value="${numerocta}" id="origen-txt" name="origen-txt" placeholder="111111" >
                            </div>
                        </div>
                        <!-- NUMERO CUENTA DESTINO -->
                        <div class="field">
                            <label class="label" for="destino-txt">Numero Cuenta Destino</label>
                            <div class="control">
                                <input class="input is-rounded" type="text" name="destino-txt" id="destino-txt" placeholder="222222">
                            </div>
                        </div>
                        <!-- MONTO  -->
                        <div class="field">
                            <label class="label" for="monto-txt">Monto a Tranferir</label>
                            <div class="control">
                                <input class="input is-rounded" type="text" name="monto-txt" id="monto-txt" placeholder="$XXXXX">
                            </div>
                        </div>
                        <!-- CLAVE -->
                        <div class="field">
                            <label class="label" for="clave-txt">Clave de Transaccion</label>
                            <div class="control">
                                <input class="input is-rounded" type="password" name="clave-txt" id="clave-txt" placeholder="*****">
                            </div>
                        </div>
                        <!-- FOOTER PARA ALOJAR EL BOTON -->
                        <div class="card-footer ">
                            <div class="card-footer-item">
                                <button class="button is-info" type="submit">TRANSFERIR</button>
                            </div>
                        </div>
                    </div>
            </form>
        </div>
    </div>



</main>
</body>
</html>
