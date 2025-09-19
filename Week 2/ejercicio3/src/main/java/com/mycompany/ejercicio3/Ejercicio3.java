/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3;

/**
 *
 * @author aleja
 */
public class Ejercicio3 {

    private int tabla;   
    private int terminos; 

   
    public Ejercicio3(int tabla) {
        this.tabla = tabla;
        this.terminos = 10; 
    }

   
    public Ejercicio3(int tabla, int terminos) {
        this.tabla = tabla;
        this.terminos = terminos;
    }

  
    public void imprimir() {
        System.out.println("\n--- Tabla del " + tabla + " ---");
        for (int i = 1; i <= terminos; i++) {
            System.out.println(tabla + " x " + i + " = " + (tabla * i));
        }
    }

    
    public static void main(String[] args) {
       
        Ejercicio3 t1 = new Ejercicio3(5);
        t1.imprimir();

        Ejercicio3 t2 = new Ejercicio3(7, 15);
        t2.imprimir();
    }
}

