package com.mycompany.ejercicio1;

public class Ejercicio1 {
    public static void main(String[] args) {
        float valor1 = 10;
        float valor2 = 20;
        Operaciones operacion;
        operacion=Operaciones.SUMA;
        if (operacion == Operaciones.SUMA) {
            float suma = valor1 + valor2;
            System.out.println("El resultado de la suma es "+ suma);
        }
        operacion=Operaciones.RESTA;
        if (operacion == Operaciones.RESTA) {
            float resta = valor1 - valor2;
            System.out.println("El resultado de la resta es "+ resta);
        }

        operacion=Operaciones.MULTIPLICACION;
        if (operacion == Operaciones.MULTIPLICACION) {
            float mult = valor1 * valor2;
            System.out.println("El resultado de la multiplicacion es "+ mult);
        }
        operacion=Operaciones.DIVISION;
        if (operacion == Operaciones.DIVISION) {
            float divi = valor1 / valor2;
            System.out.println("El resultado de la división es "+ divi);
        }
    }
}
