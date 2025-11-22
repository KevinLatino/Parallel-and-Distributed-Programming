
package com.mycompany.solucionejercicio6;

import java.util.*;

public class TestConstrucciones {
    public static void main(String[] args){
        ArrayList<Object> lista = new ArrayList<>();
        lista.add(new Polideportivo("P1", 500, 1));
        lista.add(new Polideportivo("P2", 800, 2));
        lista.add(new Polideportivo("P3", 650, 1));
        lista.add(new EdificioDeOficinas(1200, 20));
        lista.add(new EdificioDeOficinas(900, 15));

        Iterator<Object> it = lista.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
