package com.mycompany.ejercicio4;


public class ClaseExterna {
    
  
    public class ClaseInterna {
        
      
        public void imprimir() {
            System.out.println("Impresión desde ClaseInterna");
        }
    }
    
    public void imprimir() {
        System.out.println("Impresión desde ClaseExterna");
    }
}