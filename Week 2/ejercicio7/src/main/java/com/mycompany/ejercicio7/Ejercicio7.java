package com.mycompany.ejercicio7;

public class Ejercicio7 {
    
    private int hora; 
    private int minuto;
    private int segundo; 
    
    public Ejercicio7() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }
    
    public Ejercicio7(int hora, int minuto, int segundo) {
        establecerTiempo(hora, minuto, segundo);
    }
    
    
    public void establecerTiempo(int hora, int minuto, int segundo) {
        if (hora < 0 || hora >= 24 || minuto < 0 || minuto >= 60 || segundo < 0 || segundo >= 60) {
            throw new IllegalArgumentException("hora, minuto y/o segundo estaban fuera de rango");
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
    
    public String toString() {
        return String.format("%d:%02d:%02d %s", ((hora == 0 || hora == 12) ? 12 : hora % 12),
                minuto, segundo, (hora < 12 ? "AM" : "PM"));
    }
    
    private static void mostrarTiempo(String encabezado, Ejercicio7 t) {
        System.out.printf("%s%nTiempo universal: %s%nTiempo estandar: %s%n",
                encabezado, t.aStringUniversal(), t.toString());
    }
    
    public static void main(String[] args) {
        Ejercicio7 tiempo = new Ejercicio7(); 
        
        mostrarTiempo("Despues de crear el objeto tiempo", tiempo);
        System.out.println();
        
        tiempo.establecerTiempo(13, 27, 6);
        mostrarTiempo("Despues de llamar a establecerTiempo", tiempo);
        System.out.println();
        
        try {
            tiempo.establecerTiempo(99, 99, 99); 
        }
        catch (IllegalArgumentException e) {
            System.out.printf("Excepcion: %s%n%n", e.getMessage());
        }
        
        mostrarTiempo("Despues de llamar a establecerTiempo con valores invalidos", tiempo);
    }
}