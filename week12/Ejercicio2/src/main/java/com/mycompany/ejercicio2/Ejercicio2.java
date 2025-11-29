package com.mycompany.ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Coordenadas coordenadas = new Coordenadas();
        coordenadas.agregarPunto(30, 30);
        coordenadas.agregarPunto(2, 7);
        coordenadas.agregarPunto(-3, 2);
        coordenadas.agregarPunto(-5, -4);
        coordenadas.agregarPunto(-9, -2);
        System.out.println("Cantidad de puntos en el primer cuadrante:" + coordenadas.cantidadPuntosCuadrante(1));
        System.out.println("Cantidad de puntos en el segundo cuadrante:" + coordenadas.cantidadPuntosCuadrante(2));
        System.out.println("Cantidad de puntos en el tercer cuadrante:" + coordenadas.cantidadPuntosCuadrante(3));
        System.out.println("Cantidad de puntos en el cuarto cuadrante:" + coordenadas.cantidadPuntosCuadrante(4));
    }
}
