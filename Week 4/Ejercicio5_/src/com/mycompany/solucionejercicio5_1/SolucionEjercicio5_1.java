
package com.mycompany.solucionejercicio5_1;

import java.util.ArrayList;
import java.util.List;
import PolimorfismoInterface.*;

public class SolucionEjercicio5_1 {
    public static void main(String[] args) {
        List<IntegranteSeleccion> seleccion = new ArrayList<>();

        IntegranteSeleccion entrenador = new Entrenador(1, "Luis", "de la Fuente", 63, "ESP-ENT-001");
        IntegranteSeleccion pedri = new Futbolista(10, "Pedri", "González", 21, 8, "Centrocampista");
        IntegranteSeleccion morata = new Futbolista(11, "Álvaro", "Morata", 31, 7, "Delantero");
        IntegranteSeleccion fisio = new Masajista(50, "Juan", "Pérez", 45, "Fisioterapeuta", 15);

        seleccion.add(entrenador);
        seleccion.add(pedri);
        seleccion.add(morata);
        seleccion.add(fisio);

        System.out.println("=== CONCENTRACIÓN & VIAJE (interfaz) ===");
        seleccion.forEach(IntegranteSeleccion::concentrarse);
        seleccion.forEach(IntegranteSeleccion::viajar);

        System.out.println("\n=== ENTRENAMIENTO (polimorfismo) ===");
        seleccion.forEach(IntegranteSeleccion::entrenar);

        System.out.println("\n=== PARTIDO (polimorfismo) ===");
        seleccion.forEach(IntegranteSeleccion::jugarPartido);

        System.out.println("\n=== MÉTODOS ESPECÍFICOS (cast seguro) ===");
        if (entrenador instanceof Entrenador e) e.planificarEntrenamiento();
        if (pedri instanceof Futbolista f) f.entrevista();
        if (fisio instanceof Masajista m) m.darMasaje();
    }
}
