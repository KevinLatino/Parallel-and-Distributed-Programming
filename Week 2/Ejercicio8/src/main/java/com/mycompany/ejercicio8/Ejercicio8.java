/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio8;

public class Ejercicio8 {
    public static void main(String[] args) {
        Circulo circulo = new Circulo("Circulo1", 5);
        Rectangulo rectangulo = new Rectangulo("Rectangulo1", 4, 6);
        
        System.out.println("El area del circulo es: " + circulo.calcularArea());
        System.out.println("El perimetro del circulo es: " + circulo.calcularPerimetro());
        
        System.out.println("El area del rectangulo es: " + rectangulo.calcularArea());
        System.out.println("El perimetro del rectangulo es: " + rectangulo.calcularPerimetro());
    }
}