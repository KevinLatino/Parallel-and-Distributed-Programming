package com.mycompany.ejercicio5;

import java.time.LocalTime;

public class Pasajero implements Comparable<Pasajero> {
    private String id;
    private String ruta;
    private Prioridad prioridad;
    private LocalTime horaLlegada;
    
    public Pasajero(String id, String ruta, Prioridad prioridad, LocalTime horaLlegada) {
        this.id = id;
        this.ruta = ruta;
        this.prioridad = prioridad;
        this.horaLlegada = horaLlegada;
    }
    
    public String getId() { return id; }
    public String getRuta() { return ruta; }
    public Prioridad getPrioridad() { return prioridad; }
    
    @Override
    public int compareTo(Pasajero otro) {
        int cmp = this.prioridad.compareTo(otro.prioridad);
        return cmp != 0 ? cmp : this.horaLlegada.compareTo(otro.horaLlegada);
    }
    
    @Override
    public String toString() {
        return id + " (" + ruta + ", " + prioridad + ", " + horaLlegada + ")";
    }
}


