package com.mycompany.servidor;

import java.net.*;
import java.io.*;

public class Servidor {

    public static void main(String[] args) {
        DatagramSocket socket;
        boolean fin = false;

        try {
            socket = new DatagramSocket(7000);

            byte[] mensaje_bytes = new byte[256];
            String mensaje = "";
            mensaje = new String(mensaje_bytes);
            String mensajeComp = "";

            DatagramPacket paquete = new DatagramPacket(mensaje_bytes, 256);
            DatagramPacket envpaquete = new DatagramPacket(mensaje_bytes, 256);

            int puerto;
            InetAddress address;
            byte[] mensaje2_bytes = new byte[256];

            System.out.println("Servidor Listo, esperando al cliente:");

            do {
                socket.receive(paquete);

                mensaje = new String(mensaje_bytes).trim();

                System.out.println(mensaje);

                puerto = paquete.getPort();
                address = paquete.getAddress();

                if (mensaje.startsWith("fin")) {
                    mensajeComp = "chauuuuuu cliente";
                }

                if (mensaje.startsWith("hola")) {
                    mensajeComp = "hola cliente";
                }

                mensaje2_bytes = mensajeComp.getBytes();

                envpaquete = new DatagramPacket(mensaje2_bytes, mensajeComp.length(), address, puerto);

                socket.send(envpaquete);

            } while (1 > 0);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }

}
