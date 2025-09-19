/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Ejercicio1 {
    private Scanner teclado;
    private int[] sueldos;

    public Ejercicio1() {
        teclado = new Scanner(System.in);
        sueldos = new int[5];
        for (int f = 0; f < 5; f++) {
            System.out.print("Ingrese el sueldo del operario " + (f+1) + ": ");
            sueldos[f] = teclado.nextInt();
        }
    }

    public void imprimir() {
        System.out.println("\n--- Sueldos de los operarios ---");
        for (int f = 0; f < 5; f++) {
            System.out.println("Operario " + (f+1) + ": " + sueldos[f]);
        }
    }

    public static void main(String[] args) {
        Ejercicio1 op = new Ejercicio1();
        op.imprimir();
    }
}
