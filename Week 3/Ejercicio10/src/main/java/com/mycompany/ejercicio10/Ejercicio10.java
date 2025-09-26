/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio10;

import java.util.*;

public class Ejercicio10 {

    public static void main(String[] args) {
        HashSet<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(3);
        numeros.add(2);

        Iterator<Integer> i = numeros.iterator();

        System.out.println("Los elementos en el HashSet son:");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}