/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio6 {
    public static void main(String[] args) {
        Set<Integer> conjunto1 = new HashSet<Integer>();
        conjunto1.add(20);
        conjunto1.add(10);
        conjunto1.add(1);
        conjunto1.add(5);
        conjunto1.add(20);
        
        for (int elemento : conjunto1)
            System.out.print(elemento + " - ");
        System.out.println();
        
        Set<Integer> conjunto2 = new TreeSet<Integer>();
        conjunto2.add(20);
        conjunto2.add(10);
        conjunto2.add(1);
        conjunto2.add(5);
        conjunto2.add(20);
        
        for (int elemento : conjunto2)
            System.out.print(elemento + " - ");
        System.out.println();
        
        Set<Integer> conjunto3 = new LinkedHashSet<Integer>();
        conjunto3.add(20);
        conjunto3.add(10);
        conjunto3.add(1);
        conjunto3.add(5);
        conjunto3.add(20);
        
        for (int elemento : conjunto3)
            System.out.print(elemento + " - ");
        System.out.println();
    }
}
