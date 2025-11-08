package com.mycompany.ejercicio2;

import java.util.Random;

/**
 * Clase principal que ejecuta el Ejercicio 2
 * Ejecuta primero el servidor y luego el cliente automáticamente
 * Utiliza el MISMO puerto aleatorio para ambos
 */
public class Ejercicio2 {
    
    // Puerto compartido entre servidor y cliente
    private static int puertoCompartido;
    
    public static void main(String[] args) {
        System.out.println("=== INICIANDO EJERCICIO 2: CLIENTE-SERVIDOR TCP MÍNIMO ===\n");
        
        // Generar un puerto aleatorio que será usado por ambos
        Random random = new Random();
        puertoCompartido = random.nextInt(49152) + 49152;
        System.out.println("Puerto asignado: " + puertoCompartido + "\n");
        
        // Crear un hilo para ejecutar el servidor
        Thread hiloServidor = new Thread(() -> {
            System.out.println("--- INICIANDO SERVIDOR ---");
            minimoServidorTCP_Modified.main(null, puertoCompartido);
        });
        
        // Iniciar el servidor
        hiloServidor.start();
        
        // Esperar para que el servidor se inicie completamente
        try {
            System.out.println("\nEsperando 2 segundos para que el servidor se inicie...\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Ejecutar el cliente
        System.out.println("--- INICIANDO CLIENTE ---");
        try {
            minimoClienteTCP_Modified.main(null, puertoCompartido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Esperar un momento antes de cerrar
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== EJERCICIO 2 COMPLETADO ===");
        System.exit(0);
    }
}

/**
 * Versión modificada del servidor que acepta el puerto como parámetro
 */
class minimoServidorTCP_Modified {
    
    public static void main(String args[], int puerto) {
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
            
            // Aceptar UNA conexión del cliente (no loop infinito para esta demo)
            java.net.Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + socket.getInetAddress());
            
            // Obtener el stream de salida para enviar datos al cliente
            java.io.OutputStream outputStream = socket.getOutputStream();
            
            // Mensaje de bienvenida al cliente
            String mensaje = "Bienvenido al servidor TCP. Puerto: " + puerto;
            outputStream.write(mensaje.getBytes());
            outputStream.flush();
            
            System.out.println("Mensaje enviado al cliente: " + mensaje);
            
            // Cerrar la conexión con este cliente
            socket.close();
            System.out.println("Conexión cerrada con el cliente");
            
        } catch (java.io.IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            if (e.getMessage().contains("Address already in use")) {
                System.err.println("El puerto " + puerto + " ya está en uso. Intenta nuevamente.");
            }
        }
    }
}

/**
 * Versión modificada del cliente que acepta el puerto como parámetro
 */
class minimoClienteTCP_Modified {
    
    public static void main(String args[], int puerto) throws java.io.IOException {
        try (java.net.Socket socket = new java.net.Socket("127.0.0.1", puerto)) {
            System.out.println("Conectado al servidor en el puerto " + puerto);
            
            // Obtener el stream de entrada para leer datos del servidor
            java.io.InputStream inputStream = socket.getInputStream();
            
            // Lee los datos del servidor y los muestra en la consola
            int byteRead;
            System.out.print("Datos recibidos del servidor: ");
            while ((byteRead = inputStream.read()) != -1) {
                System.out.print((char) byteRead);
            }
            System.out.println();
            
        } catch (java.io.IOException e) {
            System.err.println("Error al conectar al servidor: " + e.getMessage());
        }
    }
}