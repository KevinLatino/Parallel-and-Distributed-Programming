package com.mycompany.ejercicio5;

public class ClaseExterna {
    
   
    public static class ClaseInterna {
        
    
        public void imprimir() {
            System.out.println("Impresión desde la ClaseInternaEstática");
        }
    }
   
    public void imprimir() {
        System.out.println("Impresión desde la ClaseExterna");
    }
}