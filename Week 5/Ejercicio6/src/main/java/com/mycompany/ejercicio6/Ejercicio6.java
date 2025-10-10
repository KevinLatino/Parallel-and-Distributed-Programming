package com.mycompany.ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio6 extends Thread {
    private String nombre;

    public Ejercicio6(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        for (int pan = 1; pan <= 3; pan++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio6.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nombre + " come un " + pan + " pan con queso");
        }
        System.out.printf("%s terminó\n", nombre);
    }

    public static void main(String[] args) {
        String[] nombres = {"Papa pitufo", "Pitufina", "Filosofo", "Pintor", "Gruñón"};
        for (String nombre : nombres) {
            Ejercicio6 pitufo = new Ejercicio6(nombre);
            Thread hilo = new Thread(pitufo);
            hilo.start();
        }
    }
}
