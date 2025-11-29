package com.mycompany.ejercicio2;

import java.util.ArrayList;

public class Coordenadas {
    private class Punto {
        private int x, y;

        public Punto(int x, int y) {
            fijarX(x);
            fijarY(y);
        }

        public void fijarX(int x) {
            this.x = x;
        }

        public void fijarY(int y) {
            this.y = y;
        }

        public int retornarCuadrante() {
            if (x > 0 && y > 0)
                return 1;
            else if (x < 0 && y > 0)
                return 2;
            else if (x < 0 && y < 0)
                return 3;
            else if (x > 0 && y < 0)
                return 4;
            else
                return -1;
        }
    }

    private ArrayList<Punto> puntos;

    public Coordenadas() {
        puntos = new ArrayList<Punto>();
    }

    public void agregarPunto(int x, int y) {
        puntos.add(new Punto(x, y));
    }

    public int cantidadPuntosCuadrante(int cuadrante) {
        int cant = 0;
        for (Punto pun : puntos)
            if (pun.retornarCuadrante() == cuadrante)
                cant++;
        return cant;
    }
}
