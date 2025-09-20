package com.mycompany.ejercicio6;

public class JuegoDados {
    private Dado dado1, dado2, dado3;
    
    public JuegoDados() {
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
    }
    
    public void jugar() {
        dado1.tirar();
        dado2.tirar();
        dado3.tirar();
        
        System.out.println("Resultados de los dados:");
        dado1.imprimir();
        dado2.imprimir();
        dado3.imprimir();
        
        if (dado1.retornarValor() == dado2.retornarValor() && 
            dado2.retornarValor() == dado3.retornarValor()) {
            System.out.println("¡Ganó!");
        } else {
            System.out.println("Perdió");
        }
    }
}