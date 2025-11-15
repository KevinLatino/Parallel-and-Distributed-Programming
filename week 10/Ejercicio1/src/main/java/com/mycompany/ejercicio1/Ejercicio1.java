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
            URL url = new URL("https://es.wikipedia.org/wiki/Peri%C3%B3dico");
            URLConnection conexion = url.openConnection();
            conexion.connect();
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];
            int leido;
            while ((leido = br.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, leido));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
