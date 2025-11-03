package com.mycompany.ejercicio6;

/*
 * Clase Nodo para almacenar elementos de tipo genérico
 * @param <T> Tipo de dato que almacenará el nodo
 */
class Nodo<T> {
    T valor;           // Dato almacenado en el nodo
    Nodo<T> siguiente; // Referencia al siguiente nodo en la lista
    
    /*
     * Constructor del nodo
     * @param valor Dato a almacenar en el nodo
     */
    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

/*
 * Clase ListaSimple que implementa una estructura de datos de lista enlazada simple
 * @param <T> Tipo de dato que almacenará la lista
 */
class ListaSimple<T> {
    private Nodo<T> cabeza; // Referencia al primer nodo de la lista
    private int size;       // Cantidad de elementos en la lista
    
    /*
     * Constructor de la lista simple
     * Inicializa una lista vacía
     */
    public ListaSimple() {
        this.cabeza = null;
        this.size = 0;
    }
    
    /*
     * Inserta un elemento al final de la lista
     * @param valor Elemento a insertar
     */
    public void insertarFin(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor); // Crear nuevo nodo con el valor
        
        // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            // Recorrer la lista hasta encontrar el último nodo
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo; // Enlazar el último nodo con el nuevo nodo
        }
        size++; // Incrementar el tamaño de la lista
    }
    
    /*
     * Muestra todos los elementos de la lista
     */
    public void mostrarLista() {
        // Verificar si la lista está vacía
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.print("Lista: ");
        Nodo<T> actual = cabeza;
        
        // Recorrer todos los nodos e imprimir sus valores
        while (actual != null) {
            System.out.print(actual.valor);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
    
    /*
     * Cambia un valor específico por otro en la lista
     * Este método busca la primera ocurrencia del valor antiguo y lo reemplaza
     * @param valorAntiguo Valor a buscar en la lista
     * @param nuevoValor Valor con el que se reemplazará
     * @return true si se realizó el cambio exitosamente, false si no se encontró el valor
     */
    public boolean cambiarValor(T valorAntiguo, T nuevoValor) {
        // Iniciar desde la cabeza de la lista
        Nodo<T> actual = cabeza;
        
        // Recorrer la lista buscando el valor antiguo
        while (actual != null) {
            // Comparar el valor del nodo actual con el valor buscado
            if (actual.valor.equals(valorAntiguo)) {
                // Si se encuentra, reemplazar el valor
                actual.valor = nuevoValor;
                return true; // Operación exitosa
            }
            // Avanzar al siguiente nodo
            actual = actual.siguiente;
        }
        
        // Si se recorrió toda la lista y no se encontró, retornar false
        return false;
    }
    
    /*
     * Obtiene el tamaño actual de la lista
     * @return Cantidad de elementos en la lista
     */
    public int getSize() {
        return size;
    }
    
    /*
     * Verifica si la lista está vacía
     * @return true si la lista no tiene elementos, false en caso contrario
     */
    public boolean isEmpty() {
        return cabeza == null;
    }
}

/*
 * Clase principal para ejecutar el Ejercicio 6
 * Demuestra el uso del método cambiarValor para modificar elementos en la lista
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        // Crear una instancia de lista simple para almacenar enteros
        ListaSimple<Integer> listaEnteros = new ListaSimple<>();
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  EJERCICIO 6: REEMPLAZAR VALORES          ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        // ===== FASE 1: CONSTRUCCIÓN DE LA LISTA =====
        System.out.println("─── FASE 1: Construcción de la lista ───");
        System.out.println("Insertando valores iniciales: 10, 20, 30, 40, 50");
        
        // Insertar cada valor al final de la lista
        listaEnteros.insertarFin(10);
        listaEnteros.insertarFin(20);
        listaEnteros.insertarFin(30);
        listaEnteros.insertarFin(40);
        listaEnteros.insertarFin(50);
        
        System.out.println("\nLista inicial creada:");
        listaEnteros.mostrarLista();
        System.out.println("Tamaño: " + listaEnteros.getSize() + " elementos");
        System.out.println();
        
        // ===== FASE 2: PRIMER REEMPLAZO (30 → 300) =====
        System.out.println("─── FASE 2: Primera modificación ───");
        System.out.println("Operación: Cambiar el valor 30 por 300");
        System.out.println("Proceso:");
        System.out.println("  1. Buscar el valor 30 en la lista");
        System.out.println("  2. Reemplazar 30 por 300 si se encuentra");
        
        // Ejecutar el cambio y capturar el resultado
        boolean cambio1 = listaEnteros.cambiarValor(30, 300);
        
        // Mostrar resultado de la operación
        if (cambio1) {
            System.out.println("Resultado: Cambio realizado exitosamente");
        } else {
            System.out.println("Resultado: No se encontró el valor 30");
        }
        
        System.out.println("\nEstado de la lista después del primer cambio:");
        listaEnteros.mostrarLista();
        System.out.println("Tamaño verificado: " + listaEnteros.getSize() + " elementos");
        System.out.println();
        
        // ===== FASE 3: SEGUNDO REEMPLAZO (10 → 15) =====
        System.out.println("─── FASE 3: Segunda modificación ───");
        System.out.println("Operación: Cambiar el valor 10 por 15");
        System.out.println("Proceso:");
        System.out.println("  1. Buscar el valor 10 en la lista");
        System.out.println("  2. Reemplazar 10 por 15 si se encuentra");
        
        // Ejecutar el segundo cambio
        boolean cambio2 = listaEnteros.cambiarValor(10, 15);
        
        // Mostrar resultado de la operación
        if (cambio2) {
            System.out.println("Resultado: Cambio realizado exitosamente");
        } else {
            System.out.println("Resultado: No se encontró el valor 10");
        }
        
        System.out.println("\nEstado de la lista después del segundo cambio:");
        listaEnteros.mostrarLista();
        System.out.println("Tamaño verificado: " + listaEnteros.getSize() + " elementos");
        System.out.println();
        
        // ===== FASE 4: RESUMEN FINAL =====
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         RESUMEN FINAL                     ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("\nLista final:");
        listaEnteros.mostrarLista();
        System.out.println("Tamaño final: " + listaEnteros.getSize() + " elementos");
        
        System.out.println("\n Estadísticas de las operaciones:");
        System.out.println("  • Total de modificaciones realizadas: 2");
        System.out.println("  • Modificaciones exitosas: 2");
        System.out.println("  • Elementos originales: 5");
        System.out.println("  • Elementos finales: 5");
        
        System.out.println("\n Registro de cambios:");
        System.out.println("  1. Valor 30 → 300 (Posición 2)");
        System.out.println("  2. Valor 10 → 15  (Posición 0)");
        
    }
}