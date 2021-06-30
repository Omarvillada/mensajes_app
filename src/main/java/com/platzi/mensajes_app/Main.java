/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;


/**
 *
 * @author omar
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
       int opcion = 0;
       
       do{
            System.out.println("-----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. editar mensaje");
            System.out.println(" 4. eliminar mensaje");
            System.out.println(" 5. salir");
            //leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                default:
                    break;
            }
           
       }while(opcion != 5);
        
       
    
        Conexion conection = new Conexion();
        
        try(Connection cnx = conection.get_connection();){
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
