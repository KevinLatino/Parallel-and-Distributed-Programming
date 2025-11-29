package com.mycompany.ejercicio3;

public class Ejercicio3 {
    private String jugador;
    private Dado dado1;

    private class Dado {
        private int valor = 1;

        public void tirar() throws Exception {
            if (jugador == null)
                throw new Exception("No hay jugador seleccionado");
            valor = 1 + (int) (Math.random() * 6);
        }

        public void imprimir() {
            System.out.println("Al jugador " + jugador + " le salió el valor:" + valor);
        }
    }

    public Ejercicio3() {
        dado1 = new Dado();
    }

    public void jugar() {
        try {
            jugador = "Pedro";
            dado1.tirar();
            dado1.imprimir();
            jugador = "Ana";
            dado1.tirar();
            dado1.imprimir();
            jugador = null;
            dado1.tirar();
            dado1.imprimir();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] ar) {
        Ejercicio3 juegoDeDados = new Ejercicio3();
        juegoDeDados.jugar();
    }
}
