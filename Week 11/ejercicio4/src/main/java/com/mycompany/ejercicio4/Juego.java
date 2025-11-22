package com.mycompany.ejercicio4;

// Interfaz que define el contrato que todos los juegos deben cumplir
// Una interfaz establece QUÉ métodos debe tener una clase, pero no CÓMO implementarlos
public interface Juego {
    // Método para inicializar el juego (configuración inicial)
    void iniciar();
    
    // Método para ejecutar la lógica principal del juego
    void jugar();
    
    // Método para finalizar el juego (mostrar resultados, limpiar recursos, etc.)
    void finalizar();
}