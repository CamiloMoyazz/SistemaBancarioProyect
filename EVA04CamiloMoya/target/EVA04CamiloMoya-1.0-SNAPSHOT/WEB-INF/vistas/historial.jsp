<%-- 
    Document   : historial
    Created on : 19 jul. 2021, 16:23:12
    Author     : Chalabera
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:include page="../templates/header.jsp"></jsp:include>
    <main class="container">
        <div class="columns is-centered mt-3">
            <div class="column is-8 mb-2">
                <section class="hero is-small is-grey  has-background-grey-lighter mt-1 has-text-centered">
                    <div class="hero-body">
                        <p class="title">Historial de Movimientos</p>
                        <table class="table is-striped is-hoverable is-fullwidth is-bordered ">
                            <thead class="is-info has-background-info-light">
                                <tr>
                                    <th>Fecha</th>
                                    <th>Movimiento</th>
                                    <th>Cuenta Asociada</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${movimientos}" var="movi">
                                    
                                        <tr>
                                            <td>${movi.fecha}</td>
                                            <td>${movi.descripcion}</td>
                                            <td>${movi.cuentaFK.clienteFK.getNombre()} ${movi.cuentaFK.clienteFK.getApellido()}</td>
                                        </tr>
                                    
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </main>
</body>
</html>
