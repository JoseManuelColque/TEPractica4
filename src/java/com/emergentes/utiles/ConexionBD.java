
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/cuenta";
    static String usuario = "root";
    static String password = "";

    public Connection conn = null;

    public ConexionBD() {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);

            if (conn != null) {
                System.out.println("Conexion OK");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Falta especificar driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al abrir BD " + e.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }
    public void desconectar(){
    
        try {
            System.out.println("Cerrando la BD"+conn);
            conn.close();
        } catch (SQLException ex) {
           System.out.println("Error al cerrar la BD "+ex.getMessage());
        }
    }
}
