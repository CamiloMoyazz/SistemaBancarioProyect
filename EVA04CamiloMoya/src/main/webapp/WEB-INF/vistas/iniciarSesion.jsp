<%-- 
    Document   : iniciarSesion
    Created on : 19 jul. 2021, 16:22:28
    Author     : Chalabera
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:include page="../templates/header.jsp"></jsp:include>


<main class="container">   
    <!-- FORMULARIO DE INICIO DE SESION -->
    <div class="columns is-centered mt-6">
        <div class="column is-4 mt-6">
        <c:if test="${error != null}"> 
            <div class="notification is-danger">${error}</div>
        </c:if>
            
            <form method="POST" action="iniciarSesionController.do">
                <!-- COMIENZO DEL CARD -->
                <div class="card mt-6">
                    <div class="card-header has-background-dark">
                        <h1 class="card-header-title has-text-primary-light">Iniciar Sesión</h1>
                    </div>
                    <!-- CONTENIDO DEL CARD , AQUI ESTAN LOS ELEMENTOS DEL FORMULARIO -->
                    <div class="card-content has-text-centered">
                        <!-- RUT CLIENTE -->
                        <div class="field">
                            <label class="label" for="rut-txt">Rut</label>
                            <div class="control">
                                <input class="input has-text-centered" type="text" id="rut-txt" name="rut-txt" placeholder="12983672-7" >
                            </div>
                        </div>
                        <!-- PASSWORD CLIENTE -->
                        <div class="field">
                            <label class="label" for="password-txt">Contraseña</label>
                            <div class="control">
                                <input class="input has-text-centered" type="password" name="password-txt" id="password-txt" placeholder="Password">
                            </div>
                        </div>
                        <!-- FOOTER PARA ALOJAR EL BOTON -->
                        <div class="card-footer has-text-centered">
                            <div class="card-footer-item">
                                <button class="button is-success" type="submit">Iniciar Sesión</button>
                            </div>
                        </div>
                    </div>
            </form>
        </div>
    </div>



</main>
</body>
</html>
