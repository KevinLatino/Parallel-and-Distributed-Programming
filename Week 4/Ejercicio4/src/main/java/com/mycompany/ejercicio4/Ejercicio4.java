package com.mycompany.ejercicio4;

import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Operacion> lista1 = new ArrayList<>();
        
        lista1.add(new Suma(2, 34));
        lista1.add(new Resta(3, 2));
        lista1.add(new Suma(100, 1));
        
        for (Operacion op : lista1) {
            op.operar();
            op.imprimir();
        }
    }
}