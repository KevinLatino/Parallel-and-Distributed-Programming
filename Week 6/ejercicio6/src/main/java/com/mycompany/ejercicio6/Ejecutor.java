package com.mycompany.ejercicio6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ejecutor {
    
    // Variable para controlar si el sistema sigue activo
    public static boolean systemIsAlive = true;
    
    // ExecutorService que crea un pool de hilos en caché
    // Reutiliza hilos disponibles y crea nuevos según sea necesario
    public static ExecutorService service = Executors.newCachedThreadPool();
    
    // Matriz de obstáculos: 5 equipos x 10 posiciones
    public static int[][] obstacles = new int[5][10];
}