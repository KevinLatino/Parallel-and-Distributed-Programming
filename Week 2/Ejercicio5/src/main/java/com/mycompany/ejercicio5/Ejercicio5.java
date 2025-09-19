package com.mycompany.ejercicio5;

/**
 *
 * @author kevinlatinomarin
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        Banco banco1 = new Banco();
        banco1.operar();
        banco1.depositosTotales();
    }
}

// =================== CLASE CLIENTE ===================
class Cliente {
    private String nombre;
    private int monto;

    public Cliente(String nom) {
        nombre = nom;
        monto = 0;
    }

    public void depositar(int m) {
        monto = monto + m;
    }

    public void extraer(int m) {
        monto = monto - m;
    }

    public int retornarMonto() {
        return monto;
    }

    public void imprimir() {
        System.out.println(nombre + " tiene depositado la suma de " + monto);
    }
}

// =================== CLASE BANCO ===================
class Banco {
    private Cliente cliente1, cliente2, cliente3;

    public Banco() {
        cliente1 = new Cliente("Juan");
        cliente2 = new Cliente("Ana");
        cliente3 = new Cliente("Pedro");
    }

    public void operar() {
        cliente1.depositar(100);
        cliente2.depositar(150);
        cliente3.depositar(200);
        cliente3.extraer(150);
    }

    public void depositosTotales() {
        int t = cliente1.retornarMonto() + cliente2.retornarMonto() + cliente3.retornarMonto();
        System.out.println("El total de dinero en el banco es: " + t);
        cliente1.imprimir();
        cliente2.imprimir();
        cliente3.imprimir();
    }
}
