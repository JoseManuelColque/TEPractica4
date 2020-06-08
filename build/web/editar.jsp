<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="com.emergentes.modelo.Lista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
Lista lista = (Lista) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/editarStyle.css" type="text/css"></link>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${lista.id == 0}">Nuevo lista </c:if>
            <c:if test="${lista.id != 0}">Editar lista </c:if>
        </h1>
        <div id="editar">
        <form action="MainController" method="post">
        <table>
            <input type="hidden" name="id" value="${lista.id}">
            <tr>
                <td>fecha</td>
                <td><input type="text" name="fecha" value="${lista.fecha}" ></td>
            </tr>
            <tr>
                <td>Titulo</td>
                <td><input type="text" name="titulo" value="${lista.titulo}" ></td>
            </tr>
            <tr>
                <td>Contenido</td>
                <td><input type="text" name="contenido" value="${lista.contenido}" ></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Enviar"></td>
            </tr>
        </table>
      </form> 
      </div>      
    </body>
</html>
