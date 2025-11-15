package com.mycompany.ejercicio4;

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.google.com/";

        JSONObject usuario = new JSONObject();
        usuario.put("nombre", "Juan Perez");
        usuario.put("correo", "juan.perez@ejemplo.com");
        usuario.put("contrasena", "clave123");

        String datosUsuarioJSON = usuario.toString();

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream())) {
            osw.write(datosUsuarioJSON);
            osw.flush();
        }

        int responseCode = connection.getResponseCode();
        BufferedReader reader;

        if (responseCode == HttpURLConnection.HTTP_CREATED) {
            System.out.println("Usuario creado exitosamente!");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            System.out.println("Error al crear usuario: " + responseCode);
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        connection.disconnect();
    }
}
