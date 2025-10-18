
package com.mycompany.ejercicio4;
        
import java.time.LocalDateTime;
import java.util.*;


// Enum para prioridad de pedidos
enum PrioridadPedido {
    NORMAL, PRIME
}

// Enum para las etapas del fulfillment
enum EtapaFulfillment {
    PICKING, PACKING, ENVIO, COMPLETADO
}

// Clase Pedido
class Pedido {
    private static int contadorId = 1000;
    
    private int id;
    private String cliente;
    private PrioridadPedido prioridad;
    private List<String> items;
    private int sla; // minutos
    private LocalDateTime horaLlegada;
    private EtapaFulfillment etapaActual;
    private int saltosUsados;
    
    public Pedido(String cliente, List<String> items, PrioridadPedido prioridad) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.items = new ArrayList<>(items);
        this.prioridad = prioridad;
        this.sla = (prioridad == PrioridadPedido.PRIME) ? 30 : 60;
        this.horaLlegada = LocalDateTime.now();
        this.etapaActual = EtapaFulfillment.PICKING;
        this.saltosUsados = 0;
    }
    
    public void avanzarEtapa() {
        switch (etapaActual) {
            case PICKING:
                etapaActual = EtapaFulfillment.PACKING;
                break;
            case PACKING:
                etapaActual = EtapaFulfillment.ENVIO;
                break;
            case ENVIO:
                etapaActual = EtapaFulfillment.COMPLETADO;
                break;
        }
    }
    
    public void incrementarSaltos() {
        saltosUsados++;
    }
    
    public boolean puedeUsarSalto() {
        return prioridad == PrioridadPedido.PRIME && saltosUsados < 1;
    }
    
    public void resetearSaltos() {
        saltosUsados = 0;
    }
    
    // Getters
    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public PrioridadPedido getPrioridad() { return prioridad; }
    public List<String> getItems() { return items; }
    public int getSla() { return sla; }
    public LocalDateTime getHoraLlegada() { return horaLlegada; }
    public EtapaFulfillment getEtapaActual() { return etapaActual; }
    public int getSaltosUsados() { return saltosUsados; }
    
    @Override
    public String toString() {
        return String.format("Pedido[id=%d, cliente=%s, items=%d, prioridad=%s, etapa=%s, SLA=%dmin]",
                id, cliente, items.size(), prioridad, etapaActual, sla);
    }
}

// Clase SistemaFulfillment
class SistemaFulfillment {
    private Queue<Pedido> colaPicking;
    private Queue<Pedido> colaPacking;
    private Queue<Pedido> colaEnvio;
    private List<Pedido> completados;
    
    public SistemaFulfillment() {
        this.colaPicking = new LinkedList<>();
        this.colaPacking = new LinkedList<>();
        this.colaEnvio = new LinkedList<>();
        this.completados = new ArrayList<>();
    }
    
    /**
     * Agrega un nuevo pedido al sistema (inicia en PICKING)
     */
    public void agregarPedido(Pedido pedido) {
        colaPicking.offer(pedido);
        System.out.println("✓ Pedido agregado a PICKING: " + pedido);
    }
    
    /**
     * Procesa el primer pedido de la etapa especificada
     * Lo mueve a la siguiente etapa del flujo
     */
    public void procesarEtapa(EtapaFulfillment etapa) {
        Queue<Pedido> colaActual = obtenerCola(etapa);
        
        if (colaActual == null) {
            System.out.println("✗ Etapa inválida: " + etapa);
            return;
        }
        
        if (colaActual.isEmpty()) {
            System.out.println("⚠ No hay pedidos en etapa " + etapa);
            return;
        }
        
        Pedido pedido = colaActual.poll();
        pedido.avanzarEtapa();
        
        // Al avanzar de etapa, resetear saltos para la nueva etapa
        pedido.resetearSaltos();
        
        // Mover a la siguiente cola
        switch (pedido.getEtapaActual()) {
            case PACKING:
                colaPacking.offer(pedido);
                System.out.println("✓ Pedido " + pedido.getId() + ": PICKING → PACKING");
                break;
            case ENVIO:
                colaEnvio.offer(pedido);
                System.out.println("✓ Pedido " + pedido.getId() + ": PACKING → ENVÍO");
                break;
            case COMPLETADO:
                completados.add(pedido);
                System.out.println("✓ Pedido " + pedido.getId() + ": ENVÍO → COMPLETADO ✓");
                break;
        }
    }
    
