package com.mycompany.ejercicio8;

public class Ejercicio8 {
    
    public static void main(String[] args) {
        // Crear la interfaz gráfica con 4 carros
        Interfaz ventana = new Interfaz();
        ventana.setSize(700, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Pista Carros - 4 Competidores");
        ventana.setVisible(true);
    }
}