package com.mycompany.ejercicio3;

// Enumeración que representa los 12 meses del año
// Cada constante tiene asociado un número de mes (1-12)
public enum Mes {
    // Definición de las constantes del enum con sus valores numéricos
    // En Java NO se usan parámetros nombrados, solo se pasa el valor
    ENERO(1), 
    FEBRERO(2), 
    MARZO(3), 
    ABRIL(4), 
    MAYO(5),
    JUNIO(6), 
    JULIO(7), 
    AGOSTO(8), 
    SEPTIEMBRE(9), 
    OCTUBRE(10),
    NOVIEMBRE(11), 
    DICIEMBRE(12);
    
    // Campo privado que almacena el número del mes
    private final int numero;
    
    // Constructor del enum que asigna el número a cada mes
    // Los constructores de enum siempre son privados (implícitamente)
    Mes(int numero) {
        this.numero = numero;
    }
    
    // Método getter que retorna el número del mes
    public int retornarNumero() {
        return numero;
    }
}