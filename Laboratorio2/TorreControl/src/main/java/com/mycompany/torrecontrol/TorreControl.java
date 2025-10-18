/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.torrecontrol;
import java.util.*;


/**
 *
 * @author alejandroquesadaruiz
 */

class Vuelo {
    int id;
    String tipo;
    int combustible;
    boolean emergencia;
    int horaLlegada;

    public Vuelo(int id, String tipo, int combustible, boolean emergencia, int horaLlegada) {
        this.id = id;
        this.tipo = tipo;
        this.combustible = combustible;
        this.emergencia = emergencia;
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + tipo + (emergencia ? " 🚨" : "") + " (" + combustible + "L)";
    }
}

public class TorreControl {
    static LinkedList<Vuelo> aterrizajes = new LinkedList<>();
    static LinkedList<Vuelo> despegues = new LinkedList<>();
    static boolean pistaCerrada = false;
    static final int UMBRAL_COMBUSTIBLE = 15;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- TORRE DE CONTROL ---");
            System.out.println("1. Registrar vuelo");
            System.out.println("2. Operar pista (siguiente vuelo)");
            System.out.println("3. Mostrar colas");
            System.out.println("4. Cerrar/Reabrir pista");
            System.out.println("5. Remover vuelo (desvío)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> registrarVuelo(sc);
                case 2 -> operarPista();
                case 3 -> mostrarColas();
                case 4 -> pistaCerrada = !pistaCerrada;
                case 5 -> removerVuelo(sc);
            }

        } while (opcion != 0);
    }

    static void registrarVuelo(Scanner sc) {
        System.out.print("ID vuelo: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Tipo (ATERRIZAJE/DESPEGUE): ");
        String tipo = sc.nextLine().toUpperCase();
        System.out.print("Combustible restante: ");
        int combustible = sc.nextInt();
        System.out.print("¿Emergencia? (true/false): ");
        boolean emergencia = sc.nextBoolean();
        System.out.print("Hora llegada a cola: ");
        int hora = sc.nextInt();

        Vuelo v = new Vuelo(id, tipo, combustible, emergencia, hora);
        if (emergencia) {
            if (tipo.equals("ATERRIZAJE")) aterrizajes.addFirst(v);
            else despegues.addFirst(v);
        } else {
            if (tipo.equals("ATERRIZAJE")) aterrizajes.add(v);
            else despegues.add(v);
        }

        if (tipo.equals("ATERRIZAJE") && combustible < UMBRAL_COMBUSTIBLE)
            System.out.println("⚠️  Prioridad elevada por bajo combustible");
    }

    static void operarPista() {
        if (pistaCerrada) {
            System.out.println("❌ Pista cerrada, no se puede operar.");
            return;
        }

        Vuelo v = null;
        if (!aterrizajes.isEmpty()) v = aterrizajes.poll();
        else if (!despegues.isEmpty()) v = despegues.poll();

        if (v == null) System.out.println("No hay vuelos pendientes.");
        else System.out.println("✈️ Operando: " + v);
    }

    static void mostrarColas() {
        System.out.println("\nAterrizajes: " + aterrizajes);
        System.out.println("Despegues: " + despegues);
        System.out.println("Pista: " + (pistaCerrada ? "CERRADA" : "ABIERTA"));
    }

    static void removerVuelo(Scanner sc) {
        System.out.print("ID vuelo a remover: ");
        int id = sc.nextInt();
        aterrizajes.removeIf(v -> v.id == id);
        despegues.removeIf(v -> v.id == id);
        System.out.println("Vuelo eliminado (si existía).");
    }
}
