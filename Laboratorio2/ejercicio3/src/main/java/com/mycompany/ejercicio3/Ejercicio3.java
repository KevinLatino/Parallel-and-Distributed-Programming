package com.mycompany.ejercicio3;

import java.time.LocalDateTime;
import java.util.*;

// Enum para las prioridades
enum Prioridad {
    NORMAL, ADMIN
}

// Clase TrabajoImpresion
class TrabajoImpresion {
    private static int contadorId = 1;
    
    private int id;
    private String usuario;
    private int paginas;
    private int ppm; // páginas por minuto
    private int intentos;
    private Prioridad prioridad;
    private LocalDateTime horaLlegada;
    
    public TrabajoImpresion(String usuario, int paginas, int ppm, Prioridad prioridad) {
        this.id = contadorId++;
        this.usuario = usuario;
        this.paginas = paginas;
        this.ppm = ppm;
        this.intentos = 0;
        this.prioridad = prioridad;
        this.horaLlegada = LocalDateTime.now();
    }
    
    public double calcularTiempoImpresion() {
        return (double) paginas / ppm;
    }
    
    public void incrementarIntentos() {
        intentos++;
    }
    
    // Getters
    public int getId() { return id; }
    public String getUsuario() { return usuario; }
    public int getPaginas() { return paginas; }
    public int getPpm() { return ppm; }
    public int getIntentos() { return intentos; }
    public Prioridad getPrioridad() { return prioridad; }
    public LocalDateTime getHoraLlegada() { return horaLlegada; }
    
    @Override
    public String toString() {
        return String.format("Trabajo[id=%d, usuario=%s, pags=%d, ppm=%d, intentos=%d, prioridad=%s]",
                id, usuario, paginas, ppm, intentos, prioridad);
    }
}

// Clase ServidorImpresion
class ServidorImpresion {
    private Queue<TrabajoImpresion> colaAdmin;
    private Queue<TrabajoImpresion> colaNormal;
    private Queue<TrabajoImpresion> colaReintentos;
    private List<TrabajoImpresion> noImprimibles;
    private List<TrabajoImpresion> historialCompletados;
    private Random random;
    
    public ServidorImpresion() {
        this.colaAdmin = new LinkedList<>();
        this.colaNormal = new LinkedList<>();
        this.colaReintentos = new LinkedList<>();
        this.noImprimibles = new ArrayList<>();
        this.historialCompletados = new ArrayList<>();
        this.random = new Random();
    }
    
    /**
     * Agrega un trabajo a la cola correspondiente según su prioridad
     */
    public void agregarTrabajo(TrabajoImpresion trabajo) {
        if (trabajo.getPrioridad() == Prioridad.ADMIN) {
            colaAdmin.offer(trabajo);
            System.out.println("✓ Trabajo agregado a cola ADMIN: " + trabajo);
        } else {
            colaNormal.offer(trabajo);
            System.out.println("✓ Trabajo agregado a cola NORMAL: " + trabajo);
        }
    }
    
   
    public void procesarSiguiente() {
        TrabajoImpresion trabajo = obtenerSiguienteTrabajo();
        
        if (trabajo == null) {
            System.out.println("⚠ No hay trabajos en cola para procesar");
            return;
        }
        
        trabajo.incrementarIntentos();
        boolean exito = random.nextDouble() < 0.85; // 85% éxito
        
        if (exito) {
            historialCompletados.add(trabajo);
            System.out.println("✓ ÉXITO: Trabajo " + trabajo.getId() + " impreso correctamente " +
                    "(intentos realizados: " + trabajo.getIntentos() + ")");
        } else {
            if (trabajo.getIntentos() >= 3) {
                noImprimibles.add(trabajo);
                System.out.println("✗ FALLO PERMANENTE: Trabajo " + trabajo.getId() + 
                        " movido a NO IMPRIMIBLES (3 fallos totales)");
            } else {
                colaReintentos.offer(trabajo);
                System.out.println("⚠ FALLO: Trabajo " + trabajo.getId() + 
                        " movido a REINTENTOS (intento " + trabajo.getIntentos() + "/3)");
            }
        }
    }
    
