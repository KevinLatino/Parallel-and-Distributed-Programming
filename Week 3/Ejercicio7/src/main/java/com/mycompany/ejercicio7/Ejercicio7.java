/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio7;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio7 {
    public static void main(String[] args) {
        Map<String, String> mapa1 = new HashMap<String, String>();
        mapa1.put("rojo", "red");
        mapa1.put("verde", "green");
        mapa1.put("azul", "blue");
        mapa1.put("blanco", "white");
        System.out.println(mapa1);
        System.out.println("Listado completo de valores");
        for (String valor : mapa1.values())
            System.out.print(valor + "-");
        System.out.println();
        System.out.println("Listado completo de claves");
        for (String clave : mapa1.keySet())
            System.out.print(clave + "-");
        System.out.println();
        System.out.println("La traduccion de 'rojo' es:" + mapa1.get("rojo"));
        if (mapa1.containsKey("negro"))
            System.out.println("No existe la clave 'negro'");
        System.out.println("La traduccion de 'marron' es:" + mapa1.getOrDefault("marrón", "No existe la clave marron"));
        mapa1.remove("rojo");
        System.out.println(mapa1);
    }
}