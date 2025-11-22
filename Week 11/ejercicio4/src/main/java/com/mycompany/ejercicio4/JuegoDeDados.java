package com.mycompany.ejercicio4;

import java.util.Scanner;

// Clase que implementa la interfaz Juego
// "implements Juego" significa que esta clase DEBE implementar todos los métodos de la interfaz
public class JuegoDeDados implements Juego {
    // Atributos privados para almacenar el estado del juego
    private int dado1, dado2;           // Valores de los dos dados
    private String jugador1;            // Nombre del primer jugador
    private String jugador2;            // Nombre del segundo jugador
    private Scanner teclado;            // Scanner para leer entrada del usuario
    
    // Constructor: inicializa el Scanner
    public JuegoDeDados() {
        teclado = new Scanner(System.in);
    }
    
    // Implementación del método iniciar() de la interfaz Juego
    // Este método solicita los nombres de los jugadores
    public void iniciar() {
        System.out.print("Ingrese el nombre del primer jugador: ");
        jugador1 = teclado.nextLine();
        System.out.print("Ingrese el nombre del segundo jugador: ");
        jugador2 = teclado.nextLine();
    }
    
    // Implementación del método jugar() de la interfaz Juego
    // Simula el lanzamiento de dos dados (valores aleatorios entre 1 y 6)
    public void jugar() {
        // Math.random() genera un número entre 0.0 y 1.0
        // Multiplicamos por 6 para obtener un rango de 0.0 a 5.999...
        // Convertimos a int (trunca los decimales) y sumamos 1 para obtener valores de 1 a 6
        dado1 = 1 + (int) (Math.random() * 6);
        dado2 = 1 + (int) (Math.random() * 6);
        
        // Mostramos los resultados de cada jugador
        System.out.println(jugador1 + " le salió el valor " + dado1);
        System.out.println(jugador2 + " le salió el valor " + dado2);
    }
    
    // Implementación del método finalizar() de la interfaz Juego
    // Determina y muestra quién ganó comparando los valores de los dados
    @Override
    public void finalizar() {
        if (dado1 > dado2)
            System.out.println("Gano " + jugador1 + " con un valor de " + dado1);
        else if (dado2 > dado1)
            System.out.println("Gano " + jugador2 + " con un valor de " + dado2);
        else
            System.out.println("Empataron los dos jugadores con el valor " + dado1);
    }
}