    /**
     * Obtiene el siguiente trabajo respetando prioridades
     * Orden: ADMIN > REINTENTOS > NORMAL
     */
    private TrabajoImpresion obtenerSiguienteTrabajo() {
        if (!colaAdmin.isEmpty()) {
            return colaAdmin.poll();
        } else if (!colaReintentos.isEmpty()) {
            return colaReintentos.poll();
        } else if (!colaNormal.isEmpty()) {
            return colaNormal.poll();
        }
        return null;
    }
    
    /**
     * Cancela un trabajo por ID, buscándolo en todas las colas
     */
    public boolean cancelarTrabajo(int id) {
        if (eliminarDeCola(colaAdmin, id, "ADMIN")) return true;
        if (eliminarDeCola(colaNormal, id, "NORMAL")) return true;
        if (eliminarDeCola(colaReintentos, id, "REINTENTOS")) return true;
        
        System.out.println("✗ Trabajo " + id + " no encontrado en ninguna cola");
        return false;
    }
    
    /**
     * Método auxiliar para eliminar un trabajo de una cola específica
     */
    private boolean eliminarDeCola(Queue<TrabajoImpresion> cola, int id, String nombreCola) {
        Iterator<TrabajoImpresion> it = cola.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("✓ Trabajo " + id + " cancelado de cola " + nombreCola);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Mueve un trabajo ADMIN al frente de la cola ADMIN
     */
    public boolean moverAdminAlFrente(int id) {
        TrabajoImpresion trabajo = null;
        
        for (TrabajoImpresion t : colaAdmin) {
            if (t.getId() == id) {
                trabajo = t;
                break;
            }
        }
        
        if (trabajo == null) {
            System.out.println("✗ Trabajo " + id + " no encontrado en cola ADMIN");
            return false;
        }
        
        colaAdmin.remove(trabajo);
        ((LinkedList<TrabajoImpresion>) colaAdmin).addFirst(trabajo);
        System.out.println("✓ Trabajo " + id + " movido al frente de cola ADMIN");
        return true;
    }
    
    /**
     * Calcula el tiempo estimado de espera para un trabajo
     * Suma páginas/ppm de todos los trabajos que están delante en las colas
     */
    public Double estimarTiempoEspera(int id) {
        double tiempoEspera = 0.0;
        boolean encontrado = false;
        
        // Buscar en cola ADMIN
        for (TrabajoImpresion t : colaAdmin) {
            if (t.getId() == id) {
                encontrado = true;
                break;
            }
            tiempoEspera += t.calcularTiempoImpresion();
        }
        
        if (encontrado) {
            System.out.printf("⏱ Trabajo %d: tiempo estimado = %.2f minutos (cola ADMIN)\n", 
                    id, tiempoEspera);
            return tiempoEspera;
        }
        
        // Contar todos los ADMIN
        for (TrabajoImpresion t : colaAdmin) {
            tiempoEspera += t.calcularTiempoImpresion();
        }
        
        // Buscar en cola REINTENTOS
        for (TrabajoImpresion t : colaReintentos) {
            if (t.getId() == id) {
                encontrado = true;
                break;
            }
            tiempoEspera += t.calcularTiempoImpresion();
        }
        
        if (encontrado) {
            System.out.printf("⏱ Trabajo %d: tiempo estimado = %.2f minutos (cola REINTENTOS)\n", 
                    id, tiempoEspera);
            return tiempoEspera;
        }
        
        // Contar todos los REINTENTOS
        for (TrabajoImpresion t : colaReintentos) {
            tiempoEspera += t.calcularTiempoImpresion();
        }
        
        // Buscar en cola NORMAL
        for (TrabajoImpresion t : colaNormal) {
            if (t.getId() == id) {
                encontrado = true;
                break;
            }
            tiempoEspera += t.calcularTiempoImpresion();
        }
        
        if (encontrado) {
            System.out.printf("⏱ Trabajo %d: tiempo estimado = %.2f minutos (cola NORMAL)\n", 
                    id, tiempoEspera);
            return tiempoEspera;
        }
        
        System.out.println("✗ Trabajo " + id + " no encontrado");
        return null;
    }
    
    /**
     * Muestra el estado actual de todas las colas
     */
    public void mostrarEstado() {
        System.out.println("\n========== ESTADO DEL SERVIDOR DE IMPRESIÓN ==========");
        System.out.println("Cola ADMIN:        " + colaAdmin.size() + " trabajos");
        System.out.println("Cola NORMAL:       " + colaNormal.size() + " trabajos");
        System.out.println("Cola REINTENTOS:   " + colaReintentos.size() + " trabajos");
        System.out.println("NO IMPRIMIBLES:    " + noImprimibles.size() + " trabajos");
        System.out.println("COMPLETADOS:       " + historialCompletados.size() + " trabajos");
        System.out.println("====================================================\n");
    }
}

// Clase Ejercicio3 - Programa de prueba
public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║   LABORATORIO #2 - EJERCICIO 3: SERVIDOR DE IMPRESIÓN    ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
        
