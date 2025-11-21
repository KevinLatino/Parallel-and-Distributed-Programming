package com.mycompany.ejercicio2;

public class Mazo {
    private Carta[] cartas;

    Mazo() {
        cartas = new Carta[8];
        cartas[0] = new Carta(1, Carta.Palo.TREBOL);
        cartas[1] = new Carta(2, Carta.Palo.TREBOL);
        cartas[2] = new Carta(1, Carta.Palo.DIAMANTE);
        cartas[3] = new Carta(2, Carta.Palo.DIAMANTE);
        cartas[4] = new Carta(1, Carta.Palo.PICA);
        cartas[5] = new Carta(2, Carta.Palo.PICA);
        cartas[6] = new Carta(1, Carta.Palo.CORAZON);
        cartas[7] = new Carta(2, Carta.Palo.CORAZON);
    }

    public void imprimir() {
        System.out.println("Listado completo del mazo de cartas");
        for (Carta carta : cartas)
            carta.imprimir();
    }

    public void sacarUnaCartas() {
        System.out.println("Una carta elegida al azar");
        Carta carta = cartas[(int) (Math.random() * 8)];
        carta.imprimir();
        switch (carta.retornarPalo()) {
        case CORAZON:
            System.out.println("Gana 4 puntos");
            break;
        case DIAMANTE:
            System.out.println("Gana 3 puntos");
            break;
        case PICA:
            System.out.println("Gana 2 puntos");
            break;
        case TREBOL:
            System.out.println("Gana 1 puntos");
            break;
        }
    }
}
