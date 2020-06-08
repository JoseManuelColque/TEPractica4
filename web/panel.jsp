<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Lista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  List<Lista> lista = (List<Lista>) request.getAttribute("lista2");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="./css/panelStyle.css" type="text/css"></link>
        <title>JSP Page</title>
    </head>
     <body>
         <header>
             <section id="banner">
                 <h1>LIBROS PUBLICADOS</h1>
             </section>
         </header>
         <nav>
             <h2>Blog de: Jose Manuel Colque Zarate</h2>  
         </nav>
        <main> 
         <aside id="caja1">

         </aside>

            <article>
                <hr>
               <br/>
               <p><a href="MainController?op=nuevo">Nuevo</a></p>

               <table border="0">

                   <tr>
                       <th></th>
                       <th></th>
                   </tr>
                   <tr>
                       <th></th>
                       <th></th>
                   </tr>
                   <tr>
                       <th></th>
                       <th></th>
                   </tr>
                   <tr>
                       <th></th>
                       <th></th>
                   </tr>

                   <c:forEach var="item" items="${lista2}">

                       <tr>
                           <td>${item.getFecha()}</td> 
                           <td></td>
                       </tr>
                       <tr>
                           <td> <h3>${item.titulo}</h3></td>
                           <td></td>
                       </tr>
                       <tr>
                           <td>${item.contenido}</td> 
                           <td></td>
                       </tr>
                       <tr> 

                           <td colspan=""><a href="MainController?op=editar&id=${item.id}">Editar</a>  
                               <a href="MainController?op=eliminar&id=${item.id}" onclick="return(confirm
                                           ('Esta seguro de eliminar??'))">Eliminar</a>

                           </td>

                       </tr>
                       <tr>
                           <td> <br/></td>
                       </tr>

                       <tr>
                           <td> <hr width=1050></td>
                       </tr>
                       <tr>
                           <td> <br/></td>
                       </tr>
                   </c:forEach>

               </table>
            </article>
            <aside id="caja2">

            </aside>
        </main>
        <footer>
                <h3>Universidad Publica de El Alto</h3> 
                <h3>Carrera Ingenieria en Sitemas</h3>
                <h3>Materia: Emergentes II</h3>
        </footer>
    </body>
</html>
