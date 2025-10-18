package com.mycompany.ejercicio5;

import java.util.HashMap;
import java.util.Map;

public class Estacion {
    private Map<String, ColaRuta> colas;
    
    public Estacion() {
        this.colas = new HashMap<>();
    }
    
    public void agregarPasajero(Pasajero p) {
        colas.putIfAbsent(p.getRuta(), new ColaRuta(p.getRuta()));
        colas.get(p.getRuta()).offer(p);
        System.out.println("Agregado: " + p);
    }
    
    public void procesarBus(Bus bus) {
        System.out.println("\n" + bus + " llega");
        ColaRuta cola = colas.get(bus.getRuta());
        
        if (cola == null || cola.isEmpty()) {
            System.out.println("No hay pasajeros esperando");
            return;
        }
        
        int embarcados = 0;
        while (bus.tieneEspacio() && !cola.isEmpty()) {
            Pasajero p = cola.poll();
            if (bus.embarcar(p)) {
                System.out.println("  Embarco: " + p);
                embarcados++;
            }
        }
        
        System.out.println("Total embarcados: " + embarcados);
        if (!cola.isEmpty()) {
            System.out.println("Quedan " + cola.size() + " pasajeros esperando");
        }
    }
    
    public void retirarPasajero(String ruta, String id) {
        ColaRuta cola = colas.get(ruta);
        if (cola != null && cola.removerPorId(id)) {
            System.out.println("Pasajero " + id + " retirado de " + ruta);
        }
    }
    
    public void mostrarEstado() {
        System.out.println("\n=== ESTADO ESTACION ===");
        for (ColaRuta cola : colas.values()) {
            System.out.println("Ruta " + cola.getRuta() + ": " + cola.size() + " pasajeros");
            if (!cola.isEmpty()) {
                System.out.println("  Frente: " + cola.peek());
            }
        }
    }
}


