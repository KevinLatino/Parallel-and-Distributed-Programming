/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

/**
 *
 * @author alejandroquesadaruiz
 */
public class Ejercicio1 {

    // Clase interna Nodo
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Atributos de la lista
    private Nodo cabeza;
    private int tamaño;

    // Constructor
    public Ejercicio1() {
        cabeza = null;
        tamaño = 0;
    }

    // Insertar al inicio
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    // Insertar al final
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    // Eliminar el primer nodo
    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            tamaño--;
        } else {
            System.out.println("La lista está vacía, no se puede eliminar.");
        }
    }

    // Mostrar la lista
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Obtener tamaño
    public int getTamaño() {
        return tamaño;
    }

    // Método principal
    public static void main(String[] args) {
        Ejercicio1 lista = new Ejercicio1();

        // Insertar al inicio: 10, 20, 30
        lista.insertarInicio(10);
        lista.insertarInicio(20);
        lista.insertarInicio(30);

        // Insertar al final: 40, 50
        lista.insertarFinal(40);
        lista.insertarFinal(50);

        // Mostrar lista completa
        lista.mostrarLista();

        // Mostrar tamaño
        System.out.println("Tamaño de la lista: " + lista.getTamaño());

        // Eliminar primer nodo
        lista.eliminarInicio();

        // Mostrar lista actualizada
        lista.mostrarLista();
        System.out.println("Tamaño actual: " + lista.getTamaño());
    }
}

