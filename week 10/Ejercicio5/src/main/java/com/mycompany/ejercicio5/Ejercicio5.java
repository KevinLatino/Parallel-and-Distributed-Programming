package com.mycompany.ejercicio5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        String urlString = "https://www.ulacit.ac.cr/";

        String nombreArchivo = "N-WEB-Moot-Madrid-768x344.jpg";

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();

            File archivo = new File(nombreArchivo);
            FileOutputStream outputStream = new FileOutputStream(archivo);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Archivo descargado exitosamente: " + nombreArchivo);
        } else {
            System.out.println("Error al descargar archivo: " + responseCode);
        }

        connection.disconnect();
    }
}
