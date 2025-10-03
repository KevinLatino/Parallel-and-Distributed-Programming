package com.mycompany.ejercicio2;

import java.util.Scanner;

public class Empleado extends Persona {

    int sueldo;

    void cargarSueldo() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su sueldo: ");
        sueldo = teclado.nextInt();
    }

    void imprimirSueldo() {
        System.out.println("El sueldo es: " + sueldo);
    }
}


