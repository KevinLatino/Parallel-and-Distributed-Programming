/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio11;

import java.util.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        Deque<String> cola = new ArrayDeque<String>();
        
        cola.add("1");
        cola.addFirst("2");
        cola.addLast("3");
        
        for (String str : cola) {
            System.out.println(str);
        }
    }
}