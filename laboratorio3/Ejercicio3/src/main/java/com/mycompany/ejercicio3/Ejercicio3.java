/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kevinlatinomarin
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        // Crear lista con los valores 2, 4, 6, 8, 10
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(4);
        numeros.add(6);
        numeros.add(8);
        numeros.add(10);

        Scanner sc = new Scanner(System.in);
        System.out.println("Lista actual: " + numeros);

        // Pedir número al usuario
        System.out.print("Ingrese un número para buscar: ");
        int numeroBuscado = sc.nextInt();

        // Buscar número
        int posicion = numeros.indexOf(numeroBuscado);

        if (posicion != -1) {
            System.out.println("El número " + numeroBuscado + " se encuentra en la posición " + posicion);
        } else {
            System.out.println("El número " + numeroBuscado + " no se encontró en la lista.");
        }

        // Eliminar el número 6
        numeros.remove(Integer.valueOf(6));
        System.out.println("Lista después de eliminar el número 6: " + numeros);
    }
}
