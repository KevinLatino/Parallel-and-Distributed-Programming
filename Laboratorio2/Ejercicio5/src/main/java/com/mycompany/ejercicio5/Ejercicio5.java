package com.mycompany.ejercicio5;

import java.time.LocalTime;

public class Ejercicio5 {

    public static void main(String[] args) {
        Estacion estacion = new Estacion();
        
        System.out.println("=== PARADA DE AUTOBUSES ===\n");
        
        estacion.agregarPasajero(new Pasajero("P1", "R1", Prioridad.REGULAR, LocalTime.of(8,0)));
        estacion.agregarPasajero(new Pasajero("P2", "R1", Prioridad.ALTA, LocalTime.of(8,1)));
        estacion.agregarPasajero(new Pasajero("P3", "R1", Prioridad.REGULAR, LocalTime.of(8,2)));
        estacion.agregarPasajero(new Pasajero("P4", "R1", Prioridad.ALTA, LocalTime.of(8,3)));
        estacion.agregarPasajero(new Pasajero("P5", "R2", Prioridad.REGULAR, LocalTime.of(8,0)));
        estacion.agregarPasajero(new Pasajero("P6", "R2", Prioridad.ALTA, LocalTime.of(8,1)));
        
        estacion.mostrarEstado();
        
        estacion.retirarPasajero("R1", "P3");
        
        estacion.procesarBus(new Bus("B1", "R1", 2));
        estacion.procesarBus(new Bus("B2", "R1", 5));
        estacion.procesarBus(new Bus("B3", "R2", 10));
        
        estacion.mostrarEstado();
    }
}
