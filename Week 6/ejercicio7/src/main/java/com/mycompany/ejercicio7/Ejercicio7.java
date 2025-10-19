package com.mycompany.ejercicio7;

public class Ejercicio7 {
    
    public static void main(String[] args) {
        // Crear la interfaz gráfica
        Interfaz ventana = new Interfaz();
        ventana.setSize(700, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Pista Carros");
        ventana.setVisible(true);
    }
}