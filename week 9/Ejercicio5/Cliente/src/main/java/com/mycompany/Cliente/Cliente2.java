package com.mycompany.Cliente;

import java.util.Scanner;

public class Cliente2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Digite su nombre de cliente: ");
        String nombrecliente = leer.nextLine();
        Hilocliente cliente = new Hilocliente(nombrecliente);
        cliente.start();
        while (true) {
            cliente.enviarDatos();
        }
    }
}
