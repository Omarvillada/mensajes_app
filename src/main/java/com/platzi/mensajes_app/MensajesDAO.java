/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author omar
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes_app.mensajes(mensajes_col,autor_mensaje)VALUES(?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (SQLException e) {
                System.out.println(e);
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
    }
    
    public static void leerMensajes(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM mensajes_app.mensajes;";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id_mensajes"));
                System.out.println("Mensaje :" + rs.getString("mensajes_col"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha mensaje: " + rs.getString("fecha_mensaje"));
                System.err.println(" ");
                
                
            }
            
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.err.println(e);
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion connect_db = new Conexion();
        try(Connection conexion = connect_db.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes_app.mensajes\n" +
                            "SET mensajes_col= ?, autor_mensaje= ?, fecha_mensaje= NOW()\n" +
                            "WHERE id_mensajes=?;";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.setInt(3, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Actualizado.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
    
}
