/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author omar
 */
public class MensajesService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu nombre: ");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajes();
    }
    
    public static void borrarMensaje(){
    
    }
    
    public static void editarMensaje(){
        System.out.println("Lista de mensajes disponibles a actualizar");
        MensajesDAO.leerMensajes();
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del mensaje a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nuevo mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("Ingrese el nuevo autor: ");
        String autor = sc.nextLine();
        
        Mensajes registro = new  Mensajes();
        registro.setId_mensaje(id);
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(autor);
        MensajesDAO.actualizarMensajeDB(registro);
        
    }
}