    /**
     * Permite a un pedido PRIME saltar 1 posición en la cola de la etapa especificada
     * Cada pedido PRIME puede saltar máximo 1 vez por etapa
     */
    public boolean aplicarSaltoPrime(int id, EtapaFulfillment etapa) {
        Queue<Pedido> cola = obtenerCola(etapa);
        
        if (cola == null) {
            System.out.println("✗ Etapa inválida");
            return false;
        }
        
        if (cola.size() < 2) {
            System.out.println("⚠ No hay suficientes pedidos para realizar salto");
            return false;
        }
        
        // Convertir a lista para manipular posiciones
        List<Pedido> listaPedidos = new ArrayList<>(cola);
        
        // Buscar el pedido PRIME
        int indicePedido = -1;
        for (int i = 0; i < listaPedidos.size(); i++) {
            Pedido p = listaPedidos.get(i);
            if (p.getId() == id && p.puedeUsarSalto()) {
                indicePedido = i;
                break;
            }
        }
        
        if (indicePedido <= 0) {
            if (indicePedido == 0) {
                System.out.println("⚠ Pedido " + id + " ya está en primera posición");
            } else {
                System.out.println("⚠ Pedido no encontrado, no es PRIME, o ya usó su salto");
            }
            return false;
        }
        
        // Realizar salto (intercambiar con el pedido anterior)
        Pedido pedido = listaPedidos.remove(indicePedido);
        listaPedidos.add(indicePedido - 1, pedido);
        pedido.incrementarSaltos();
        
        // Reconstruir la cola
        cola.clear();
        cola.addAll(listaPedidos);
        
        System.out.println("✓ Pedido PRIME " + id + " adelantado en " + etapa + 
                " (saltos en esta etapa: " + pedido.getSaltosUsados() + "/1)");
        return true;
    }
    
    /**
     * Cancela un pedido buscándolo en todas las etapas y eliminándolo
     */
    public boolean cancelarPedido(int id) {
        if (eliminarDeCola(colaPicking, id, "PICKING")) return true;
        if (eliminarDeCola(colaPacking, id, "PACKING")) return true;
        if (eliminarDeCola(colaEnvio, id, "ENVÍO")) return true;
        
        System.out.println("✗ Pedido " + id + " no encontrado en ninguna etapa activa");
        return false;
    }
    
    /**
     * Método auxiliar para eliminar un pedido de una cola específica
     */
    private boolean eliminarDeCola(Queue<Pedido> cola, int id, String nombreCola) {
        Iterator<Pedido> it = cola.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                System.out.println("✓ Pedido " + id + " cancelado de " + nombreCola);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Batch Picking: procesa N pedidos juntos de la cola de picking
     * Los agrupa por zona manteniendo el orden relativo
     * Todos avanzan juntos a PACKING
     */
    public void batchPicking(int n, String zona) {
        if (colaPicking.size() < n) {
            System.out.println("⚠ No hay suficientes pedidos para batch picking");
            System.out.println("  Disponibles: " + colaPicking.size() + ", Requeridos: " + n);
            return;
        }
        
        System.out.println("\n📦 ========== BATCH PICKING ==========");
        System.out.println("Zona: " + zona + " | Cantidad: " + n + " pedidos");
        
        List<Pedido> batch = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pedido pedido = colaPicking.poll();
            pedido.avanzarEtapa(); // PICKING → PACKING
            pedido.resetearSaltos(); // Resetear saltos para nueva etapa
            batch.add(pedido);
            System.out.println("  → Pedido " + pedido.getId() + " recogido");
        }
        
        // Mover todos a packing manteniendo orden relativo del batch
        System.out.println("\nMoviendo batch a PACKING...");
        for (Pedido pedido : batch) {
            colaPacking.offer(pedido);
        }
        
        System.out.println("✓ Batch de " + n + " pedidos procesado (Zona " + zona + ") → PACKING");
        System.out.println("=====================================\n");
    }
    
    /**
     * Obtiene la cola correspondiente a una etapa
     */
    private Queue<Pedido> obtenerCola(EtapaFulfillment etapa) {
        switch (etapa) {
            case PICKING: return colaPicking;
            case PACKING: return colaPacking;
            case ENVIO: return colaEnvio;
            default: return null;
        }
    }
    
    /**
     * Muestra el estado resumido del sistema
     */
    public void mostrarEstado() {
        System.out.println("\n========== ESTADO DEL SISTEMA FULFILLMENT ==========");
        System.out.println("PICKING:      " + colaPicking.size() + " pedidos");
        System.out.println("PACKING:      " + colaPacking.size() + " pedidos");
        System.out.println("ENVÍO:        " + colaEnvio.size() + " pedidos");
        System.out.println("COMPLETADOS:  " + completados.size() + " pedidos");
        System.out.println("==================================================\n");
    }
}

