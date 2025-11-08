package com.mycompany.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Ejercicio 1: Programa que muestra la conexión mínima de un socket
 * Este programa actúa como cliente y se conecta a un servidor
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        // Host del servidor (localhost)
        final String HOST = "127.0.0.1";
        // Puerto del servidor (asumiendo que el servidor está corriendo en el mismo equipo)
        final int PUERTO = 5000;
        
        DataInputStream in;
        DataOutputStream out;
        
        try {
            // Crear el socket para conectarse con el servidor
            Socket sc = new Socket(HOST, PUERTO);
            System.out.println("Conexión establecida con el servidor " + HOST + ":" + PUERTO);
            
            // Configurar los streams de entrada y salida
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            // Enviar un mensaje al servidor
            out.writeUTF("¡Hola mundo desde el cliente!");
            out.flush(); // Asegurar que el mensaje se envíe inmediatamente
            System.out.println("Mensaje enviado al servidor");
            
            // Recibir la respuesta del servidor
            String mensaje = in.readUTF();
            System.out.println("Respuesta del servidor: " + mensaje);
            
            // Cerrar la conexión
            sc.close();
            System.out.println("Conexión cerrada");
            
        } catch (UnknownHostException e) {
            System.err.println("Error: Host desconocido - " + HOST);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Fallo en la conexión - " + e.getMessage());
            e.printStackTrace();
        }
    }
}