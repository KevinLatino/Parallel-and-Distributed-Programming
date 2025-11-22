package com.mycompany.ejercicio3;

// Clase principal que demuestra el uso de la enumeración Mes
public class Ejercicio3 {
    
    public static void main(String[] args) {
        // Iteramos sobre todos los valores del enum Mes
        // Mes.values() retorna un array con todas las constantes del enum
        for (Mes mes : Mes.values()) {
            // Imprimimos cada mes junto con su número correspondiente
            System.out.println(mes + " " + mes.retornarNumero());
        }
    }
}