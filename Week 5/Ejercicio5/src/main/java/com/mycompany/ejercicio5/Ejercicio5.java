package com.mycompany.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio5 extends Thread {
    String nombre;

    public Ejercicio5(int prioridad, String nombre) {
        this.nombre = nombre;
        setPriority(prioridad);
    }

    public void run() {
        for (int metros = 1; metros <= 10; metros++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(metros + "m ");
        }
        System.out.println("\nLlego a la meta: " + nombre);
    }

    public static void main(String[] args) throws InterruptedException {
        Ejercicio5 leopardo;
        Ejercicio5 conejo;
        Ejercicio5 tortuga;

        conejo = new Ejercicio5(8, "CONEJO");
        leopardo = new Ejercicio5(10, "LEOPARDO");
        tortuga = new Ejercicio5(1, "TORTUGA");

        conejo.start();
        leopardo.start();
        tortuga.start();

        conejo.join();
        leopardo.join();
        tortuga.join();
    }
}
