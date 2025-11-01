package com.mycompany.clienteudp.votacion;

import java.net.*;
import java.io.*;

public class ClienteUDPVotacion {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        int puerto = 9876;
        try {
            socket = new DatagramSocket();
            InetAddress direccion = InetAddress.getByName("localhost");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese su voto (A/B/C o FIN para terminar): ");

            while (true) {
                System.out.print("Su voto: ");
                String voto = br.readLine();
                if (voto.equalsIgnoreCase("FIN")) break;

                byte[] mensaje = voto.getBytes();
                DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, direccion, puerto);
                socket.send(peticion);

                byte[] buffer = new byte[1024];
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
                socket.receive(respuesta);

                String mensajeRecibido = new String(respuesta.getData(), 0, respuesta.getLength());
                System.out.println("Respuesta del servidor: \n" + mensajeRecibido);
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
