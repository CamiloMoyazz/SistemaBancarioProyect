<%-- 
    Document   : header
    Created on : 20 jun. 2021, 19:14:06
    Author     : Chalabera
--%>

<%@page import="cl.inacap.eva04camilomoya.dto.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bienvenido a tú Banco</title>
        <link rel="stylesheet" href="vendor/bulma/css/bulma.min.css">
    </head>
    <body>

        <header>
            <nav class="navbar is-info has-background-info-dark is-spaced" role="navigation" aria-label="main navigation">

                <div class="navbar-brand">
                    <img class="image is-64x64 mr-5" src="https://iconmonstr.com/wp-content/g/gd/makefg.php?i=../assets/preview/2013/png/iconmonstr-coin-10.png&r=255&g=255&b=255">
                    <a role="button" class="navbar-burger" aria-label="menu"
                       aria-expanded="false" data-target="navbarBasicExample"> <span
                            aria-hidden="true"></span> <span aria-hidden="true"></span> <span
                            aria-hidden="true"></span>
                    </a>
                </div>

                <div id="navbarBasicExample" class="navbar-menu">
                    <div class="navbar-start">
                        <a class="navbar-item" href="miSaldoController.do">Mi Saldo</a> 
                        <a class="navbar-item" href="transferirController.do">Transferir</a> 
                        <a class="navbar-item" href="historialController.do">Historial de Movimientos</a>  
                    </div>
                    <c:if test="${cliente != null}">
                        <div class="navbar-end">
                            <a class="button is-danger has-background-danger mt-2" href="cerrarSesionController.do">Cerrar Sesion</a>
                        </div>
                    </c:if>
                </div>
            </nav>
        </header>
        
        