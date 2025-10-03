package com.mycompany.ejercicio2;

import java.util.Scanner;

public class Persona {

    Scanner teclado;
    String nombre;
    int edad;

    void cargarDatosPersonales() {
        teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        nombre = teclado.next();
        System.out.print("Ingrese edad: ");
        edad = teclado.nextInt();
    }

    void imprimirDatosPersonales() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}


