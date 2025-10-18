package com.mycompany.ejercicio1;

public class Ejercicio1 {
    public void mostrar0() {
        for (int f = 1; f <= 1000; f++)
            System.out.print("0-");
    }

    public void mostrar1() {
        for (int f = 1; f <= 1000; f++)
            System.out.print("1-");
    }

    public static void main(String[] args) {
        Ejercicio1 llamar = new Ejercicio1();
        llamar.mostrar0();
        llamar.mostrar1();
    }
}
