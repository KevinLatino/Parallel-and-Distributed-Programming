package com.mycompany.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ejercicio2 {
    
    public static void main(String[] args) throws IOException {
        
        // URL de la página web a recuperar
        URL url = new URL("https://www.ulacit.ac.cr/");
        
        // Establecer la conexión HTTP
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            
            System.out.println("=== Contenido de la página web ===\n");
            
            // Leer y mostrar cada línea del contenido
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.err.println("Error: Fallo en la comunicación HTTP. " + e.getMessage());
        } finally {
            // Cerrar la conexión
            connection.disconnect();
        }
    }
}