package com.mycompany.chatudp.servidor;

import java.net.*;
import java.io.*;

public class ChatUDPServidor {
    private DatagramSocket socket = null;
    private DatagramPacket entrada = null, salida = null;
    private BufferedReader entradaTeclado = null;

    public ChatUDPServidor(int puerto) throws IOException {
        socket = new DatagramSocket(puerto);
        entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
    }

    public void enviarMensaje(String mensaje, InetAddress direccion, int puerto) throws IOException {
        byte[] buffer = mensaje.getBytes();
        salida = new DatagramPacket(buffer, buffer.length, direccion, puerto);
        socket.send(salida);
    }

    public void recibirMensaje() throws IOException {
        byte[] buffer = new byte[65535];
        entrada = new DatagramPacket(buffer, buffer.length);
        socket.receive(entrada);
        String mensaje = new String(buffer, 0, entrada.getLength());
        System.out.println("Cliente: " + mensaje);
    }

    public void iniciar() throws IOException {
        while (true) {
            recibirMensaje();
            InetAddress direccion = entrada.getAddress();
            int puerto = entrada.getPort();
            String mensaje = entradaTeclado.readLine();
            enviarMensaje(mensaje, direccion, puerto);
            if (mensaje.equals("FIN")) {
                System.out.println("Servidor terminado");
                break;
            }
        }
        entradaTeclado.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        ChatUDPServidor servidor = new ChatUDPServidor(5000);
        servidor.iniciar();
    }
}
