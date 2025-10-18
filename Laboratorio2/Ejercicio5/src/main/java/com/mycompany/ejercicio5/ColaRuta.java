package com.mycompany.ejercicio5;

import java.util.PriorityQueue;
import java.util.Iterator;

public class ColaRuta {
    private String ruta;
    private PriorityQueue<Pasajero> cola;
    
    public ColaRuta(String ruta) {
        this.ruta = ruta;
        this.cola = new PriorityQueue<>();
    }
    
    public boolean offer(Pasajero p) {
        return cola.offer(p);
    }
    
    public Pasajero poll() {
        return cola.poll();
    }
    
    public Pasajero peek() {
        return cola.peek();
    }
    
    public boolean isEmpty() {
        return cola.isEmpty();
    }
    
    public int size() {
        return cola.size();
    }
    
    public boolean removerPorId(String id) {
        Iterator<Pasajero> it = cola.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    public String getRuta() { return ruta; }
}


