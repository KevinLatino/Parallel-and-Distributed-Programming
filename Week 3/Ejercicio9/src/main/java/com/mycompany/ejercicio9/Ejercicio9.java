package com.mycompany.ejercicio9;

import java.util.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        // Creando la lista de matrices (libros)
        ArrayList<String> libros = new ArrayList<String>();
        
        // Agregar libros a la biblioteca
        libros.add("The Sniper");
        libros.add("A Time to Kill");
        libros.add("The House of Mirth");
        libros.add("East of Eden");
        
        // Mostrar la lista completa
        System.out.println("Libros en la biblioteca: " + libros);
        
        // Recorriendo la lista a través del Iterador
        System.out.println("Recorriendo la biblioteca:");
        Iterator<String> itr = libros.iterator();
        
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}