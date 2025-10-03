package com.mycompany.ejercicio4;

public class Suma extends Operacion {
    
    public Suma(int valor1, int valor2) {
        super(valor1, valor2);
    }
    
    @Override
    public void operar() {
        resultado = valor1 + valor2;
    }
}