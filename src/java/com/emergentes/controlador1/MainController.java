package com.emergentes.controlador1;

import com.emergentes.modelo.Lista;
import com.emergentes.utiles.ConexionBD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Atiende peticiones de tipo GET enlaces / URL

        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        ArrayList<Lista> lista1 = new ArrayList<Lista>();

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();

        PreparedStatement ps;
        ResultSet rs;
        //System.out.println("aa "+op);
        if (op.equalsIgnoreCase("list")) {

            try {
                String sql = "SELECT * FROM `listas` ORDER BY fecha DESC";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Lista lis = new Lista();
                    lis.setId(rs.getInt("id"));
                    lis.setFecha(rs.getString("fecha"));
                    lis.setTitulo(rs.getString("titulo"));
                    lis.setContenido(rs.getString("contenido"));

                    lista1.add(lis);
                }
                request.setAttribute("lista2", lista1);
                request.getRequestDispatcher("panel.jsp").forward(request, response);

            } catch (SQLException ex) {
                System.out.println("Error en SQl " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
        }
        if (op.equals("nuevo")) {
            Lista l = new Lista();
            request.setAttribute("lista", l);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
            System.out.println("llego aqui");
        }
        if (op.equals("editar")) {
            try {
                int id = Integer.parseInt(request.getParameter(("id")));

                String sql = "select * from listas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                Lista li = new Lista();
                while (rs.next()) {
                    li.setId(rs.getInt("id"));
                    li.setFecha(rs.getString("fecha"));
                    li.setTitulo(rs.getString("titulo"));
                    li.setContenido(rs.getString("contenido"));
                }
                request.setAttribute("lista", li);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex.getMessage());
            }
        }
        if (op.equals("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter(("id")));

                String sql = "delete from listas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error de SQL " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Atiende deste formulario POST
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");

        Lista l = new Lista();
        l.setId(id);
        l.setFecha(fecha);
        l.setTitulo(titulo);
        l.setContenido(contenido);

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
       
        // si es nuevo
        if (id == 0) {
            String sql = "insert into listas (titulo,contenido) values (?,?)";
            try {
                ps = conn.prepareStatement(sql);
                //ps.setString(1, l.getFecha());
                ps.setString(1, l.getTitulo());
                ps.setString(2, l.getContenido());

                ps.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Error de SQL " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
            response.sendRedirect("MainController");
        } //Si el registro ya existe
        else {

            try {
                String sql = "update listas set fecha=null, titulo=?,contenido=? where id = ?";
                
                ps = conn.prepareStatement(sql);
                //ps.setString(1, l.getFecha());
                ps.setString(1, l.getTitulo());
                ps.setString(2, l.getContenido());
                
                ps.setInt(3, l.getId());
                //System.out.println("llego aqui alci 4444");
                // ps.setInt(4, l.getId());

                ps.executeUpdate();
                
            } catch (SQLException ex) {
                System.out.println("Error al actualizar aqui alci " + ex.getMessage());
            }
            response.sendRedirect("MainController");

        }
    }

}
