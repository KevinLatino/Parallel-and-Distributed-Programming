package com.mycompany.ejercicio4;

public class Resta extends Operacion {
    
    public Resta(int valor1, int valor2) {
        super(valor1, valor2);
    }
    
    @Override
    public void operar() {
        resultado = valor1 - valor2;
    }
}