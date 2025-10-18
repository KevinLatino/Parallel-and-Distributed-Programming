package com.mycompany.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String id;
    private String ruta;
    private int capacidad;
    private List<Pasajero> pasajeros;
    
    public Bus(String id, String ruta, int capacidad) {
        this.id = id;
        this.ruta = ruta;
        this.capacidad = capacidad;
        this.pasajeros = new ArrayList<>();
    }
    
    public String getRuta() { return ruta; }
    public boolean tieneEspacio() { return pasajeros.size() < capacidad; }
    
    public boolean embarcar(Pasajero p) {
        if (tieneEspacio()) {
            pasajeros.add(p);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Bus " + id + " [" + ruta + "] - " + pasajeros.size() + "/" + capacidad;
    }
}


