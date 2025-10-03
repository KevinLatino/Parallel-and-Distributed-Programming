package com.mycompany.ejercicio4;

public abstract class Operacion {
    protected int valor1, valor2, resultado;
    
    public Operacion(int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    
    public void imprimir() {
        System.out.println("Resultado: " + resultado);
    }
    
    public abstract void operar();
}