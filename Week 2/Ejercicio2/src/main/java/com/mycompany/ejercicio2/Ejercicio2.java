/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    private Scanner teclado;
    private String nombre;
    private int edad;
    
    public Ejercicio2() {
        teclado = new Scanner(System.in);
        System.out.print("Ingrese nombre:");
        nombre = teclado.next();
        System.out.print("Ingrese edad:");
        edad = teclado.nextInt();
    }
    
    public void imprimir() {
        System.out.println("Nombre:" + nombre);
        System.out.println("Edad:" + edad);
    }
    
    public void esMayorEdad() {
        if (edad >= 18) {
            System.out.print(nombre + " es mayor de edad.");
        } else {
            System.out.print(nombre + " no es mayor de edad.");
        }
    }
    
    public static void main(String[] ar) {
        Ejercicio2 alumno1 = new Ejercicio2();
        alumno1.imprimir();
        alumno1.esMayorEdad();
    }
}