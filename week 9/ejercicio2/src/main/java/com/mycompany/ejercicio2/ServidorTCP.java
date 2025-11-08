package com.mycompany.ejercicio2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Ejercicio 2: minimoServidorTCP
 * Servidor TCP que utiliza ServerSocket para crear un servidor
 * Genera un puerto aleatorio dentro del rango dinámico
 */
public class ServidorTCP {
    
    public static void main(String args[]) {
        // Generamos un puerto aleatorio dentro del rango dinámico
        Random random = new Random();
        int puerto = random.nextInt(49152) + 49152;
        
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
            
            while (true) {
                // Aceptar conexión del cliente
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());
                
                // Obtener el stream de salida para enviar datos al cliente
                OutputStream outputStream = socket.getOutputStream();
                
                // Mensaje de bienvenida al cliente
                String mensaje = "Bienvenido al servidor TCP. Puerto: " + puerto;
                outputStream.write(mensaje.getBytes());
                outputStream.flush();
                
                System.out.println("Mensaje enviado al cliente: " + mensaje);
                
                // Cerrar la conexión con este cliente
                socket.close();
                System.out.println("Conexión cerrada con el cliente\n");
            }
            
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            // Verificar si el error es por puerto en uso
            if (e.getMessage().contains("Address already in use")) {
                System.err.println("El puerto " + puerto + " ya está en uso. Intenta nuevamente.");
            }
        }
    }
}