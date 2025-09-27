package com.mycompany.ejercicio8;

import java.util.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        Queue<String> clienteQueue = new LinkedList<String>();
        
        clienteQueue.add("John");
        clienteQueue.add("Angelina");
        clienteQueue.add("Maria");
        clienteQueue.add("Carlos");
        
        System.out.println("Clientes en la cola: " + clienteQueue);
        
      
        System.out.println("Primer cliente de la cola: " + clienteQueue.element());
        
       
        System.out.println("Elemento eliminado de la cola: " + clienteQueue.remove());
        
        System.out.println("Poll(): Muestra y elimina el primer elemento de la cola: " + clienteQueue.poll());
        
        System.out.println("Clientes en la cola después de cambios: " + clienteQueue);
    }
}