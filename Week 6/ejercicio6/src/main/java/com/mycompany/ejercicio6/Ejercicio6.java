package com.mycompany.ejercicio6;

public class Ejercicio6 {
    
    public static void main(String[] args) {
        // Crear y enviar 5 corredores al ExecutorService
        Ejecutor.service.submit(new Corredor(1, 1));
        Ejecutor.service.submit(new Corredor(1, 2));
        Ejecutor.service.submit(new Corredor(1, 3));
        Ejecutor.service.submit(new Corredor(1, 4));
        Ejecutor.service.submit(new Corredor(1, 5));
        
        // Crear y enviar el generador de obstáculos
        Ejecutor.service.submit(new Obstaculos());
    }
}