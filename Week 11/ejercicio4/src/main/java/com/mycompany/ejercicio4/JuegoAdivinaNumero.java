package com.mycompany.ejercicio4;

import java.util.Scanner;

// Segunda implementación de la interfaz Juego
// Demuestra cómo diferentes clases pueden implementar la misma interfaz de formas distintas
public class JuegoAdivinaNumero implements Juego {
    // Atributos privados
    private int numAdivina;     // Número secreto que el jugador debe adivinar
    private final Scanner teclado;    // Scanner para leer entrada del usuario
    private int intentos;       // Contador de intentos del jugador
    
    // Constructor: inicializa el Scanner
    public JuegoAdivinaNumero() {
        teclado = new Scanner(System.in);
    }
    
    // Implementación del método iniciar() de la interfaz Juego
    // Genera el número aleatorio entre 1 y 100 que el jugador debe adivinar
    public void iniciar() {
        // Genera un número aleatorio entre 1 y 100
        numAdivina = 1 + (int) (Math.random() * 100);
    }
    
    // Implementación del método jugar() de la interfaz Juego
    // Bucle que permite al jugador intentar adivinar el número
    public void jugar() {
        int numero;  // Variable para almacenar cada intento del jugador
        
        // Bucle do-while: se ejecuta al menos una vez y continúa hasta que se adivine el número
        do {
            System.out.print("Adivina un número entre 1 y 100: ");
            numero = teclado.nextInt();
            
            // Comparamos el número ingresado con el número secreto
            if (numAdivina < numero)
                System.out.println("El número a adivinar es menor");
            else if (numAdivina > numero)
                System.out.println("El número a adivinar es mayor");
            
            // Incrementamos el contador de intentos
            intentos++;
            
        } while (numero != numAdivina);  // Continúa hasta que el número sea correcto
    }
    
    // Implementación del método finalizar() de la interfaz Juego
    // Muestra el mensaje de victoria con el número de intentos
    public void finalizar() {
        System.out.println("Ganaste luego de " + intentos + " intentos");
    }
}