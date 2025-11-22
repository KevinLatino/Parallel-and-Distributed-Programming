package com.mycompany.ejercicio4;

// Clase principal que demuestra el uso del polimorfismo con interfaces
public class Ejercicio4 {
    
    public static void main(String[] args) {
        // === PRIMER JUEGO: Juego de Dados ===
        // Creamos una instancia del juego de dados
        JuegoDeDados juego1 = new JuegoDeDados();
        
        // Ejecutamos los tres pasos del juego según la interfaz
        juego1.iniciar();      // Solicita nombres de jugadores
        juego1.jugar();        // Lanza los dados
        juego1.finalizar();    // Muestra el ganador
        
        System.out.println();  // Línea en blanco para separar los juegos
        
        // === SEGUNDO JUEGO: Adivina el Número ===
        // Creamos una instancia del juego de adivinanza
        JuegoAdivinaNumero juego2 = new JuegoAdivinaNumero();
        
        // Ejecutamos los tres pasos del juego según la interfaz
        juego2.iniciar();      // Genera el número secreto
        juego2.jugar();        // Permite al jugador adivinar
        juego2.finalizar();    // Muestra el mensaje de victoria
    }
}