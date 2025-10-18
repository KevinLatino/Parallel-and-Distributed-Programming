package com.mycompany.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 implements Runnable {
    private String palabra;
    private Thread hilo;
    private int cant;

    public Ejercicio3(String palabra) {
        this.palabra = palabra;
        hilo = new Thread(this);
        hilo.start();
        while (hilo.isAlive()) {
        }
        System.out.println("La palabra " + palabra + " se encuentra contenida en " + cant + " archivos");
    }

    @Override
    public void run() {
        File f = new File("F:\\");
        String[] directorio = f.list();
        for (String arch : directorio) {
            if (tiene(arch)) cant++;
        }
    }

    private synchronized boolean tiene(String archivo) {
        boolean existe = false;
        try {
            FileReader fr = new FileReader("F:\\ULACIT\\" + archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                if (linea.indexOf(palabra) != -1) {
                    existe = true;
                }
                linea = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return existe;
    }

    public static void main(String[] ar) {
        new Ejercicio3("verde");
    }
}
