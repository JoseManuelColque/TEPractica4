

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/loginStyle.css" type="text/css"></link>
        <title>JSP Page</title>
    </head>
 
    <body>
    
        <div id="login">
            
            <h1>Login</h1>
            <form action="LoginControlador" method="post">
                <div id="imagen">
                    <img src="./img/libro.jpg" alt="libros" width="300px">
                </div>
               
                <label>Usuario:</label>
                <input type="text" name="usuario">
                <br><br>
                <label>Password:</label>
                <input type="password" name="password">
                <br><br>
                <div id="boton">
                <input type="submit" value="Ingresar">
                </div>
            </form>
        </div>
    </body>
</html>
