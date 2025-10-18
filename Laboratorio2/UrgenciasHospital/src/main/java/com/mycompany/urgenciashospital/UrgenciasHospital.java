/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.urgenciashospital;
import java.util.*;


/**
 *
 * @author alejandroquesadaruiz
 */

class Paciente {
    int id;
    String nombre;
    String sintoma;
    String triage; 
    int horaLlegada;
    int tiempoMaxEspera;
    boolean requiereEstudios;

    public Paciente(int id, String nombre, String sintoma, String triage, int horaLlegada, int tiempoMaxEspera, boolean requiereEstudios) {
        this.id = id;
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.triage = triage;
        this.horaLlegada = horaLlegada;
        this.tiempoMaxEspera = tiempoMaxEspera;
        this.requiereEstudios = requiereEstudios;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (" + triage + ")";
    }
}

public class UrgenciasHospital {
    static Queue<Paciente> colaRoja = new LinkedList<>();
    static Queue<Paciente> colaAmarilla = new LinkedList<>();
    static Queue<Paciente> colaVerde = new LinkedList<>();
    static Queue<Paciente> imagenologia = new LinkedList<>();
    static Queue<Paciente> alta = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- URGENCIAS HOSPITALARIAS ---");
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Mostrar colas");
            System.out.println("4. Escalar prioridad (por tiempo)");
            System.out.println("5. Retirar paciente (abandono)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ingresarPaciente(sc);
                case 2 -> atenderPaciente();
                case 3 -> mostrarColas();
                case 4 -> escalarPrioridad();
                case 5 -> retirarPaciente(sc);
            }

        } while (opcion != 0);
    }

    static void ingresarPaciente(Scanner sc) {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Síntoma: ");
        String sintoma = sc.nextLine();
        System.out.print("Triage (rojo/amarillo/verde): ");
        String triage = sc.nextLine().toLowerCase();
        System.out.print("Hora llegada (minutos): ");
        int hora = sc.nextInt();
        System.out.print("Tiempo máximo de espera (minutos): ");
        int espera = sc.nextInt();
        System.out.print("¿Requiere estudios? (true/false): ");
        boolean estudios = sc.nextBoolean();

        Paciente p = new Paciente(id, nombre, sintoma, triage, hora, espera, estudios);
        switch (triage) {
            case "rojo" -> colaRoja.add(p);
            case "amarillo" -> colaAmarilla.add(p);
            case "verde" -> colaVerde.add(p);
            default -> System.out.println("Triage inválido");
        }
    }

    static void atenderPaciente() {
        Paciente p = null;
        if (!colaRoja.isEmpty()) p = colaRoja.poll();
        else if (!colaAmarilla.isEmpty()) p = colaAmarilla.poll();
        else if (!colaVerde.isEmpty()) p = colaVerde.poll();

        if (p == null) {
            System.out.println("No hay pacientes.");
            return;
        }

        System.out.println("Atendiendo: " + p);
        if (p.requiereEstudios) imagenologia.add(p);
        else alta.add(p);
    }

    static void mostrarColas() {
        System.out.println("\nRojo: " + colaRoja);
        System.out.println("Amarillo: " + colaAmarilla);
        System.out.println("Verde: " + colaVerde);
        System.out.println("Imagenología: " + imagenologia);
        System.out.println("Alta: " + alta);
    }

    static void escalarPrioridad() {
        if (!colaVerde.isEmpty()) {
            Paciente p = colaVerde.poll();
            p.triage = "amarillo";
            colaAmarilla.add(p);
            System.out.println("Escalado de verde a amarillo: " + p.nombre);
        } else if (!colaAmarilla.isEmpty()) {
            Paciente p = colaAmarilla.poll();
            p.triage = "rojo";
            colaRoja.add(p);
            System.out.println("Escalado de amarillo a rojo: " + p.nombre);
        }
    }

    static void retirarPaciente(Scanner sc) {
        System.out.print("Ingrese ID del paciente a retirar: ");
        int id = sc.nextInt();
        eliminarDeCola(colaRoja, id);
        eliminarDeCola(colaAmarilla, id);
        eliminarDeCola(colaVerde, id);
        System.out.println("Paciente retirado (si existía).");
    }

    static void eliminarDeCola(Queue<Paciente> cola, int id) {
        cola.removeIf(p -> p.id == id);
    }
}
