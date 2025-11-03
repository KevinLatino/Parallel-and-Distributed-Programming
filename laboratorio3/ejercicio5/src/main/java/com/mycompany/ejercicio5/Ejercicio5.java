package com.mycompany.ejercicio5;

/*
 * Clase Nodo para almacenar elementos de tipo genérico
 *
 * @param <T> Tipo de dato que almacenará el nodo
 * 
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
     * Inserta un elemento al inicio de la lista
     * @param valor Elemento a insertar
     */
    public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor); // Crear nuevo nodo con el valor
        nuevoNodo.siguiente = cabeza;          // El siguiente del nuevo nodo apunta a la cabeza actual
        cabeza = nuevoNodo;                    // La cabeza ahora es el nuevo nodo
        size++;                                // Incrementar el tamaño de la lista
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
     * Busca un elemento en la lista y devuelve su posición
     * @param valor Elemento a buscar
     * @return Posición del elemento (iniciando en 0) o -1 si no se encuentra
     */
    public int buscar(T valor) {
        Nodo<T> actual = cabeza;
        int posicion = 0;
        
        // Recorrer la lista buscando el valor
        while (actual != null) {
            if (actual.valor.equals(valor)) {
                return posicion; // Retornar la posición donde se encontró
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Retornar -1 si no se encontró el elemento
    }
    
    /*
     * Cambia un valor específico por otro en la lista
     * @param valorAntiguo Valor a buscar
     * @param nuevoValor Valor con el que se reemplazará
     * @return true si se realizó el cambio, false si no se encontró el valor
     */
    public boolean cambiarValor(T valorAntiguo, T nuevoValor) {
        Nodo<T> actual = cabeza;
        
        // Recorrer la lista buscando el valor antiguo
        while (actual != null) {
            if (actual.valor.equals(valorAntiguo)) {
                actual.valor = nuevoValor; // Reemplazar el valor
                return true;
            }
            actual = actual.siguiente;
        }
        return false; // Retornar false si no se encontró el valor
    }
    
    /*
     * Elimina el último nodo de la lista
     * @return true si se eliminó correctamente, false si la lista estaba vacía
     */
    public boolean eliminarUltimo() {
        // Verificar si la lista está vacía
        if (cabeza == null) {
            return false;
        }
        
        // Si solo hay un elemento, eliminar la cabeza
        if (cabeza.siguiente == null) {
            cabeza = null;
            size--;
            return true;
        }
        
        // Recorrer hasta el penúltimo nodo
        Nodo<T> actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        
        // Eliminar el último nodo
        actual.siguiente = null;
        size--;
        return true;
    }
    
    /*
     * Obtiene el tamaño de la lista
     * @return Cantidad de elementos en la lista
     */
    public int getSize() {
        return size;
    }
}

/*
 * Clase principal para ejecutar el Ejercicio 5
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        // Crear una lista de tipo String para almacenar nombres
        ListaSimple<String> listaNombres = new ListaSimple<>();
        
        System.out.println("=== EJERCICIO 5: LISTA DE NOMBRES ===\n");
        
        // 1. Insertar al inicio: "Ana", "Luis"
        System.out.println("1. Insertando 'Ana' y 'Luis' al inicio:");
        listaNombres.insertarInicio("Ana");
        listaNombres.insertarInicio("Luis");
        listaNombres.mostrarLista();
        System.out.println("Tamaño: " + listaNombres.getSize() + "\n");
        
        // 2. Insertar al final: "Marta", "Carlos"
        System.out.println("2. Insertando 'Marta' y 'Carlos' al final:");
        listaNombres.insertarFin("Marta");
        listaNombres.insertarFin("Carlos");
        listaNombres.mostrarLista();
        System.out.println("Tamaño: " + listaNombres.getSize() + "\n");
        
        // 3. Mostrar la lista completa
        System.out.println("3. Lista completa:");
        listaNombres.mostrarLista();
        System.out.println();
        
        // 4. Buscar el nombre "Luis" y cambiarlo por "Lucía"
        System.out.println("4. Buscando 'Luis' para cambiarlo por 'Lucía':");
        int posicionLuis = listaNombres.buscar("Luis");
        if (posicionLuis != -1) {
            System.out.println("   'Luis' encontrado en la posición: " + posicionLuis);
            listaNombres.cambiarValor("Luis", "Lucía");
            System.out.println("   Cambio realizado exitosamente");
        } else {
            System.out.println("   'Luis' no se encontró en la lista");
        }
        listaNombres.mostrarLista();
        System.out.println();
        
        // 5. Eliminar el último nombre y mostrar la lista final
        System.out.println("5. Eliminando el último nombre:");
        listaNombres.eliminarUltimo();
        System.out.println("Lista final:");
        listaNombres.mostrarLista();
        System.out.println("Tamaño final: " + listaNombres.getSize());
    }
}