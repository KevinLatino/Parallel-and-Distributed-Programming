package com.mycompany.ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {
        HiloMostrarCero hilo1 = new HiloMostrarCero();
        hilo1.start();
        HiloMostrarUno hilo2 = new HiloMostrarUno();
        hilo2.start();
    }
}

class HiloMostrarCero extends Thread {
    @Override
    public void run() {
        for (int f = 1; f <= 1000; f++) {
            System.out.print("0-");
        }
    }
}

class HiloMostrarUno extends Thread {
    @Override
    public void run() {
        for (int f = 1; f <= 1000; f++) {
            System.out.print("1-");
        }
    }
}
