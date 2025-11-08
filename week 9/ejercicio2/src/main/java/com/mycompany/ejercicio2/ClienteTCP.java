package com.mycompany.ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

/**
 * Ejercicio 2: minimoClienteTCP
 * Cliente TCP que se conecta al servidor y lee los datos que recibe
 * El cliente imprime por consola todo lo que recibe del servidor
 */
public class ClienteTCP {
    
    public static void main(String args[]) throws IOException {
        // Generamos un puerto aleatorio dentro del rango dinámico
        Random random = new Random();
        int puerto = random.nextInt(49152) + 49152;
        
        try (Socket socket = new Socket("127.0.0.1", puerto)) {
            System.out.println("Conectado al servidor en el puerto " + puerto);
            
            // Obtener el stream de entrada para leer datos del servidor
            InputStream inputStream = socket.getInputStream();
            
            // Lee los datos del servidor y los muestra en la consola
            int byteRead;
            System.out.print("Datos recibidos del servidor: ");
            while ((byteRead = inputStream.read()) != -1) {
                System.out.print((char) byteRead);
            }
            System.out.println("\n");
            
        } catch (IOException e) {
            System.err.println("Error al conectar al servidor: " + e.getMessage());
        }
    }
}