package com.mycompany.ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la primer cadena: ");
        String cad1 = teclado.nextLine();

        System.out.print("Ingrese la segunda cadena: ");
        String cad2 = teclado.nextLine();

        // Comparación exacta
        if (cad1.equals(cad2)) {
            System.out.println(cad1 + " es exactamente igual a " + cad2);
        } else {
            System.out.println(cad1 + " no es exactamente igual a " + cad2);
        }

        // Comparación sin importar mayúsculas/minúsculas
        if (cad1.equalsIgnoreCase(cad2)) {
            System.out.println(cad1 + " es igual a " + cad2 + " sin tener en cuenta mayúsculas/minúsculas");
        } else {
            System.out.println(cad1 + " no es igual a " + cad2 + " sin tener en cuenta mayúsculas/minúsculas");
        }

        // Comparación alfabética
        int comp = cad1.compareTo(cad2);
        if (comp == 0) {
            System.out.println(cad1 + " es exactamente igual a " + cad2);
        } else if (comp > 0) {
            System.out.println(cad1 + " es mayor alfabéticamente que " + cad2);
        } else {
            System.out.println(cad2 + " es mayor alfabéticamente que " + cad1);
        }

        // Primer carácter
        char carac1 = cad1.charAt(0);
        System.out.println("El primer carácter de " + cad1 + " es " + carac1);

        // Largo de la cadena
        int largo = cad1.length();
        System.out.println("El largo del String " + cad1 + " es " + largo);

        // Subcadena (primeros tres caracteres si hay suficientes)
        String cad3 = cad1.length() >= 3 ? cad1.substring(0, 3) : cad1;
        System.out.println("Los primeros tres caracteres de " + cad1 + " son " + cad3);

        // Verificar si cad2 está contenida en cad1
        int posi = cad1.indexOf(cad2);
        if (posi == -1) {
            System.out.println(cad2 + " no está contenido en " + cad1);
        } else {
            System.out.println(cad2 + " está contenido en " + cad1 + " a partir de la posición " + posi);
        }

        // Conversión a mayúsculas y minúsculas
        System.out.println(cad1 + " convertido a mayúsculas es " + cad1.toUpperCase());
        System.out.println(cad1 + " convertido a minúsculas es " + cad1.toLowerCase());

        teclado.close();
    }
}
