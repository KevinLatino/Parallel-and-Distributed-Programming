package com.mycompany.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor simple para probar la conexión del cliente
 * Este servidor escucha en el puerto 5000 y responde a los mensajes del cliente
 */
public class Server {
    
    public static void main(String[] args) {
        final int PUERTO = 5000;
        ServerSocket servidor = null;
        
        try {
            // Crear el servidor en el puerto especificado
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado en el puerto " + PUERTO);
            System.out.println("Esperando conexión del cliente...");
            
            // Esperar a que un cliente se conecte
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde: " + cliente.getInetAddress().getHostAddress());
            
            // Configurar los streams de entrada y salida
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            
            // Recibir mensaje del cliente
            String mensajeCliente = in.readUTF();
            System.out.println("Mensaje del cliente: " + mensajeCliente);
            
            // Enviar respuesta al cliente
            out.writeUTF("¡Hola cliente! Mensaje recibido correctamente");
            out.flush();
            System.out.println("Respuesta enviada al cliente");
            
            // Cerrar conexiones
            cliente.close();
            servidor.close();
            System.out.println("Servidor cerrado");
            
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}