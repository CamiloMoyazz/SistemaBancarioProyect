<%-- 
    Document   : miSaldo
    Created on : 19 jul. 2021, 16:22:43
    Author     : Chalabera
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main class="container">

    <div class="columns is-centered mt-5">
        <div class="column is-10">
            <section class="hero is-info has-background-info-dark welcome is-small">
                <div class="hero-body">
                    <div class="container has-text-centered">
                        <h1 class="title is-centered">BIENVENID@ ${cliente.nombre}  ${cliente.getApellido()} </h1>
                    </div>
                </div>
            </section>
            <section class="info-tiles">
                <div class="tile is-ancestor has-text-centered">
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">$${cuenta.getSaldo()}</p>
                            <p class="subtitle">Saldo Actual</p>
                        </article>

                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">$${cuenta.saldolineacredito}</p>
                            <p class="subtitle">Linea de crédito</p>
                        </article>

                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child box">
                            <p class="title">$${cuenta.saldolineacreditousado}</p>
                            <p class="subtitle">Linea de crédito utilizada</p>
                        </article>

                    </div>
                </div>

            </section>
        </div>
    </div>

</main>    
</body>
</html>
