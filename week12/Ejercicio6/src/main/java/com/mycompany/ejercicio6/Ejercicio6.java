package com.mycompany.ejercicio6;


public class Ejercicio6 {
    
   
    abstract class A {
        public abstract void imprimir();
    }
    

    interface B {
        void imprimir();
    }

    public void probar() {
        
        (new A() {
            @Override
            public void imprimir() {
                System.out.println("Clase");
            }
        }).imprimir();
        
        
        (new B() {
            @Override
            public void imprimir() {
                System.out.println("Interface");
            }
        }).imprimir();
    }
    
   
    public static void main(String[] args) {
        Ejercicio6 p = new Ejercicio6();
        p.probar();
    }
}