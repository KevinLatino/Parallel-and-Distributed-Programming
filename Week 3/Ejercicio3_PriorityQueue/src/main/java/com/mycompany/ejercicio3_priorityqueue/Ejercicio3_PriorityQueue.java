/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3_priorityqueue;

import java.util.PriorityQueue;

/**
 *
 * @author kevinlatinomarin
 */
public class Ejercicio3_PriorityQueue {

    public static void main(String[] args) {
        // Crear una cola con prioridad (por defecto, orden natural: menor → mayor)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insertamos valores desordenados
        pq.add(42);
        pq.add(7);
        pq.add(100);
        pq.add(1);
        pq.add(15);

        // peek: muestra el elemento con mayor prioridad (el menor en este caso)
        System.out.println("peek(): " + pq.peek());

        // poll: extrae en orden de prioridad
        System.out.println("== Extracción en orden de prioridad ==");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