        ServidorImpresion servidor = new ServidorImpresion();
        
        // ===== FASE 1: Agregar trabajos =====
        System.out.println("========== FASE 1: Agregando trabajos ==========\n");
        
        servidor.agregarTrabajo(new TrabajoImpresion("Ana García", 50, 10, Prioridad.NORMAL));
        servidor.agregarTrabajo(new TrabajoImpresion("Carlos Ruiz", 30, 15, Prioridad.ADMIN));
        servidor.agregarTrabajo(new TrabajoImpresion("María López", 20, 10, Prioridad.NORMAL));
        servidor.agregarTrabajo(new TrabajoImpresion("Pedro Martínez", 40, 20, Prioridad.ADMIN));
        servidor.agregarTrabajo(new TrabajoImpresion("Luis Fernández", 25, 12, Prioridad.NORMAL));
        servidor.agregarTrabajo(new TrabajoImpresion("Admin Sistema", 15, 30, Prioridad.ADMIN));
        
        servidor.mostrarEstado();
        
        // ===== FASE 2: Estimación de tiempos =====
        System.out.println("========== FASE 2: Estimación de tiempos ==========\n");
        
        servidor.estimarTiempoEspera(1);
        servidor.estimarTiempoEspera(2);
        servidor.estimarTiempoEspera(5);
        
        // ===== FASE 3: Mover ADMIN al frente =====
        System.out.println("\n========== FASE 3: Priorización ADMIN ==========\n");
        
        servidor.moverAdminAlFrente(4);
        servidor.estimarTiempoEspera(4);
        
        // ===== FASE 4: Procesar trabajos =====
        System.out.println("\n========== FASE 4: Procesando trabajos ==========\n");
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("--- Procesamiento #" + i + " ---");
            servidor.procesarSiguiente();
            System.out.println();
        }
        
        servidor.mostrarEstado();
        
        // ===== FASE 5: Cancelación =====
        System.out.println("========== FASE 5: Cancelación de trabajos ==========\n");
        
        servidor.agregarTrabajo(new TrabajoImpresion("Jorge Díaz", 35, 18, Prioridad.NORMAL));
        servidor.agregarTrabajo(new TrabajoImpresion("Admin Urgente", 10, 25, Prioridad.ADMIN));
        
        servidor.mostrarEstado();
        
        servidor.cancelarTrabajo(7);
        servidor.cancelarTrabajo(99);
        
        servidor.mostrarEstado();
        
        // ===== FASE 6: Procesamiento final =====
        System.out.println("========== FASE 6: Procesamiento final ==========\n");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("--- Procesamiento final #" + i + " ---");
            servidor.procesarSiguiente();
            System.out.println();
        }
        
        servidor.mostrarEstado();
        
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                    FIN DE LA SIMULACIÓN                   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }
}