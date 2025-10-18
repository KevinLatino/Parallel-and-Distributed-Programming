package com.mycompany.ejercicio4;

public class Ejercicio4 extends Thread {
    public int i;
    private String identidad;

    public void nombre(String identidad) {
        this.identidad = identidad;
    }

    public void run() {
        for (i = 1; i < 11; i++) {
            System.out.println(i + " ");
            try {
                sleep(0);
            } catch (InterruptedException ex) {
            }
        }
    }

    public synchronized void impares() {
        for (i = 1; i < 10; i++) {
            System.out.print(identidad + " " + i + " ");
            i++;
        }
    }

    public static void main(String[] args) {
        Thread num1 = new Ejercicio4();
        Ejercicio4 num2 = new Ejercicio4();
        num2.nombre("Impar --> ");
        num1.start();
        System.out.println("\n");
        try {
            num2.impares();
            System.out.println("\n");
            num2.sleep(0);
        } catch (Exception ex) {
        }
    }
}
