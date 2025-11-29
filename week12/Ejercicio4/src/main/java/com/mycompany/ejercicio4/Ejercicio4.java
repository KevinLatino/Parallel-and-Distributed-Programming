package com.mycompany.ejercicio4;


public class Ejercicio4 {
    
   
    public static void main(String[] args) {
        ClaseExterna externa = new ClaseExterna();
        
        ClaseExterna.ClaseInterna interna = externa.new ClaseInterna();
        
        interna.imprimir();
        
        externa.imprimir();
    }
}