// Clase Main - Programa de prueba
public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║   LABORATORIO #2 - EJERCICIO 4: FULFILLMENT E-COMMERCE   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
        
        SistemaFulfillment sistema = new SistemaFulfillment();
        
        // ===== FASE 1: Agregar pedidos =====
        System.out.println("========== FASE 1: Agregando pedidos ==========\n");
        
        sistema.agregarPedido(new Pedido("Juan Pérez", 
                Arrays.asList("Laptop", "Mouse", "Teclado"), PrioridadPedido.NORMAL));
        sistema.agregarPedido(new Pedido("María González", 
                Arrays.asList("Teléfono", "Funda"), PrioridadPedido.PRIME));
        sistema.agregarPedido(new Pedido("Carlos López", 
                Arrays.asList("Tablet", "Cargador", "Audífonos"), PrioridadPedido.NORMAL));
        sistema.agregarPedido(new Pedido("Ana Martínez", 
                Arrays.asList("Smartwatch"), PrioridadPedido.PRIME));
        sistema.agregarPedido(new Pedido("Pedro Ramírez", 
                Arrays.asList("Cámara", "Trípode"), PrioridadPedido.NORMAL));
        sistema.agregarPedido(new Pedido("Laura Silva", 
                Arrays.asList("Bocinas", "Cable HDMI"), PrioridadPedido.NORMAL));
        
        sistema.mostrarEstado();
        
        // ===== FASE 2: Aplicar prioridad PRIME =====
        System.out.println("========== FASE 2: Prioridad PRIME en PICKING ==========\n");
        
        sistema.aplicarSaltoPrime(1001, EtapaFulfillment.PICKING);
        sistema.aplicarSaltoPrime(1003, EtapaFulfillment.PICKING);
        
        // ===== FASE 3: Batch Picking =====
        System.out.println("\n========== FASE 3: Batch Picking ==========\n");
        
        sistema.batchPicking(3, "Zona-A");
        
        sistema.mostrarEstado();
        
        // ===== FASE 4: Procesar en PACKING =====
        System.out.println("========== FASE 4: Procesamiento PACKING ==========\n");
        
        sistema.procesarEtapa(EtapaFulfillment.PACKING);
        sistema.procesarEtapa(EtapaFulfillment.PACKING);
        
        // Aplicar salto PRIME en PACKING
        sistema.aplicarSaltoPrime(1001, EtapaFulfillment.PACKING);
        
        sistema.procesarEtapa(EtapaFulfillment.PACKING);
        
        sistema.mostrarEstado();
        
        // ===== FASE 5: Procesar más pedidos =====
        System.out.println("========== FASE 5: Continuando procesamiento ==========\n");
        
        // Procesar el resto de PICKING
        sistema.procesarEtapa(EtapaFulfillment.PICKING);
        sistema.procesarEtapa(EtapaFulfillment.PICKING);
        sistema.procesarEtapa(EtapaFulfillment.PICKING);
        
        sistema.mostrarEstado();
        
        // ===== FASE 6: Procesar ENVÍO =====
        System.out.println("========== FASE 6: Procesamiento ENVÍO ==========\n");
        
        sistema.procesarEtapa(EtapaFulfillment.ENVIO);
        sistema.procesarEtapa(EtapaFulfillment.ENVIO);
        sistema.procesarEtapa(EtapaFulfillment.ENVIO);
        
        sistema.mostrarEstado();
        
        // ===== FASE 7: Cancelar pedido =====
        System.out.println("========== FASE 7: Cancelación de pedidos ==========\n");
        
        sistema.agregarPedido(new Pedido("Roberto Flores", 
                Arrays.asList("Monitor", "Teclado mecánico"), PrioridadPedido.PRIME));
        
        sistema.mostrarEstado();
        
        sistema.cancelarPedido(1004);
        sistema.cancelarPedido(999);
        
        sistema.mostrarEstado();
        
        // ===== FASE 8: Segundo Batch Picking =====
        System.out.println("========== FASE 8: Segundo Batch Picking ==========\n");
        
        sistema.agregarPedido(new Pedido("Sandra Morales", 
                Arrays.asList("Memoria USB", "Mouse inalámbrico"), PrioridadPedido.NORMAL));
        sistema.agregarPedido(new Pedido("Diego Castro", 
                Arrays.asList("Disco duro externo"), PrioridadPedido.NORMAL));
        
        sistema.batchPicking(2, "Zona-B");
        
        sistema.mostrarEstado();
        
        // ===== FASE 9: Completar todos los pedidos =====
        System.out.println("========== FASE 9: Completando todos los pedidos ==========\n");
        
        // Procesar PACKING
        for (int i = 0; i < 5; i++) {
            sistema.procesarEtapa(EtapaFulfillment.PACKING);
        }
        
        // Procesar ENVÍO
        for (int i = 0; i < 5; i++) {
            sistema.procesarEtapa(EtapaFulfillment.ENVIO);
        }
        
        sistema.mostrarEstado();
        
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║                    FIN DE LA SIMULACIÓN                   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }
}