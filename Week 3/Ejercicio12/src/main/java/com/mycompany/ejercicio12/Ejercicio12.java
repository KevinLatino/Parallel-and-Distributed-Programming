package com.mycompany.ejercicio12;

import java.util.*;

public class Ejercicio12 {
    public static void main(String[] args) {
        // Creando un HashMap
        HashMap<Integer, String> diccionario = new HashMap<Integer, String>();
        
        // Poner elementos en el diccionario
        diccionario.put(1, "Inglaterra");
        diccionario.put(7, "Italia");
        diccionario.put(3, "Países Bajos");
        diccionario.put(6, "Alemania");
        diccionario.put(5, "Francia");
        diccionario.put(4, "España");
        diccionario.put(2, "Bélgica");
        
        // Imprimir el diccionario completo
        System.out.println(diccionario);
        
        // Obtener elementos según el índice
        System.out.println("El valor del índice 6 es: " + diccionario.get(6));
        System.out.println("El valor del índice 4 es: " + diccionario.get(4));
        System.out.println("El valor del índice 2 es: " + diccionario.get(2));
        
        System.out.println("Recorriendo el diccionario:");
        // Recorrer el diccionario
        for (Map.Entry<Integer, String> m : diccionario.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}