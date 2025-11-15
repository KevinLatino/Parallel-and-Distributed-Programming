package com.mycompany.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Ejercicio3 {
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
        // URL del servidor web
        String urlString = "https://www.google.com/";
        
        // Crear la conexión HTTP
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Configurar la solicitud
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.84 Safari/537.36");
        
        // Enviar la solicitud y obtener la respuesta
        connection.connect();
        int responseCode = connection.getResponseCode();
        
        // Verificar si la solicitud fue exitosa
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Leer la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            
            System.out.println("=== Contenido de la página web ===\n");
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            reader.close();
        } else {
            System.out.println("Error: Código de respuesta HTTP: " + responseCode);
        }
        
        // Cerrar la conexión
        connection.disconnect();
    }
}