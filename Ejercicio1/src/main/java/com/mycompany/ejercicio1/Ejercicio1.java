package com.mycompany.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            // Se abre la conexión
            URL url = new URL("https://es.wikipedia.org/wiki/Peri%C3%B3dico");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            // Lectura del contenido HTML
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            char[] buffer = new char[1000];
            int leido;

            while ((leido = br.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, leido));
            }

            br.close();
            is.close();

        } catch (MalformedURLException e) {
            System.out.println("URL mal formada:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la conexión/lectura:");
            e.printStackTrace();
        }
    }
}
