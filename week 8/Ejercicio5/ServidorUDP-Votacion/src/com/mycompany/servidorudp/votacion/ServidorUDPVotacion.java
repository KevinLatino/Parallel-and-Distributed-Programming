package com.mycompany.servidorudp.votacion;

import java.net.*;
import java.io.*;
import java.util.HashMap;

public class ServidorUDPVotacion {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        int puerto = 9876;
        HashMap<String, Integer> votos = new HashMap<>();

        try {
            socket = new DatagramSocket(puerto);
            byte[] buffer = new byte[1024];
            System.out.println("Servidor UDP iniciado en el puerto " + puerto);

            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socket.receive(peticion);
                String votoRecibido = new String(peticion.getData(), 0, peticion.getLength()).trim();
                System.out.println("Voto recibido: " + votoRecibido);

                // Contar votos
                votos.put(votoRecibido, votos.getOrDefault(votoRecibido, 0) + 1);

                // Construir respuesta con resultados
                StringBuilder resultados = new StringBuilder("Voto registrado. Resultados actuales:\n");
                for (String opcion : votos.keySet()) {
                    resultados.append(opcion).append(": ").append(votos.get(opcion)).append("\n");
                }

                InetAddress direccion = peticion.getAddress();
                int puertoCliente = peticion.getPort();
                byte[] mensaje = resultados.toString().getBytes();

                DatagramPacket respuesta = new DatagramPacket(mensaje, mensaje.length, direccion, puertoCliente);
                socket.send(respuesta);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
