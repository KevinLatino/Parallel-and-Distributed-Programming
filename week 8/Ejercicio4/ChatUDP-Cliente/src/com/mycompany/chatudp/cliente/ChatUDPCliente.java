package com.mycompany.chatudp.cliente;

import java.net.*;
import java.io.*;

public class ChatUDPCliente {
    private DatagramSocket socket = null;
    private DatagramPacket entrada = null, salida = null;
    private BufferedReader entradaTeclado = null;

    public ChatUDPCliente(String direccion, int puerto) throws IOException {
        socket = new DatagramSocket();
        entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
    }

    public void enviarMensaje(String mensaje, int puerto) throws IOException {
        byte[] buffer = mensaje.getBytes();
        salida = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), puerto);
        socket.send(salida);
    }

    public void recibirMensaje() throws IOException {
        byte[] buffer = new byte[65535];
        entrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(entrada);
        String mensaje = new String(buffer, 0, entrada.getLength());
        System.out.println("Servidor: " + mensaje);
    }

    public void iniciar() throws IOException {
        while (true) {
            String mensaje = entradaTeclado.readLine();
            enviarMensaje(mensaje, 5000);
            if (mensaje.equals("FIN")) {
                System.out.println("Cliente terminado");
                break;
            }
            recibirMensaje();
        }
        entradaTeclado.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ChatUDPCliente cliente = new ChatUDPCliente("localhost", 5000);
        cliente.iniciar();
    }
}
