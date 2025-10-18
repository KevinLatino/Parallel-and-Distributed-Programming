package com.mycompany.solucionejercicio3;

import java.util.ArrayList;
import java.util.List;
import Seleccion.*;

/**
 * Programa de demostración simple de herencia y polimorfismo.
 * Estructura de paquetes:
 *  - package Seleccion: Futbolista, Entrenador, Masajista, SeleccionFutbol
 *  - package com.mycompany.solucionejercicio3: clase main
 */
public class SolucionEjercicio3 {

    public static void main(String[] args) {
        List<SeleccionFutbol> equipo = new ArrayList<>();

        Entrenador entrenador = new Entrenador(1, "Luis", "de la Fuente", 63, "ESP-ENT-001");
        Futbolista jugador1 = new Futbolista(10, "Pedri", "González", 21, 8, "Centrocampista");
        Futbolista jugador2 = new Futbolista(11, "Álvaro", "Morata", 31, 7, "Delantero");
        Masajista masajista = new Masajista(50, "Juan", "Pérez", 45, "Fisioterapeuta Deportivo", 15);

        equipo.add(entrenador);
        equipo.add(jugador1);
        equipo.add(jugador2);
        equipo.add(masajista);

        System.out.println("=== Integrantes ===");
        equipo.forEach(miembro -> System.out.println(miembro));

        System.out.println("\n=== Concentración y viaje ===");
        equipo.forEach(SeleccionFutbol::concentrarse);
        equipo.forEach(SeleccionFutbol::viajar);

        System.out.println("\n=== Entrenamiento (polimorfismo) ===");
        equipo.forEach(SeleccionFutbol::entrenar);

        System.out.println("\n=== Partido (polimorfismo) ===");
        equipo.forEach(SeleccionFutbol::jugarPartido);

        System.out.println("\n=== Acciones específicas ===");
        entrenador.planificarEntrenamiento();
        jugador1.entrevista();
        masajista.darMasaje();
    }
}
