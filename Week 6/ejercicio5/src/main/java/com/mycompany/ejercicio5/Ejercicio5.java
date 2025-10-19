package com.mycompany.ejercicio5;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Crear los tres hilos
        Thread th1 = new Thread("th1");
        Thread th2 = new Thread("th2");
        Thread th3 = new Thread("th3");
        
        // Iniciar el primer hilo inmediatamente
        th1.start();
        System.out.println("Hilo 1 iniciándose");
        
        // Iniciar el segundo hilo (th2) una vez que el primer hilo (th1) esté muerto
        try {
            th1.join(); // Espera a que th1 termine
            System.out.println("Hilo 1 uniéndose");
        } catch (InterruptedException ie) {
        }
        
        th2.start();
        System.out.println("Hilo 2 iniciándose");
        
        // Iniciar tercer hilo (th3) una vez que el segundo hilo (th2) esté muerto
        try {
            th2.join(); // Espera a que th2 termine
            System.out.println("Hilo 2 uniéndose");
        } catch (InterruptedException ie) {
        }
        
        th3.start();
        System.out.println("Hilo 3 iniciándose");
        
        // Esperar a que el tercer hilo termine para mostrar el mensaje final
        try {
            th3.join(); // Espera a que th3 termine
            System.out.println("Hilo 3 uniéndose");
        } catch (InterruptedException ie) {
        }
        
        System.out.println("Los tres hilos han terminado su ejecución");
    }
}