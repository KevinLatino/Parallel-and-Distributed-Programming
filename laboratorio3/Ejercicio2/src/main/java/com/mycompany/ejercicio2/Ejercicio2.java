
package com.mycompany.ejercicio2;

public class Ejercicio2 {

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
    public Ejercicio2() {
        cabeza = null;
        tamaño = 0;
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

    // Insertar al inicio
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    // Insertar después de un valor específico
    public boolean insertarDespuesDe(int valorBuscado, int nuevoValor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía. No se puede insertar después de " + valorBuscado);
            return false;
        }

        Nodo actual = cabeza;
        while (actual != null && actual.dato != valorBuscado) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            Nodo nuevo = new Nodo(nuevoValor);
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            tamaño++;
            return true;
        } else {
            System.out.println("No se encontró el valor " + valorBuscado + " en la lista.");
            return false;
        }
    }

    // Eliminar el último nodo
    public boolean eliminarUltimo() {
        if (cabeza == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return false;
        }

        if (cabeza.siguiente == null) {
            cabeza = null;
            tamaño--;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = null;
        tamaño--;
        return true;
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
        Ejercicio2 lista = new Ejercicio2();

        System.out.println("=== EJERCICIO 2: CONSTRUCCIÓN PROGRESIVA DE LA LISTA ===\n");

        // Paso 1: Insertar elementos al final (5, 15, 25)
        System.out.println("--- Paso 1: Insertar números al final ---");

        System.out.println("\nInsertando 5 al final...");
        lista.insertarFinal(5);
        lista.mostrarLista();

        System.out.println("\nInsertando 15 al final...");
        lista.insertarFinal(15);
        lista.mostrarLista();

        System.out.println("\nInsertando 25 al final...");
        lista.insertarFinal(25);
        lista.mostrarLista();

        // Paso 2: Insertar al inicio (3)
        System.out.println("\n--- Paso 2: Insertar 3 al inicio ---");
        lista.insertarInicio(3);
        lista.mostrarLista();

        // Paso 3: Insertar en posición intermedia (100 después del 15)
        System.out.println("\n--- Paso 3: Insertar 100 después del 15 ---");
        lista.insertarDespuesDe(15, 100);
        lista.mostrarLista();

        // Mostrar tamaño de la lista
        System.out.println("\nTamaño de la lista: " + lista.getTamaño() + " elementos");

        // Paso 4: Eliminar el último nodo
        System.out.println("\n--- Paso 4: Eliminar el último nodo ---");
        lista.eliminarUltimo();
        lista.mostrarLista();

        System.out.println("\nTamaño final de la lista: " + lista.getTamaño() + " elementos");

        System.out.println("\n=== FIN DEL EJERCICIO ===");
    }
}
